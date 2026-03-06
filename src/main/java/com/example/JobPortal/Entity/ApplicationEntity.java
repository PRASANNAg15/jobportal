package com.example.JobPortal.Entity;

import com.example.JobPortal.Utils.AppUtils;
import jakarta.persistence.*;

import java.lang.reflect.Type;

@Entity
public class ApplicationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long jobSeekerId;

    @Column(nullable = false)
    private String resume;
    @ManyToOne
    @JoinColumn(name = "job_id",referencedColumnName = "id")
    private JobsEntity jobId;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private AppUtils.status status;

    @Column
    private Long empId;

    public Long getEmpId() {
        return empId;
    }

    public void setEmpId(Long empId) {
        this.empId = empId;
    }

  public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJobSeekerId() {
        return jobSeekerId;
    }

    public void setJobSeekerId(Long jobSeekerId) {
        this.jobSeekerId = jobSeekerId;
    }


    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public AppUtils.status getStatus() {
        return status;
    }

    public void setStatus(AppUtils.status status) {
        this.status = status;
    }

    public JobsEntity getJobId() {
        return jobId;
    }

    public void setJobId(JobsEntity jobId) {
        this.jobId = jobId;
    }
}
