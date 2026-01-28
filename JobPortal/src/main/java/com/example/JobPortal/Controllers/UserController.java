package com.example.JobPortal.Controllers;

import com.example.JobPortal.DTO.AuthenticateDto;
import com.example.JobPortal.DTO.UserDto;
import com.example.JobPortal.Service.UserService;
import com.example.JobPortal.UpdateDto.UserUpdateDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/users/add")
    public ResponseEntity<UserDto> addUser(@RequestBody @Valid UserDto dto)
    {
        UserDto savedUser=userService.createUser(dto);
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
    public ResponseEntity<UserUpdateDto> changeUser(@PathVariable long id,@RequestBody UserUpdateDto dto)
    {
        UserUpdateDto user=userService.updateUser(id,dto);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }


}
