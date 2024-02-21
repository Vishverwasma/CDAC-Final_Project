use drug_project_cdac;

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


UPDATE pharmacist_db
SET License_Number = 'IN123456'
WHERE pharmacist_id = 1;

UPDATE pharmacist_db
SET License_Number = 'IN234567'
WHERE pharmacist_id = 2;

UPDATE pharmacist_db
SET License_Number = 'IN345678'
WHERE pharmacist_id = 3;

UPDATE pharmacist_db
SET License_Number = 'IN456789'
WHERE pharmacist_id = 4;

UPDATE pharmacist_db
SET License_Number = 'IN567890'
WHERE pharmacist_id = 5;

