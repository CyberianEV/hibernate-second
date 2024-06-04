package org.spring.hiber_second.repositories;

import org.hibernate.Session;
import org.spring.hiber_second.data.Customer;
import org.spring.hiber_second.data.Product;
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

    public List<Product> getCustomersProducts(Long id) {
        try (Session session = factory.getSession()) {
            session.beginTransaction();
            List<Product> products = session
                    .createQuery("SELECT c.products FROM Customer c WHERE c.id = :id", Product.class)
                    .setParameter("id", id)
                    .getResultList();

//            Вариант выше отлично работает, однако если сделать так:
//
//            Customer customer = session.get(Customer.class, id);
//            List<Product> products = customer.getProducts();
//
//            то лист продуктов не "фетчится" в полученный объект Customer,
//            т.е. вызов геттера не заставляет Hibernate "джойнить" таблицы и наполнять из связанных таблиц
//            атрибут связанный с этим геттером (в данном случае products). С другой стороны,
//            если вызвать для этого атриббута печать в консоль (sout) или просто попросить посчитать размер List
//            (product.size()), то Hibernate выполнит JOIN запрос и заполнит products значениями из связанной таблицы
//            Вопрос: почему для этой цели не работает геттер и какой есть "правильный" способ, чтоб он заработал?

            session.getTransaction().commit();
            return products;
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
