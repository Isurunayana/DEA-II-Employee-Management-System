package com.nsbm.ems.authenticationservice.service;


import com.nsbm.ems.authenticationservice.controler.RoleController;
import com.nsbm.ems.authenticationservice.model.Role;
import com.nsbm.ems.authenticationservice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<RoleController> getAllRoles() {
        return roleRepository.findAll();
    }

    public Role createRole(Role role) {
        return roleRepository.save(role);
    }

    public Role getRoleByName(String name) {
        return roleRepository.findByName(name);
    }
}

