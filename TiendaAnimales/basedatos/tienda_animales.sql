-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.7.23 - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.5.0.5293
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para tienda_animales
DROP DATABASE IF EXISTS `tienda_animales`;
CREATE DATABASE IF NOT EXISTS `tienda_animales` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tienda_animales`;

-- Volcando estructura para tabla tienda_animales.animal
DROP TABLE IF EXISTS `animal`;
CREATE TABLE IF NOT EXISTS `animal` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `id_tipo` int(11) NOT NULL,
  `id_dieta` int(11) NOT NULL,
  `peso` float NOT NULL,
  `precio` float NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_animal_dieta1_idx` (`id_dieta`),
  KEY `fk_animal_tipo1_idx` (`id_tipo`),
  CONSTRAINT `fk_animal_dieta1` FOREIGN KEY (`id_dieta`) REFERENCES `dieta` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_animal_tipo1` FOREIGN KEY (`id_tipo`) REFERENCES `tipo` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tienda_animales.animal: ~9 rows (aproximadamente)
DELETE FROM `animal`;
/*!40000 ALTER TABLE `animal` DISABLE KEYS */;
INSERT INTO `animal` (`id`, `nombre`, `id_tipo`, `id_dieta`, `peso`, `precio`) VALUES
	(1, 'Pitón', 1, 1, 2.3, 99.5),
	(2, 'Boa Constrictor', 1, 1, 4.5, 129.99),
	(3, 'Cobra', 1, 1, 3, 75),
	(4, 'Negra', 2, 2, 0.7, 44.95),
	(5, 'Roja', 2, 2, 0.5, 35.65),
	(6, 'Peluda', 2, 2, 0.4, 29.95),
	(7, 'Verde', 3, 3, 1.5, 65),
	(8, 'Mocoso', 3, 3, 1, 45),
	(9, 'Cara Sapo', 3, 3, 2.1, 89.5);
/*!40000 ALTER TABLE `animal` ENABLE KEYS */;

-- Volcando estructura para tabla tienda_animales.cliente
DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `dni` varchar(10) NOT NULL,
  `telefono` varchar(13) NOT NULL,
  `email` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tienda_animales.cliente: ~5 rows (aproximadamente)
DELETE FROM `cliente`;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` (`id`, `nombre`, `apellidos`, `dni`, `telefono`, `email`) VALUES
	(1, 'Ander', 'Solana', '77777777P', '666666666', 'ander@solana.com'),
	(2, 'Ander', 'Uraga', '88888888T', '688888888', 'ander@uraga.com'),
	(3, 'Daniel', 'Zallo', '55555555E', '655555555', 'daniel@zallo.com'),
	(4, 'Endika', 'Vázquez', '44444444S', '644444444', 'endika@vazquez.com'),
	(5, 'Amaia', 'Del Olmo', '22222222W', '622222222', 'amaia@delolmo.com');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;

-- Volcando estructura para tabla tienda_animales.dieta
DROP TABLE IF EXISTS `dieta`;
CREATE TABLE IF NOT EXISTS `dieta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tienda_animales.dieta: ~3 rows (aproximadamente)
DELETE FROM `dieta`;
/*!40000 ALTER TABLE `dieta` DISABLE KEYS */;
INSERT INTO `dieta` (`id`, `nombre`) VALUES
	(1, 'Herbívoro'),
	(2, 'Insectívoro'),
	(3, 'Vegetariano');
/*!40000 ALTER TABLE `dieta` ENABLE KEYS */;

-- Volcando estructura para tabla tienda_animales.empleado
DROP TABLE IF EXISTS `empleado`;
CREATE TABLE IF NOT EXISTS `empleado` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `dni` varchar(10) NOT NULL,
  `telefono` varchar(13) NOT NULL,
  `email` varchar(100) NOT NULL,
  `id_rol` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  KEY `fk_empleado_rol_idx` (`id_rol`),
  CONSTRAINT `fk_empleado_rol` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tienda_animales.empleado: ~10 rows (aproximadamente)
DELETE FROM `empleado`;
/*!40000 ALTER TABLE `empleado` DISABLE KEYS */;
INSERT INTO `empleado` (`id`, `nombre`, `apellidos`, `dni`, `telefono`, `email`, `id_rol`) VALUES
	(1, 'Juancho', 'Gomez', '11111111K', '666111111', 'juancho@gomez.com', 1),
	(2, 'Manolo', 'Jimenez', '111222333J', '678900000', 'manolo@jimenez.com', 1),
	(3, 'Jose', 'Coronado', '123456789O', '655555555', 'jose@coronado.com', 2),
	(4, 'Fausto', 'Hernandez', '111444222Q', '677777223', 'fausto@hernandez.com', 2),
	(5, 'Mikel', 'Oyarzabal', '10101010T', '610100100', 'mikel@oyarzabal.com', 2),
	(6, 'Asier', 'Illarramendi', '44444444M', '644000444', 'asier@illarramendi.com', 2),
	(7, 'Geronimo', 'Rulli', '11131113V', '611133133', 'geronimo@rulli.com', 2),
	(8, 'Miguel Angel', 'Moyá', '13131313G', '613613613', 'miguelangel@moya.com', 3),
	(9, 'William', 'José', '99913399J', '699999999', 'william@jose.com', 4),
	(10, 'Michel', 'Sobrino', '333222555Y', '622333678', 'michel@sobrino.com', 5);
/*!40000 ALTER TABLE `empleado` ENABLE KEYS */;

-- Volcando estructura para tabla tienda_animales.rol
DROP TABLE IF EXISTS `rol`;
CREATE TABLE IF NOT EXISTS `rol` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tienda_animales.rol: ~5 rows (aproximadamente)
DELETE FROM `rol`;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` (`id`, `nombre`) VALUES
	(4, 'Auxiliar'),
	(2, 'Empleado de tienda'),
	(5, 'Jefe'),
	(1, 'Secretario'),
	(3, 'Veterinario');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;

-- Volcando estructura para tabla tienda_animales.stock
DROP TABLE IF EXISTS `stock`;
CREATE TABLE IF NOT EXISTS `stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_animal` int(11) NOT NULL,
  `isListo` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0 si no está listo\n1 si está listo',
  PRIMARY KEY (`id`),
  KEY `fk_stock_animal1_idx` (`id_animal`),
  CONSTRAINT `fk_stock_animal1` FOREIGN KEY (`id_animal`) REFERENCES `animal` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tienda_animales.stock: ~11 rows (aproximadamente)
DELETE FROM `stock`;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` (`id`, `id_animal`, `isListo`) VALUES
	(1, 1, 1),
	(2, 2, 1),
	(3, 3, 0),
	(4, 4, 1),
	(5, 5, 0),
	(6, 6, 0),
	(7, 7, 1),
	(8, 8, 1),
	(9, 9, 0),
	(10, 1, 1),
	(11, 3, 1);
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;

-- Volcando estructura para tabla tienda_animales.tipo
DROP TABLE IF EXISTS `tipo`;
CREATE TABLE IF NOT EXISTS `tipo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `nombre_UNIQUE` (`nombre`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tienda_animales.tipo: ~3 rows (aproximadamente)
DELETE FROM `tipo`;
/*!40000 ALTER TABLE `tipo` DISABLE KEYS */;
INSERT INTO `tipo` (`id`, `nombre`) VALUES
	(1, 'Serpiente'),
	(2, 'Tarántula'),
	(3, 'Tritón');
/*!40000 ALTER TABLE `tipo` ENABLE KEYS */;

-- Volcando estructura para tabla tienda_animales.venta
DROP TABLE IF EXISTS `venta`;
CREATE TABLE IF NOT EXISTS `venta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_cliente` int(11) NOT NULL,
  `id_stock` int(11) NOT NULL,
  `fecha` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_venta_cliente1_idx` (`id_cliente`),
  KEY `fk_venta_stock1_idx` (`id_stock`),
  CONSTRAINT `fk_venta_cliente1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_venta_stock1` FOREIGN KEY (`id_stock`) REFERENCES `stock` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tienda_animales.venta: ~8 rows (aproximadamente)
DELETE FROM `venta`;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` (`id`, `id_cliente`, `id_stock`, `fecha`) VALUES
	(1, 1, 1, '2019-02-11 10:18:11'),
	(2, 1, 2, '2019-02-11 10:18:11'),
	(3, 2, 4, '2019-02-11 10:18:11'),
	(4, 3, 7, '2019-02-11 10:18:11'),
	(5, 3, 8, '2019-02-11 10:18:11'),
	(6, 3, 10, '2019-02-11 12:30:14'),
	(7, 1, 11, '2019-02-11 12:48:21'),
	(8, 2, 11, '2019-02-11 13:08:36');
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
