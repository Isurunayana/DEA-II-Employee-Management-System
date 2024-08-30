package com.nsbm.ems.employeeservice.repo;

import com.nsbm.ems.employeeservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Repository interface for employee entity, extending JpaRepository to provide CRUD operations
public interface UserRepo extends JpaRepository<User, Integer> {
}
