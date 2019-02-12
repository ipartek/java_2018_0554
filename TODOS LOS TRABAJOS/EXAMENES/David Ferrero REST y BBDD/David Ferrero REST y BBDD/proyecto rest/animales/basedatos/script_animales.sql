CREATE DATABASE  IF NOT EXISTS `animales` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `animales`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: animales
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
-- Table structure for table `animal`
--

DROP TABLE IF EXISTS `animal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `animal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `peso` float NOT NULL,
  `precio` float NOT NULL,
  `fecha_nacimiento` datetime DEFAULT CURRENT_TIMESTAMP,
  `listo_venta` tinyint(4) NOT NULL,
  `id_dieta` int(11) NOT NULL,
  `id_tipo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`),
  KEY `fk_animal_dieta_idx` (`id_dieta`),
  KEY `fk_animal_tipo1_idx` (`id_tipo`),
  CONSTRAINT `fk_animal_has_dieta` FOREIGN KEY (`id_dieta`) REFERENCES `dieta` (`id`),
  CONSTRAINT `fk_animal_has_tipo1` FOREIGN KEY (`id_tipo`) REFERENCES `tipo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `animal`
--

LOCK TABLES `animal` WRITE;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` VALUES (1,'voldemort',9,589,'2019-01-01 09:35:06',1,3,1),(2,'lycosa',1,620,'2018-02-11 09:36:14',1,4,2),(3,'dgagafdg',1,1,'2019-02-11 09:36:45',1,1,1),(4,'cambiado',1,1,'2019-02-01 09:38:29',1,1,1),(5,'la hiervas',5,950.23,'2019-02-11 09:38:29',0,1,3),(6,'strgfgdfding',3,3,'2019-02-11 12:03:26',0,3,3),(7,'strgdfdfsdfsfgdfding',3,3,'2019-02-11 12:05:02',0,3,3),(8,'instertado prueba',3,3,'2019-02-11 13:35:27',1,3,3),(11,'strefdierewrng',4,4,'2019-02-11 13:47:03',1,4,2);
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'david'),(2,'arantza'),(3,'dario'),(4,'elias');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `compra` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha_compra` datetime DEFAULT CURRENT_TIMESTAMP,
  `id_stock` int(11) NOT NULL,
  `id_empleado` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_compra_stock1_idx` (`id_stock`),
  KEY `fk_compra_empleado1_idx` (`id_empleado`),
  KEY `fk_compra_cliente1_idx` (`id_cliente`),
  CONSTRAINT `fk_compra_has_cliente1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`),
  CONSTRAINT `fk_compra_has_empleado1` FOREIGN KEY (`id_empleado`) REFERENCES `empleado` (`id`),
  CONSTRAINT `fk_compra_has_stock1` FOREIGN KEY (`id_stock`) REFERENCES `stock` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (2,'2019-02-11 09:51:58',2,1,2),(4,'2019-02-11 09:51:58',4,4,1),(5,'2019-02-11 09:51:58',5,4,1),(6,'2019-02-11 13:14:09',1,1,1),(7,'2019-02-11 13:16:08',1,1,1),(8,'2019-02-11 13:18:21',1,1,1),(9,'2019-02-11 13:18:21',1,1,1),(10,'2019-02-11 13:18:21',1,1,1),(11,'2019-02-11 13:18:22',1,1,1),(12,'2019-02-11 13:18:55',1,1,1),(13,'2019-02-11 13:20:43',2,2,2),(14,'2019-02-11 13:21:18',2,2,2),(15,'2019-02-11 13:22:01',2,2,2),(16,'2019-02-11 13:23:25',2,2,2),(17,'2019-02-11 13:24:12',2,2,2),(18,'2019-02-11 13:36:17',2,3,3),(19,'2019-02-11 13:48:58',3,1,1);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `departamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'administracion'),(2,'tienda'),(3,'veterinario'),(4,'aux_veterinario'),(5,'secretatria');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dieta`
--

DROP TABLE IF EXISTS `dieta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `dieta` (
  `id` int(11) NOT NULL,
  `nombre` varchar(15) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dieta`
--

LOCK TABLES `dieta` WRITE;
/*!40000 ALTER TABLE `dieta` DISABLE KEYS */;
INSERT INTO `dieta` VALUES (1,'herbivoro'),(2,'carnivoro'),(3,'omnivoro'),(4,'insectivoro');
/*!40000 ALTER TABLE `dieta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `empleado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(145) NOT NULL,
  `dni` varchar(10) NOT NULL,
  `telefono` varchar(11) NOT NULL,
  `email` varchar(145) NOT NULL,
  `id_departamento` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  UNIQUE KEY `telefono_UNIQUE` (`telefono`),
  KEY `fk_empleado_departamento1_idx` (`id_departamento`),
  CONSTRAINT `fk_empleado_has_departamento1` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleado`
--

LOCK TABLES `empleado` WRITE;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` VALUES (1,'javier','martineza','12345678G','654987321','javier@animalia.com',1),(2,'marta','pallesa','98765432l','654321789','marta@animalia.com',2),(3,'julia','estadella','65432198y','654125896','julia@animalia.com',3),(4,'elena','bueno','14785236o','639528417','elena@animalia.com',4),(5,'amparo','baro','12345698l','652641687','amparo@animalia.com',2),(6,'tomas ','parrita','32165498m','624789513','parrita@animalia.com',2),(7,'paco','perez','12546878k','653625898','paco@animalia.com',2),(8,'antonio','ferrero','12345789m','647895654','antonio@animalia.com',2),(9,'secterario','secretario','59489898m','632165689','secretario@animalia.com',5),(10,'mayte','ferrer','78945612e','654654456','mayte@animalia.com',5);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `unidades` int(11) NOT NULL,
  `id_animal` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_stock_animal1_idx` (`id_animal`),
  CONSTRAINT `fk_stock_has_animal1` FOREIGN KEY (`id_animal`) REFERENCES `animal` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES (1,5,1),(2,1,2),(3,8,3),(4,10,4),(5,2,5);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo`
--

DROP TABLE IF EXISTS `tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tipo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo`
--

LOCK TABLES `tipo` WRITE;
/*!40000 ALTER TABLE `tipo` DISABLE KEYS */;
INSERT INTO `tipo` VALUES (1,'serpiente'),(2,'tarantula'),(3,'triton');
/*!40000 ALTER TABLE `tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'animales'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-11 14:09:31
