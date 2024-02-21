CREATE DATABASE  IF NOT EXISTS `drug_project_cdac` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `drug_project_cdac`;
-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: localhost    Database: drug_project_cdac
-- ------------------------------------------------------
-- Server version	8.1.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `order_db`
--

DROP TABLE IF EXISTS `order_db`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_db` (
  `order_id` int NOT NULL AUTO_INCREMENT,
  `Medicine_id` int NOT NULL,
  `Medicine_Name` varchar(255) NOT NULL,
  `pharmacist_id` int NOT NULL,
  `pharmacist_name` varchar(255) NOT NULL,
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
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_db`
--

LOCK TABLES `order_db` WRITE;
/*!40000 ALTER TABLE `order_db` DISABLE KEYS */;
/*!40000 ALTER TABLE `order_db` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-21 13:45:27
