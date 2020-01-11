-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema movie_cruiser
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema movie_cruiser
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `movie_cruiser` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `movie_cruiser` ;

-- -----------------------------------------------------
-- Table `movie_cruiser`.`movies`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_cruiser`.`movies` (
  `mov_id` INT(11) NOT NULL AUTO_INCREMENT,
  `mov_title` VARCHAR(100) NULL DEFAULT NULL,
  `mov_box_office` BIGINT(20) NULL DEFAULT NULL,
  `mov_active` VARCHAR(3) NULL DEFAULT NULL,
  `mov_date_of_launch` DATE NULL DEFAULT NULL,
  `mov_genre` VARCHAR(45) NULL DEFAULT NULL,
  `mov_has_teaser` VARCHAR(3) NULL DEFAULT NULL,
  PRIMARY KEY (`mov_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `movie_cruiser`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_cruiser`.`user` (
  `us_id` INT(11) NOT NULL AUTO_INCREMENT,
  `us_name` VARCHAR(60) NULL DEFAULT NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `movie_cruiser`.`favorites`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `movie_cruiser`.`favorites` (
  `fav_id` INT(11) NOT NULL AUTO_INCREMENT,
  `fav_us_id` INT(11) NULL DEFAULT NULL,
  `fav_mov_id` INT(11) NULL DEFAULT NULL,
  PRIMARY KEY (`fav_id`),
  INDEX `fav_us_id_idx` (`fav_us_id` ASC),
  INDEX `fav_mov_id_idx` (`fav_mov_id` ASC),
  CONSTRAINT `fav_mov_id`
    FOREIGN KEY (`fav_mov_id`)
    REFERENCES `movie_cruiser`.`movies` (`mov_id`),
  CONSTRAINT `fav_us_id`
    FOREIGN KEY (`fav_us_id`)
    REFERENCES `movie_cruiser`.`user` (`us_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
