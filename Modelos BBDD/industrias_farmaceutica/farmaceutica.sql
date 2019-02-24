-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema farmaceutica
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema farmaceutica
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `farmaceutica` DEFAULT CHARACTER SET utf8 ;
USE `farmaceutica` ;

-- -----------------------------------------------------
-- Table `farmaceutica`.`accion_terapeutica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmaceutica`.`accion_terapeutica` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `farmaceutica`.`ciudad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmaceutica`.`ciudad` (
  `id` INT(10) UNSIGNED NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `farmaceutica`.`farmacia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmaceutica`.`farmacia` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `id_cuidad` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_farmacia_cuidad1_idx` (`id_cuidad` ASC) VISIBLE,
  CONSTRAINT `fk_farmacia_cuidad1`
    FOREIGN KEY (`id_cuidad`)
    REFERENCES `farmaceutica`.`ciudad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `farmaceutica`.`laboratorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmaceutica`.`laboratorio` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `farmaceutica`.`presentacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmaceutica`.`presentacion` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL COMMENT 'Gragea, capsula, ampolla, parche... etc',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `farmaceutica`.`medicamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmaceutica`.`medicamento` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `precio` FLOAT NULL DEFAULT NULL,
  `id_laboratorio` INT(11) NOT NULL,
  `id_presentacion` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_medicamento_laboratorio1_idx` (`id_laboratorio` ASC) VISIBLE,
  INDEX `fk_medicamento_presentacion1_idx` (`id_presentacion` ASC) VISIBLE,
  CONSTRAINT `fk_medicamento_laboratorio1`
    FOREIGN KEY (`id_laboratorio`)
    REFERENCES `farmaceutica`.`laboratorio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_medicamento_presentacion1`
    FOREIGN KEY (`id_presentacion`)
    REFERENCES `farmaceutica`.`presentacion` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `farmaceutica`.`medicamento_has_accion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmaceutica`.`medicamento_has_accion` (
  `id` VARCHAR(45) NOT NULL,
  `id_medicamento` INT(11) NOT NULL,
  `id_accion_terapeutica` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_medicamento_has:accion_medicamento_idx` (`id_medicamento` ASC) VISIBLE,
  INDEX `fk_medicamento_has:accion_accion_terapeutica_idx` (`id_accion_terapeutica` ASC) VISIBLE,
  CONSTRAINT `fk_medicamento_has:accion_accion_terapeutica`
    FOREIGN KEY (`id_accion_terapeutica`)
    REFERENCES `farmaceutica`.`accion_terapeutica` (`id`),
  CONSTRAINT `fk_medicamento_has:accion_medicamento`
    FOREIGN KEY (`id_medicamento`)
    REFERENCES `farmaceutica`.`medicamento` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `farmaceutica`.`monodroga`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmaceutica`.`monodroga` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` TEXT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `farmaceutica`.`medicamento_has_monodroga`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmaceutica`.`medicamento_has_monodroga` (
  `id` VARCHAR(45) NOT NULL,
  `id_medicamento` INT(11) NOT NULL,
  `id_monodroga` INT(11) NOT NULL,
  INDEX `fk_medicamento_has_monodroga_monodroga1_idx` (`id_monodroga` ASC) VISIBLE,
  INDEX `fk_medicamento_has_monodroga_medicamento1_idx` (`id_medicamento` ASC) VISIBLE,
  CONSTRAINT `fk_medicamento_has_monodroga_medicamento1`
    FOREIGN KEY (`id_medicamento`)
    REFERENCES `farmaceutica`.`medicamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_medicamento_has_monodroga_monodroga1`
    FOREIGN KEY (`id_monodroga`)
    REFERENCES `farmaceutica`.`monodroga` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `farmaceutica`.`stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmaceutica`.`stock` (
  `id` VARCHAR(45) NOT NULL,
  `cantidad` INT(11) NOT NULL,
  `id_farmacia` INT(11) NOT NULL,
  `id_medicamento` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_stock_farmacia1_idx` (`id_farmacia` ASC) VISIBLE,
  INDEX `fk_stock_medicamento1_idx` (`id_medicamento` ASC) VISIBLE,
  CONSTRAINT `fk_stock_farmacia1`
    FOREIGN KEY (`id_farmacia`)
    REFERENCES `farmaceutica`.`farmacia` (`id`),
  CONSTRAINT `fk_stock_medicamento1`
    FOREIGN KEY (`id_medicamento`)
    REFERENCES `farmaceutica`.`medicamento` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `farmaceutica`.`trabajador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `farmaceutica`.`trabajador` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `dni` VARCHAR(45) NOT NULL,
  `telefono` INT(11) NOT NULL,
  `encargado` TINYINT(2) NOT NULL COMMENT '0 - Empleado / 1 - Encargado',
  `id_ciudad` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_trabajador_ciudad1_idx` (`id_ciudad` ASC) VISIBLE,
  CONSTRAINT `fk_trabajador_ciudad1`
    FOREIGN KEY (`id_ciudad`)
    REFERENCES `farmaceutica`.`ciudad` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
