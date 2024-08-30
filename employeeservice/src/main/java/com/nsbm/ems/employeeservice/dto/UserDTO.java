package com.nsbm.ems.employeeservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data // Generates getters, setters, toString, equals, and hashCode methods for all fields
public class UserDTO {
    private int id; // Unique identifier for the Employee
    private String name; //employee name
    private String address; // employee address
}
