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
-- Table structure for table `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `funcionario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `sobrenome` varchar(50) NOT NULL,
  `rg` varchar(50) NOT NULL,
  `cpf` varchar(50) NOT NULL,
  `telefone` varchar(50) NOT NULL,
  `senha` varchar(50) DEFAULT NULL,
  `salario` double NOT NULL,
  `nivel` int(11) NOT NULL,
  `cargo` varchar(50) NOT NULL,
  `departamentoId` int(11) NOT NULL,
  `cargoId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `departamentoId` (`departamentoId`),
  CONSTRAINT `funcionario_ibfk_1` FOREIGN KEY (`departamentoId`) REFERENCES `departamento` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `funcionario`
--

LOCK TABLES `funcionario` WRITE;
/*!40000 ALTER TABLE `funcionario` DISABLE KEYS */;
INSERT INTO `funcionario` VALUES (1,'John','Doe','124480213','000.000.000-00','(41) 99999-9999','123456',2200,3,'Diretor',1,1),(2,'Bryan','Kennedy','124480213','111.111.111-11','(41) 99999-9999',NULL,1320,1,'Limpeza',7,NULL),(3,'Dora','Park','124480213','222.222.222-22','(41) 99999-9999',NULL,2000,3,'Limpeza',7,NULL),(4,'Jhon','Cruz','124480213','333.333.333-33','(41) 99999-9999','123456',2200,1,'Programador',4,NULL),(5,'Quentin','Williams','124480213','444.444.444-44','(41) 99999-9999','123456',2500,3,'Programador',4,NULL),(6,'Tyrone','Smith','124480213','555.555.555-55','(41) 99999-9999','123456',3000,2,'Analista',4,NULL),(7,'Pamela','Wyatt','124480213','666.666.666-66','(41) 99999-9999',NULL,3500,3,'Limpeza',4,NULL),(8,'Dante','Kellet','124480213','777.777.777-77','(41) 99999-9999','123456',6000,3,'Gerente',4,1),(9,'John','Samora','124480213','888.888.888-88','(41) 99999-9999','123456',9000,3,'Diretor',8,2),(10,'Shirley','Fontenot','124480213','999.999.999-99','(41) 99999-9999','123456',10000,3,'Diretor',8,3);
/*!40000 ALTER TABLE `funcionario` ENABLE KEYS */;
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
