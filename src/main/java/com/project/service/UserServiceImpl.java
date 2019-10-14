package com.project.service;

import com.project.config.JwtUtil;
import com.project.model.User;
import com.project.repository.UserRepository;
import org.dom4j.IllegalAddException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserProfileService userProfileService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    @Qualifier("encoder")
    PasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUser(username);

        if(user==null)
            throw new UsernameNotFoundException("User null");

        return new org.springframework.security.core.userdetails.User(user.getUsername(), bCryptPasswordEncoder.encode(user.getPassword()),
                true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority("USER"));

        return authorities;
    }

    //Might not need to have an override and declare the method in UserService
    @Override
    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }
//------------------------------|     Endpoints     |----------------------------------------

    @Override
    public String createUser(User newUser) throws Exception{
        //Encrypts the passed over password
        newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
        if(userRepository.findByUsername(newUser.getUsername()) == null){
            userRepository.save(newUser);
            UserDetails userDetails = loadUserByUsername(newUser.getUsername());
            return jwtUtil.generateToken(userDetails);
        }
        throw new Exception();
    }

    @Override
    public String login(User user, HttpServletRequest request, HttpSession session) {
        User returningUser = userRepository.findByUsername(user.getUsername());
        if(returningUser != null && bCryptPasswordEncoder.matches(user.getPassword(), returningUser.getPassword())){
            UserDetails userDetails = loadUserByUsername(returningUser.getUsername());
            session.invalidate();
            HttpSession newSession = request.getSession();
            return jwtUtil.generateToken(userDetails);
        }
        return null;
    }

    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    }

