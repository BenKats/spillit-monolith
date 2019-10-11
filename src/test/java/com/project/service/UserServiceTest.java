//package com.project.service;
//
//import com.project.config.JwtUtil;
//import com.project.model.User;
//import com.project.repository.UserProfileRepository;
//import com.project.repository.UserRepository;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnitRunner;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import static org.junit.Assert.assertEquals;
//import static org.mockito.ArgumentMatchers.anyString;
//import static org.mockito.Mockito.when;
//
//@RunWith(MockitoJUnitRunner.class)
//public class UserServiceTest {
//
//    @Mock
//    UserRepository userRepository;
//
//    @Mock
//    private UserProfileService userProfileService;
//
//    @Mock
//    private UserProfileRepository userProfileRepository;
//
//    @Mock
//    private JwtUtil jwtUtil;
//
//    @Mock
//    private PasswordEncoder passwordEncoder;
//
//    @InjectMocks
//    private UserServiceImpl userService;
//
//
//    @InjectMocks
//    private User user;
//
//    @Before
//    public void initializeDummyUser(){
//        user.setUsername("test1");
//        user.setPassword("test1");
//    }
//
//    @Test
//    public void getUser_ReturnsUser_Success(){
//
//        user.setUsername("test1");
//        user.setPassword("test1");
//
//        when(userRepository.findByUsername(anyString())).thenReturn(user);
//
//        User tempUser = userService.getUser(user.getUsername());
//
//        assertEquals(tempUser.getUsername(), user.getUsername());
//    }
//
//    @Test
//    public void login_UserNotFound_Error(){
//        user.setUsername("test1");
//        user.setPassword("test1");
//
//        when(userRepository.findByUsername(anyString())).thenReturn(null);
//
//        String token = userService.login(user);
//
//        assertEquals(token, null);
//    }
//
//}