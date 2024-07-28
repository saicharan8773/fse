package com.company.employeemanagement;

public interface EmployeeManagement {
    void addEmployee(Employee employee);
    Employee searchEmployee(String employeeId);
    void traverseEmployees();
    boolean deleteEmployee(String employeeId);
}
