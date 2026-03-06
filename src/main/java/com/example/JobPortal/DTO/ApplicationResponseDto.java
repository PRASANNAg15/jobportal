package com.example.JobPortal.DTO;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ApplicationResponseDto {
   private String companyName;
   private String role;
  private Long id;
   private String status;
  private String resume;

   public String getResume() {
      return resume;
   }

   public void setResume(String resume) {
      this.resume = resume;
   }

   public String getCompanyName() {
      return companyName;
   }

   public void setCompanyName(String companyName) {
      this.companyName = companyName;
   }

   public String getRole() {
      return role;
   }

   public void setRole(String role) {
      this.role = role;
   }

   public String getStatus() {
      return status;
   }

   public void setStatus(String status) {
      this.status = status;
   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
