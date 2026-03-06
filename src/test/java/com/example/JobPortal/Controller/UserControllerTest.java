package com.example.JobPortal.Controller;

import com.example.JobPortal.Controllers.UserController;
import com.example.JobPortal.DTO.UserDto;
import com.example.JobPortal.Service.UserService;
import com.example.JobPortal.Utils.AppUtils;
import com.example.JobPortal.Utils.JwtTokenFilter;
import com.example.JobPortal.Utils.JwtUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;


import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)
public class UserControllerTest {

    @MockBean
    private UserService service;

    private UserDto userDto;

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private JwtTokenFilter jwtFilter;

    @MockBean
    private JwtUtil jwtUtil;

@Autowired
   private ObjectMapper objectMapper;

   @BeforeEach
    public void setup()
   {
       userDto= new UserDto();
       userDto.setCompanyName("AWS");
       userDto.setUserName("Prasanna");
       userDto.setEmail("prasannag1505@gmail.com");
       userDto.setPassword("123Prasanna@");
       userDto.setRole(AppUtils.UserRoles.EMPLOYER);

   }

   @Test
    public void givenUserDetails_whenSaved_returnSavedUser() throws Exception {

       String userJson = objectMapper.writeValueAsString(userDto);


       MockMultipartFile userPart = new MockMultipartFile(
               "user",
               "",
               "application/json",
               userJson.getBytes()
       );


       MockMultipartFile profileFile = new MockMultipartFile(
               "profile",
               "logo.jpg",
               MediaType.IMAGE_JPEG_VALUE,
               "dummy-image".getBytes()
       );

       when(service.createUser(
               ArgumentMatchers.any(UserDto.class),
               ArgumentMatchers.any(),
               ArgumentMatchers.any()
       )).thenReturn(userDto);


       mockMvc.perform(multipart("/users/add")
                       .file(userPart)
                       .file(profileFile)
                       .contentType(MediaType.MULTIPART_FORM_DATA))
               .andExpect(status().isCreated())
               .andExpect(jsonPath("$.companyName").value("AWS"))
               .andExpect(jsonPath("$.email").value("prasannag1505@gmail.com"))
               .andExpect(jsonPath("$.role").value("EMPLOYER"));
   }
}
