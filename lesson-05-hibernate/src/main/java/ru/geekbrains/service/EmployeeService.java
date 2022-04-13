package ru.geekbrains.service;

import org.springframework.stereotype.Service;
import ru.geekbrains.dao.impl.EmployeeDaoImpl;
import ru.geekbrains.model.Employee;

import java.util.List;

@Service
public class EmployeeService {

    private static EmployeeDaoImpl employeeDaoImpl;

    public EmployeeService() {
        employeeDaoImpl = new EmployeeDaoImpl();
    }

    public void persist(Employee entity) {
        employeeDaoImpl.openCurrentSessionWithTransaction();
        employeeDaoImpl.persist(entity);
        employeeDaoImpl.closeCurrentSessionWithTransaction();
    }

    public void update(Employee entity) {
        employeeDaoImpl.openCurrentSessionWithTransaction();
        employeeDaoImpl.update(entity);
        employeeDaoImpl.closeCurrentSessionWithTransaction();
    }

    public Employee findById(Long id) {
        employeeDaoImpl.openCurrentSession();
        Employee employee = employeeDaoImpl.findById(id);
        employeeDaoImpl.closeCurrentSession();
        return employee;
    }

    public void delete(Long id) {
        employeeDaoImpl.openCurrentSessionWithTransaction();
        Employee employee = employeeDaoImpl.findById(id);
        employeeDaoImpl.delete(employee);
        employeeDaoImpl.closeCurrentSessionWithTransaction();
    }

    public List<Employee> findAll() {
        employeeDaoImpl.openCurrentSession();
        List<Employee> employees = employeeDaoImpl.findAll();
        employeeDaoImpl.closeCurrentSession();
        return employees;
    }

    public void deleteAll() {
        employeeDaoImpl.openCurrentSessionWithTransaction();
        employeeDaoImpl.deleteAll();
        employeeDaoImpl.closeCurrentSessionWithTransaction();
    }

    public EmployeeDaoImpl employeeDao() {
        return employeeDaoImpl;
    }
}
