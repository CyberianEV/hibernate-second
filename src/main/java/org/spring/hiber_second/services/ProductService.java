package org.spring.hiber_second.services;

import org.spring.hiber_second.data.Customer;
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
        Product product = productDao.getProductById(id);
        return product.getCustomers();
    }

    public List<Product> getAllProducts() {
        return productDao.getAllProducts();
    }
}
