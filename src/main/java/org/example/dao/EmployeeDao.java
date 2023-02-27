package org.example.dao;

import org.example.model.Employee;

import java.util.List;

public interface EmployeeDao {
    void add(Employee employee);

    Employee getEmployeeById(int id);

    List<Employee> getEmployees();

    void updateEmployee(Employee employee);

    void deleteEmployeeById(int id);
}