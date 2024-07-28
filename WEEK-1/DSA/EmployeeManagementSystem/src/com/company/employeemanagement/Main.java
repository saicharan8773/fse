package com.company.employeemanagement;

public class Main {
    public static void main(String[] args) {
        EmployeeManagement employeeManagement = new EmployeeManagementImpl(5);

        Employee emp1 = new Employee("21501A0532", "Buvan", "Manager", 70000);
        Employee emp2 = new Employee("22505A0507", "Darshini", "Developer", 50000);
        Employee emp3 = new Employee("21501A0503", "Harsha", "Designer", 45000);
        Employee emp4 = new Employee("21501A0512", "Nireekshan", "Developer", 50000);

        employeeManagement.addEmployee(emp1);
        employeeManagement.addEmployee(emp2);
        employeeManagement.addEmployee(emp3);
        employeeManagement.addEmployee(emp4);

        System.out.println("Traverse Employees:");
        employeeManagement.traverseEmployees();

        System.out.println("\nSearch Employee with ID 21501A0503:");
        System.out.println(employeeManagement.searchEmployee("21501A0503"));

        System.out.println("\nDelete Employee with ID 22505A0507:");
        employeeManagement.deleteEmployee("22505A0507");
        employeeManagement.traverseEmployees();
    }
}
