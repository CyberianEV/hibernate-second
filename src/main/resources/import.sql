DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS products_customers;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS customers;

CREATE TABLE IF NOT EXISTS products (id BIGINT auto_increment NOT NULL, title varchar(100) NOT NULL, price DOUBLE NOT NULL, CONSTRAINT products_pk PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS customers (id BIGINT auto_increment NOT NULL, customer_name varchar(100) NOT NULL, CONSTRAINT customers_pk PRIMARY KEY (id));
CREATE TABLE IF NOT EXISTS products_customers (product_id BIGINT NOT NULL, customer_id BIGINT NOT NULL, CONSTRAINT products_customers_products_FK FOREIGN KEY (product_id) REFERENCES products(id), CONSTRAINT products_customers_customers_FK FOREIGN KEY (customer_id) REFERENCES customers(id));
CREATE TABLE IF NOT EXISTS orders (id BIGINT auto_increment NOT NULL, `date` DATE NOT NULL, customer_id BIGINT NOT NULL, product_id BIGINT NOT NULL, price DOUBLE NOT NULL, CONSTRAINT orders_pk PRIMARY KEY (id), CONSTRAINT orders_customers_FK FOREIGN KEY (customer_id) REFERENCES customers(id), CONSTRAINT orders_products_FK FOREIGN KEY (product_id) REFERENCES products(id));

INSERT INTO products (title, price) VALUES ('Lamp', 35.50), ('Table', 137.40), ('Sofa', 250);
INSERT INTO customers (customer_name) VALUES ('John'), ('Bob'), ('Helen'), ('Sophy');
INSERT INTO products_customers (customer_id, product_id) VALUES (1, 1), (1, 2), (2, 3), (3, 3), (3, 1), (3, 2), (4, 1), (4, 3);
INSERT INTO orders (`date`, customer_id, product_id, price) VALUES ('2024-01-01',1,1,33.70), ('2024-02-01',1,2,121.30), ('2024-03-01',2,3,235), ('2024-04-01',3,3,240), ('2024-05-01',3,1,34.50), ('2024-06-01',3,2,137.40), ('2024-07-01',4,1,35.50), ('2024-08-01',4,3,250);
