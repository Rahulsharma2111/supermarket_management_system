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
-- Table structure for table `selldetails`
--

DROP TABLE IF EXISTS `selldetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `selldetails` (
  `buyer_Id` int NOT NULL AUTO_INCREMENT,
  `buyer_name` varchar(30) NOT NULL,
  `mobile_no` varchar(11) DEFAULT NULL,
  `email_id` varchar(25) DEFAULT NULL,
  `payment_type` varchar(15) NOT NULL,
  `date_time` datetime NOT NULL,
  `item_ID` int NOT NULL,
  `iteam_name` varchar(25) DEFAULT NULL,
  `iteam_type` varchar(25) DEFAULT NULL,
  `expiry_date` date DEFAULT NULL,
  `quantity` int NOT NULL,
  `rate_per_piece` decimal(10,2) NOT NULL DEFAULT '0.00',
  `total_amount` decimal(10,2) NOT NULL DEFAULT '0.00',
  `discount` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`buyer_Id`),
  KEY `item_ID` (`item_ID`),
  CONSTRAINT `selldetails_ibfk_1` FOREIGN KEY (`item_ID`) REFERENCES `itemsdetails` (`item_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=116 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `selldetails`
--

LOCK TABLES `selldetails` WRITE;
/*!40000 ALTER TABLE `selldetails` DISABLE KEYS */;
INSERT INTO `selldetails` VALUES (101,'Rahul Sharma','9602353233','rahul123@gmail.com','Cash','2024-07-26 22:53:18',103,NULL,NULL,NULL,10,195.50,1955.00,0.00),(102,'Krishna Sharma','9877899877','','Cash','2024-08-09 17:17:13',105,'Moniter Dell Led','4753PC','2028-05-10',5,13500.00,67500.00,0.00),(103,'Neha Sharma','687789875','neha12@email.com','UPI','2024-08-10 13:25:55',105,'Moniter Dell Led','4753PC','2028-05-10',10,2100.20,21002.00,0.00),(104,'Fuli Devi','6579875487','','Debit cards','2024-08-10 13:35:23',105,'Moniter Dell Led','4753PC','2028-05-10',2,2000.50,4001.00,0.00),(105,'Ram Shyam','8524568745','','Cash','2024-08-25 18:14:58',102,'MotherBoard ','4753PC','2024-12-05',50,750.00,37500.00,0.00),(106,'Diljit Singh','9547865487','','Cash','2024-08-28 18:24:02',106,'Rice','1524FO','2025-12-15',15,30.85,462.75,0.00),(107,'Shiv','987658754','','UPI','2024-08-28 18:52:05',102,'MotherBoard ','4753PC','2024-12-05',11,750.00,8250.00,0.00),(109,'Rahul Sharma','9654859542','rahul.123@gmail.com','Credit cards','2024-09-09 17:08:09',102,'MotherBoard ','4753PC','2024-12-05',30,705.80,21174.00,0.00),(110,'rahul 1','7894568542','','UPI','2024-09-09 17:27:47',102,'MotherBoard ','4753PC','2024-12-05',30,700.00,21000.00,0.00),(111,'rahul 2','6548798524','','Cash','2024-09-09 17:31:01',102,'MotherBoard ','4753PC','2024-12-05',30,700.00,21000.00,0.00),(112,'rahul 3','7894568547','','Cash','2024-09-09 17:34:13',102,'MotherBoard ','4753PC','2024-12-05',30,705.80,21174.00,0.00),(113,'rahul 4','89754685794','','UPI','2024-09-09 17:42:40',102,'MotherBoard ','4753PC','2024-12-05',30,700.00,21000.00,0.00),(114,'rahul 5','9876549875','','Cash','2024-09-09 17:44:39',102,'MotherBoard ','4753PC','2024-12-05',30,705.80,21174.00,0.00),(115,'rahul 6','9876548547','','UPI','2024-09-09 17:56:33',102,'MotherBoard ','4753PC','2024-12-05',30,700.50,21015.00,0.00);
/*!40000 ALTER TABLE `selldetails` ENABLE KEYS */;
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
