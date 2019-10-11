package com.project.service;


import com.project.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class UserServiceStub implements UserService{


    @Override
    public User getUser(String username) {
        User user = new User();
        user.setUsername(username);
        return user;
    }

    @Override
    public String createUser(User newUser) {
    return null;
    }

    @Override
    public String login(User returningUser, HttpServletRequest request, HttpSession session) {
        return null;
    }

    @Override
    public List<User> listUsers() {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
