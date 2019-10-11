package com.project.service;

import com.project.model.UserProfile;

public interface UserProfileService {
    public UserProfile createUserProfile(String username, UserProfile newUserProfile);

    public UserProfile updateUserProfile(UserProfile updatedUserProfile);

    public UserProfile getUserProfileOfUser(String username);

    public UserProfile getUserProfile();
}
