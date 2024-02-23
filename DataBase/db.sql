select * from  address;
select * from  bill_table;
select * from  cart;
select * from  cart_medicine;
select * from  distributor_db;
select * from  medicine_category;
select * from  medicine_db;
select * from  order_db;
select * from  order_medicine;
select * from pharmacist_db;
use drug_project_cdac;
use practise_during_creation;

Insert into pharmacist_db ( 
pharmacist_name,
License_Number ,
pharmacist_Email, 
Address ,
Password)
values
('Vishwas Verma','IB0785BHJ','vishwasv834@Gmail.com','Durg,C.G.','vishwas1234');


Insert into distributor_db ( 
distributor_name,
distributorEmail, 
Password)
values
('Vishwas Verma','vishwasv834@Gmail.com','vishwas1234');



DELIMITER //

CREATE TRIGGER reset_auto_increment_to_zero
BEFORE INSERT ON your_table_name
FOR EACH ROW
BEGIN
    IF NEW.auto_increment_column_name IS NULL THEN
        SET NEW.auto_increment_column_name = 0;
    END IF;
END;
//

DELIMITER ;



delete from pharmacist_db where pharmacist_id<>0;
delete from medicine_db where Medicine_id<>0;
delete from address where address_id<>0;
delete from medicine_category where Category_id<>0;
delete from cart where cart_id<>0;