package com.example.crudspringboot.dao;

import com.example.crudspringboot.Entity.Employee;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO{

    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Employee> findAll() {
        Query theQuery= (Query) entityManager.createQuery("from Employee");
        List<Employee> employees=theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class, theId);
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        Employee employee=entityManager.merge(theEmployee);
        theEmployee.setId(employee.getId());
    }

    @Override
    public void deleteById(int theId) {
        Query theQuery= (Query) entityManager.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId",theId);
        theQuery.executeUpdate();
    }
}
