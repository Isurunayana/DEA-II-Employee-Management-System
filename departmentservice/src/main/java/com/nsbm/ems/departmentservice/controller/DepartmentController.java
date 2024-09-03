package com.nsbm.ems.departmentservice.controller;

import com.nsbm.ems.departmentservice.model.Department;
import com.nsbm.ems.departmentservice.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//add document comment   --->
@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

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

    /*@GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable int id) {
        return departmentService.(id);
    }*/

    @GetMapping("/all")
    public List getAllDepartments() {
        return departmentService.getDepartment();
    }

    @GetMapping("/search")
    public Optional<Department> searchDepartments(@RequestParam Integer id) {
        return departmentService.searchDepartment(id);
    }
}
