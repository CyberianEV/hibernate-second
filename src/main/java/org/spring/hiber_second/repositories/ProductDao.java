package org.spring.hiber_second.repositories;

import org.hibernate.Session;
import org.spring.hiber_second.data.Customer;
import org.spring.hiber_second.data.Order;
import org.spring.hiber_second.data.Product;
import org.spring.hiber_second.utils.SessionFactoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {
    SessionFactoryUtil factory;

    @Autowired
    public ProductDao(SessionFactoryUtil factory) {
        this.factory = factory;
    }

    public Product getProductById(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.beginTransaction().commit();
            return product;
        }
    }

    public List<Customer> getProductsCustomers(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Customer> customers = session
                    .createQuery("SELECT p.customers FROM Product p WHERE p.id = :id", Customer.class)
                    .setParameter("id", id)
                    .getResultList();
            session.getTransaction().commit();
            return customers;
        }
    }

    public List<Product> getAllProducts() {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("SELECT p FROM Product p", Product.class)
                            .getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    public List<Order> getProductsOrders(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Order> orders = session
                    .createQuery("SELECT p.orders FROM Product p WHERE p.id = :id", Order.class)
                    .setParameter("id", id)
                    .getResultList();
            session.getTransaction().commit();
            return orders;
        }
    }
}
