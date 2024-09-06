package com.nsbm.ems.employeeservice.service;

import com.nsbm.ems.employeeservice.dto.UserDTO;
import java.util.List;

public interface UserService {
    UserDTO saveUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(UserDTO userDTO);
    boolean deleteUser(UserDTO userDTO);
}
