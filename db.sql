-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema flight
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema flight
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `flight` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `flight` ;

-- -----------------------------------------------------
-- Table `flight`.`fidelity_card`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flight`.`fidelity_card` (
  `card_number` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `last_purchase_date` DATE NULL DEFAULT NULL,
  `points` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`card_number`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `flight`.`flights`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flight`.`flights` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `cancelled` BIT(1) NOT NULL,
  `departure_day` DATE NOT NULL,
  `departure_hour` TIME NOT NULL,
  `departure_location` VARCHAR(255) NOT NULL,
  `landing_hour` TIME NOT NULL,
  `landing_location` VARCHAR(255) NOT NULL,
  `price` INT(11) NOT NULL,
  `seats_left` INT(11) NOT NULL,
  `seats_number` INT(11) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `flight`.`promotions`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flight`.`promotions` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `discount_percentage` INT(11) NULL DEFAULT NULL,
  `end` DATE NULL DEFAULT NULL,
  `flight` TINYBLOB NULL DEFAULT NULL,
  `start` DATE NULL DEFAULT NULL,
  `premium` bit(1) DEFAULT 0,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `flight`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flight`.`users` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `address` VARCHAR(255) NULL DEFAULT NULL,
  `date_creation` DATETIME(6) NOT NULL,
  `date_deletion` DATETIME(6) NULL DEFAULT NULL,
  `email` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `surname` VARCHAR(255) NOT NULL,
  `fidelity_card_card_number` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `UK_6dotkott2kjsp8vw4d0m25fb7` (`email` ASC) VISIBLE,
  INDEX `FK8jbkkbr1vbfkgq5ksg6yuajyu` (`fidelity_card_card_number` ASC) VISIBLE,
  CONSTRAINT `FK8jbkkbr1vbfkgq5ksg6yuajyu`
    FOREIGN KEY (`fidelity_card_card_number`)
    REFERENCES `flight`.`fidelity_card` (`card_number`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `flight`.`tickets`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `flight`.`tickets` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `reserved` BIT(1) NULL DEFAULT NULL,
  `buyer_id` BIGINT(20) NOT NULL,
  `flight_id` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKprr7809lfbwkgc85qxprbwf7j` (`buyer_id` ASC) VISIBLE,
  INDEX `FKtdayegtd891qq5xm0axfbckvy` (`flight_id` ASC) VISIBLE,
  CONSTRAINT `FKprr7809lfbwkgc85qxprbwf7j`
    FOREIGN KEY (`buyer_id`)
    REFERENCES `flight`.`users` (`id`),
  CONSTRAINT `FKtdayegtd891qq5xm0axfbckvy`
    FOREIGN KEY (`flight_id`)
    REFERENCES `flight`.`flights` (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
