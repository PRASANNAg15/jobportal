package com.example.JobPortal;

import org.apache.catalina.mapper.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JobPortalApplication {
	@Bean
	ModelMapper modelMapper()

	{
		return new ModelMapper();
	}

	public static void main(String[] args) {


		SpringApplication.run(JobPortalApplication.class, args);
	}

}
