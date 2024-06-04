package org.spring.hiber_second;

import org.spring.hiber_second.data.Product;
import org.spring.hiber_second.services.CustomerService;
import org.spring.hiber_second.services.OrderService;
import org.spring.hiber_second.services.ProductService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.NativeDetector;

import java.util.List;

@SpringBootApplication
public class HiberSecondApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext("org.spring.hiber_second");

		CustomerService customerService = context.getBean(CustomerService.class);
		ProductService productService = context.getBean(ProductService.class);
		OrderService orderService = context.getBean(OrderService.class);

		System.out.println("==============================");
		System.out.println(customerService.getAllCustomers());
		System.out.println("==============================");
		System.out.println();

		System.out.println("==============================");
		System.out.println(productService.getAllProducts());
		System.out.println("==============================");
		System.out.println();

		System.out.println("==============================");
		System.out.println(customerService.getCustomersProducts(1L).toString());
		System.out.println("==============================");
		System.out.println();

		System.out.println("==============================");
		System.out.println(productService.getProductsCustomers(3L).toString());
		System.out.println("==============================");
		System.out.println();

		System.out.println("==============================");
		System.out.println(orderService.getAllOrders());
		System.out.println("==============================");
		System.out.println();

		System.out.println("==============================");
		System.out.println(orderService.getOrderById(2L));
		System.out.println("==============================");
		System.out.println();

		System.out.println("==============================");
		System.out.println(productService.getProductOrders(2L));
		System.out.println("==============================");
		System.out.println();
	}

}
