package com.example.JobPortal.Entity;

import com.example.JobPortal.DTO.EducationDto;
import com.example.JobPortal.Utils.AppUtils;
import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.NotFound;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String userName;
    @Column(unique = true)
    private String email;
    @Column(unique = true)
    private Long contactNumber;
    @Enumerated(EnumType.STRING)
    @Column
    private AppUtils.UserRoles role;
    @Column
    private String location;
    @Column
    private String companyName;
    @Column
    private String password;
     @Column
    private String resumeURL;
     @Column
     private String profileURL;
     @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
     private List<EducationEntity> educations;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public AppUtils.UserRoles getRole() {
        return role;
    }

    public void setRole(AppUtils.UserRoles role) {
        this.role = role;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getResumeURL() {
        return resumeURL;
    }

    public void setResumeURL(String resumeURL) {
        this.resumeURL = resumeURL;
    }

    public String getProfileURL() {
        return profileURL;
    }

    public void setProfileURL(String profile) {
        this.profileURL = profile;
    }

    public List<EducationEntity> getEducations() {
        return educations;
    }

    public void setEducations(List<EducationEntity> educations) {
        this.educations = educations;
    }
}
