-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `factory` DEFAULT CHARACTER SET utf8 ;
USE `factory` ;

CREATE TABLE IF NOT EXISTS `factory`.`product` (
  `id_product` INT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(45) NULL,
  `production_time(hours)` INT NULL,
  PRIMARY KEY (`id_product`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`equpment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `factory`.`equpment` (
  `id_equpment` INT NOT NULL,
  `equpment_name` VARCHAR(45) NULL,
  `guaranty_period(months)` INT NULL,
  `period_of_exploitation(months)` INT NULL,
  `work_resource(hours)` INT NULL,
  `exploitation_resource(hours)` INT NULL,
  `equpment_price` INT NULL,
  PRIMARY KEY (`id_equpment`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`product_to_equpment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `factory`.`product_to_equpment` (
  `product_id_product` INT NOT NULL,
  `equpment_id_equpment` INT NOT NULL,
  `operation_execution_time(hours)` INT NOT NULL,
  PRIMARY KEY (`product_id_product`, `equpment_id_equpment`),
  INDEX `fk_product_to_equpment_product_idx` (`product_id_product` ASC) VISIBLE,
  INDEX `fk_product_to_equpment_equpment1_idx` (`equpment_id_equpment` ASC) VISIBLE,
  CONSTRAINT `fk_product_to_equpment_product`
    FOREIGN KEY (`product_id_product`)
    REFERENCES `factory`.`product` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_to_equpment_equpment1`
    FOREIGN KEY (`equpment_id_equpment`)
    REFERENCES `factory`.`equpment` (`id_equpment`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`orders`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `factory`.`orders` (
  `id_orders` INT NOT NULL,
  `order_date` DATE NULL,
  `manager` VARCHAR(45) NULL,
  `price_order` INT NULL,
  `price_delivery` INT NULL,
  PRIMARY KEY (`id_orders`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`materials`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `factory`.`materials` (
  `id_materials` INT NOT NULL AUTO_INCREMENT,
  `material_name` VARCHAR(45) NULL,
  `unit_price` INT NULL,
  PRIMARY KEY (`id_materials`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`product_has_materials`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `factory`.`product_has_materials` (
  `product_id_product` INT NOT NULL,
  `materials_id_materials` INT NOT NULL,
  `quantity_entity` INT NULL,
  PRIMARY KEY (`product_id_product`, `materials_id_materials`),
  INDEX `fk_product_has_materials_materials1_idx` (`materials_id_materials` ASC) VISIBLE,
  INDEX `fk_product_has_materials_product1_idx` (`product_id_product` ASC) VISIBLE,
  CONSTRAINT `fk_product_has_materials_product1`
    FOREIGN KEY (`product_id_product`)
    REFERENCES `factory`.`product` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_product_has_materials_materials1`
    FOREIGN KEY (`materials_id_materials`)
    REFERENCES `factory`.`materials` (`id_materials`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`orders_has_product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `factory`.`orders_has_product` (
  `orders_id_orders` INT NOT NULL,
  `product_id_product` INT NOT NULL,
  PRIMARY KEY (`orders_id_orders`, `product_id_product`),
  INDEX `fk_orders_has_product_product1_idx` (`product_id_product` ASC) VISIBLE,
  INDEX `fk_orders_has_product_orders1_idx` (`orders_id_orders` ASC) VISIBLE,
  CONSTRAINT `fk_orders_has_product_orders1`
    FOREIGN KEY (`orders_id_orders`)
    REFERENCES `factory`.`orders` (`id_orders`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orders_has_product_product1`
    FOREIGN KEY (`product_id_product`)
    REFERENCES `factory`.`product` (`id_product`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

