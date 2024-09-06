package com.nsbm.ems.departmentservice.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Entity class representing a department in the system.
 * This class uses Lombok annotations to automatically generate
 * boilerplate code like getters, setters, constructors, etc.
 */
@Entity
@Data
@NoArgsConstructor

public class Department {

    /**
     * Unique identifier for the department.
     * The value is auto-generated using an identity strategy.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String location;
    /**
     * constructors,getters and setters are automatically genarated by lomboc
     */
}
