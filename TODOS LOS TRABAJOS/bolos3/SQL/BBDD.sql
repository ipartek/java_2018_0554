CREATE DATABASE  IF NOT EXISTS `apr_producciones` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `apr_producciones`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: apr_producciones
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
-- Table structure for table `bolo`
--

DROP TABLE IF EXISTS `bolo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `bolo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lugar` varchar(45) NOT NULL,
  `banda1` varchar(145) DEFAULT NULL,
  `banda2` varchar(145) DEFAULT NULL,
  `banda3` varchar(145) DEFAULT NULL,
  `id_crew` int(11) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bolo_has_crew_idx` (`id_crew`),
  CONSTRAINT `fk_bolo_has_crew` FOREIGN KEY (`id_crew`) REFERENCES `crew` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bolo`
--

LOCK TABLES `bolo` WRITE;
/*!40000 ALTER TABLE `bolo` DISABLE KEYS */;
INSERT INTO `bolo` VALUES (1,'2019-03-26 19:14:27','shake','sonora_kilombo',NULL,NULL,1,NULL),(2,'2018-02-26 20:50:34','zaldibar','sonora_kilombo',NULL,NULL,2,NULL),(3,'2017-08-26 20:50:34','azkena','moncada_20',NULL,NULL,3,NULL),(4,'2019-01-26 20:53:04','azkena','tokodera',NULL,NULL,1,NULL);
/*!40000 ALTER TABLE `bolo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `correo` varchar(145) DEFAULT NULL,
  `id_bolo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_bolo_has_clien_idx` (`id_bolo`),
  CONSTRAINT `fk_bolo_has_clien` FOREIGN KEY (`id_bolo`) REFERENCES `bolo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES (1,'alejo','613613613','alejo@musicasmundo',1);
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crew`
--

DROP TABLE IF EXISTS `crew`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `crew` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `foh` varchar(45) NOT NULL,
  `monitores` varchar(45) DEFAULT NULL,
  `luces` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crew`
--

LOCK TABLES `crew` WRITE;
/*!40000 ALTER TABLE `crew` DISABLE KEYS */;
INSERT INTO `crew` VALUES (1,'david','elias','dario'),(2,'david','elias','nadie'),(3,'david','nadie','dario'),(4,'nadie','elias','dario');
/*!40000 ALTER TABLE `crew` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tecnico`
--

DROP TABLE IF EXISTS `tecnico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tecnico` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `puesto` varchar(45) NOT NULL,
  `sueldo` int(11) DEFAULT NULL,
  `id_crew` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tecnico_has_crew_idx` (`id_crew`),
  CONSTRAINT `fk_tecnico_has_crew` FOREIGN KEY (`id_crew`) REFERENCES `crew` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tecnico`
--

LOCK TABLES `tecnico` WRITE;
/*!40000 ALTER TABLE `tecnico` DISABLE KEYS */;
INSERT INTO `tecnico` VALUES (1,'david','foh',180,1),(2,'elias','moni',180,1),(3,'dario','luces',180,1);
/*!40000 ALTER TABLE `tecnico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'apr_producciones'
--
/*!50003 DROP PROCEDURE IF EXISTS `bolo_getById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `bolo_getById`(
in p_id LONG)
BEGIN

SELECT 
	b.id,
	b.fecha , 
	b.lugar, 
	cw.foh,
    cw.monitores,
	cw.luces,
	c.nombre AS 'cliente', 
	c.telefono AS 'telf_cliente',
    count(*) AS 'num_bolos'
FROM 
bolo AS b, 
cliente AS c, 
crew AS cw
WHERE
b.id = p.id
GROUP BY (b.lugar) ;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-29 14:14:04
