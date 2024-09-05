package com.nsbm.ems.departmentservice.controller;

import com.nsbm.ems.departmentservice.model.Department;
import com.nsbm.ems.departmentservice.service.implementation.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//add document comment   ---> correct
@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentServiceImpl departmentService;

    @Autowired
    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    /**
     *
     * @param department
     * @return
     */
    @PostMapping("/save")
    public String saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    @PutMapping("/update/{id}")
    public String updateDepartment(@PathVariable int id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteDepartment(@PathVariable int id) {
        return departmentService.deleteDepartment(id);
    }

    @GetMapping("/all")
    public List getAllDepartments() {
        return departmentService.getDepartment();
    }

    @GetMapping("/search")
    public Optional<Department> searchDepartments(@RequestParam Integer id) {
        return departmentService.searchDepartment(id);
    }

    @GetMapping("/searchbyname")
    public Optional<Department> searchDepartmentsByName(@RequestParam String name) {
        return departmentService.getDepartmentByName(name);
    }
}
