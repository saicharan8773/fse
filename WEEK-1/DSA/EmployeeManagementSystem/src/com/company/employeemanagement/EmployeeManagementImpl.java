package com.company.employeemanagement;

import java.util.Arrays;

public class EmployeeManagementImpl implements EmployeeManagement {
    private Employee[] employees;
    private int count;

    public EmployeeManagementImpl(int size) {
        employees = new Employee[size];
        count = 0;
    }

    @Override
    public void addEmployee(Employee employee) {
        if (count == employees.length) {
            employees = Arrays.copyOf(employees, employees.length * 2);
        }
        employees[count++] = employee;
    }

    @Override
    public Employee searchEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                return employees[i];
            }
        }
        return null;
    }

    @Override
    public void traverseEmployees() {
        for (int i = 0; i < count; i++) {
            System.out.println(employees[i]);
        }
    }

    @Override
    public boolean deleteEmployee(String employeeId) {
        for (int i = 0; i < count; i++) {
            if (employees[i].getEmployeeId().equals(employeeId)) {
                employees[i] = employees[count - 1];
                employees[--count] = null;
                return true;
            }
        }
        return false;
    }
}
