package org.example.service;

import org.example.dao.EmployeeDao;
import org.example.exceptions.EmpException;
import org.example.model.Employee;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeDao employeeDao;

    public EmployeeServiceImpl(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Override
    @Transactional
    public void add(Employee employee) {
        employeeDao.add(employee);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
            Employee employee = employeeDao.getEmployeeById(id);
            if (employee == null) {
                throw new EmpException("Employee with id = " + id + " doesn't exist");
            }
        return employeeDao.getEmployeeById(id);
    }

    @Override
    @Transactional
    public List<Employee> getEmployees() {
        return employeeDao.getEmployees();
    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }

    @Override
    @Transactional
    public void deleteEmployeeById(int id) {
        Employee employee = employeeDao.getEmployeeById(id);
        if (employee == null) {
            throw new EmpException("Employee with id = " + id + " doesn't exist");
        }

        employeeDao.deleteEmployeeById(id);
    }
}