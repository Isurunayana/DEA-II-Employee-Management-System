package com.nsbm.ems.employeeservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Marking the class as a JPA entity that maps to a database table
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    @Id // Marks this field as the primary key of the entity
    private int id;
    private String name;
    private String address;
    private String email; // User's email
    private double salary;
}
