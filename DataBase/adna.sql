use practise_during_creation;


select * from medicine_db as md
inner join medicine_category as cm where md.Category_id=cm.Category_id;
select * from medicine_category;
select * from medicine_db;
select * from order_medicine;
select * from order_db;
select * from bill_table;
select * from distributor_db;
select * from pharmacist_db;
select * from distributor_db;
select * from address;
SELECT VERSION();

delete from medicine_db where Medicine_id<>0;

CREATE TABLE cart (
    cart_id INT PRIMARY KEY AUTO_INCREMENT,
    pharmacist_id INT NOT NULL,
    total_item INT,
    total_price INT,
    FOREIGN KEY (pharmacist_id) REFERENCES pharmacist_db(pharmacist_id)
);

CREATE TABLE cart_medicine (
    cart_id INT,
    medicine_id INT,
    quantity INT,
    PRIMARY KEY (cart_id, medicine_id),
    FOREIGN KEY (cart_id) REFERENCES cart(cart_id),
    FOREIGN KEY (medicine_id) REFERENCES medicine_db(Medicine_id)
);


INSERT INTO medicine_category (Category_id, Category_Name,Medicine_Quantity)
VALUES
    (1, 'Painkillers','0'),
    (2, 'Antibiotics','0'),
    (3, 'Antipyretics','0'),
    (4, 'Antacids','0'),
    (5, 'Antihistamines','0'),
    (6, 'Anti-inflammatory','0'),
    (7, 'Emergency_Condition','0');
