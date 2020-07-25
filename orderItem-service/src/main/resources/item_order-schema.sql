DROP TABLE IF EXISTS item_order;
 
CREATE TABLE item_order (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  product_name VARCHAR(250) NOT NULL,
  product_code VARCHAR(250) NOT NULL,
  order_items INT(4)
);