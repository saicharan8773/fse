package com.exercise1.EmployeeManagementSystem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);

    Employee findByEmail(String email);

    @Query(name = "Employee.findByDepartmentName")
    List<Employee> findEmployeesByDepartmentName(String departmentName);

    @Query(name = "Employee.findByEmail")
    Employee findEmployeeByEmail(String email);
}
