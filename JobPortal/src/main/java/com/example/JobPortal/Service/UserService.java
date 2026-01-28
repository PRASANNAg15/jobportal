package com.example.JobPortal.Service;


import com.example.JobPortal.DTO.AuthenticateDto;
import com.example.JobPortal.DTO.UserDto;
import com.example.JobPortal.Entity.UserEntity;
import com.example.JobPortal.Repository.UserRepository;
import com.example.JobPortal.UpdateDto.UserUpdateDto;
import org.apache.coyote.Response;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    public UserDto createUser(UserDto dto)
    {
        UserEntity userEntity=new UserEntity();
        userEntity.setUserName(dto.getUserName());
        userEntity.setEmail(dto.getEmail());
        userEntity.setLocation(dto.getLocation());
        userEntity.setRole(dto.getRole());
        userEntity.setContactNumber(dto.getContactNumber());
        userEntity.setCompanyName(dto.getCompanyName());
        userEntity.setPassword(dto.getPassword());
        userEntity.setResume(dto.getResume());
        UserEntity savedUser=userRepository.save(userEntity);
        return modelMapper.map(savedUser,UserDto.class);
    }

    public void deleteUser(long id){
        UserEntity user=userRepository.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
        userRepository.delete(user);
    }

    public List<UserDto> findAllUsers(){
       List<UserEntity> users=userRepository.findAll();
       List<UserDto> allUsers=users.stream().map(user->modelMapper.map(user,UserDto.class)).collect(Collectors.toList());

       return allUsers;
    }

    public UserDto findUserDetails( long id){
        UserEntity user=userRepository.findById(id).orElseThrow(()->new RuntimeException("Not Found"));
        return modelMapper.map(user,UserDto.class);
    }
    public UserUpdateDto updateUser(long id, UserUpdateDto dto)
    {
       UserEntity userEntity=userRepository.findById(id).orElseThrow(()->new RuntimeException("Invalid ID to Update"));
       if(dto.getResume()!=null && !dto.getResume().isEmpty()) {
           userEntity.setResume(dto.getResume());
       }
       if(dto.getUserName()!=null && !dto.getUserName().isEmpty()) {
           userEntity.setUserName(dto.getUserName());
       }
       if(dto.getRole()!=null) {
           userEntity.setRole(dto.getRole());
       }
       if(dto.getLocation()!=null && !dto.getLocation().isEmpty()) {
           userEntity.setLocation(dto.getLocation());
       }
       if(dto.getPassword()!=null) {
           userEntity.setPassword(dto.getPassword());
       }
       if(dto.getContactNumber()!=null) {
           userEntity.setContactNumber(dto.getContactNumber());
       }
       if(dto.getCompanyName()!=null && !dto.getCompanyName().isEmpty()) {
           userEntity.setCompanyName(dto.getCompanyName());
       }
       if(dto.getEmail()!=null && !dto.getEmail().isEmpty()) {
           userEntity.setEmail(dto.getEmail());
       }
       UserEntity updatedUser=userRepository.save(userEntity);
       return modelMapper.map(updatedUser,UserUpdateDto.class);
    }
    public AuthenticateDto authUser(AuthenticateDto dto)
    {
        UserEntity user=userRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword()).orElseThrow(()->new RuntimeException("Invalid Login Credentials"));
        return modelMapper.map(user,AuthenticateDto.class);
    }
}
