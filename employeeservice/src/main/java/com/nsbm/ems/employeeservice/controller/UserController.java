package com.nsbm.ems.employeeservice.controller;

import com.nsbm.ems.employeeservice.dto.UserDTO;
import com.nsbm.ems.employeeservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public String getUser(){
        return "Chamath Hasaranga";
    }
    @PostMapping("/saveUser")
    public UserDTO saveUser(@RequestBody UserDTO userDTO){
        return userService.saveUser(userDTO);
    }
    @PutMapping("/updateUser")
    public String updateUser(){
        return "Update User";
    }
    @DeleteMapping("/deleteUser")
    public String deleterUser(){
        return "User Deleted";
    }
}
