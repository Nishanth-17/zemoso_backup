package dbwebapp.dao;

import dbwebapp.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

    //need to inject the session factory
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        //get the hibernate session
        Session session=sessionFactory.getCurrentSession();
        //create a query
        Query<Customer> theQuery=session.createQuery("from Customer order by lastName" ,Customer.class);
        //execute Query and get results list
        List<Customer>  customers=theQuery.getResultList();
        //return results
        return customers;
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        //get current hibernate session
        Session session=sessionFactory.getCurrentSession();
        //save the customer into the db
        session.saveOrUpdate(theCustomer);
    }

    @Override
    public Customer getCustomer(int theId) {
        Session session=sessionFactory.getCurrentSession();
        Customer myCustomer=session.get(Customer.class,theId);
        return myCustomer;
    }

    @Override
    public void deleteCustomer(int theId) {
        Session session=sessionFactory.getCurrentSession();
        Customer myCustomer=session.get(Customer.class,theId);
        session.delete(myCustomer);
    }
}
