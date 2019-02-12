CREATE DATABASE  IF NOT EXISTS `dgt` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `dgt`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: dgt
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
-- Table structure for table `agente`
--

DROP TABLE IF EXISTS `agente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `agente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `placa` int(11) NOT NULL,
  `id_departamento` int(11) DEFAULT NULL,
  `password` varchar(145) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_departamento_idx` (`id_departamento`),
  CONSTRAINT `fk_departamento_has_agente` FOREIGN KEY (`id_departamento`) REFERENCES `departamento` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agente`
--

LOCK TABLES `agente` WRITE;
/*!40000 ALTER TABLE `agente` DISABLE KEYS */;
INSERT INTO `agente` VALUES (1,'majonei',111,37,'123456'),(2,'jony walker',222,36,'123456'),(3,'monk',333,38,'123456'),(4,'takelberri',444,39,'123456'),(5,'tontini',555,39,'123456');
/*!40000 ALTER TABLE `agente` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `agente_BEFORE_INSERT` BEFORE INSERT ON `agente` FOR EACH ROW BEGIN
set new.nombre= trim(new.nombre);
set new.password= trim(new.password);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `coche`
--

DROP TABLE IF EXISTS `coche`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `coche` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` varchar(10) NOT NULL,
  `modelo` varchar(45) NOT NULL DEFAULT 'cuatro latas',
  `km` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `matricula_UNIQUE` (`matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coche`
--

LOCK TABLES `coche` WRITE;
/*!40000 ALTER TABLE `coche` DISABLE KEYS */;
INSERT INTO `coche` VALUES (1,'3548MKZ','toyota yaris',500),(2,'9605EFH','fiat multipla',800),(3,'5674MBD','GTR',1800),(4,'BI0020AZ','flagoneta',47500),(6,'3521MKL','prueba trigger',20),(8,'3456','chek',0);
/*!40000 ALTER TABLE `coche` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `coche_BEFORE_INSERT` BEFORE INSERT ON `coche` FOR EACH ROW BEGIN

if new.km < 0 then set new.km=0;
END if;
set new.modelo= trim(new.modelo);
set new.matricula= trim(new.matricula);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `departamento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (36,'Alcoholemia'),(55,'check'),(38,'Fealdad'),(32,'hhhhh'),(33,'Ingeniería'),(35,'Mercadeo'),(39,'Oficinistas'),(34,'Producción'),(41,'pru    eba'),(40,'prueba'),(37,'Velocidad'),(31,'Ventas');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tbi_departamento_trim` BEFORE INSERT ON `departamento` FOR EACH ROW BEGIN
set new.nombre= trim(new.nombre);
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `multa`
--

DROP TABLE IF EXISTS `multa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `multa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_coche` int(11) NOT NULL,
  `id_agente` int(11) DEFAULT NULL,
  `importe` float DEFAULT '50',
  `concepto` varchar(255) NOT NULL,
  `fecha` datetime DEFAULT CURRENT_TIMESTAMP,
  `fecha_modificacion` datetime DEFAULT CURRENT_TIMESTAMP,
  `fecha_baja` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_multas_coches_idx` (`id_coche`),
  KEY `fk_agente_idx` (`id_agente`),
  CONSTRAINT `fk_agente_has_multa` FOREIGN KEY (`id_agente`) REFERENCES `agente` (`id`),
  CONSTRAINT `fk_coche_has_multa` FOREIGN KEY (`id_coche`) REFERENCES `coche` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `multa`
--

LOCK TABLES `multa` WRITE;
/*!40000 ALTER TABLE `multa` DISABLE KEYS */;
INSERT INTO `multa` VALUES (15,1,2,500,'arturient habitant maecenas sodales vulputate ornare torquent sem magnis massa placerat, egestas euismod scelerisque nam sociosqu enim montes molestie in.','2019-01-01 00:10:50','2019-01-01 00:10:50','2019-01-01 00:10:50'),(16,1,2,200,'Parturient habitant maecenas sodales vulputate ornare torquent sem magnis massa placerat, egestas euismod scelerisque nam sociosqu enim montes molestie in.','2018-12-19 01:11:37','2018-12-19 01:11:37',NULL),(17,1,2,200,'Parturient habitant maecenas sodales vulputate ornare torquent sem magnis massa placerat, egestas euismod scelerisque nam sociosqu enim montes molestie in.','2018-11-19 02:14:17','2018-11-19 02:14:17',NULL),(18,1,2,300,'Parturient habitant maecenas sodales vulputate ornare torquent sem magnis massa placerat, egestas euismod scelerisque nam sociosqu enim montes molestie in.','2018-06-19 03:14:17','2018-06-19 03:14:17',NULL),(19,1,2,400,'Parturient habitant maecenas sodales vulputate ornare torquent sem magnis massa placerat, egestas euismod scelerisque nam sociosqu enim montes molestie in.','2017-01-19 04:14:17','2017-01-19 04:14:17',NULL),(20,2,2,100,'Parturient habitant maecenas sodales vulputate ornare torquent sem magnis massa placerat, egestas euismod scelerisque nam sociosqu enim montes molestie in.','2016-01-19 05:14:17','2016-01-19 05:14:17',NULL),(21,2,2,200,'Parturient habitant maecenas sodales vulputate ornare torquent sem magnis massa placerat, egestas euismod scelerisque nam sociosqu enim montes molestie in.','2018-03-19 06:14:17','2018-03-19 06:14:17','2018-03-23 06:14:17'),(22,2,2,300,'Parturient habitant maecenas sodales vulputate ornare torquent sem magnis massa placerat, egestas euismod scelerisque nam sociosqu enim montes molestie in.','2019-01-11 07:14:17','2019-01-11 07:14:17',NULL),(23,2,2,400,'Parturient habitant maecenas sodales vulputate ornare torquent sem magnis massa placerat, egestas euismod scelerisque nam sociosqu enim montes molestie in.','2018-06-19 18:14:17','2018-06-19 18:14:17',NULL),(24,3,2,50,'Parturient habitant maecenas sodales vulputate ornare torquent sem magnis massa placerat, egestas euismod scelerisque nam sociosqu enim montes molestie in.','2018-06-19 18:14:17','2018-06-19 18:14:17','2018-09-19 18:14:17'),(25,3,2,100,'Parturient habitant maecenas sodales vulputate ornare torquent sem magnis massa placerat, egestas euismod scelerisque nam sociosqu enim montes molestie in.','2018-06-19 18:14:17','2018-06-19 18:14:17',NULL),(26,3,2,150,'Parturient habitant maecenas sodales vulputate ornare torquent sem magnis massa placerat, egestas euismod scelerisque nam sociosqu enim montes molestie in.','2018-06-19 18:14:17','2018-06-19 18:14:17',NULL),(27,3,2,200,'Parturient habitant maecenas sodales vulputate ornare torquent sem magnis massa placerat, egestas euismod scelerisque nam sociosqu enim montes molestie in.','2018-06-19 18:14:17','2018-06-19 18:14:17',NULL),(28,4,2,25,'Parturient habitant maecenas sodales vulputate ornare torquent sem magnis massa placerat, egestas euismod scelerisque nam sociosqu enim montes molestie in.','2018-06-19 18:14:17','2018-06-19 18:14:17',NULL),(29,4,2,100,'Parturient habitant maecenas sodales vulputate ornare torquent sem magnis massa placerat, egestas euismod scelerisque nam sociosqu enim montes molestie in.','2018-06-19 18:14:17','2018-06-19 18:14:17',NULL),(30,4,2,300,'Parturient habitant maecenas sodales vulputate ornare torquent sem magnis massa placerat, egestas euismod scelerisque nam sociosqu enim montes molestie in.','2016-12-19 19:14:17','2016-12-19 19:14:17',NULL),(31,4,2,650,'Parturient habitant maecenas sodales vulputate ornare torquent sem magnis massa placerat, egestas euismod scelerisque nam sociosqu enim montes molestie in.','2019-01-06 22:14:17','2019-01-06 22:14:17','2019-01-08 22:14:17');
/*!40000 ALTER TABLE `multa` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `tbi_multa_check` BEFORE INSERT ON `multa` FOR EACH ROW BEGIN

if new.importe < 0 then set new.importe=0;
END if;

set new.concepto= trim(new.concepto);
end */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Temporary view structure for view `v_objetivos`
--
DROP TABLE IF EXISTS `v_objetivos`;
/*!50001 DROP VIEW IF EXISTS `v_objetivos`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8mb4;
/*!50001 CREATE VIEW `v_objetivos` AS SELECT 
 1 AS `id_agente`,
 1 AS `fecha`,
 1 AS `anyo`,
 1 AS `mes`,
 1 AS `numero_multas`,
 1 AS `importe`*/;
SET character_set_client = @saved_cs_client;

--
-- Dumping events for database 'dgt'
--

--
-- Dumping routines for database 'dgt'
--
/*!50003 DROP FUNCTION IF EXISTS `nombre_mes` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` FUNCTION `nombre_mes`(numeroMes INTEGER) RETURNS varchar(50) CHARSET utf8
    READS SQL DATA
    DETERMINISTIC
BEGIN

DECLARE mes VARCHAR (20) DEFAULT 'NO EXISTE';

CASE  numeroMes
WHEN 1 then set MES = 'ENERO';
WHEN 2 then set MES = 'FEBRERO';
WHEN 3 then set MES = 'MARZO';
WHEN 4 then set MES = 'ABRIL';
WHEN 5 then set MES = 'MAYO';
WHEN 6 then set MES = 'JUNIO';
WHEN 7 then set MES = 'JULIO';
WHEN 8 then set MES = 'AGOSTO';
WHEN 9 then set MES = 'SEPTIEMBRE';
WHEN 10 then set MES = 'OCTUBRE';
WHEN 11 then set MES = 'NOVIEMBRE';
WHEN 12 then set MES = 'DICIEMBRE';
ELSE
SET mes = concat(numeroMes, 'NO existe');
end case;
RETURN mes;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `agente_getById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `agente_getById`( 
IN p_id LONG )
BEGIN    
SELECT id, nombre, placa, id_departamento FROM agente WHERE id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `agente_getMultas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `agente_getMultas`( 
IN  p_id LONG)
BEGIN
SELECT m.id AS 'id_multa', c.id AS 'id_coche',fecha, importe, concepto, matricula, modelo,km FROM agente AS a, multa AS m, coche AS c WHERE a.id=m.id_agente AND m.id_coche=c.id AND a.id=p_id AND m.fecha_baja IS NULL ORDER BY m.fecha DESC;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `agente_getMultasAnuladas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `agente_getMultasAnuladas`( 
IN  p_id LONG)
BEGIN
SELECT m.id AS 'id_multa', c.id AS 'id_coche',fecha, importe, concepto, matricula, modelo,km FROM agente AS a, multa AS m, coche AS c WHERE a.id=m.id_agente AND m.id_coche=c.id AND a.id=p_id AND m.fecha_baja IS NOT NULL ORDER BY m.fecha DESC ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `agente_login` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `agente_login`(
	
    IN p_placa VARCHAR(150) , 
    IN p_password VARCHAR(45) )
BEGIN
SELECT 
a.id AS 'id_agente',
 a.nombre AS 'nombre_agente',
 a.placa AS 'placa_agente',
 a.id_departamento AS 'id_dep'
 , password 
 ,d.nombre AS 'nombre_dep'
FROM agente as a, departamento as d
WHERE a.id_departamento=d.id
AND placa = p_placa AND password = p_password;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `coche_get_matricula` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `coche_get_matricula`(IN matri VARCHAR(10))
BEGIN
SELECT id, matricula, modelo, km FROM coche WHERE coche.matricula = matri;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `multa_activar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `multa_activar`(

	IN p_id LONG,
	OUT o_id LONG

)
BEGIN
UPDATE multa SET fecha_modificacion = CURRENT_TIMESTAMP, fecha_baja = NULL WHERE (`id` = p_id);
SET o_id = LAST_INSERT_ID();

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `multa_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `multa_insert`(

	IN p_importe FLOAT,
    IN p_concepto VARCHAR(255),
	IN id_coche LONG,
	IN id_agente LONG,
	OUT o_id LONG

)
BEGIN
INSERT INTO multa (importe, concepto, id_coche, id_agente) VALUES (p_importe, p_concepto, id_coche, id_agente);

SET o_id = LAST_INSERT_ID();

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `multa_objetivos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `multa_objetivos`()
BEGIN
SELECT * FROM dgt.v_objetivos;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `multa_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `multa_update`(

	IN p_id LONG,
	OUT o_id LONG

)
BEGIN
UPDATE multa SET fecha_baja = CURRENT_TIMESTAMP WHERE (`id` = p_id);
SET o_id = LAST_INSERT_ID();

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `v_objetivos`
--

/*!50001 DROP VIEW IF EXISTS `v_objetivos`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `v_objetivos` AS select `multa`.`id_agente` AS `id_agente`,`multa`.`fecha` AS `fecha`,year(`multa`.`fecha`) AS `anyo`,month(`multa`.`fecha`) AS `mes`,count(0) AS `numero_multas`,sum(`multa`.`importe`) AS `importe` from `multa` where isnull(`multa`.`fecha_baja`) group by `multa`.`id_agente`,year(`multa`.`fecha`),month(`multa`.`fecha`) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-23  9:14:47
