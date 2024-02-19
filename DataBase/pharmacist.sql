ROLLback;

use drug_project_cdac;


select * from address;
select * from pharmacist_db;
select * from medicine_db;
select * from medicine_category;

-- Insert data into pharmacist_db table with auto-incremented pharmacist_id
INSERT INTO pharmacist_db (pharmacist_name, pharmacist_Email, Password) 
VALUES
('John Smith', 'john@example.com', CONCAT('john', 'Karnataka')),
('Emily Johnson', 'emily@example.com', CONCAT('emily', 'Maharashtra')),
('Michael Brown', 'michael@example.com', CONCAT('michael', 'Delhi')),
('Jessica Davis', 'jessica@example.com', CONCAT('jessica', 'Tamil Nadu')),
('Christopher Wilson', 'chris@example.com', CONCAT('chris', 'Telangana'));

-- Create a trigger to insert data into the address column of pharmacist_db
DELIMITER //
CREATE TRIGGER insert_address_trigger AFTER INSERT ON address
FOR EACH ROW
BEGIN
    INSERT INTO pharmacist_db (Address) VALUES (NEW.pharmacist_id);
END;
//
DELIMITER ;
DELIMITER //

CREATE TRIGGER insert_address_trigger
AFTER INSERT ON pharmacist_db
FOR EACH ROW
BEGIN
    INSERT INTO address (pharmacist_id, pharmacist_Name,Full_Address)
    VALUES (NEW.pharmacist_id, NEW.pharmacist_name, NEW.Address);
END;
//

DELIMITER ;



INSERT INTO pharmacist_db (pharmacist_name, License_Number, pharmacist_Email, Address, Password)
VALUES 
('John Smith', 'IN123456', 'john@example.com', '123 Main Street, Bangalore, Karnataka', 'password123'),
('Emily Johnson', 'IN234567', 'emily@example.com', '456 Elm Avenue, Mumbai, Maharashtra', 'password456'),
('Michael Brown', 'IN345678', 'michael@example.com', '789 Oak Lane, New Delhi, Delhi', 'password789'),
('Jessica Davis', 'IN456789', 'jessica@example.com', '1011 Pine Road, Chennai, Tamil Nadu', 'password101'),
('Christopher Wilson', 'IN567890', 'chris@example.com', '1213 Cedar Street, Hyderabad, Telangana', 'password2022');
