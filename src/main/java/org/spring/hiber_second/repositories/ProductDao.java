package org.spring.hiber_second.repositories;

import org.hibernate.Session;
import org.spring.hiber_second.data.Customer;
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

    public List<Product> getAllProducts() {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("SELECT p FROM Product p", Product.class)
                            .getResultList();
            session.beginTransaction().commit();
            return products;
        }
    }
}
