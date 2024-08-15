package com.exercise1.EmployeeManagementSystem;

public class EmployeeDTO {
    private String name;
    private String email;
    private String departmentName;

    public EmployeeDTO(String name, String email, String departmentName) {
        this.name = name;
        this.email = email;
        this.departmentName = departmentName;
    }

    // Getters
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getDepartmentName() { return departmentName; }
}
