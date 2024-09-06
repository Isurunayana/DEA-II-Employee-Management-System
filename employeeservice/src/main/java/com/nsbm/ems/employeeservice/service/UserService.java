package com.nsbm.ems.employeeservice.service;

import com.nsbm.ems.employeeservice.dto.UserDTO;
import com.nsbm.ems.employeeservice.entity.User;
import com.nsbm.ems.employeeservice.repo.UserRepo;
import jakarta.transaction.Transactional;  // Ensures transaction management
import org.modelmapper.ModelMapper; // Used for mapping between DTOs and entities
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service  // Service class annotated with @Service to indicate it's a Spring service component
@Transactional  // Ensures methods are run within a transaction contex
public class UserService {
    @Autowired    // Autowiring UserRepo for database operations
    private UserRepo userRepo;
    @Autowired  // Autowiring ModelMapper for mapping between employee and UserDTO
    private ModelMapper modelMapper;

    // Saves a new user to the database
    public UserDTO saveUser(UserDTO userDTO){
        // Maps UserDTO to User entity and saves it to the repository
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    // Retrieves all users from the database and maps them to a list of UserDTOs
    public List<UserDTO> getAllUsers(){
        // Fetches all users from the repository
        List<User>userList = userRepo.findAll();
        // Maps the list of User entities to a list of UserDTOs
        return modelMapper.map(userList, new TypeToken<List<UserDTO>>(){}.getType());
    }

    // Updates an existing user in the database
    public UserDTO updateUser(UserDTO userDTO){
        // Maps UserDTO to User entity and saves the update to the repository
        userRepo.save(modelMapper.map(userDTO,User.class));
        return userDTO;
    }

    // Deletes a user from the database
    public boolean deleteUser(UserDTO userDTO){
        // Maps UserDTO to User entity and deletes it from the repository
        userRepo.delete(modelMapper.map(userDTO,User.class));
        return true;
    }
}
