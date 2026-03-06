package com.example.JobPortal.Service;

import com.example.JobPortal.DTO.JobsDto;
import com.example.JobPortal.UpdateDto.JobsUpdateDto;

import java.io.IOException;
import java.util.List;

public interface JobsServiceInterface {
    public JobsDto createJobs(JobsDto dto) throws IOException;

    public JobsDto findJobDetails(long id);

    public List<JobsDto> findAllJobs();

    public void deleteJob(long id);

    public JobsUpdateDto updateJob(long id, JobsUpdateDto dto) throws IOException;

    public List<JobsDto> findMatchingOnes(String name);

    public List<JobsDto> findMatchingRoles(String role);

    public List<JobsDto> findMatchingLocations(String location);

    public List<JobsDto> findMatchingSalary(Long salary);
    public List<JobsDto> findMatchingJobs(String location ,String role);
    public List<JobsDto> findRelJobs(long id);
}
