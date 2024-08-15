package com.exercise1.EmployeeManagementSystem;

import java.util.function.IntPredicate;

public interface EmployeeProjection {
    String getName();
    String getEmail();
	IntPredicate getDepartmentName();
}
