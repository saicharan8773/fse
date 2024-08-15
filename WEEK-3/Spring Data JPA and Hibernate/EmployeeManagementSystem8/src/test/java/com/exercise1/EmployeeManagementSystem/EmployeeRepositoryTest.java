package com.exercise1.EmployeeManagementSystem;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private DepartmentRepository departmentRepo;

    @Test
    public void testFindEmployeeProjections() {
        // Setup test data
        Department dept = new Department();
        dept.setName("IT");
        departmentRepo.save(dept);

        Employee emp = new Employee();
        emp.setName("John Doe");
        emp.setEmail("john.doe@example.com");
        emp.setDepartment(dept);
        employeeRepo.save(emp);

        // Execute query
        List<EmployeeProjection> projections = employeeRepo.findEmployeeProjections();

        // Verify results
        assertThat(projections).hasSize(1);
        assertThat(projections.get(0).getName()).isEqualTo("John Doe");
        assertThat(projections.get(0).getEmail()).isEqualTo("john.doe@example.com");
        assertThat(projections.get(0).getDepartmentName()).isEqualTo("IT");
    }

    @Test
    public void testFindDepartmentProjections() {
        // Setup test data
        Department dept = new Department();
        dept.setName("HR");
        departmentRepo.save(dept);

        Employee emp = new Employee();
        emp.setName("Alice Smith");
        emp.setEmail("alice.smith@example.com");
        emp.setDepartment(dept);
        employeeRepo.save(emp);

        // Execute query
        List<DepartmentProjection> projections = employeeRepo.findDepartmentDTOs();

        // Verify results
        assertThat(projections).hasSize(1);
        assertThat(projections.get(0).getName()).isEqualTo("HR");
        assertThat(projections.get(0).getEmployeeNames()).contains("Alice Smith");
    }
}
