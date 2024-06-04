package org.spring.hiber_second.services;

import org.spring.hiber_second.data.Order;
import org.spring.hiber_second.repositories.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    OrderDao orderDao;

    @Autowired
    public OrderService(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public List<Order> getAllOrders() {
        return orderDao.getAllOrders();
    }

    public Order getOrderById(Long id) {
        return orderDao.getOrderById(id);
    }
}
