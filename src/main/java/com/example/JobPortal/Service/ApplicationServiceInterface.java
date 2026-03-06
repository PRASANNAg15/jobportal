package com.example.JobPortal.Service;

import com.example.JobPortal.DTO.ApplicationDto;
import com.example.JobPortal.DTO.ApplicationResponseDto;
import com.example.JobPortal.UpdateDto.ApplicationUpdateDto;

import java.util.List;

public interface ApplicationServiceInterface {

    public ApplicationDto addApplication(ApplicationDto dto);

    public ApplicationUpdateDto update(long id, ApplicationUpdateDto dto);

    public List<ApplicationDto> findAll();

    public ApplicationDto findApplicationId(long id);

    public void DeleteApplication(long id);
    public List<ApplicationResponseDto> jobSeeker(long id);
    public List<ApplicationResponseDto> employer(long id);
}
