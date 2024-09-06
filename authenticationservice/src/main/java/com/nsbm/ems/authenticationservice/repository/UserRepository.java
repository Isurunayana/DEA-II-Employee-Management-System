package com.nsbm.ems.authenticationservice.repository;

import com.nsbm.ems.authenticationservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserRepository, Long> {

    static void save(User user) {

    }

    UserRepository findByUsername(String username);
}

