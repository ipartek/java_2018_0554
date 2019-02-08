CREATE DATABASE  IF NOT EXISTS `taller` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `taller`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: taller
-- ------------------------------------------------------
-- Server version	5.7.14

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
-- Table structure for table `combustible`
--

DROP TABLE IF EXISTS `combustible`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `combustible` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `combustible`
--

LOCK TABLES `combustible` WRITE;
/*!40000 ALTER TABLE `combustible` DISABLE KEYS */;
INSERT INTO `combustible` VALUES (5,'Condensador de fluzo'),(2,'diesel'),(3,'electrico'),(1,'gasolina'),(4,'GLP');
/*!40000 ALTER TABLE `combustible` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `modelo`
--

DROP TABLE IF EXISTS `modelo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `modelo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `modelo`
--

LOCK TABLES `modelo` WRITE;
/*!40000 ALTER TABLE `modelo` DISABLE KEYS */;
INSERT INTO `modelo` VALUES (1,'Audi'),(11,'Carroza'),(9,'Chatarra'),(10,'Citroen'),(15,'El Homer'),(4,'Ferrari'),(2,'Ford'),(3,'Hyundai'),(6,'Maserati'),(5,'Mazda'),(17,'Mierdamovil'),(7,'Nisan'),(8,'Peugeot'),(16,'Seat Leon Amarillo'),(14,'Suzuki Bandit 650'),(13,'Toyota Auris'),(12,'Txalupa');
/*!40000 ALTER TABLE `modelo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `dni` varchar(10) NOT NULL COMMENT 'Documento identidad para Españoles y extranjeros',
  `telefono` varchar(15) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'david','ferrero','12345678g','617766859'),(2,'hector','serrano','48951231H','679541367'),(3,'xabier','eguskiza','87654321W','666222333'),(4,'endika','vasques','42823820B','688693053'),(5,'Ander','Solana','77777777K','666666666'),(6,'amaia','del olmo','74115210L','633215478'),(7,'imanol','hernando','12345678A','654654654'),(8,'andoni','penalva','16084554V','+34 645332212'),(10,'Daniel','Zallo','88888888B','987654321'),(11,'Borja','Reyes Diez','16235478R','456987532');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona_has_rol`
--

DROP TABLE IF EXISTS `persona_has_rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona_has_rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_persona` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_persona_has_rol_rol1_idx` (`id_rol`),
  KEY `fk_persona_has_rol_persona_idx` (`id_persona`),
  CONSTRAINT `fk_persona_has_rol` FOREIGN KEY (`id_persona`) REFERENCES `persona` (`id`),
  CONSTRAINT `fk_rol_has_persona` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona_has_rol`
--

LOCK TABLES `persona_has_rol` WRITE;
/*!40000 ALTER TABLE `persona_has_rol` DISABLE KEYS */;
INSERT INTO `persona_has_rol` VALUES (1,1,1),(2,4,2),(3,10,1),(4,5,1),(5,6,1),(6,8,1),(7,7,1),(8,3,1),(9,2,2);
/*!40000 ALTER TABLE `persona_has_rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reparaciones`
--

DROP TABLE IF EXISTS `reparaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reparaciones` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `precio` float NOT NULL,
  `descripcion` mediumtext NOT NULL,
  `id_mecanico` int(11) NOT NULL,
  `id_vehiculo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_reparaciones_persona1_idx` (`id_mecanico`),
  KEY `fk_reparaciones_vehiculo1_idx` (`id_vehiculo`),
  CONSTRAINT `fk_reparaciones_mecanico` FOREIGN KEY (`id_mecanico`) REFERENCES `persona` (`id`),
  CONSTRAINT `fk_reparaciones_vehiculo` FOREIGN KEY (`id_vehiculo`) REFERENCES `vehiculo` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reparaciones`
--

LOCK TABLES `reparaciones` WRITE;
/*!40000 ALTER TABLE `reparaciones` DISABLE KEYS */;
INSERT INTO `reparaciones` VALUES (1,'2019-02-04 09:25:26',200,'ostion guapo (PUUUUMMMBAAA!!!)',4,1),(2,'2019-02-04 09:26:14',10,'rueda pinchada',4,3),(3,'2019-02-04 09:29:15',149.99,'Cambio de filtros y liquidos',4,14),(4,'2019-02-04 09:30:33',19.99,'Venta e instalación de limpiaparabrisas ',4,9),(5,'2019-01-04 12:36:15',1150,'caja de cambios',4,15),(6,'2019-02-04 09:31:57',500,'Se ha caido por un terraplen pero después ha quedado como nuevo ',2,17),(7,'2019-02-04 09:32:59',154.7,'cambio luna trasera y varios arreglos',4,11),(8,'2019-02-04 09:38:24',110,'revision general',4,4),(10,'2017-02-04 09:32:59',249.95,'cambio alternador y correa distribución',2,5),(11,'2018-02-04 09:32:59',124.7,'ruedas',4,5),(12,'2018-06-28 09:32:59',429,'revision general',7,12),(13,'2019-02-04 09:41:46',200,'discos de freno',4,20),(14,'2019-02-04 09:42:53',152361,'Pintura color caquita del bosque fresca',4,21),(15,'2019-02-04 09:43:17',1,'secarlo al viento',2,21),(16,'2019-06-28 09:32:59',755,'kit',4,12),(17,'2019-02-04 09:44:02',0.01,'pasar por delante de la puerta',4,21),(18,'2019-02-04 09:45:11',56,'cambio de aceite de girasol',2,21);
/*!40000 ALTER TABLE `reparaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (5,'aprendiz'),(1,'cliente'),(4,'contable'),(3,'jefe'),(2,'mecanico');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vehiculo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `numero_bastidor` varchar(45) NOT NULL,
  `matricula` varchar(10) NOT NULL,
  `id_propietario` int(11) NOT NULL,
  `id_combustible` int(11) NOT NULL,
  `id_modelo` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `numero_bastidor_UNIQUE` (`numero_bastidor`),
  UNIQUE KEY `matricula_UNIQUE` (`matricula`),
  KEY `fk_vehiculo_persona1_idx` (`id_propietario`),
  KEY `fk_vehiculo_combustible1_idx` (`id_combustible`),
  KEY `fk_vehiculo_modelo1_idx` (`id_modelo`),
  CONSTRAINT `fk_combustible` FOREIGN KEY (`id_combustible`) REFERENCES `combustible` (`id`),
  CONSTRAINT `fk_modelo` FOREIGN KEY (`id_modelo`) REFERENCES `modelo` (`id`),
  CONSTRAINT `fk_propietario` FOREIGN KEY (`id_propietario`) REFERENCES `persona` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehiculo`
--

LOCK TABLES `vehiculo` WRITE;
/*!40000 ALTER TABLE `vehiculo` DISABLE KEYS */;
INSERT INTO `vehiculo` VALUES (1,'34653344','445643',4,1,7),(2,'1236589541203652','0258ABC',3,2,9),(3,'57644','44333',4,2,9),(4,'XYZ123ZYX321','1528YXB',1,1,8),(5,'asdfg12345','bi0000aa',7,1,5),(6,'32584696','BI1502CN',6,2,3),(7,'123124564464','434546',2,3,3),(8,'95421302597412','0666HLL',3,1,10),(9,'88888888','4563ABC',5,2,13),(10,'53765345','BI3463SD',2,1,2),(11,'XYZ323ZYX445','BI7002FF',8,3,4),(12,'gfdsa654321','bi0001aa',7,2,7),(13,'3453534533','ZA2342DA',2,2,12),(14,'4562189634785BV','4563JVL',10,1,14),(15,'85412036987410','9874HMR',3,2,15),(16,'kvn5675687','DA948DS',2,1,10),(17,'24234212','NM9876AS',2,3,4),(18,'asdf1234fdsa','1440AN',1,1,3),(19,'767677676767','BI86868KI',4,1,16),(20,'7852014596LKJ','BI9631NM',6,1,9),(21,'atiqueteimporta','FR1563PP',11,5,17);
/*!40000 ALTER TABLE `vehiculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-04  9:46:57
