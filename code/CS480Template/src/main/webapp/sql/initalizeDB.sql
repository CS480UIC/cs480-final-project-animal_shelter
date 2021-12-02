-- MySQL dump 10.13  Distrib 8.0.19, for macos10.15 (x86_64)
--
-- Host: localhost    Database: animal_shelter
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
-- Current Database: `animal_shelter`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `animal_shelter` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `animal_shelter`;

--
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `animal` (
  `id` varchar(10) NOT NULL,
  `name` varchar(30) NOT NULL,
  `species` varchar(50) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `physical_description` varchar(100) NOT NULL,
  `microchip_id` varchar(10) DEFAULT NULL,
  `adoption_history` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `microchip_id` (`microchip_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` VALUES ('34','george','Felis silvestris catus - Ragdoll',9,'Colorpoint cream, brown eyed','789000034','adopted'),('37','poppy','Felis silvestris catus - chausie',NULL,'tabby','6784563','adopted once, returned'),('56','peach','Felis silvestris catus - American ringtail',2,'brown, white markings','6758004','never adopted'),('76','amren','Felis silvestris catus - siamese',1,'cream, blue eyes, brown markings','5560009','never adopted'),('89','mor','Felis silvestris catus - British shorthair',1,'gray, blue eyed','4857004','ready for adoption');
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medical`
--

DROP TABLE IF EXISTS `medical`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medical` (
  `animal_id` varchar(10) NOT NULL,
  `clinic_id` varchar(10) NOT NULL,
  `vet_id` varchar(10) NOT NULL,
  `date_of_visit` date NOT NULL,
  `diagnosis` varchar(100) NOT NULL,
  `prescription` varchar(100) NOT NULL,
  `total_due` int NOT NULL,
  PRIMARY KEY (`animal_id`,`clinic_id`,`vet_id`),
  UNIQUE KEY `animal_id` (`animal_id`),
  CONSTRAINT `medical_ibfk_1` FOREIGN KEY (`animal_id`) REFERENCES `animal` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medical`
--

LOCK TABLES `medical` WRITE;
/*!40000 ALTER TABLE `medical` DISABLE KEYS */;
/*!40000 ALTER TABLE `medical` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `person`
--

DROP TABLE IF EXISTS `person`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `person` (
  `id` varchar(10) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) NOT NULL,
  `dob` date NOT NULL,
  `email` varchar(50) NOT NULL,
  `phone` char(10) NOT NULL,
  `street_address` varchar(50) NOT NULL,
  `zip_code` varchar(10) NOT NULL,
  `housing_status` varchar(20) NOT NULL,
  `kids` int DEFAULT NULL,
  `adoption_history` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `person`
--

LOCK TABLES `person` WRITE;
/*!40000 ALTER TABLE `person` DISABLE KEYS */;
INSERT INTO `person` VALUES ('3','Atlas','Corrigan','1987-03-04','chefcorrigan@gmail.com','3126943416','768 abc lane, state b','78096','owns house',0,'never adopted'),('34','lily','bloom','1989-12-13','lbloom26@gmail.com','8904567892','124 example street, state','67850','rent',1,'never adopted before'),('56','Ryle','Kincaid','1985-06-12','rkincaid@gmail.com','7804567865','124 blue course drive, state','79600','owns house',1,'1 cat'),('57','kell','marsh','1972-08-17','kmaresh34@gmail.com','3126943416','abc lane, 1234','67086','rents',3,'1 dog, 1 cat'),('90','aaron','blackford','2000-01-03','ablackford@yahoo.com','9582830396','304, blockader lane','70890','owns',2,'never adopted');
/*!40000 ALTER TABLE `person` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shelter_animal`
--

DROP TABLE IF EXISTS `shelter_animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shelter_animal` (
  `animal_id` varchar(10) NOT NULL,
  `shelter_id` varchar(10) NOT NULL,
  `date_of_entry` date NOT NULL,
  `date_of_exit` date DEFAULT NULL,
  `adopter_id` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`animal_id`,`shelter_id`),
  CONSTRAINT `shelter_animal_ibfk_1` FOREIGN KEY (`animal_id`) REFERENCES `animal` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shelter_animal`
--

LOCK TABLES `shelter_animal` WRITE;
/*!40000 ALTER TABLE `shelter_animal` DISABLE KEYS */;
INSERT INTO `shelter_animal` VALUES ('34','45','2021-01-02','2021-04-03','34'),('37','3','2021-02-02','2021-06-07','3'),('56','45','2021-07-08',NULL,'123'),('76','3','2020-08-09',NULL,NULL),('89','3','2021-04-06',NULL,NULL);
/*!40000 ALTER TABLE `shelter_animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shelter_finance`
--

DROP TABLE IF EXISTS `shelter_finance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shelter_finance` (
  `transaction_id` varchar(10) NOT NULL,
  `transaction_value` int NOT NULL,
  `transaction_type` varchar(20) NOT NULL,
  `donor_name` varchar(50) DEFAULT NULL,
  `person_id` varchar(10) DEFAULT NULL,
  `transaction_date` date NOT NULL,
  PRIMARY KEY (`transaction_id`),
  UNIQUE KEY `transaction_id` (`transaction_id`),
  KEY `person_id` (`person_id`),
  CONSTRAINT `shelter_finance_ibfk_1` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shelter_finance`
--

LOCK TABLES `shelter_finance` WRITE;
/*!40000 ALTER TABLE `shelter_finance` DISABLE KEYS */;
INSERT INTO `shelter_finance` VALUES ('1295674',100,'cash',NULL,NULL,'2020-08-11'),('1295675',350,'echeck','lily bloom','34','2020-08-21'),('1295676',1000,'supplies echeck','rhys cohen',NULL,'2020-11-25'),('1295677',250,'bank-transfer','kell marsh','57','2020-11-30'),('1295678',1250,'echeck',NULL,NULL,'2020-12-12');
/*!40000 ALTER TABLE `shelter_finance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Current Database: `bookstore`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `bookstore` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `bookstore`;

--
-- Table structure for table `entity1`
--

DROP TABLE IF EXISTS `entity1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entity1` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entity1`
--

LOCK TABLES `entity1` WRITE;
/*!40000 ALTER TABLE `entity1` DISABLE KEYS */;
/*!40000 ALTER TABLE `entity1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
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

-- Dump completed on 2021-11-11 13:38:42
