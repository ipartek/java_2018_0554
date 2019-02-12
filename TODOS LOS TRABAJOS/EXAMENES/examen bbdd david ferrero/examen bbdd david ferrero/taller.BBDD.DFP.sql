CREATE DATABASE  IF NOT EXISTS `taller_mecanico` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `taller_mecanico`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: taller_mecanico
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dni` varchar(10) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `primer_apellido` varchar(30) NOT NULL,
  `segundo_apellido` varchar(45) DEFAULT 'no tiene',
  `telefono` varchar(9) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (4,'30966222','Maria','del Mal','no tiene','666666666'),(5,'30966223','Armando','Bronca','Segura','617617617'),(6,'30966233','Jaime','Marron','Segura','617523523'),(7,'30966251','Armando','Casillas','Peon','958852235');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `combustible`
--

DROP TABLE IF EXISTS `combustible`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `combustible` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(12) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `combustible`
--

LOCK TABLES `combustible` WRITE;
/*!40000 ALTER TABLE `combustible` DISABLE KEYS */;
INSERT INTO `combustible` VALUES (1,'gasolina'),(2,'diesel'),(3,'electrico'),(4,'hidrogeno');
/*!40000 ALTER TABLE `combustible` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `empleado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(30) NOT NULL,
  `primer_apellido` varchar(45) NOT NULL,
  `segundo_apellido` varchar(45) DEFAULT 'no tiene',
  `dni` varchar(10) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `id_puesto` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  KEY `fk_empleado_has_puesto_idx` (`id_puesto`),
  CONSTRAINT `fk_empleado_has_puesto` FOREIGN KEY (`id_puesto`) REFERENCES `puesto` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'david','ferrero','peon','30966222g','617768859',3),(2,'txabi','garcia','garcia','31212312f','956654456',4),(3,'amaia','alvarez','del rio','31112354g','689689689',1),(4,'imanol','sanchez','herrerin','33333333g','654321987',2),(5,'marta','sanchez','higuera','34343434j','632651648',3);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puesto`
--

DROP TABLE IF EXISTS `puesto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `puesto` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo` varchar(45) NOT NULL,
  `sueldo` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puesto`
--

LOCK TABLES `puesto` WRITE;
/*!40000 ALTER TABLE `puesto` DISABLE KEYS */;
INSERT INTO `puesto` VALUES (1,'jefe taller',2500),(2,'contable',1050.46),(3,'mecanico',1460.25),(4,'aprendiz',844.22);
/*!40000 ALTER TABLE `puesto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reparacion`
--

DROP TABLE IF EXISTS `reparacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `reparacion` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `precio` double NOT NULL,
  `observaciones` mediumtext,
  `id_empleado` int(11) NOT NULL,
  `id_vehiculo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reparacion_has_empleado_idx` (`id_empleado`),
  KEY `fk_reparacion_has_vehiculo_idx` (`id_vehiculo`),
  CONSTRAINT `fk_reparacion_has_empleado` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id`),
  CONSTRAINT `fk_reparacion_has_vehiculo` FOREIGN KEY (`id_vehiculo`) REFERENCES `vehiculo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reparacion`
--

LOCK TABLES `reparacion` WRITE;
/*!40000 ALTER TABLE `reparacion` DISABLE KEYS */;
INSERT INTO `reparacion` VALUES (1,'2018-02-01 13:12:12',200,'discos desgastados',1,4),(2,'2019-02-01 13:12:12',150,'espejo retrovisor',2,3),(3,'2017-02-01 13:12:12',2000,'cambio de motor',3,2),(4,'2019-02-01 13:12:12',90,'revision',4,1);
/*!40000 ALTER TABLE `reparacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vehiculo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bastidor` varchar(17) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `matricula` varchar(7) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_combustible` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `bastidor_UNIQUE` (`bastidor`),
  UNIQUE KEY `matricula_UNIQUE` (`matricula`),
  KEY `fk_vehiculo_has_cliente_idx` (`id_cliente`),
  KEY `fk_vehiculo_has_combustible_idx` (`id_combustible`),
  CONSTRAINT `fk_vehiculo_has_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `fk_vehiculo_has_combustible` FOREIGN KEY (`id_combustible`) REFERENCES `combustible` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
INSERT INTO `vehiculo` VALUES (1,'wv2zzz70zmh','seat cordoba','1440co',4,1),(2,'wv8lzz70zmh','peugeot 307','1528bxy',5,2),(3,'bx6mmm70zmh','toyota yaris','2530zvy',6,3),(4,'cs8ppw70zmh','citroen c3','1534hgm',7,4);
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'taller_mecanico'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-01 14:04:46
