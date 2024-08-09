package com.nsbm.ems.employeeservice.repo;

import com.nsbm.ems.employeeservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Integer> {
}
