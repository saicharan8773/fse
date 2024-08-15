package com.exercise1.EmployeeManagementSystem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT new com.exercise1.EmployeeManagementSystem.EmployeeDTO(e.name, e.email, e.department.name) FROM Employee e")
    List<EmployeeDTO> findEmployeeDTOs();

    @Query("SELECT new com.exercise1.EmployeeManagementSystem.DepartmentDTO(d.name, d.employees.name) FROM Department d")
    List<DepartmentProjection> findDepartmentDTOs();

	Page<Employee> findByDepartmentName(String departmentName, Pageable pageable);

	List<Employee> findEmployeesByDepartmentName(String string);

	List<EmployeeProjection> findEmployeeProjections();
}
