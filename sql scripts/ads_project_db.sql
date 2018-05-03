-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema krasutski
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `krasutski` ;

-- -----------------------------------------------------
-- Schema krasutski
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `krasutski` DEFAULT CHARACTER SET utf8 ;
USE `krasutski` ;

-- -----------------------------------------------------
-- Table `krasutski`.`roles`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `krasutski`.`roles` ;

CREATE TABLE IF NOT EXISTS `krasutski`.`roles` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `krasutski`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `krasutski`.`users` ;

CREATE TABLE IF NOT EXISTS `krasutski`.`users` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Login` VARCHAR(45) NULL,
  `Password` VARCHAR(45) NULL,
  `Email` VARCHAR(45) NULL,
  `Nickname` VARCHAR(45) NULL,
  `PhoneNumber` VARCHAR(45) NULL,
  `roles_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_users_roles1_idx` (`roles_ID` ASC),
  CONSTRAINT `fk_users_roles1`
    FOREIGN KEY (`roles_ID`)
    REFERENCES `krasutski`.`roles` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `krasutski`.`category`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `krasutski`.`category` ;

CREATE TABLE IF NOT EXISTS `krasutski`.`category` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `krasutski`.`ads`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `krasutski`.`ads` ;

CREATE TABLE IF NOT EXISTS `krasutski`.`ads` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Title` VARCHAR(45) NOT NULL,
  `SmallDesc` VARCHAR(150) NOT NULL,
  `Description` VARCHAR(500) NOT NULL,
  `Price` INT NOT NULL,
  `users_ID` INT NOT NULL,
  `category_ID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_ads_users1_idx` (`users_ID` ASC),
  INDEX `fk_ads_category1_idx` (`category_ID` ASC),
  CONSTRAINT `fk_ads_users1`
    FOREIGN KEY (`users_ID`)
    REFERENCES `krasutski`.`users` (`ID`)
    ON DELETE RESTRICT
    ON UPDATE RESTRICT,
  CONSTRAINT `fk_ads_category1`
    FOREIGN KEY (`category_ID`)
    REFERENCES `krasutski`.`category` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;