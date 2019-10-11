package com.project.service;

import com.project.model.UserProfile;
import com.project.repository.UserProfileRepositoryStub;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class UserProfileServiceTest {

    private UserProfileServiceImpl userProfileService;


    @Before
    public void initializeUserProfile(){
        userProfileService = new UserProfileServiceImpl(new UserServiceStub(), new UserProfileRepositoryStub());
    }

//              //does not work IS THE THING WE AUTOWIRED
//    @Test
//    public void createUserProfile_Success(){
//        UserProfile userProfile = new UserProfile();
//        userProfile.setEmail("ben@gmail.com");
//
//        UserProfile newProfile = userProfileService.createUserProfile("ben", userProfile);
//
//        Assert.assertNotNull(newProfile);
//        Assert.assertEquals(newProfile.getEmail(), userProfile.getEmail());
//        Assert.assertEquals(newProfile.getMobile(),userProfile.getMobile());
//            }
        }
