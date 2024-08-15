package com.exercise1.EmployeeManagementSystem;

import java.util.Set;

public class DepartmentDTO {
    private String name;
    private Set<String> employeeNames;

    public DepartmentDTO(String name, Set<String> employeeNames) {
        this.name = name;
        this.employeeNames = employeeNames;
    }

    // Getters
    public String getName() { return name; }
    public Set<String> getEmployeeNames() { return employeeNames; }
}
