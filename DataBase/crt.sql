CREATE TABLE address (
    address_id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255),
    street_address VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    zip_code VARCHAR(20),
    mobile VARCHAR(20)
);

CREATE TABLE bill_table (
    bill_id INT AUTO_INCREMENT PRIMARY KEY,
    Order_id INT,
    pharmacist_id INT,
    Pharmacist_Name VARCHAR(250),
    medicine_id INT,
    Quantity INT,
    Total_Amount DOUBLE,
    Discount_price INT,
    Discounted_price INT,
    To_Pay_Amount INT,
    Billing_Date DATETIME,
    FOREIGN KEY (Order_id) REFERENCES order_db(order_id),
    FOREIGN KEY (pharmacist_id) REFERENCES pharmacist_db(pharmacist_id),
    FOREIGN KEY (medicine_id) REFERENCES medicine_db(Medicine_id)
);

CREATE TABLE cart_medicine (
    cart_id INT AUTO_INCREMENT PRIMARY KEY,
    pharmacist_id INT,
    medicine_id INT,
    quantity INT,
    FOREIGN KEY (pharmacist_id) REFERENCES pharmacist_db(pharmacist_id),
    FOREIGN KEY (medicine_id) REFERENCES medicine_db(Medicine_id)
);

CREATE TABLE distributor_db (
    Distributor_ID INT AUTO_INCREMENT PRIMARY KEY,
    distributor_name VARCHAR(255),
    distributorEmail VARCHAR(250),
    Password VARCHAR(250)
);

CREATE TABLE medicine_category (
    Category_id INT AUTO_INCREMENT PRIMARY KEY,
    Category_Name VARCHAR(255)
);

CREATE TABLE medicine_db (
    Medicine_id INT AUTO_INCREMENT PRIMARY KEY,
    Medicine_name VARCHAR(250),
    Category_id INT,
    Medicine_Quantity INT,
    Manufacture_date DATE,
    Unit_Price INT,
    FOREIGN KEY (Category_id) REFERENCES medicine_category(Category_id)
);

CREATE TABLE order_db (
    order_id INT AUTO_INCREMENT PRIMARY KEY,
    Medicine_id INT,
    pharmacist_id INT,
    Price DOUBLE,
    ShippingAddress_id BIGINT,
    Order_Date DATETIME,
    Delivery_Date DATETIME,
    bill_id INT,
    createdAt DATETIME,
    created_at DATE,
    FOREIGN KEY (Medicine_id) REFERENCES medicine_db(Medicine_id),
    FOREIGN KEY (pharmacist_id) REFERENCES pharmacist_db(pharmacist_id),
    FOREIGN KEY (bill_id) REFERENCES bill_table(bill_id)
);

CREATE TABLE order_medicine (
    order_id INT,
    medicine_id INT,
    quantity INT,
    PRIMARY KEY (order_id),
    FOREIGN KEY (order_id) REFERENCES order_db(order_id),
    FOREIGN KEY (medicine_id) REFERENCES medicine_db(Medicine_id)
);

CREATE TABLE pharmacist_db (
    pharmacist_id INT AUTO_INCREMENT PRIMARY KEY,
    pharmacist_name VARCHAR(250),
    License_Number VARCHAR(255),
    pharmacist_Email VARCHAR(150),
    Address_ID INT,
    Password VARCHAR(255),
    FOREIGN KEY (Address_ID) REFERENCES address(address_id)
);
CREATE TABLE `cart` (
  `cart_id` int NOT NULL AUTO_INCREMENT,
  `pharmacist_id` int NOT NULL,
  `total_item` int DEFAULT NULL,
  `total_price` int DEFAULT NULL,
  `totalPrice` int NOT NULL,
  PRIMARY KEY (`cart_id`),
  KEY `pharmacist_id` (`pharmacist_id`),
  CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`pharmacist_id`) REFERENCES `pharmacist_db` (`pharmacist_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


ALTER TABLE cart_medicine DROP FOREIGN KEY cart_medicine_ibfk_2;
ALTER TABLE cart_medicine DROP FOREIGN KEY cart_medicine_ibfk_2;
ALTER TABLE cart_medicine ADD CONSTRAINT cart_medicine_ibfk_2 FOREIGN KEY (medicine_id) REFERENCES medicine_db (Medicine_id) ON DELETE SET NULL ON UPDATE CASCADE;
