package com.project.service;

import com.project.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class UserServiceStub implements UserService{

    @Override
    public User getUser(String username){
        User user = new User();
        user.setUsername(username);
        return user;
    }

    @Override
    public String createUser(User newUser) {
        return null;
    }

    @Override
    public String login(User returningUser) {
        return null;
    }

    @Override
    public List<User> listUsers() {
        return null;
    }

    @Override
    public User getUserInfo(String username) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
