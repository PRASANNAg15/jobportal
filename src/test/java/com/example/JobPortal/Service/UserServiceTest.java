package com.example.JobPortal.Service;

import com.example.JobPortal.DTO.UserDto;
import com.example.JobPortal.Entity.UserEntity;
import com.example.JobPortal.Repository.UserRepository;
import com.example.JobPortal.Utils.AppUtils;
import com.example.JobPortal.Utils.JwtTokenFilter;
import com.example.JobPortal.Utils.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtTokenFilter jwtTokenFilter;
    @Mock
    private ModelMapper modelMapper;
    @Mock
    private PasswordEncoder passwordEncoder;
    @Mock
    private AuthenticationManager authenticationManager;
    @Mock
    private JwtUtil jwtUtil;
    @InjectMocks
    private UserService userService;

    private UserEntity userEntity;

    @BeforeEach
    public void setup()
    {
        userEntity=new UserEntity();
        userEntity.setUserName("testUser");
        userEntity.setPassword("password123@");
        userEntity.setEmail("testUser@gmail.com");
        userEntity.setRole(AppUtils.UserRoles.EMPLOYER);
    }
    @Test
    public void givenUserObject_whenSaved_returnSavedUser() throws IOException {
       UserDto dto=new UserDto();
       dto.setRole(AppUtils.UserRoles.EMPLOYER);
       dto.setPassword("test@123");
       dto.setCompanyName("AWS");
       dto.setEmail("test@gmail.com");

       UserEntity user=new UserEntity();
        user.setRole(AppUtils.UserRoles.EMPLOYER);
        user.setPassword("test@123");
        user.setCompanyName("AWS");
        user.setEmail("encodedPassword");

        given(passwordEncoder.encode(any()))
                .willReturn("encodedPassword");
        given(userRepository.save(any(UserEntity.class)))
                .willReturn(userEntity);


        given(modelMapper.map(any(UserEntity.class), any(Class.class)))
                .willReturn(dto);
        MockMultipartFile resume =
                new MockMultipartFile(
                        "resume",
                        "resume.pdf",
                        "application/pdf",
                        "dummy resume content".getBytes()
                );

        MockMultipartFile profile =
                new MockMultipartFile(
                        "profile",
                        "profile.png",
                        "image/png",
                        "dummy profile".getBytes()
                );

        UserDto savedDto = userService.createUser(dto,resume,profile);


        assertThat(savedDto).isNotNull();
        assertThat(savedDto.getEmail()).isEqualTo("test@gmail.com");
    }
}
