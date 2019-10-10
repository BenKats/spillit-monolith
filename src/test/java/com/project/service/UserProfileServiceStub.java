package com.project.service;

import com.project.model.UserProfile;

public class UserProfileServiceStub implements UserProfileService {

    @Override

    public UserProfile createUserProfile(String username, UserProfile newUserProfile) {
        UserProfile userProfile = new UserProfile();
        userProfile.setEmail("ben@gmail.com");
        userProfile.setMobile("913-874-3333");

        return userProfile;
    }

    @Override

    public UserProfile updateUserProfile(String username, UserProfile updatedUserProfile) {
        UserProfile userProfile = new UserProfile();
        userProfile.setMobile("999-999-9999");
        userProfile.setEmail("ben@mail.com");

        return userProfile;
    }

    @Override
    public UserProfile getUserProfile(String username){
        UserProfile userProfile = new UserProfile();
        userProfile.setEmail("mel@me.com");
        userProfile.setMobile("000-000-0000");

        return userProfile;
    }

}



