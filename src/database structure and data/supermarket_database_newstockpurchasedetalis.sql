-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: supermarket_database
-- ------------------------------------------------------
-- Server version	8.0.33

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
-- Table structure for table `newstockpurchasedetalis`
--

DROP TABLE IF EXISTS `newstockpurchasedetalis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `newstockpurchasedetalis` (
  `supplier_id` int NOT NULL AUTO_INCREMENT,
  `supplier_name` varchar(215) DEFAULT NULL,
  `mobile_no` bigint NOT NULL,
  `email_id` varchar(25) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  `district` varchar(30) DEFAULT NULL,
  `state` varchar(30) DEFAULT NULL,
  `pincode` mediumint NOT NULL,
  `vehicle_no` varchar(15) NOT NULL,
  `vehicle_type` varchar(15) NOT NULL,
  `vehicle_driver_name` varchar(20) NOT NULL,
  `vehicle_driver_Id` bigint NOT NULL,
  `driver_contact_no` bigint NOT NULL,
  `item_ID` int NOT NULL,
  `item_name` varchar(30) NOT NULL,
  `item_type` varchar(20) NOT NULL,
  `quantity` int NOT NULL,
  `rate_per_piece` decimal(10,2) NOT NULL,
  `expiry_date` date NOT NULL,
  `date_time` date NOT NULL,
  `total_amount` decimal(10,2) NOT NULL,
  PRIMARY KEY (`supplier_id`),
  KEY `newstockpurchasedetalis` (`item_type`),
  CONSTRAINT `newstockpurchasedetalis` FOREIGN KEY (`item_type`) REFERENCES `itemtypetable` (`item_type_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=249 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `newstockpurchasedetalis`
--

LOCK TABLES `newstockpurchasedetalis` WRITE;
/*!40000 ALTER TABLE `newstockpurchasedetalis` DISABLE KEYS */;
INSERT INTO `newstockpurchasedetalis` VALUES (135,'Bharat & food com.',9632587402,NULL,'12 street shiv nagar','Gandhi Nagar','Gujrate',254878,'GJ 14 CB1482','Truck','Rahul sharma',854793549015,8547021648,101,'Cream Bell','1557IC',35,190.00,'2024-11-15','2024-07-17',6650.00),(152,'Heavlls com.',9874563012,'healls12@email.com','south block','New Delhi','Delhi',254635,'DL 25 HJ 2548','Truck','Rahul Sharma',8972587530854,8627519043,102,'Led Blub','1547EI',105,25.00,'2025-10-15','2024-08-02',2625.00),(245,'Jio mart',9632587402,'rahu3@gmail.com','154/155 Shyam nager','Jaipur','Rajasthan',302030,'RJ45 KF 4875','Mini truck','Rahul',354793549548,9787021865,103,'Coca Cola','1587CD',57,102.53,'2024-11-15','2024-07-17',5844.21),(246,'Shiv and light company',9875879477,'shiv123@gmail.com','Narayan vihar, Ajmer road ','jaipur','Rajastha',302026,'RJ 14 SE 1421','Truck','Ram singh',687687954588,6573549544,104,'LG LED TV','1547EI',156,12500.00,'2028-12-18','2024-08-05',1950000.00),(247,'Shiv Hardware and metals',9876875487,'','Bhankrota, Ajmer Road','Jaipur','Rajasthan',302026,'RJ 14 NK 3425','Mini Truck','Kalu Jat',687588781254,6781548765,105,'Moniter Dell Led','4753PC',50,1980.00,'2028-05-10','2024-08-08',99000.00),(248,'Telecom service pvt ltd',9872547845,'','xyz sector , amritasir','Amritasir','Punjab',357456,'PJ 32 CH 9382','Big Truck','Diljit singh',95487524582458,8547359845,106,'Rice','1524FO',200,25.70,'2025-12-15','2024-08-28',5140.00);
/*!40000 ALTER TABLE `newstockpurchasedetalis` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-09 17:58:56
