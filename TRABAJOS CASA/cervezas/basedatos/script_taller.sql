-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema cervezas
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema cervezas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `cervezas` DEFAULT CHARACTER SET utf8 ;
USE `cervezas` ;

-- -----------------------------------------------------
-- Table `cervezas`.`tipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cervezas`.`tipo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cervezas`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cervezas`.`cliente` (
  `id` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cervezas`.`compra`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cervezas`.`compra` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NOT NULL,
  `fecha_compra` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tipo_id` INT NOT NULL,
  `cliente_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_compra_tipo_idx` (`tipo_id` ASC),
  INDEX `fk_compra_cliente1_idx` (`cliente_id` ASC),
  CONSTRAINT `fk_compra_tipo`
    FOREIGN KEY (`tipo_id`)
    REFERENCES `cervezas`.`tipo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_compra_cliente1`
    FOREIGN KEY (`cliente_id`)
    REFERENCES `cervezas`.`cliente` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cervezas`.`fabrica`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cervezas`.`fabrica` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cervezas`.`cerveza`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cervezas`.`cerveza` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `tipo_id` INT NOT NULL,
  `compra_id` INT NOT NULL,
  `fabrica_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `nombre_UNIQUE` (`nombre` ASC),
  INDEX `fk_cerveza_tipo1_idx` (`tipo_id` ASC),
  INDEX `fk_cerveza_compra1_idx` (`compra_id` ASC),
  INDEX `fk_cerveza_fabrica1_idx` (`fabrica_id` ASC),
  CONSTRAINT `fk_cerveza_tipo1`
    FOREIGN KEY (`tipo_id`)
    REFERENCES `cervezas`.`tipo` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cerveza_compra1`
    FOREIGN KEY (`compra_id`)
    REFERENCES `cervezas`.`compra` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_cerveza_fabrica1`
    FOREIGN KEY (`fabrica_id`)
    REFERENCES `cervezas`.`fabrica` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `cervezas`.`empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `cervezas`.`empleado` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `fabrica_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_empleado_fabrica1_idx` (`fabrica_id` ASC),
  CONSTRAINT `fk_empleado_fabrica1`
    FOREIGN KEY (`fabrica_id`)
    REFERENCES `cervezas`.`fabrica` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
