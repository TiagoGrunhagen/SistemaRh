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
-- Table structure for table `diretordepartamento`
--

DROP TABLE IF EXISTS `diretordepartamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `diretordepartamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `diretorId` int(11) NOT NULL,
  `departamentoId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `diretorId` (`diretorId`),
  KEY `departamentoId` (`departamentoId`),
  CONSTRAINT `diretordepartamento_ibfk_1` FOREIGN KEY (`diretorId`) REFERENCES `diretor` (`id`) ON DELETE CASCADE,
  CONSTRAINT `diretordepartamento_ibfk_2` FOREIGN KEY (`departamentoId`) REFERENCES `departamento` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diretordepartamento`
--

LOCK TABLES `diretordepartamento` WRITE;
/*!40000 ALTER TABLE `diretordepartamento` DISABLE KEYS */;
INSERT INTO `diretordepartamento` VALUES (1,1,1),(2,2,4),(3,2,5),(4,2,6),(5,2,7),(6,2,8),(7,3,1),(8,3,2),(9,3,3),(10,3,4),(11,3,5),(12,3,6),(13,3,7),(14,3,8);
/*!40000 ALTER TABLE `diretordepartamento` ENABLE KEYS */;
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
