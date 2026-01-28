package com.example.JobPortal.Controllers;
import com.example.JobPortal.DTO.JobsDto;
import com.example.JobPortal.Service.JobsService;
import com.example.JobPortal.UpdateDto.JobsUpdateDto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/jobs")
public class JobsController {
    @Autowired
    private JobsService jobsService;

    @PostMapping("/add")
    public ResponseEntity<JobsDto> addJob(@RequestBody @Valid JobsDto dto)
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

    @DeleteMapping("/delete/{id}")
    public void removeJob(@PathVariable long id){
        jobsService.deleteJob(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<JobsUpdateDto> changeJob(@PathVariable long id,@RequestBody JobsUpdateDto dto)
    {
        System.out.print("Patch");
        JobsUpdateDto job=jobsService.updateJob(id,dto);
        return new ResponseEntity<>(job,HttpStatus.OK);
    }

}
