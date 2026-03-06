package com.example.JobPortal.Repository;

import com.example.JobPortal.Entity.JobsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface JobRepository extends JpaRepository<JobsEntity,Long> {
  Optional<List<JobsEntity>> findByCompanyName(String name);
  Optional<List<JobsEntity>> findByJobRole(String role);
  Optional<List<JobsEntity>> findByJobRoleAndLocation(String location, String role);
  Optional<List<JobsEntity>> findByLocation(String location);
  Optional<List<JobsEntity>> findBySalary(Long salary);
  Optional<List<JobsEntity>> findByEmpId(long id);

}
