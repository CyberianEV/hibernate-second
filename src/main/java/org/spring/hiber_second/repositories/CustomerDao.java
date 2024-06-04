package org.spring.hiber_second.repositories;

import org.hibernate.Session;
import org.spring.hiber_second.data.Customer;
import org.spring.hiber_second.utils.SessionFactoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDao {
    SessionFactoryUtil factory;

    @Autowired
    public CustomerDao(SessionFactoryUtil factory) {
        this.factory = factory;
    }

    public Customer getCustomerById(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.getTransaction().commit();
            return customer;
        }
    }

    public List<Customer> getAllCustomers() {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Customer> customers = session.createQuery("SELECT c FROM Customer c", Customer.class)
                            .getResultList();
            session.getTransaction().commit();
            return customers;
        }
    }
}
