package com.example.JobPortal.Repository;

import com.example.JobPortal.Entity.ApplicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<ApplicationEntity,Long> {
    List<ApplicationEntity> findByJobSeekerId(long id);
    List<ApplicationEntity> findByEmpId(long id);


}
