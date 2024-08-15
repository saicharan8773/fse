package com.exercise1.EmployeeManagementSystem;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class EmployeeService {

    private Session session;

    public EmployeeService(Session session) {
        this.session = session;
    }

    @SuppressWarnings("deprecation")
	public void saveEmployees(List<Employee> employees) {
        Transaction tx = session.beginTransaction();
        int batchSize = 30;
        int count = 0;
        
        for (int i = 0; i < employees.size(); i++) {
            session.save(employees.get(i));
            count++;
            
            if (count % batchSize == 0) {
                session.flush();
                session.clear();
            }
        }
        
        tx.commit();
    }
}
