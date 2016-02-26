CREATE SCHEMA IF NOT EXISTS `andboarddb` DEFAULT CHARACTER SET utf8 ;
USE `andboarddb` ;

-- -----------------------------------------------------
-- Table `andboarddb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `andboarddb`.`user` (
  `user_id` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `address` VARCHAR(45) NULL DEFAULT NULL,
  `join_date` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `andboarddb`.`post`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `andboarddb`.`post` (
  `post_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(140) NULL DEFAULT NULL,
  `content` TEXT NULL DEFAULT NULL,
  `created` DATETIME NULL DEFAULT NULL,
  `user_id` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`post_id`),
  INDEX `user_id_idx` (`user_id` ASC),
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `andboarddb`.`user` (`user_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `andboarddb`.`comment`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `andboarddb`.`comment` (
  `comment_id` INT NOT NULL AUTO_INCREMENT,
  `content` TEXT NULL DEFAULT NULL,
  `created` DATETIME NULL DEFAULT NULL,
  `user_name` VARCHAR(45) NOT NULL,
  `post_number` INT NOT NULL,
  PRIMARY KEY (`comment_id`),
  CONSTRAINT `user_name`
    FOREIGN KEY (`user_name`)
    REFERENCES `andboarddb`.`user` (`user_id`)
    ON DELETE CASCADE,
  CONSTRAINT `post_number`
    FOREIGN KEY (`post_number`)
    REFERENCES `andboarddb`.`post` (`post_id`)
    ON DELETE CASCADE)
ENGINE = InnoDB;