package com.nsbm.ems.departmentservice.service;

import com.nsbm.ems.departmentservice.model.Department;
import com.nsbm.ems.departmentservice.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public String saveDepartment(Department department) {
        departmentRepository.save(department);
        return "Department saved successfully";
        //create a package call utill and add the class constant class -->
                //creta a package call impl add class DeparmentServiceImpl-interface(only signature) move this code to impl class -->
                //public class DeparmentServiceImpl extends DeparmentService  -->
                //add custom exception(package DepartmentNotFound) -->
    }
    public List getDepartment() {
        return departmentRepository.findAll();
        //return "Department saved successfully";
    }

    public Optional<Department> searchDepartment(Integer id) {
        return departmentRepository.findById(id);
        //return "Department saved successfully";
    }

    public String updateDepartment(int id, Department department) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isPresent()) {
            Department existingDepartment = optionalDepartment.get();
            existingDepartment.setName(department.getName());
            existingDepartment.setLocation(department.getLocation());
            departmentRepository.save(existingDepartment);
            return "Department updated successfully";
        }
        return "Department not found";
    }

    public String deleteDepartment(int id) {
        departmentRepository.deleteById(id);
        return "Department deleted successfully";
    }
}
