package com.example.JobPortal.Service;

import com.example.JobPortal.DTO.JobsDto;
import com.example.JobPortal.UpdateDto.JobsUpdateDto;

import java.util.List;

public interface JobsServiceInterface {
    public JobsDto createJobs(JobsDto dto);

    public JobsDto findJobDetails(long id);

    public List<JobsDto> findAllJobs();

    public void deleteJob(long id);

    public JobsUpdateDto updateJob(long id, JobsUpdateDto dto);
}
