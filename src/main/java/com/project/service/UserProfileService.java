package com.project.service;

import com.project.model.UserProfile;


public interface UserProfileService {

    public UserProfile createUserProfile(String username, UserProfile newUserProfile);

    public UserProfile updateUserProfile(String username, UserProfile updatedUserProfile);

    public UserProfile getUserProfile(String username);


}
