package dbwebapp.service;

import dbwebapp.dao.CustomerDAO;
import dbwebapp.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    //need to inject Customer DAO
    @Autowired
    private CustomerDAO customerdao;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerdao.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer theCustomer) {
        customerdao.saveCustomer(theCustomer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        return customerdao.getCustomer(theId);
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        customerdao.deleteCustomer(theId);
    }
}
