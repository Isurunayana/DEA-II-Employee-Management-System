package com.nsbm.ems.departmentservice.repository;

import com.nsbm.ems.departmentservice.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}

//add the custom method -->
       // ex search by id -->