package org.spring.hiber_second.repositories;

import org.hibernate.Session;
import org.spring.hiber_second.data.Customer;
import org.spring.hiber_second.data.Order;
import org.spring.hiber_second.utils.SessionFactoryUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao {
    SessionFactoryUtil factory;

    @Autowired
    public OrderDao(SessionFactoryUtil sessionFactoryUtil) {
        this.factory = sessionFactoryUtil;
    }

    public List<Order> getAllOrders() {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Order> orders = session.createQuery("SELECT o FROM Order o", Order.class)
                    .getResultList();
            session.getTransaction().commit();
            return orders;
        }
    }

    public Order getOrderById(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            Order order = session.get(Order.class, id);
            session.getTransaction().commit();
            return order;
        }
    }
}
