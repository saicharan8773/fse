package com.exercise1.EmployeeManagementSystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@SpringJUnitConfig
public class EmployeeManagementSystemApplicationTests {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private DepartmentRepository departmentRepo;

    @Test
    public void testFindEmployeesByDepartmentName() {
        // Setup test data
        Department dept = new Department();
        dept.setName("IT");
        departmentRepo.save(dept);

        Employee emp1 = new Employee();
        emp1.setName("SAI");
        emp1.setEmail("sai@gmail.com");
        emp1.setDepartment(dept);
        employeeRepo.save(emp1);

        Employee emp2 = new Employee();
        emp2.setName("Bob");
        emp2.setEmail("bob@example.com");
        emp2.setDepartment(dept);
        employeeRepo.save(emp2);

        // Execute query
        List<Employee> employees = employeeRepo.findEmployeesByDepartmentName("HR");

        // Verify results
        assertThat(employees).hasSize(2);
        assertThat(employees).extracting(Employee::getName).contains("Alice", "Bob");
    }
}
