
CREATE DATABASE `animal_shelter`;

USE `animal_shelter`;

DROP TABLE IF EXISTS `animal`;

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
  UNIQUE KEY `microchip_id` (`microchip_id`),
  KEY `microchip` (`microchip_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `animal` WRITE;
INSERT INTO `animal` VALUES ('34','george','Felis silvestris catus - Ragdoll',9,'Colorpoint cream, brown eyed','789000034','adopted'),('37','poppy','Felis silvestris catus - chausie',NULL,'tabby','6784563','adopted once, returned'),('56','peach','Felis silvestris catus - American ringtail',2,'brown, white markings','6758004','never adopted'),('76','amren','Felis silvestris catus - siamese',1,'cream, blue eyes, brown markings','5560009','never adopted'),('89','mor','Felis silvestris catus - British shorthair',1,'gray, blue eyed','4857004','ready for adoption');
UNLOCK TABLES;


DROP TABLE IF EXISTS `medical`;
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
  KEY `vet_office` (`clinic_id`),
  CONSTRAINT `medical_ibfk_1` FOREIGN KEY (`animal_id`) REFERENCES `animal` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


LOCK TABLES `medical` WRITE;
INSERT INTO `medical` VALUES ('34','234','5','2021-10-09','worms','deworming',80),('37','560','36','2021-09-01','respiratory infections','medicine A',150),('56','234','36','2021-09-23','perfect health','multivitamins',80),('76','234','37','2020-08-04','upset stomach','stomach medications',130),('89','234','8','2021-07-03','perfect health','none',80);
UNLOCK TABLES;


DROP TABLE IF EXISTS `person`;
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


LOCK TABLES `person` WRITE;
INSERT INTO `person` VALUES ('3','Atlas','Corrigan','1987-03-04','chefcorrigan@gmail.com','3126943416','768 abc lane, state b','78096','owns house',0,'never adopted'),('34','lily','bloom','1989-12-13','lbloom26@gmail.com','8904567892','124 example street, state','67850','rent',1,'never adopted before'),('56','Ryle','Kincaid','1985-06-12','rkincaid@gmail.com','7804567865','124 blue course drive, state','79600','owns house',1,'1 cat'),('57','kell','marsh','1972-08-17','kmaresh34@gmail.com','3126943416','abc lane, 1234','67086','rents',3,'1 dog, 1 cat'),('90','aaron','blackford','2000-01-03','ablackford@yahoo.com','9582830396','304, blockader lane','70890','owns',2,'never adopted');
UNLOCK TABLES;


DROP TABLE IF EXISTS `shelter_animal`;
CREATE TABLE `shelter_animal` (
  `animal_id` varchar(10) NOT NULL,
  `shelter_id` varchar(10) NOT NULL,
  `date_of_entry` date NOT NULL,
  `date_of_exit` date DEFAULT NULL,
  `adopter_id` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`animal_id`,`shelter_id`),
  CONSTRAINT `shelter_animal_ibfk_1` FOREIGN KEY (`animal_id`) REFERENCES `animal` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `shelter_animal` WRITE;
INSERT INTO `shelter_animal` VALUES ('34','45','2021-01-02','2021-04-03','34'),('37','3','2021-02-02','2021-06-07','3'),('56','45','2021-07-08',NULL,'123'),('76','3','2020-08-09',NULL,NULL),('89','3','2021-04-06',NULL,NULL);
UNLOCK TABLES;

DROP TABLE IF EXISTS `shelter_finance`;
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
  KEY `dateTransact` (`transaction_date`),
  CONSTRAINT `shelter_finance_ibfk_1` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `shelter_finance` WRITE;
INSERT INTO `shelter_finance` VALUES ('1295674',100,'cash',NULL,NULL,'2020-08-11'),('1295675',350,'echeck','lily bloom','34','2020-08-21'),('1295676',1000,'supplies echeck','rhys cohen',NULL,'2020-11-25'),('1295677',250,'bank-transfer','kell marsh','57','2020-11-30'),('1295678',1250,'echeck',NULL,NULL,'2020-12-12');
UNLOCK TABLES;


CREATE DATABASE `bookstore`;

USE `bookstore`;

DROP TABLE IF EXISTS `entity1`;
CREATE TABLE `entity1` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `entity1` WRITE;
UNLOCK TABLES;


DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES ('ameesha','123456','asaxen21@uic.edu');
UNLOCK TABLES;
