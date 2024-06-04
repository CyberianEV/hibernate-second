package org.spring.hiber_second.services;

import org.spring.hiber_second.data.Customer;
import org.spring.hiber_second.data.Product;
import org.spring.hiber_second.repositories.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    CustomerDao customerDao;

    @Autowired
    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Product> getCustomersProducts(Long id) {
        return customerDao.getCustomersProducts(id);
    }

    public List<Customer> getAllCustomers() {
        return customerDao.getAllCustomers();
    }
}
