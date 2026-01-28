package com.example.JobPortal.Repository;

import com.example.JobPortal.Entity.JobsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobsEntity,Long> {
}
