package com.example.crudspringboot.dao;

import com.example.crudspringboot.Entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDAOHibernateImpl implements EmployeeDAO {

    //Define Entity manager
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> findAll() {
        //get the current hibernate session
        Session currentSession=entityManager.unwrap(Session.class);
        //Create a query
        Query<Employee> tquery=currentSession.createQuery("from Employee",Employee.class);
        //execute query
        List<Employee> employees=tquery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        //get the current hibernate session
        Session currentSession=entityManager.unwrap(Session.class);
        //Create a query
        Employee theEmployee=currentSession.get(Employee.class,theId);
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        Session currentSession=entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery =
                currentSession.createQuery("delete from Employee where id=:employeeId");
        theQuery.setParameter("employeeId", theId);
        theQuery.executeUpdate();
    }
}
