package ru.geekbrains.dao.impl;

import org.springframework.stereotype.Repository;
import ru.geekbrains.dao.HibernateDao;
import ru.geekbrains.dao.config.HibernateUtil;
import ru.geekbrains.model.Employee;

import java.util.List;

@Repository
public class EmployeeDaoImpl extends HibernateUtil implements HibernateDao<Employee, Long> {

    public EmployeeDaoImpl() {
    }

    public void persist(Employee entity) {
        getCurrentSession().save(entity);
    }

    public void update(Employee entity) {
        getCurrentSession().update(entity);
    }

    public Employee findById(Long id) {
        Employee employee = getCurrentSession().get(Employee.class, id);
        return employee;
    }

    public void delete(Employee entity) {
        getCurrentSession().delete(entity);
    }

    @SuppressWarnings("unchecked")
    public List<Employee> findAll() {
        List<Employee> employees = (List<Employee>) getCurrentSession().createQuery("from Employee").list();
        return employees;
    }

    public void deleteAll() {
        List<Employee> entityList = findAll();
        for (Employee entity : entityList) {
            delete(entity);
        }
    }
}
