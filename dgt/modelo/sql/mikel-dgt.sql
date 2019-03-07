-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.1.37-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win32
-- HeidiSQL Versión:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para dgt
DROP DATABASE IF EXISTS `mikel_dgt`;
CREATE DATABASE IF NOT EXISTS `mikel_dgt` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `mikel_dgt`;

-- Volcando estructura para tabla dgt.agente
CREATE TABLE IF NOT EXISTS `agente` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `placa` int(11) NOT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `placa_UNIQUE` (`placa`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla dgt.agente: ~5 rows (aproximadamente)
/*!40000 ALTER TABLE `agente` DISABLE KEYS */;
INSERT INTO `agente` (`id`, `nombre`, `placa`, `password`) VALUES
	(1, 'Majonei', 123456, '123456'),
	(2, 'Johnny Walker', 222222, '222222'),
	(3, 'Monk', 333333, '333333'),
	(4, 'Takelberry', 111111, '111111'),
	(5, 'Tontimmy', 444444, '444444');
/*!40000 ALTER TABLE `agente` ENABLE KEYS */;

-- Volcando estructura para tabla dgt.coche
CREATE TABLE IF NOT EXISTS `coche` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `matricula` varchar(10) NOT NULL,
  `modelo` varchar(45) NOT NULL DEFAULT 'cuatro latas',
  `km` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `matricula_UNIQUE` (`matricula`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla dgt.coche: ~4 rows (aproximadamente)
/*!40000 ALTER TABLE `coche` DISABLE KEYS */;
INSERT INTO `coche` (`id`, `matricula`, `modelo`, `km`) VALUES
	(1, '3548MKZ', 'Toyota Yaris', 500),
	(2, '9605EFH', 'Fiat multipla', 800),
	(3, '5674MBD', 'GRT', 1800),
	(4, 'BI0020AZ', 'flagoneta', 47500);
/*!40000 ALTER TABLE `coche` ENABLE KEYS */;

-- Volcando estructura para tabla dgt.multa
CREATE TABLE IF NOT EXISTS `multa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `importe` float DEFAULT '50',
  `concepto` varchar(255) DEFAULT NULL,
  `fecha_alta` datetime DEFAULT CURRENT_TIMESTAMP,
  `id_coche` int(11) NOT NULL,
  `id_agente` int(11) NOT NULL,
  `fecha_mod` datetime DEFAULT NULL,
  `fecha_baja` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_multa_coches_idx` (`id_coche`),
  KEY `fk__idx` (`id_agente`),
  CONSTRAINT `fk_multa_agente` FOREIGN KEY (`id_agente`) REFERENCES `agente` (`id`),
  CONSTRAINT `fk_multa_coches` FOREIGN KEY (`id_coche`) REFERENCES `coche` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla dgt.multa: ~27 rows (aproximadamente)
/*!40000 ALTER TABLE `multa` DISABLE KEYS */;
INSERT INTO `multa` (`id`, `importe`, `concepto`, `fecha_alta`, `id_coche`, `id_agente`, `fecha_mod`, `fecha_baja`) VALUES
	(12, 21.53, '234567876532weerewtrwywete', '2018-09-14 10:25:30', 1, 4, NULL, NULL),
	(13, 0, 'por muy feo', '2018-09-14 11:06:39', 1, 4, NULL, NULL),
	(14, 500, 'por muy feo', '2018-08-14 13:02:47', 1, 4, NULL, NULL),
	(15, 500.7, 'vas mas borracho que el tato', '2018-06-15 12:25:10', 2, 4, NULL, NULL),
	(16, 500.7, 'borrachuzo de mierda', '2018-05-15 12:31:15', 2, 4, NULL, NULL),
	(17, 500.7, 'borrachuzo de mierda', '2018-02-15 12:33:21', 2, 4, NULL, NULL),
	(18, 500.7, 'borrachuzo de mierda', '2019-01-15 12:35:22', 2, 4, NULL, NULL),
	(19, 500.7, 'borrachuzo de mierda', '2018-08-15 12:37:48', 2, 4, NULL, NULL),
	(20, 500.7, 'borrachuzo de mierda', '2019-01-15 12:38:49', 2, 4, NULL, NULL),
	(21, 500.7, 'borrachuzo de mierda', '2019-01-15 12:39:12', 2, 4, NULL, NULL),
	(22, 500.7, 'borrachuzo de mierda', '2018-04-15 12:42:02', 2, 4, NULL, NULL),
	(23, 500.7, 'borrachuzo de mierda', '2018-07-15 12:45:28', 2, 4, NULL, NULL),
	(24, 500.7, 'borrachuzo de mierda', '2018-11-15 12:45:32', 2, 2, NULL, NULL),
	(25, 500.7, 'borrachuzo de mierda', '2018-01-15 12:46:07', 2, 2, NULL, NULL),
	(26, 500.7, 'borrachuzo de mierda', '2018-10-15 12:48:21', 2, 2, NULL, NULL),
	(27, 500.7, 'borrachuzo de mierda', '2018-11-15 12:49:41', 2, 4, NULL, NULL),
	(28, 456.6, 'fdgrd', '2018-12-16 09:21:46', 2, 4, NULL, NULL),
	(29, 540.59, 'aefwefwefwfewefwe', '2018-12-17 12:08:48', 1, 1, NULL, NULL),
	(30, 1445, 'pruebaaaaaaa', '2018-03-20 21:21:10', 2, 4, NULL, NULL),
	(31, 0, 'khfkesjh', '2018-03-21 10:02:01', 3, 4, NULL, '2019-03-04 13:52:04'),
	(32, 350, 'prueba rest', '2019-02-26 13:29:16', 2, 2, NULL, NULL),
	(33, 333, 'prueba rest y service', '2019-02-28 09:35:47', 4, 2, NULL, NULL),
	(34, 333, 'prueba body corto', '2019-03-04 09:59:35', 4, 2, NULL, NULL),
	(37, 305, 'prueba desde app funcionara', '2019-03-04 10:32:52', 4, 4, NULL, NULL),
	(38, 300, 'lalalalalalalalalalalala', '2019-03-04 12:00:05', 4, 4, NULL, NULL),
	(40, 200, 'qsdfghjkhgfdsadfghjwedfgh', '2019-03-04 12:04:08', 4, 4, NULL, '2019-03-05 10:34:28'),
	(41, 30, 'porque me da la puta gana', '2019-03-05 10:34:46', 4, 4, NULL, '2019-03-06 10:17:34');
/*!40000 ALTER TABLE `multa` ENABLE KEYS */;

-- Volcando estructura para tabla dgt.objetivo
CREATE TABLE IF NOT EXISTS `objetivo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Anio` int(4) NOT NULL,
  `objetivo` float NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='	';

-- Volcando datos para la tabla dgt.objetivo: ~2 rows (aproximadamente)
/*!40000 ALTER TABLE `objetivo` DISABLE KEYS */;
INSERT INTO `objetivo` (`id`, `Anio`, `objetivo`) VALUES
	(1, 2018, 12000),
	(2, 2019, 14400);
/*!40000 ALTER TABLE `objetivo` ENABLE KEYS */;

-- Volcando estructura para vista dgt.objetivo_agente_mes
-- Creando tabla temporal para superar errores de dependencia de VIEW
CREATE TABLE `objetivo_agente_mes` (
	`month(fecha_alta)` INT(2) NULL,
	`sum(importe)` DOUBLE NULL
) ENGINE=MyISAM;

-- Volcando estructura para procedimiento dgt.pa_agente_getById
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `pa_agente_getById`(IN p_id LONG)
BEGIN
	SELECT 
		id, 
        nombre 
    FROM 
		agente 
    WHERE 
		id = p_id;
END//
DELIMITER ;

-- Volcando estructura para procedimiento dgt.pa_coche_getByMatricula
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `pa_coche_getByMatricula`(IN p_matricula VARCHAR(50))
BEGIN
SELECT id,matricula,modelo,km FROM coche WHERE matricula= p_matricula;
END//
DELIMITER ;

-- Volcando estructura para procedimiento dgt.pa_login
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `pa_login`(IN p_placa INT, IN p_pass VARCHAR(20))
BEGIN
SELECT 
	a.id,
	a.nombre,
	a.placa,
    a.password
FROM 
	agente as a
WHERE
	a.placa=p_placa AND
    a.password=p_pass;
END//
DELIMITER ;

-- Volcando estructura para procedimiento dgt.pa_multa_devuelveTotales
DELIMITER //
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

END//
DELIMITER ;

-- Volcando estructura para procedimiento dgt.pa_multa_getByAgenteId
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `pa_multa_getByAgenteId`(IN p_id_agente INT, IN p_operacion VARCHAR(15))
BEGIN

IF p_operacion = 'baja' then
	SELECT 
		m.id,
		m.fecha_alta, 
		m.fecha_baja,
		c.matricula, 
		c.modelo 
	FROM 
		multa m, 
		coche c 
	WHERE 
		m.id_coche = c.id AND 
		m.id_agente = p_id_agente AND
		m.fecha_baja IS NOT NULL
	ORDER BY m.id DESC LIMIT 1000;
            
else
	SELECT 
		m.id,
		m.fecha_alta, 
		m.fecha_baja,
		c.matricula, 
		c.modelo 
	FROM 
		multa m, 
		coche c 
	WHERE 
		m.id_coche = c.id AND 
		m.id_agente = p_id_agente AND
		m.fecha_baja IS NULL
	ORDER BY m.id DESC LIMIT 1000;
end if;
END//
DELIMITER ;

-- Volcando estructura para procedimiento dgt.pa_multa_getById
DELIMITER //
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
END//
DELIMITER ;

-- Volcando estructura para procedimiento dgt.pa_multa_insert
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `pa_multa_insert`(IN p_importe FLOAT, IN p_concepto VARCHAR(255), IN p_id_coche LONG, IN p_id_agente LONG, OUT o_id LONG)
BEGIN
INSERT INTO multa (`importe`, `concepto`, `id_coche`, `id_agente`) VALUES (p_importe, p_concepto, p_id_coche, p_id_agente);

SET o_id=last_insert_id();

END//
DELIMITER ;

-- Volcando estructura para procedimiento dgt.pa_multa_update
DELIMITER //
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
END//
DELIMITER ;

-- Volcando estructura para disparador dgt.tbi_agente_comprobacion
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `tbi_agente_comprobacion` BEFORE INSERT ON `agente` FOR EACH ROW BEGIN
	set new.nombre=trim(new.nombre);
    set new.password=trim(new.password);
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador dgt.tbi_coche_comprobaciones
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `tbi_coche_comprobaciones` BEFORE INSERT ON `coche` FOR EACH ROW BEGIN
	set new.matricula=trim(new.matricula);
    set new.modelo=trim(new.modelo);
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para disparador dgt.tbi_multa_correcciones
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `tbi_multa_correcciones` BEFORE INSERT ON `multa` FOR EACH ROW BEGIN
	set new.concepto=trim(new.concepto);
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Volcando estructura para vista dgt.objetivo_agente_mes
-- Eliminando tabla temporal y crear estructura final de VIEW
DROP TABLE IF EXISTS `objetivo_agente_mes`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`127.0.0.1` SQL SECURITY DEFINER VIEW `objetivo_agente_mes` AS select month(fecha_alta), sum(importe) from multa where id_agente = 4 GROUP BY month(fecha_alta) ;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
