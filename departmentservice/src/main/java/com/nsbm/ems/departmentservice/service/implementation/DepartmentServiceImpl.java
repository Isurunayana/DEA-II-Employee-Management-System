package com.nsbm.ems.departmentservice.service.implementation;

import com.nsbm.ems.departmentservice.model.Department;
import com.nsbm.ems.departmentservice.repository.DepartmentRepository;
import com.nsbm.ems.departmentservice.service.DepartmentService;
import com.nsbm.ems.departmentservice.utills.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public String saveDepartment(Department department) {
        departmentRepository.save(department);
        return Constants.DEPARTMENT_SAVED_SUCCESSFULLY;
        //create a package call utill and add the class constant class -->
                //creta a package call impl add class DeparmentServiceImpl-interface(only signature) move this code to impl class -->
                //public class DeparmentServiceImpl extends DeparmentService  -->
                //add custom exception(package DepartmentNotFound) -->
    }
    @Override
    public List getDepartment() {
        return departmentRepository.findAll();
        //return "Department saved successfully";
    }

    @Override
    public Optional<Department> getDepartmentByName(String name) {
        return departmentRepository.findByName(name);
        //return "Department saved successfully";
    }

    @Override
    public Optional<Department> searchDepartment(Integer id) {
        return departmentRepository.findById(id);
        //return "Department saved successfully";
    }

    @Override
    public String updateDepartment(int id, Department department) {
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        if (optionalDepartment.isPresent()) {
            Department existingDepartment = optionalDepartment.get();
            existingDepartment.setName(department.getName());
            existingDepartment.setLocation(department.getLocation());
            departmentRepository.save(existingDepartment);
            return Constants.DEPARTMENT_UPDATED_SUCCESSFULLY;
        }
        return Constants.DEPARTMENT_NOT_FOUND;
    }

    @Override
    public String deleteDepartment(int id) {
        departmentRepository.deleteById(id);
        return Constants.DEPARTMENT_DELETED_SUCCESSFULLY;
    }
}
