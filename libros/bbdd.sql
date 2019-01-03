-- --------------------------------------------------------
-- Host:                         192.168.0.44
-- Versión del servidor:         5.7.14 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para youtube
CREATE DATABASE IF NOT EXISTS `youtube` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `youtube`;

-- Volcando estructura para tabla youtube.mikel_videos
CREATE TABLE IF NOT EXISTS `mikel_videos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Volcando datos para la tabla youtube.mikel_videos: 3 rows
/*!40000 ALTER TABLE `mikel_videos` DISABLE KEYS */;
INSERT INTO `mikel_videos` (`id`, `nombre`, `url`) VALUES
	(1, 'Fredrik\'s DRIFT', 'TLoAdsj5jRo'),
	(2, 'Fredrik Sørlie\'s Scandinavian Flickfest', '_1ZauQdvlqo'),
	(3, 'BRING BACK THE TOUGE', 'Rq2ktZSyoEo');
/*!40000 ALTER TABLE `mikel_videos` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
