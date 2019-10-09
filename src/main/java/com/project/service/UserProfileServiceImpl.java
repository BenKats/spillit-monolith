package com.project.service;

import com.project.model.User;
import com.project.model.UserProfile;
import com.project.repository.UserProfileRepository;
import com.project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserProfileServiceImpl implements UserProfileService{

    @Autowired
    UserProfileRepository userProfileRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public UserProfile createUserProfile(String username, UserProfile newUserProfile) {
        User user = userRepository.findByUsername(username);
        newUserProfile.setUser(user);
        user.setUserProfile(newUserProfile);
        userProfileRepository.save(newUserProfile);
        return user.getUserProfile();
    }

    @Override
    public UserProfile getUserProfile(String username){
        User user = userRepository.findByUsername(username);
        return user.getUserProfile();

    }



}
