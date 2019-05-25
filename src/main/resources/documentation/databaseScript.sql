-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema ocr_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema ocr_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `ocr_db` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `ocr_db` ;

-- -----------------------------------------------------
-- Table `ocr_db`.`customer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ocr_db`.`customer` (
  `customer_id` BIGINT(20) NOT NULL,
  `address` VARCHAR(255) NULL DEFAULT NULL,
  `contact_phone_number` VARCHAR(255) NULL DEFAULT NULL,
  `first_name` VARCHAR(255) NULL DEFAULT NULL,
  `points` DOUBLE NOT NULL,
  `rate` VARCHAR(255) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`customer_id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ocr_db`.`hibernate_sequence`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ocr_db`.`hibernate_sequence` (
  `next_val` BIGINT(20) NULL DEFAULT NULL)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ocr_db`.`order_line`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ocr_db`.`order_line` (
  `order_line_id` BIGINT(20) NOT NULL,
  `quantity` INT(11) NOT NULL,
  `fk_orders` BIGINT(20) NULL DEFAULT NULL,
  `product_product_id` BIGINT(20) NULL DEFAULT NULL,
  `fk_product` BIGINT(20) NULL DEFAULT NULL,
  `product` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`order_line_id`),
  INDEX `FKs6h2fndxvlmgoumuow6bdsd2g` (`fk_product` ASC) VISIBLE,
  INDEX `FK863a744knr50mljrji0krsko` (`product` ASC) VISIBLE,
  INDEX `FKrqybhbrw3lrr861opjsl9kqgo` (`fk_orders` ASC) VISIBLE,
  INDEX `FKmk8y3rw2ybq7oty1qme297w9x` (`product_product_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ocr_db`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ocr_db`.`orders` (
  `order_id` BIGINT(20) NOT NULL,
  `date_of_order` DATE NULL DEFAULT NULL,
  `fk_customer` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`order_id`),
  INDEX `FKmjaa8xhbjo46x280fwo41tlpi` (`fk_customer` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ocr_db`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ocr_db`.`product` (
  `product_id` BIGINT(20) NOT NULL,
  `locaiton` INT(11) NULL DEFAULT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `price` DOUBLE NOT NULL,
  `product_description` VARCHAR(255) NULL DEFAULT NULL,
  `type` INT(11) NULL DEFAULT NULL,
  `location` INT(11) NULL DEFAULT NULL,
  `order_line_order_line_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  INDEX `FKix4151jdbnaderjv90kij6sa8` (`order_line_order_line_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ocr_db`.`role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ocr_db`.`role` (
  `role_id` INT(11) NOT NULL,
  `role` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`role_id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ocr_db`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ocr_db`.`user` (
  `user_id` INT(11) NOT NULL,
  `active` INT(11) NULL DEFAULT NULL,
  `email` VARCHAR(255) NULL DEFAULT NULL,
  `last_name` VARCHAR(255) NULL DEFAULT NULL,
  `password` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `ocr_db`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `ocr_db`.`user_role` (
  `user_id` INT(11) NOT NULL,
  `role_id` INT(11) NOT NULL,
  PRIMARY KEY (`user_id`, `role_id`),
  INDEX `FKa68196081fvovjhkek5m97n3y` (`role_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
