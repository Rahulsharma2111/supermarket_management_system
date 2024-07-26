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
-- Table structure for table `adminuserdetails`
--

DROP TABLE IF EXISTS `adminuserdetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adminuserdetails` (
  `serial_no` int NOT NULL AUTO_INCREMENT,
  `username` varchar(30) NOT NULL,
  `password` varchar(25) NOT NULL,
  `name` varchar(20) NOT NULL,
  `email_Id` varchar(20) NOT NULL,
  `mobile_no` bigint NOT NULL,
  `address` varchar(40) NOT NULL,
  `date_time` datetime NOT NULL,
  `user_type` varchar(20) NOT NULL,
  PRIMARY KEY (`serial_no`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email_Id` (`email_Id`),
  UNIQUE KEY `mobile_no` (`mobile_no`)
) ENGINE=InnoDB AUTO_INCREMENT=1006 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adminuserdetails`
--

LOCK TABLES `adminuserdetails` WRITE;
/*!40000 ALTER TABLE `adminuserdetails` DISABLE KEYS */;
INSERT INTO `adminuserdetails` VALUES (1,'rahul123','','rahul','rahul123@gmail.com',9602353233,'jaipur raj 302026','2024-07-16 18:52:31','Admin'),(1001,'shiv123','','shiv','shiv123@gmail.com',9602547233,'jaipur raj 302025','2024-07-16 19:00:32','User'),(1002,'ram123','','ram','ram123@gmail.com',9645877233,'jaipur raj 302026','2024-07-16 19:08:12','User'),(1003,'dev123','dev123','dev','dev123@gmail.com',9785877233,'jaipur raj 302036','2024-07-17 16:53:33','User'),(1004,'a123','a123','aaa','aa123@gmail.com',9780277233,'jaipur raj 302036','2024-07-17 16:57:23','User'),(1005,'b123','b123','bbb','bb123@gmail.com',9780277113,'jaipur raj 302037','2024-07-17 17:18:42','User');
/*!40000 ALTER TABLE `adminuserdetails` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-07-17 19:31:45
