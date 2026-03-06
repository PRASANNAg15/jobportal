package com.example.JobPortal.Controllers;

import com.example.JobPortal.DTO.AuthenticateDto;
import com.example.JobPortal.DTO.AuthenticateResponseDto;
import com.example.JobPortal.DTO.UserDto;
import com.example.JobPortal.Service.UserService;
import com.example.JobPortal.UpdateDto.UserUpdateDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<UserDto> addUser( @RequestPart("user") UserDto dto,
                                            @RequestPart(value = "resume", required = false) MultipartFile resume,
                                            @RequestPart(value = "profile", required = false) MultipartFile profile) throws IOException {
        UserDto savedUser=userService.createUser(dto,resume,profile);
        return new  ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findUser(@PathVariable long id)
    {
        UserDto user=userService.findUserDetails(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll()
    {
        List<UserDto> users=userService.findAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @DeleteMapping("/delete/{id}")
    public void removeUser(@PathVariable long id){
        userService.deleteUser(id);
    }
    @PatchMapping("/update/{id}")
    public ResponseEntity<UserUpdateDto> changeUser(@PathVariable long id,@ModelAttribute UserUpdateDto dto) throws IOException {
        UserUpdateDto user=userService.updateUser(id,dto);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PostMapping("/auth")
    public ResponseEntity<AuthenticateResponseDto> loginUser(@RequestBody AuthenticateDto dto){
        AuthenticateResponseDto user=userService.authUser(dto);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }


}
