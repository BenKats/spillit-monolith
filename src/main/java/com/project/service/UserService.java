package com.project.service;


import com.project.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;


import java.util.List;


public interface UserService  extends UserDetailsService {
    //Might not need to declare getUser method here, might be enough to just define it in the implement
    public User getUser(String username);

    public String createUser(User newUser);

    public String login(User returningUser);

    public List<User> listUsers();

    public User getUserInfo(String username);
}
