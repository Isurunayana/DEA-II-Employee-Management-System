package com.nsbm.ems.authenticationservice.service;

import com.nsbm.ems.authenticationservice.model.User;
import com.nsbm.ems.authenticationservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
 package (user service impl exteds user service

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Example method to update a user

    public String updateUser(Long id, User userDetails) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setUsername(userDetails.getUsername());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setPassword(userDetails.getPassword());
            existingUser.setRoles(userDetails.getRoles());

            userRepository.save(existingUser);

            return "User updated successfully";
        } else {
            return "User not found";
        }


    }