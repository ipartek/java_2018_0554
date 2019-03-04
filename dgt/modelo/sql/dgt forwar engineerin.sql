-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema dgt2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema dgt2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dgt2` DEFAULT CHARACTER SET utf8 ;
USE `dgt2` ;

-- -----------------------------------------------------
-- Table `dgt2`.`agente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dgt2`.`agente` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `placa` INT(11) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `imagen` VARCHAR(200) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `placa_UNIQUE` (`placa` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dgt2`.`coche`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dgt2`.`coche` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `matricula` VARCHAR(10) NOT NULL,
  `modelo` VARCHAR(45) NOT NULL DEFAULT 'cuatro latas',
  `km` INT(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE INDEX `matricula_UNIQUE` (`matricula` ASC))
ENGINE = InnoDB
AUTO_INCREMENT = 5
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dgt2`.`multa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dgt2`.`multa` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `importe` FLOAT NULL DEFAULT '50',
  `concepto` VARCHAR(255) NULL DEFAULT NULL,
  `fecha_alta` DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
  `id_coche` INT(11) NOT NULL,
  `id_agente` INT(11) NOT NULL,
  `fecha_mod` DATETIME NULL DEFAULT NULL,
  `fecha_baja` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_multa_coches_idx` (`id_coche` ASC),
  INDEX `fk__idx` (`id_agente` ASC),
  CONSTRAINT `fk_multa_agente`
    FOREIGN KEY (`id_agente`)
    REFERENCES `dgt2`.`agente` (`id`),
  CONSTRAINT `fk_multa_coches`
    FOREIGN KEY (`id_coche`)
    REFERENCES `dgt2`.`coche` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 49
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `dgt2`.`objetivo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dgt2`.`objetivo` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `Anio` INT(4) NOT NULL,
  `objetivo` FLOAT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8
COMMENT = '	';

USE `dgt2` ;

-- -----------------------------------------------------
-- procedure pa_agente_getById
-- -----------------------------------------------------

DELIMITER $$
USE `dgt2`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pa_agente_getById`(IN p_id LONG)
BEGIN
	SELECT 
		id, 
        nombre 
    FROM 
		agente 
    WHERE 
		id = p_id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure pa_coche_getByMatricula
-- -----------------------------------------------------

DELIMITER $$
USE `dgt2`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pa_coche_getByMatricula`(IN p_matricula VARCHAR(50))
BEGIN
SELECT id,matricula,modelo,km FROM coche WHERE matricula= p_matricula;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure pa_login
-- -----------------------------------------------------

DELIMITER $$
USE `dgt2`$$
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
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure pa_multa_anulada_getByAgenteId
-- -----------------------------------------------------

DELIMITER $$
USE `dgt2`$$
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
            


END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure pa_multa_devuelveTotales
-- -----------------------------------------------------

DELIMITER $$
USE `dgt2`$$
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

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure pa_multa_getByAgenteId
-- -----------------------------------------------------

DELIMITER $$
USE `dgt2`$$
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
		m.fecha_baja IS  NULL
	ORDER BY m.id DESC LIMIT 1000;
            


END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure pa_multa_getById
-- -----------------------------------------------------

DELIMITER $$
USE `dgt2`$$
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
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure pa_multa_insert
-- -----------------------------------------------------

DELIMITER $$
USE `dgt2`$$
CREATE DEFINER=`root`@`localhost` PROCEDURE `pa_multa_insert`(IN p_importe FLOAT, IN p_concepto VARCHAR(255),  IN p_id_agente LONG, IN p_id_coche LONG, OUT o_id LONG)
BEGIN
INSERT INTO multa (`importe`, `concepto`,`id_agente`, `id_coche` ) VALUES (p_importe, p_concepto,  p_id_agente, p_id_coche);

SET o_id=last_insert_id();

END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure pa_multa_update
-- -----------------------------------------------------

DELIMITER $$
USE `dgt2`$$
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
END$$

DELIMITER ;
USE `dgt2`;

DELIMITER $$
USE `dgt2`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `dgt`.`tbi_agente_comprobacion`
BEFORE INSERT ON `dgt`.`agente`
FOR EACH ROW
BEGIN
	set new.nombre=trim(new.nombre);
    set new.password=trim(new.password);
END$$

USE `dgt2`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `dgt`.`tbi_coche_comprobaciones`
BEFORE INSERT ON `dgt`.`coche`
FOR EACH ROW
BEGIN
	set new.matricula=trim(new.matricula);
    set new.modelo=trim(new.modelo);
END$$

USE `dgt2`$$
CREATE
DEFINER=`root`@`localhost`
TRIGGER `dgt`.`tbi_multa_correcciones`
BEFORE INSERT ON `dgt`.`multa`
FOR EACH ROW
BEGIN
	set new.concepto=trim(new.concepto);
END$$


DELIMITER ;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
