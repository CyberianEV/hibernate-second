package org.spring.hiber_second.services;

import org.spring.hiber_second.data.Customer;
import org.spring.hiber_second.data.Order;
import org.spring.hiber_second.data.Product;
import org.spring.hiber_second.repositories.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    ProductDao productDao;

    @Autowired
    public ProductService(ProductDao productDao) {
        this.productDao = productDao;
    }

    public List<Customer> getProductsCustomers(Long id) {
        return productDao.getProductsCustomers(id);
    }

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }

    public List<Order> getProductOrders(Long id) {
        return productDao.getProductsOrders(id);
    }
}
