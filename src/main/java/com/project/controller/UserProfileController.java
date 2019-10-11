package com.project.controller;

import com.project.model.UserProfile;
import com.project.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserProfileController {
    @Autowired
    UserProfileService userProfileService;

    @Autowired
    public void setUserProfileService(UserProfileService userProfileService){
        this.userProfileService = userProfileService;
    }

    @PostMapping("/profile/{username}")
    public UserProfile createUserProfile(@PathVariable String username, @RequestBody UserProfile newUserProfile) {
        return userProfileService.createUserProfile(username, newUserProfile);
    }

    @GetMapping("/profile/{username}")
    public UserProfile getUserProfileOfUser(@PathVariable String username){
        return userProfileService.getUserProfileOfUser(username);
    }

    @GetMapping("/profile")
    public UserProfile getUserProfile(){
        return userProfileService.getUserProfile();
    }

    @PutMapping("/update")
    public UserProfile updateUserProfile(@RequestBody UserProfile updatedUserProfile){
        return userProfileService.updateUserProfile(updatedUserProfile);
    }

}

