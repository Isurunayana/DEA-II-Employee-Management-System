package com.nsbm.ems.employeeservice.repo; // Changed package to repository

import com.nsbm.ems.employeeservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email); // Custom method to find a user by email
}