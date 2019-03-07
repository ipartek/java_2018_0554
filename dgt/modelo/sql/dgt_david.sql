-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: dgt_david
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
  `password` varchar(20) NOT NULL,
  `imagen` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `placa_UNIQUE` (`placa`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `agente`
--

LOCK TABLES `agente` WRITE;
/*!40000 ALTER TABLE `agente` DISABLE KEYS */;
INSERT INTO `agente` VALUES (1,'Mahoney',123456,'123456','https://vignette.wikia.nocookie.net/policeacademy/images/a/a6/Mahoney_films.jpg/revision/latest?cb=20140315152502'),(2,'Ruiditos',987654,'t45gt4w5t','https://is5-ssl.mzstatic.com/image/thumb/Video118/v4/84/f1/cc/84f1cc9f-c128-b523-e784-7acf70588e17/source/560x315mv.jpg'),(3,'Lassard',987321,'123456789','https://i.pinimg.com/originals/53/b3/9d/53b39d0192760ba84554b1b42b634109.jpg'),(4,'Tackleberry',987987,'987987','https://hips.hearstapps.com/es.h-cdn.co/fotoes/images/media/imagenes/reportajes/que-fue-de-el-reparto-de-loca-academia-de-policia/09-david-graf-tackleberry/7733514-1-esl-ES/09-David-GRaf-Tackleberry.jpg'),(5,'Hightower',998776,'7miti76','https://vignette.wikia.nocookie.net/policeacademy/images/b/bb/Hightower_films.jpg/revision/latest?cb=20140315183731');
/*!40000 ALTER TABLE `agente` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `coche`
--

LOCK TABLES `coche` WRITE;
/*!40000 ALTER TABLE `coche` DISABLE KEYS */;
INSERT INTO `coche` VALUES (1,'1234ABC','Toyota Yaris',500),(2,'9605EFH','Fiat multipla',800),(3,'5674MBD','GRT',1800),(4,'BI0020AZ','flagoneta',47500);
/*!40000 ALTER TABLE `coche` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `multa`
--

DROP TABLE IF EXISTS `multa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `multa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `importe` float DEFAULT '50',
  `concepto` varchar(255) DEFAULT NULL,
  `fecha_alta` datetime DEFAULT CURRENT_TIMESTAMP,
  `id_coche` int(11) NOT NULL,
  `id_agente` int(11) NOT NULL,
  `fecha_mod` datetime DEFAULT NULL,
  `fecha_baja` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_multa_coches_idx` (`id_coche`) /*!80000 INVISIBLE */,
  KEY `fk__idx` (`id_agente`),
  CONSTRAINT `fk_multa_agente` FOREIGN KEY (`id_agente`) REFERENCES `agente` (`id`),
  CONSTRAINT `fk_multa_coches` FOREIGN KEY (`id_coche`) REFERENCES `coche` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `multa`
--

LOCK TABLES `multa` WRITE;
/*!40000 ALTER TABLE `multa` DISABLE KEYS */;
INSERT INTO `multa` VALUES (12,21.53,'234567876532weerewtrwywete','2018-09-14 10:25:30',1,1,NULL,'2019-01-15 12:35:22'),(13,0,'por muy feo','2018-09-14 11:06:39',1,1,NULL,NULL),(14,500,'por muy feo','2018-08-14 13:02:47',1,1,NULL,'2019-01-15 12:35:22'),(15,500.7,'vas mas borracho que el tato','2018-06-15 12:25:10',2,2,NULL,NULL),(16,500.7,'borrachuzo de mierda','2018-05-15 12:31:15',4,2,NULL,'2019-01-15 12:35:22'),(17,500.7,'borrachuzo de mierda','2018-02-15 12:33:21',2,2,NULL,NULL),(18,500.7,'borrachuzo de mierda','2019-01-15 12:35:22',4,3,NULL,NULL),(19,500.7,'borrachuzo de mierda','2018-08-15 12:37:48',2,3,NULL,NULL),(20,500.7,'borrachuzo de mierda','2019-01-15 12:38:49',2,3,NULL,'2019-01-15 12:35:22'),(21,500.7,'borrachuzo de mierda','2019-01-15 12:39:12',3,2,NULL,NULL),(22,500.7,'borrachuzo de mierda','2018-04-15 12:42:02',2,4,NULL,'2019-01-15 12:35:22'),(23,500.7,'borrachuzo de mierda','2018-07-15 12:45:28',3,4,NULL,'2019-01-15 12:35:22'),(24,500.7,'borrachuzo de mierda','2018-11-15 12:45:32',2,4,NULL,NULL),(25,500.7,'borrachuzo de mierda','2018-01-15 12:46:07',3,1,NULL,NULL),(26,500.7,'borrachuzo de mierda','2018-10-15 12:48:21',2,1,NULL,NULL),(27,500.7,'borrachuzo de mierda','2018-11-15 12:49:41',2,4,NULL,'2019-01-15 12:35:22'),(28,456.6,'fdgrd','2018-12-16 09:21:46',2,4,NULL,NULL),(29,540.59,'aefwefwefwfewefwe','2018-12-17 12:08:48',1,1,NULL,'2019-01-15 12:35:22'),(30,1445,'pruebaaaaaaa','2018-03-20 21:21:10',2,4,NULL,NULL),(31,0,'khfkesjh','2018-03-21 10:02:01',3,4,NULL,'2019-01-15 12:35:22'),(32,2000,'caca de la vaca','2019-03-05 12:56:27',1,1,NULL,NULL),(33,1234,'<xczxzxcxzc','2019-03-05 13:07:05',1,1,NULL,NULL),(34,300,'enesima prueba','2019-03-06 10:13:30',1,2,NULL,NULL);
/*!40000 ALTER TABLE `multa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `objetivo`
--

DROP TABLE IF EXISTS `objetivo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `objetivo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Anio` int(4) NOT NULL,
  `objetivo` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='	';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `objetivo`
--

LOCK TABLES `objetivo` WRITE;
/*!40000 ALTER TABLE `objetivo` DISABLE KEYS */;
INSERT INTO `objetivo` VALUES (1,2018,12000),(2,2019,14400);
/*!40000 ALTER TABLE `objetivo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'dgt_david'
--
/*!50003 DROP PROCEDURE IF EXISTS `pa_agente_getById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pa_agente_getById`(IN p_id LONG)
BEGIN
	SELECT 
		id, 
        nombre 
    FROM 
		agente 
    WHERE 
		id = p_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pa_coche_getByMatricula` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pa_coche_getByMatricula`(IN p_matricula VARCHAR(50))
BEGIN
SELECT id,matricula,modelo,km FROM coche WHERE matricula= p_matricula;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pa_login` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pa_login`(IN p_placa INT, IN p_pass VARCHAR(20))
BEGIN
SELECT 
	a.id,
	a.nombre,
	a.placa,
    a.password,
    a.imagen
FROM 
	agente as a
WHERE
	a.placa=p_placa AND
    a.password=p_pass;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pa_multa_activar` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pa_multa_activar`(IN p_id LONG)
BEGIN

	UPDATE 
		multa 
    SET 
		fecha_baja = null 
	WHERE 
		id = p_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pa_multa_anulada_getByAgenteId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pa_multa_anulada_getByAgenteId`(IN a_id INT)
BEGIN


	SELECT
		
		m.id ,
        m.importe,
        m.concepto,
        m.id_coche,
        c.modelo, 
        c.km,
		m.fecha_alta  , 
		m.fecha_baja  ,
		c.matricula,
        a.placa,
        a.nombre,
        a.password,
        a.imagen
		
	FROM 
		multa m, 
		coche c,
        agente a
	WHERE 
		m.id_coche = c.id AND 
        m.id_agente= a.id AND
		m.id_agente = a_id AND
		m.fecha_baja IS NOT  NULL
	ORDER BY m.id DESC LIMIT 1000;
            


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pa_multa_anular` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pa_multa_anular`(IN p_id LONG)
BEGIN

	UPDATE 
		multa 
    SET 
		fecha_baja = CURRENT_TIMESTAMP  
	WHERE 
		id = p_id;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pa_multa_devuelveTotales` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pa_multa_devuelveTotales`(IN p_opcion varchar(30),IN p_idagente LONG,IN p_anio INTEGER,IN p_mes INTEGER,OUT o_total FLOAT)
BEGIN
IF p_opcion='totalMensualAnio' then
	SELECT
		round(sum(importe)) INTO o_total
	FROM
		multa
    WHERE
		id_agente=p_idagente AND
        month(fecha_alta)=p_mes AND
        year(fecha_alta)=p_anio AND
        fecha_baja is null;
elseif p_opcion='totalAnual' then
	SELECT
		round(sum(importe)) INTO o_total
	FROM
		multa
    WHERE
		id_agente=p_idagente AND
        year(fecha_alta)=p_anio AND
        fecha_baja is null;
end if;

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pa_multa_getByAgenteId` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pa_multa_getByAgenteId`(IN a_id INT)
BEGIN


	SELECT
		
		m.id ,
        m.importe,
        m.concepto,
        m.id_coche,
        c.modelo, 
        c.km,
		m.fecha_alta  , 
		m.fecha_baja  ,
		c.matricula,
        a.placa,
        a.nombre,
        a.password,
        a.imagen
		
	FROM 
		multa m, 
		coche c,
        agente a
	WHERE 
		m.id_coche = c.id AND 
        m.id_agente= a.id AND
		m.id_agente = a_id AND
		m.fecha_baja IS   NULL
	ORDER BY m.id DESC LIMIT 1000;
            


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pa_multa_getById` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pa_multa_getById`(IN p_id_multa LONG)
BEGIN
SELECT
	m.id, 
    id_agente,
    id_coche,
    fecha_alta,
    fecha_baja, 
    importe, 
    concepto,
    c.matricula,
    c.modelo,
    c.km
FROM 
	multa as m,
    coche as c
WHERE 
	m.id_coche=c.id AND
    m.id = p_id_multa;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pa_multa_insert` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_AUTO_VALUE_ON_ZERO' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pa_multa_insert`(IN p_importe FLOAT, IN p_concepto VARCHAR(255), IN p_id_coche LONG, IN p_id_agente LONG, OUT o_id LONG)
BEGIN
INSERT INTO multa (`importe`, `concepto`, `id_coche`, `id_agente`) VALUES (p_importe, p_concepto, p_id_coche, p_id_agente);

SET o_id=last_insert_id();

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `pa_multa_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pa_multa_update`(IN p_id LONG, IN p_oper VARCHAR(15))
BEGIN
IF p_oper = 'recuperar' then
	UPDATE 
		multa 
    SET 
		fecha_baja = NULL,
        fecha_mod = CURRENT_TIMESTAMP 
	WHERE 
		id = p_id;
else
	UPDATE 
		multa 
    SET 
		fecha_baja = CURRENT_TIMESTAMP  
	WHERE 
		id = p_id;
end if;
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

-- Dump completed on 2019-03-07 10:02:28
