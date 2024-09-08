package com.nsbm.ems.departmentservice.service.implementation;

import com.nsbm.ems.departmentservice.model.Department;
import com.nsbm.ems.departmentservice.repository.DepartmentRepository;
import com.nsbm.ems.departmentservice.service.DepartmentService;
import com.nsbm.ems.departmentservice.utills.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementation of the DepartmentService interface.
 * This class handles all the business logic for managing departments.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    /**
     * Constructor for injecting the DepartmentRepository.
     *
     * @param departmentRepository the repository used for performing database operations
     */
    @Autowired
    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    /**
     * Saves a new department in the database.
     *
     * @param department the department entity to be saved
     * @return a success message indicating the department was saved
     */
    @Override
    public String saveDepartment(Department department) {
        departmentRepository.save(department);
        return Constants.DEPARTMENT_SAVED_SUCCESSFULLY;
    }

    /**
     * Retrieves all departments from the database.
     *
     * @return a list of all departments
     */
    @Override
    public List getDepartment() {
        return departmentRepository.findAll();
        //return "Department saved successfully";
    }

    /**
     * Retrieves a department by its name.
     *
     * @param name the name of the department to search for
     * @return an Optional containing the found department, or empty if not found
     */
    @Override
    public Optional<Department> getDepartmentByName(String name) {
        return departmentRepository.findByName(name);
        //return "Department saved successfully";
    }

    /**
     * Searches for a department by its ID.
     *
     * @param id the ID of the department to search for
     * @return an Optional containing the found department, or empty if not found
     */
    @Override
    public Optional<Department> searchDepartment(Integer id) {
        return departmentRepository.findById(id);
        //return "Department saved successfully";
    }

    /**
     * Updates an existing department's details.
     *
     * @param id        the ID of the department to update
     * @param department the updated department data
     * @return a message indicating whether the update was successful or if the department was not found
     */
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

    /**
     * Deletes a department by its ID.
     *
     * @param id the ID of the department to delete
     * @return a message indicating that the department was deleted
     */
    @Override
    public String deleteDepartment(int id) {
        departmentRepository.deleteById(id);
        return Constants.DEPARTMENT_DELETED_SUCCESSFULLY;
    }
}