-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema industria_farmaceutica
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `industria_farmaceutica` ;

-- -----------------------------------------------------
-- Schema industria_farmaceutica
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `industria_farmaceutica` DEFAULT CHARACTER SET utf8 ;
USE `industria_farmaceutica` ;

-- -----------------------------------------------------
-- Table `industria_farmaceutica`.`cuidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `industria_farmaceutica`.`cuidad` (
  `id` INT UNSIGNED NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `industria_farmaceutica`.`farmaceutico`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `industria_farmaceutica`.`farmaceutico` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `dni` VARCHAR(45) NOT NULL,
  `telefono` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `industria_farmaceutica`.`farmacia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `industria_farmaceutica`.`farmacia` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `id_cuidad` INT UNSIGNED NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `industria_farmaceutica`.`empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `industria_farmaceutica`.`empleado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `dni` VARCHAR(45) NOT NULL,
  `telefono` INT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `industria_farmaceutica`.`personal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `industria_farmaceutica`.`personal` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `id_empleado` INT NOT NULL,
  `id_farmaceutico` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_personal_empleado1_idx` (`id_empleado` ASC) ,
  INDEX `fk_personal_farmaceutico1_idx` (`id_farmaceutico` ASC) ,
  CONSTRAINT `fk_personal_empleado1`
    FOREIGN KEY (`id_empleado`)
    REFERENCES `industria_farmaceutica`.`empleado` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_personal_farmaceutico1`
    FOREIGN KEY (`id_farmaceutico`)
    REFERENCES `industria_farmaceutica`.`farmaceutico` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `industria_farmaceutica`.`laboratorio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `industria_farmaceutica`.`laboratorio` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `industria_farmaceutica`.`medicamento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `industria_farmaceutica`.`medicamento` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `cantidad` INT NULL,
  `precio` FLOAT NULL,
  `id_laboratorio` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_medicamento_laboratorio1_idx` (`id_laboratorio` ASC) ,
  CONSTRAINT `fk_medicamento_laboratorio1`
    FOREIGN KEY (`id_laboratorio`)
    REFERENCES `industria_farmaceutica`.`laboratorio` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `industria_farmaceutica`.`presentacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `industria_farmaceutica`.`presentacion` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL COMMENT 'Gragea, capsula, ampolla, parche... etc',
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `industria_farmaceutica`.`stock`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `industria_farmaceutica`.`stock` (
  `cantidad` INT NOT NULL,
  `id_farmacia` INT NOT NULL,
  `id_medicamento` INT NOT NULL,
  `id_presentacion` INT NOT NULL,
  INDEX `fk_stock_farmacia1_idx` (`id_farmacia` ASC) ,
  INDEX `fk_stock_medicamento1_idx` (`id_medicamento` ASC) ,
  INDEX `fk_stock_presentacion1_idx` (`id_presentacion` ASC) ,
  CONSTRAINT `fk_stock_farmacia1`
    FOREIGN KEY (`id_farmacia`)
    REFERENCES `industria_farmaceutica`.`farmacia` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_stock_medicamento1`
    FOREIGN KEY (`id_medicamento`)
    REFERENCES `industria_farmaceutica`.`medicamento` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_stock_presentacion1`
    FOREIGN KEY (`id_presentacion`)
    REFERENCES `industria_farmaceutica`.`presentacion` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `industria_farmaceutica`.`accion_terapeutica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `industria_farmaceutica`.`accion_terapeutica` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `tipo` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `industria_farmaceutica`.`medicamento_has_accion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `industria_farmaceutica`.`medicamento_has_accion` (
  `id_medicamento` INT NOT NULL,
  `id_accion_terapeutica` INT NOT NULL,
  INDEX `fk_medicamento_has_accion_medicamento1_idx` (`id_medicamento` ASC) ,
  INDEX `fk_medicamento_has_accion_accion_terapeutica1_idx` (`id_accion_terapeutica` ASC) ,
  CONSTRAINT `fk_medicamento_has_accion_medicamento1`
    FOREIGN KEY (`id_medicamento`)
    REFERENCES `industria_farmaceutica`.`medicamento` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_medicamento_has_accion_accion_terapeutica1`
    FOREIGN KEY (`id_accion_terapeutica`)
    REFERENCES `industria_farmaceutica`.`accion_terapeutica` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `industria_farmaceutica`.`farmacia_has_empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `industria_farmaceutica`.`farmacia_has_empleado` (
  `id_farmacia` INT NOT NULL,
  `id_personal` INT NOT NULL,
  INDEX `fk_farmacia_has_empleado_farmacia1_idx` (`id_farmacia` ASC) ,
  INDEX `fk_farmacia_has_empleado_personal1_idx` (`id_personal` ASC) ,
  CONSTRAINT `fk_farmacia_has_empleado_farmacia1`
    FOREIGN KEY (`id_farmacia`)
    REFERENCES `industria_farmaceutica`.`farmacia` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_farmacia_has_empleado_personal1`
    FOREIGN KEY (`id_personal`)
    REFERENCES `industria_farmaceutica`.`personal` (`id`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `industria_farmaceutica`.`monodroga`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `industria_farmaceutica`.`monodroga` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descripcion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `industria_farmaceutica`.`administracion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `industria_farmaceutica`.`administracion` (
  `id` INT NOT NULL,
  `id_monodroga` INT NOT NULL,
  `id_medicamento` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_administracion_monodroga1_idx` (`id_monodroga` ASC) ,
  INDEX `fk_administracion_medicamento1_idx` (`id_medicamento` ASC) ,
  CONSTRAINT `fk_administracion_monodroga1`
    FOREIGN KEY (`id_monodroga`)
    REFERENCES `industria_farmaceutica`.`monodroga` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_administracion_medicamento1`
    FOREIGN KEY (`id_medicamento`)
    REFERENCES `industria_farmaceutica`.`medicamento` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;