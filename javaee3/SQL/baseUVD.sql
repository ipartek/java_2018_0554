CREATE DATABASE  IF NOT EXISTS `javaee` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `javaee`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: javaee
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
-- Table structure for table `disco`
--

DROP TABLE IF EXISTS `disco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `disco` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `titulo` varchar(150) NOT NULL,
  `artista` varchar(150) NOT NULL,
  `portada` varchar(150) NOT NULL,
  `year` varchar(4) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `portada_UNIQUE` (`portada`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disco`
--

LOCK TABLES `disco` WRITE;
/*!40000 ALTER TABLE `disco` DISABLE KEYS */;
INSERT INTO `disco` VALUES (1,'Trapped!','Rage','https://images-na.ssl-images-amazon.com/images/I/718mNFu5jfL._SY355_.jpg','1992'),(2,'Firepower','Judas Priest','https://diablorock.com/wp-content/uploads/2018/03/firepower_portada.jpg','2018'),(3,'01011001','Ayreon','https://upload.wikimedia.org/wikipedia/en/a/ae/Ayreon_-_01011001.jpg','2008'),(4,'The Bottom Deep','Communic','https://upload.wikimedia.org/wikipedia/en/thumb/f/f1/Communic-2011.jpg/220px-Communic-2011.jpg','2011'),(5,'Apocalypse','Primal Fear','https://i2.wp.com/rockangels.com/web/wp-content/uploads/2018/08/primalfearapocalypsecd.jpg','2018'),(6,'Voyage','The Vintage Caravan','https://rockthebestmusic.com/wp-content/uploads/2014/01/the-vintage-caravan-voyage.png','2014'),(7,'Killing The Dragon','Dio','https://upload.wikimedia.org/wikipedia/en/c/cd/DioKillingTheDragon.jpg','2002'),(8,'Dehumanizer','Black Sabbath','https://upload.wikimedia.org/wikipedia/en/1/12/Black-sabbath-dehumanizer.jpg','1992'),(9,'The Metal Opera Part. 1','Avantasia','https://upload.wikimedia.org/wikipedia/en/thumb/8/8d/The_Metal_Opera.jpg/220px-The_Metal_Opera.jpg','2000'),(10,'Imaginations From The Other Side','Blind Guardian','https://upload.wikimedia.org/wikipedia/en/thumb/e/ed/IFtOS.jpg/220px-IFtOS.jpg','1995');
/*!40000 ALTER TABLE `disco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'identificador',
  `email` varchar(150) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin@admin.com','123456'),(2,'xabier@ipartek.com','Pa$$w0rd'),(6,'ttttt@gmgkgf.com','asdfghjkl'),(8,'email@ipartek.com','kdjhdjshvhsd'),(9,'discos@email.com','discospass'),(10,'videos@email.vid','videospass');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `video`
--

DROP TABLE IF EXISTS `video`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `video` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(150) NOT NULL,
  `codigo` varchar(11) NOT NULL COMMENT 'codigo youtube',
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  UNIQUE KEY `codigo_UNIQUE` (`codigo`),
  KEY `FK_USUARIO_idx` (`id_usuario`),
  CONSTRAINT `FK_USUARIO` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `video`
--

LOCK TABLES `video` WRITE;
/*!40000 ALTER TABLE `video` DISABLE KEYS */;
INSERT INTO `video` VALUES (1,'Iron Maiden - The Trooper','X4bgXH3sJ2Q',1),(2,'Iron Maiden - Run To The Hills','86URGgqONvA',6),(3,'Queensryche - Eyes Of A Stranger','A4duZjxusGM',1),(4,'Bruce Dickinson - Tears of The Dragon','vXClBjNxiOA',2),(6,'Rage - Refuge','d0_vu4biME8',2),(8,'Dio - Push','EFKnO9apt5I',2),(9,'AVANTASIA - The Raven Child','CTN2ZzpQRh4',2),(10,'Iced Earth - Ten Thousand Strong','jM4CDLmDx_Y',10);
/*!40000 ALTER TABLE `video` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-01-04 14:23:05