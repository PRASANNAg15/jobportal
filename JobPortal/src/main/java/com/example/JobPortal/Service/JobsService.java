package com.example.JobPortal.Service;

import com.example.JobPortal.DTO.JobsDto;
import com.example.JobPortal.Entity.JobsEntity;
import com.example.JobPortal.Repository.JobRepository;
import com.example.JobPortal.UpdateDto.JobsUpdateDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.lang.String;

@Service
public class JobsService implements JobsServiceInterface {
    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public JobsDto createJobs(JobsDto dto) {
        JobsEntity jobsEntity=new JobsEntity();
        jobsEntity.setEmpId(dto.getEmpId());
        jobsEntity.setJobRole(dto.getJobRole());
        jobsEntity.setCompanyName(dto.getCompanyName());
        jobsEntity.setCompanyLogo(dto.getCompanyLogo());
        jobsEntity.setDescription(dto.getDescription());
        jobsEntity.setSalary(dto.getSalary());
        jobsEntity.setCategory(dto.getCategory());
        JobsEntity savedJob=jobRepository.save(jobsEntity);
        return modelMapper.map(savedJob,JobsDto.class);
    }

    @Override
    public JobsDto findJobDetails(long id) {
        JobsEntity job=jobRepository.findById(id).orElseThrow(()->new RuntimeException("Job Not Found"));
        return modelMapper.map(job, JobsDto.class);
    }

    @Override
    public List<JobsDto> findAllJobs() {
        List<JobsEntity> jobs= jobRepository.findAll();
        List<JobsDto> filteredJob=jobs.stream().map((job)->modelMapper.map(job,JobsDto.class)).toList();
        return filteredJob;
    }

    @Override
    public void deleteJob(long id) {
        JobsEntity jobId=jobRepository.findById(id).orElseThrow(()->new RuntimeException("Job ID not found"));
        jobRepository.delete(jobId);
    }

    @Override
    public JobsUpdateDto updateJob(long id, JobsUpdateDto dto) {
        JobsEntity jobsEntity=jobRepository.findById(id).orElseThrow(()->new RuntimeException("Invalid ID to update"));

        if(dto.getEmpId()!=null) {
            jobsEntity.setEmpId(dto.getEmpId());
        }
        if(dto.getJobRole()!=null && !dto.getJobRole().isEmpty()) {
            jobsEntity.setJobRole(dto.getJobRole());
        }
        if(dto.getCategory()!=null && !dto.getCategory().isEmpty()) {
            jobsEntity.setCategory(dto.getCategory());
        }
        if(dto.getDescription()!=null &&!dto.getDescription().isEmpty()) {
            jobsEntity.setDescription(dto.getDescription());
        }
        if(dto.getCompanyName()!=null && !dto.getCompanyName().isEmpty()) {
            jobsEntity.setCompanyName(dto.getCompanyName());
        }
        if(dto.getCompanyLogo()!=null && !dto.getCompanyLogo().isEmpty()) {
            jobsEntity.setCompanyLogo(dto.getCompanyLogo());
        }
        if(dto.getSalary()!=null) {
            jobsEntity.setSalary(dto.getSalary());
        }
               JobsEntity updatedJob=jobRepository.save(jobsEntity);
        return modelMapper.map(updatedJob,JobsUpdateDto.class);
    }
}
