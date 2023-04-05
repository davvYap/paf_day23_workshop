CREATE TABLE products (
 id INT PRIMARY KEY,
 standard_cost DECIMAL(10,2)
);

INSERT INTO products (id, standard_cost)
VALUES
 (1, 10.50),
 (2, 20.25),
 (3, 15.75),
 (4, 12.99),
 (5, 18.50),
 (6, 22.75),
 (7, 17.25),
 (8, 9.99),
 (9, 23.50),
 (10, 16.75);
 
 CREATE TABLE order_details (
 id INT PRIMARY KEY,
 order_id INT,
 quantity INT,
 unit_price DECIMAL(10,2),
 discount DECIMAL(10,2),
 product_id INT,
 FOREIGN KEY (order_id) REFERENCES orders(id),
 FOREIGN KEY (product_id) REFERENCES products(id)
);

INSERT INTO order_details (id, order_id, quantity, unit_price, discount, product_id)
VALUES
 (1, 1, 10, 20.00, 0.05, 1),
 (2, 1, 5, 15.00, 0.00, 2),
 (3, 2, 3, 12.50, 0.10, 1),
 (4, 2, 8, 18.75, 3.25, 3),
 (5, 3, 2, 25.00, 0.50, 2);
 
 select * from order_details od join products p on od.product_id = p.id;
 
 /*join 3 tables: orders, order_details, products*/
 select o.id as order_id, date_format(o.order_date, '%d/%m/%Y') as order_date , o.customer_id, 
 sum(od.quantity * od.unit_price ) as total_price,
 sum(od.quantity * od.unit_price * od.discount) as discount_total_price,
 sum(od.quantity * od.unit_price ) - sum(od.quantity * od.unit_price * od.discount) as discounted_price,
 sum(od.quantity * p.standard_cost) as cost_price
 from orders o join order_details od on o.id = od.order_id
 left join products p on od.product_id = p.id
--  group by o.id;
 where o.id = 1;