package com.nsbm.ems.departmentservice.controller;

import com.nsbm.ems.departmentservice.model.Department;
import com.nsbm.ems.departmentservice.service.implementation.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing department-related operations.
 * Provides endpoints for saving, updating, deleting, and retrieving department details.
 */
@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentServiceImpl departmentService;

    /**
     * Constructor to inject the department service implementation.
     *
     * @param departmentService the implementation of the DepartmentService
     */
    @Autowired
    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    /**
     * Endpoint to save a new department.
     *
     * @param department the department object to save
     * @return a success message upon saving the department
     */
    @PostMapping("/save")
    public String saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    /**
     * Endpoint to update an existing department.
     *
     * @param id the ID of the department to update
     * @param department the updated department object
     * @return a success message upon updating the department
     */
    @PutMapping("/update/{id}")
    public String updateDepartment(@PathVariable int id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    /**
     * Endpoint to delete a department by its ID.
     *
     * @param id the ID of the department to delete
     * @return a success message upon deleting the department
     */
    @DeleteMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable int id) {
        return departmentService.deleteDepartment(id);
    }

    /**
     * Endpoint to retrieve all departments.
     *
     * @return a list of all departments
     */
    @GetMapping("/all")
    public List getAllDepartments() {
        return departmentService.getDepartment();
    }

    /**
     * Endpoint to search for a department by its ID.
     *
     * @param id the ID of the department to search
     * @return an Optional containing the found department, or empty if not found
     */
    @GetMapping("/search")
    public Optional<Department> searchDepartments(@RequestParam Integer id) {
        return departmentService.searchDepartment(id);
    }

    /**
     * Endpoint to search for a department by its name.
     *
     * @param name the name of the department to search
     * @return an Optional containing the found department, or empty if not found
     */
    @GetMapping("/searchbyname")
    public Optional<Department> searchDepartmentsByName(@RequestParam String name) {
        return departmentService.getDepartmentByName(name);
    }
}
