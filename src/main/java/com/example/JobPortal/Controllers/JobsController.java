package com.example.JobPortal.Controllers;
import com.example.JobPortal.DTO.JobsDto;
import com.example.JobPortal.Service.JobsService;
import com.example.JobPortal.UpdateDto.JobsUpdateDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
@RestController
@RequestMapping("/jobs")
public class JobsController {
    @Autowired
    private JobsService jobsService;

    @PostMapping("/add")
    public ResponseEntity<JobsDto> addJob(@ModelAttribute @Valid JobsDto dto) throws IOException
    {
        JobsDto savedJobs=jobsService.createJobs(dto);
        return new  ResponseEntity<>(savedJobs, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JobsDto> findJob(@PathVariable long id)
    {
        JobsDto user=jobsService.findJobDetails(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<JobsDto>> findAll()
    {
        List<JobsDto> jobs=jobsService.findAllJobs();
        return new ResponseEntity<>(jobs,HttpStatus.OK);
    }


    @GetMapping("/company/{companyName}")
    public ResponseEntity<List<JobsDto>> findByName(@PathVariable  String companyName){
        List<JobsDto> matched=jobsService.findMatchingOnes(companyName);
        return new ResponseEntity<>(matched,HttpStatus.OK);
    }


    @GetMapping("/role/{role}")
    public ResponseEntity<List<JobsDto>> findByRole(@PathVariable String role)
    {
        List<JobsDto> matched=jobsService.findMatchingRoles(role);
        return new ResponseEntity<>(matched,HttpStatus.OK);
    }

    @GetMapping("/location/{location}")
    public ResponseEntity<List<JobsDto>> findByLocation(@PathVariable String location)
    {
        List<JobsDto> matched=jobsService.findMatchingLocations(location);
        return new ResponseEntity<>(matched,HttpStatus.OK);
    }

    @GetMapping("/salary/{salary}")
    public ResponseEntity<List<JobsDto>> findBySalary(@PathVariable long salary)
    {
        List<JobsDto> matched=jobsService.findMatchingSalary(salary);
        return new ResponseEntity<>(matched,HttpStatus.OK);
    }
    @GetMapping("/employerId/{id}")
    public ResponseEntity<List<JobsDto>> findByEmpId(@PathVariable long id)
    {
        List<JobsDto> matched=jobsService.findRelJobs(id);
        return new ResponseEntity<>(matched,HttpStatus.OK);
    }

    @GetMapping("/locationandrole/{location}/{role}")
    public ResponseEntity<List<JobsDto>> findByLocationAndRole(@PathVariable String location,@PathVariable String role)
    {
        List<JobsDto> matched=jobsService.findMatchingJobs(location,role);
        return new ResponseEntity<>(matched,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void removeJob(@PathVariable long id){
        jobsService.deleteJob(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<JobsUpdateDto> changeJob(@PathVariable long id,@ModelAttribute JobsUpdateDto dto) throws IOException {
        System.out.print("Patch");
        JobsUpdateDto job=jobsService.updateJob(id,dto);
        return new ResponseEntity<>(job,HttpStatus.OK);
    }

}
