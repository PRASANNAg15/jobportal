package com.example.JobPortal.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class JobsDto {

   private Long id;
   @NotNull
   private Long empId;
   @NotBlank
   private String companyName;
   @NotBlank
   private String companyLogo;
   @NotBlank
   private String jobRole;
   @NotBlank
   private String description;
   @NotNull
   private Long salary;
   @NotBlank
   private String category;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Long getEmpId() {
      return empId;
   }

   public void setEmpId(Long empId) {
      this.empId = empId;
   }

   public String getCompanyName() {
      return companyName;
   }

   public void setCompanyName(String companyName) {
      this.companyName = companyName;
   }

   public String getCompanyLogo() {
      return companyLogo;
   }

   public void setCompanyLogo(String companyLogo) {
      this.companyLogo = companyLogo;
   }

   public String getJobRole() {
      return jobRole;
   }

   public void setJobRole(String jobRole) {
      this.jobRole = jobRole;
   }

   public String getDescription() {
      return description;
   }

   public void setDescription(String description) {
      this.description = description;
   }

   public Long getSalary() {
      return salary;
   }

   public void setSalary(Long salary) {
      this.salary = salary;
   }

   public String getCategory() {
      return category;
   }

   public void setCategory(String category) {
      this.category = category;
   }
}
