package com.nsbm.ems.departmentservice.repository;

import com.nsbm.ems.departmentservice.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

    Optional<Department> findByName(String name);
}
