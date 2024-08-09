package com.nsbm.ems.employeeservice;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class EmployeeserviceApplication {
	public static void main(String[] args) {SpringApplication.run(EmployeeserviceApplication.class, args);}
    @Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
		}
	}