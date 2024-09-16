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
-- Table structure for table `balancesheet`
--

DROP TABLE IF EXISTS `balancesheet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `balancesheet` (
  `serial_no` int NOT NULL AUTO_INCREMENT,
  `item_no` int NOT NULL,
  `item_name` varchar(50) NOT NULL,
  `quantity` int NOT NULL,
  `buy_price` double NOT NULL,
  `sell_price` double NOT NULL,
  `profit_per_piece` decimal(10,2) NOT NULL,
  `net_profit` decimal(10,2) NOT NULL,
  `date_Time` datetime DEFAULT NULL,
  PRIMARY KEY (`serial_no`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `balancesheet`
--

LOCK TABLES `balancesheet` WRITE;
/*!40000 ALTER TABLE `balancesheet` DISABLE KEYS */;
INSERT INTO `balancesheet` VALUES (1,105,'Moniter Dell Led',10,0,0,2100.20,21002.00,NULL),(2,102,'MotherBoard ',50,0,0,750.00,37500.00,'2024-08-25 18:14:58'),(3,106,'Rice',15,0,0,30.85,462.75,'2024-08-28 18:24:02'),(4,102,'MotherBoard ',11,0,0,750.00,8250.00,'2024-08-28 18:52:05'),(5,102,'MotherBoard ',30,650.58,705.8,55.22,-18811.60,'2024-09-09 17:08:09'),(6,102,'MotherBoard ',30,650.58,700,49.42,1482.60,'2024-09-09 17:27:47'),(7,102,'MotherBoard ',30,650.58,700,49.42,1482.60,'2024-09-09 17:31:01'),(8,102,'MotherBoard ',30,650.58,705.8,55.22,1656.60,'2024-09-09 17:34:13'),(9,102,'MotherBoard ',30,650.58,700,49.42,1482.60,'2024-09-09 17:42:40'),(10,102,'MotherBoard ',30,650.58,705.8,55.22,1656.60,'2024-09-09 17:44:39'),(11,102,'MotherBoard ',30,650.58,700.5,49.92,1497.60,'2024-09-09 17:56:33');
/*!40000 ALTER TABLE `balancesheet` ENABLE KEYS */;
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
