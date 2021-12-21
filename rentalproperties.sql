-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: rentalproperties
-- ------------------------------------------------------
-- Server version	8.0.23

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
-- Table structure for table `editfees`
--

DROP TABLE IF EXISTS `editfees`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `editfees` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `FeeAmount` int DEFAULT NULL,
  `Days` int DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editfees`
--

LOCK TABLES `editfees` WRITE;
/*!40000 ALTER TABLE `editfees` DISABLE KEYS */;
INSERT INTO `editfees` VALUES (1,30,60);
/*!40000 ALTER TABLE `editfees` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `landlord`
--

DROP TABLE IF EXISTS `landlord`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `landlord` (
  `lemail` varchar(500) NOT NULL,
  `messageID` int NOT NULL AUTO_INCREMENT,
  `message` varchar(500) DEFAULT NULL,
  `propertyID` int NOT NULL,
  PRIMARY KEY (`messageID`),
  KEY `lemail` (`lemail`),
  CONSTRAINT `lemail` FOREIGN KEY (`lemail`) REFERENCES `user` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `landlord`
--

LOCK TABLES `landlord` WRITE;
/*!40000 ALTER TABLE `landlord` DISABLE KEYS */;
INSERT INTO `landlord` VALUES ('bryan.steven@gmail.com',1,'bryans message',1),('bryan.steven@gmail.com',4,'bryans second message',11),('sandy.river@gmail.com',6,'sandys first message',9),('dan.lee@gmail.com',7,'dans first message',4);
/*!40000 ALTER TABLE `landlord` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `listing`
--

DROP TABLE IF EXISTS `listing`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `listing` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `email` varchar(500) NOT NULL,
  `propertyType` varchar(500) NOT NULL,
  `bedrooms` int NOT NULL,
  `bathrooms` int NOT NULL,
  `Furnished` tinyint NOT NULL,
  `quadrant` varchar(500) NOT NULL,
  `address` varchar(500) NOT NULL,
  `listingTime` varchar(500) NOT NULL,
  `status` varchar(500) NOT NULL,
  `balance` tinyint NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `email_idx` (`email`),
  CONSTRAINT `email` FOREIGN KEY (`email`) REFERENCES `user` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `listing`
--

LOCK TABLES `listing` WRITE;
/*!40000 ALTER TABLE `listing` DISABLE KEYS */;
INSERT INTO `listing` VALUES (1,'bryan.steven@gmail.com','Apartment',3,2,1,'NE','38 Rocky River St. AB J2N 9N1','2021-12-01','Active',1),(2,'dan.lee@gmail.com','Attached',4,3,1,'SE','148 Washington Street, AB N7A 8H2','2021-10-20','Canceled',0),(4,'dan.lee@gmail.com','Detached',6,3,0,'NW','705 Heritage Lane, AB E7G 9G8','2021-09-30','Suspended',0),(9,'sandy.river@gmail.com','Townhouse',2,2,0,'SW','628 Lake Ave, AB E2B 6S4','2021-06-08','Active',1),(10,'sandy.river@gmail.com','Apartment',1,1,0,'NW','8665 Bear Hill Street, AB B9A 1G5','2021-09-25','Active',1),(11,'bryan.steven@gmail.com','Townhouse',5,2,1,'SW','27 North Shore St, AB T9H 7N4','2021-11-16','Rented',1),(15,'bryan.steven@gmail.com','Detached Home',6,3,0,'NE','120 6th Ave, AB T4N 7KJ','2021-12-10','Suspended',0);
/*!40000 ALTER TABLE `listing` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `registeredrenter`
--

DROP TABLE IF EXISTS `registeredrenter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `registeredrenter` (
  `r_email` varchar(500) NOT NULL,
  `SID` int NOT NULL AUTO_INCREMENT,
  `propertyType` varchar(500) DEFAULT NULL,
  `bedrooms` int DEFAULT NULL,
  `bathrooms` int DEFAULT NULL,
  `Furnished` tinyint DEFAULT NULL,
  `quadrant` varchar(500) DEFAULT NULL,
  `notify` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`SID`),
  KEY `r_email` (`r_email`),
  CONSTRAINT `r_email` FOREIGN KEY (`r_email`) REFERENCES `user` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `registeredrenter`
--

LOCK TABLES `registeredrenter` WRITE;
/*!40000 ALTER TABLE `registeredrenter` DISABLE KEYS */;
INSERT INTO `registeredrenter` VALUES ('jade.lewis@gmail.com',1,'Appartment',3,2,1,'NE',NULL),('jade.lewis@gmail.com',3,'Townhouse',3,2,1,'NW',NULL),('lisa.marks@gmail.com',4,'Townhouse',2,2,0,'SW',NULL);
/*!40000 ALTER TABLE `registeredrenter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `email` varchar(500) NOT NULL,
  `password` varchar(500) NOT NULL,
  `FName` varchar(500) DEFAULT NULL,
  `LName` varchar(500) DEFAULT NULL,
  `Role` varchar(500) NOT NULL,
  PRIMARY KEY (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('bryan.steven@gmail.com','orange','Bryan','Steven','Landlord'),('charlie.lennon@gmail.com','house','Charlie','Lennon','Manager'),('dan.lee@gmail.com','pear','Dan','Lee','Landlord'),('jack.smith@gmail.com','apple','Jack','Smith','Manager'),('jade.lewis@gmail.com','grape','Jade','Lewis','RegisteredRenter'),('lisa.marks@gmail.com','garden','Lisa','Marks','RegisteredRenter'),('sandy.river@gmail.com','glass','Sandy','River','Landlord');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-10 18:59:59
