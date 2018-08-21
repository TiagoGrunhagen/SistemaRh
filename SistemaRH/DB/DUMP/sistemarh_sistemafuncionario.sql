CREATE DATABASE  IF NOT EXISTS `sistemarh` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `sistemarh`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: sistemarh
-- ------------------------------------------------------
-- Server version	5.7.22-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `sistemafuncionario`
--

DROP TABLE IF EXISTS `sistemafuncionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sistemafuncionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `funcionarioId` int(11) NOT NULL,
  `sistemaId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `funcionarioId` (`funcionarioId`),
  KEY `sistemaId` (`sistemaId`),
  CONSTRAINT `sistemafuncionario_ibfk_1` FOREIGN KEY (`funcionarioId`) REFERENCES `funcionario` (`id`) ON DELETE CASCADE,
  CONSTRAINT `sistemafuncionario_ibfk_2` FOREIGN KEY (`sistemaId`) REFERENCES `sistema` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sistemafuncionario`
--

LOCK TABLES `sistemafuncionario` WRITE;
/*!40000 ALTER TABLE `sistemafuncionario` DISABLE KEYS */;
INSERT INTO `sistemafuncionario` VALUES (1,1,1),(2,4,5),(3,4,6),(4,5,5),(5,5,6),(6,6,5),(7,6,6);
/*!40000 ALTER TABLE `sistemafuncionario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-06-02 14:38:53
