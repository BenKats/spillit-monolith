package com.project.controller;

import com.project.model.UserProfile;
import com.project.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserProfileController {

    @Autowired
    UserProfileService userProfileService;

    @PostMapping("/profile/{username}")
    public UserProfile createUserProfile(@PathVariable String username, @RequestBody UserProfile newUserProfile) {
        return userProfileService.createUserProfile(username, newUserProfile);
    }


    @GetMapping("/profile/{username}")
    public UserProfile getUserProfile(@PathVariable String username){
        return userProfileService.getUserProfile(username);
    }

    @PutMapping("/update/{username}")
    public UserProfile updateUserProfile(@PathVariable String username, @RequestBody UserProfile updatedUserProfile){
        return userProfileService.updateUserProfile(username, updatedUserProfile);
    }






}

