package com.nsbm.ems.departmentservice.service;

import com.nsbm.ems.departmentservice.model.Department;

import java.util.List;
import java.util.Optional;

public interface DepartmentService {
    String saveDepartment(Department department);

    List getDepartment();

    Optional<Department> getDepartmentByName(String name);

    Optional<Department> searchDepartment(Integer id);

    String updateDepartment(int id, Department department);

    String deleteDepartment(int id);
}
