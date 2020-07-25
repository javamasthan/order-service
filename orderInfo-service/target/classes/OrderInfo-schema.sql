DROP TABLE IF EXISTS order_info;
 
CREATE TABLE order_info (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  customer_name VARCHAR(250) NOT NULL,
  shipping_address VARCHAR(250) NOT NULL,
  order_items INT(4),
  orderedDate DATE DEFAULT NULL,
  total DOUBLE
  
);