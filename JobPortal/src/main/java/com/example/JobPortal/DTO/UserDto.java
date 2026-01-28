package com.example.JobPortal.DTO;

import com.example.JobPortal.Utils.AppUtils;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


@Data
public class UserDto {
    private Long id;
    @NotBlank
    private String userName;
    @NotBlank
    private  String email;
    @NotNull
    @Digits(integer = 10,fraction = 0)
    private Long contactNumber;
    @NotNull
    private AppUtils.UserRoles role;
    @NotNull
    private String companyName;
    @NotBlank
    private String location;
    @NotNull
    private String password;
    @NotBlank
    private String resume;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(Long contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUtils.UserRoles getRole() {
        return role;
    }

    public void setRole(AppUtils.UserRoles role) {
        this.role = role;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}
