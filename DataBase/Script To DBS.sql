CREATE TABLE address (
    address_id INT PRIMARY KEY,
    Pharmaaddresscist_id INT,
    street_address VARCHAR(255),
    city VARCHAR(255),
    state VARCHAR(255),
    zip_code VARCHAR(250),
    FOREIGN KEY (Pharmacist_id) REFERENCES pharmacist_db(pharmacist_id)
);

CREATE TABLE bill_table (
    bill_id INT AUTO_INCREMENT PRIMARY KEY,
    Order_id INT,
    pharmacist_id INT,
    Pharmacist_Name VARCHAR(250),
    medicine_id INT,
    Medicine_name VARCHAR(250),
    Quantity INT,
    Total_Amount DOUBLE,
    Discount_price INT,
    Discounted_price INT,
    To_Pay_Amount INT,
    Billing_Date DATETIME
);

CREATE TABLE cart_medicine (
    cart_id INT AUTO_INCREMENT PRIMARY KEY,
    pharmacist_id INT,
    medicine_id INT,
    quantity INT
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
    Medicine_Name VARCHAR(250),
    pharmacist_id INT,
    pharmacist_name VARCHAR(250),
    Price DOUBLE,
    ShippingAddress_id BIGINT,
    Order_Date DATETIME,
    Delivery_Date DATETIME,
    bill_id INT,
    createdAt DATETIME,
    created_at DATE,
    FOREIGN KEY (Medicine_id) REFERENCES medicine_db(Medicine_id),
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
    Address_ID VARCHAR(250),
    Password VARCHAR(255)
);
