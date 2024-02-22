
CREATE TABLE `address` (
  `address_id` int NOT NULL AUTO_INCREMENT,
  `pharmacist_id` int NOT NULL,
  `pharmacist_Name` varchar(255) NOT NULL,
  `Full_Address` varchar(255) NOT NULL,
  PRIMARY KEY (`address_id`),
  KEY `pharmacist_id_idx` (`pharmacist_id`),
  CONSTRAINT `pharmacist_id` FOREIGN KEY (`pharmacist_id`) REFERENCES `pharmacist_db` (`pharmacist_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `bill_table` (
  `bill_id` int NOT NULL AUTO_INCREMENT,
  `Order_id` int NOT NULL,
  `pharmacist_id` int NOT NULL,
  `Pharmacist_Name` varchar(250) NOT NULL,
  `medicine_id` int NOT NULL,
  `Quantity` int NOT NULL,
  `Total_Amount` double NOT NULL,
  `Discount_price` int NOT NULL,
  `Discounted_price` int NOT NULL,
  `To_Pay_Amount` int NOT NULL,
  `Billing_Date` datetime NOT NULL,
  PRIMARY KEY (`bill_id`),
  KEY `ordr_idx` (`Order_id`),
  KEY `bill_table_ibfk_1` (`pharmacist_id`),
  KEY `bill_table_ibfk_2` (`medicine_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `cart_medicine` (
  `cart_id` int NOT NULL AUTO_INCREMENT,
  `pharmacist_id` int NOT NULL,
  `medicine_id` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`cart_id`),
  KEY `cart_medicine_ibfk_1` (`pharmacist_id`),
  KEY `cart_medicine_ibfk_2` (`medicine_id`),
  CONSTRAINT `cart_medicine_ibfk_1` FOREIGN KEY (`pharmacist_id`) REFERENCES `pharmacist_db` (`pharmacist_id`),
  CONSTRAINT `cart_medicine_ibfk_2` FOREIGN KEY (`medicine_id`) REFERENCES `medicine_db` (`Medicine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `distributor_db` (
  `Distributor_ID` int NOT NULL AUTO_INCREMENT,
  `distributor_name` varchar(255) NOT NULL,
  `distributorEmail` varchar(250) NOT NULL,
  `Password` varchar(250) NOT NULL,
  PRIMARY KEY (`Distributor_ID`),
  UNIQUE KEY `Distributor_ID_UNIQUE` (`Distributor_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `medicine_category` (
  `Category_id` int NOT NULL AUTO_INCREMENT,
  `Category_Name` varchar(255) NOT NULL,
  `Medicine_Quantity` int NOT NULL,
  PRIMARY KEY (`Category_id`),
  UNIQUE KEY `Category_Name_UNIQUE` (`Category_Name`),
  UNIQUE KEY `Category_id_UNIQUE` (`Category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `medicine_db` (
  `Medicine_id` int NOT NULL AUTO_INCREMENT,
  `Medicine_name` varchar(250) NOT NULL,
  `Category_id` int NOT NULL,
  `Quantity` int NOT NULL,
  `Manufacture_date` datetime NOT NULL,
  `Unit_Price` int NOT NULL,
  PRIMARY KEY (`Medicine_id`),
  KEY `medicine_db_ibfk_1` (`Category_id`),
  CONSTRAINT `medicine_db_ibfk_1` FOREIGN KEY (`Category_id`) REFERENCES `medicine_category` (`Category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `order_db` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `Medicine_id` int NOT NULL,
  `pharmacist_id` int NOT NULL,
  `Price` double NOT NULL,
  `ShippingAddress_id` int NOT NULL,
  `Order_Date` datetime NOT NULL,
  `Delivery_Date` datetime NOT NULL,
  `bill_id` int NOT NULL,
  `createdAt` datetime NOT NULL,
  PRIMARY KEY (`order_id`),
  KEY `order_db_ibfk_1` (`Medicine_id`),
  KEY `order_db_ibfk_2` (`pharmacist_id`),
  KEY `order_db_ibfk_3` (`bill_id`),
  CONSTRAINT `order_db_ibfk_1` FOREIGN KEY (`Medicine_id`) REFERENCES `medicine_db` (`Medicine_id`),
  CONSTRAINT `order_db_ibfk_2` FOREIGN KEY (`pharmacist_id`) REFERENCES `pharmacist_db` (`pharmacist_id`),
  CONSTRAINT `order_db_ibfk_3` FOREIGN KEY (`bill_id`) REFERENCES `bill_table` (`bill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `order_medicine` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `medicine_id` int NOT NULL,
  `quantity` int NOT NULL,
  PRIMARY KEY (`order_id`),
  UNIQUE KEY `medicine_id_UNIQUE` (`medicine_id`),
  CONSTRAINT `order_medicine_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `order_db` (`order_id`),
  CONSTRAINT `order_medicine_ibfk_2` FOREIGN KEY (`medicine_id`) REFERENCES `medicine_db` (`Medicine_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `pharmacist_db` (
  `pharmacist_id` int NOT NULL AUTO_INCREMENT,
  `pharmacist_name` varchar(250) NOT NULL,
  `License_Number` varchar(255) NOT NULL,
  `pharmacist_Email` varchar(150) NOT NULL,
  `Address` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  PRIMARY KEY (`pharmacist_id`),
  UNIQUE KEY `lnu` (`License_Number`),
  UNIQUE KEY `peu` (`pharmacist_Email`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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
