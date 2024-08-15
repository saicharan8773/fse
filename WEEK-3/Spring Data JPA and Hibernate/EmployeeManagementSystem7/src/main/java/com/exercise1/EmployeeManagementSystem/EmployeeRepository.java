package com.exercise1.EmployeeManagementSystem;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByName(String name);

    Employee findByEmail(String email);

    @Query(name = "Employee.findByDepartmentName")
    List<Employee> findEmployeesByDepartmentName(String departmentName);

    @Query(name = "Employee.findByEmail")
    Employee findEmployeeByEmail(String email);

    // Pagination and Sorting
    Page<Employee> findAll(Pageable pageable);

	Page<Employee> findByDepartmentName(String departmentName, Pageable pageable);
}
