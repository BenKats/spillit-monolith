package com.project.service;
import com.project.config.JwtUtil;
import com.project.model.User;
import com.project.model.UserProfile;
import com.project.repository.UserProfileRepository;
import com.project.repository.UserProfileRepositoryStub;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
//
@RunWith(SpringRunner.class)
public class UserProfileServiceTest {




    private UserProfileServiceImpl userProfileService;


    @Before
    public void initializeUserProfile(){
        userProfileService = new UserProfileServiceImpl(new UserServiceStub(), new UserProfileRepositoryStub());
    }


    @Test
    public void createUserProfile_Success(){
        UserProfile userProfile = new UserProfile();
        userProfile.setEmail("batman@superhero.com");

        UserProfile newProfile = userProfileService.createUserProfile("sign", userProfile);

        Assert.assertNotNull(newProfile);
        Assert.assertEquals(newProfile.getEmail(), userProfile.getEmail());
        Assert.assertEquals(newProfile.getMobile(),userProfile.getMobile());
            }
        }
