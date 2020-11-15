-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema dogsdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `dogsdb` ;

-- -----------------------------------------------------
-- Schema dogsdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dogsdb` DEFAULT CHARACTER SET utf8 ;
USE `dogsdb` ;

-- -----------------------------------------------------
-- Table `dog`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `dog` ;

CREATE TABLE IF NOT EXISTS `dog` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `breed` VARCHAR(45) NULL,
  `size` CHAR(2) NULL,
  `aggressive` CHAR(1) NULL,
  `description` VARCHAR(500) NULL,
  `image_url` TEXT NULL,
  `date_created` DATETIME NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS dog@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'dog'@'localhost' IDENTIFIED BY 'dog';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'dog'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `dog`
-- -----------------------------------------------------
START TRANSACTION;
USE `dogsdb`;
INSERT INTO `dog` (`id`, `name`, `breed`, `size`, `aggressive`, `description`, `image_url`, `date_created`) VALUES (1, 'Coda', 'Maltese Poodle', 'S', 'N', 'Small cute dog that does all of the cute dog poses ', 'https://animalcorner.org/wp-content/uploads/2020/04/Maltese-Poodle-1-e1588071595891.jpg', NULL);
INSERT INTO `dog` (`id`, `name`, `breed`, `size`, `aggressive`, `description`, `image_url`, `date_created`) VALUES (2, 'Rocko', 'America Pitbull Terrior', 'XL', 'N', '120 lb dog that is sweet and loving', 'https://www.k9rl.com/wp-content/uploads/2015/12/Pitbull.jpg', NULL);
INSERT INTO `dog` (`id`, `name`, `breed`, `size`, `aggressive`, `description`, `image_url`, `date_created`) VALUES (3, 'Ace', 'Chihuahua', 'S', 'Y', ' 5 lb dog that protects what it loves and destroys what it hates', 'https://vetstreet.brightspotcdn.com/dims4/default/8045317/2147483647/thumbnail/645x380/quality/90/?url=https%3A%2F%2Fvetstreet-brightspot.s3.amazonaws.com%2F92%2F0a%2Fc32d93d94a5a912b53f94255a8e2%2Fchihuahua-ap-0kp0pg-645-x-380.jpg', NULL);
INSERT INTO `dog` (`id`, `name`, `breed`, `size`, `aggressive`, `description`, `image_url`, `date_created`) VALUES (4, 'Cita', 'Boxer', 'M', 'N', 'Protective and smart, great family dog that loves kids', 'https://www.zooplus.co.uk/magazine/wp-content/uploads/2018/07/deutscher-boxer-tabby-2.jpg', NULL);
INSERT INTO `dog` (`id`, `name`, `breed`, `size`, `aggressive`, `description`, `image_url`, `date_created`) VALUES (5, 'Keno', 'Rottweiler', 'XL', 'Y', 'if this dog doesnt like you it will not even listen to its owner. ', 'https://pawleaks.com/wp-content/uploads/2020/09/adult-rottweiler.png', NULL);
INSERT INTO `dog` (`id`, `name`, `breed`, `size`, `aggressive`, `description`, `image_url`, `date_created`) VALUES (6, 'Queenie', 'bulldog', 'M', 'N', 'big fat lazy boy ', 'https://anybulldog.com/wp-content/uploads/2019/01/Webp.net-resizeimage-1-4.jpg', NULL);
INSERT INTO `dog` (`id`, `name`, `breed`, `size`, `aggressive`, `description`, `image_url`, `date_created`) VALUES (7, 'goldie', 'Golden retriever ', 'L', 'N', 'there are sweet dogs then there is goldie', 'https://goldenretrieversociety.com/wp-content/uploads/2020/03/Training-a-Golden-Retriever.png', NULL);
INSERT INTO `dog` (`id`, `name`, `breed`, `size`, `aggressive`, `description`, `image_url`, `date_created`) VALUES (8, 'bones', 'German Sheppard', 'L', 'Y', 'old drug sniffing dog. do not pet', 'https://www.allthingsdogs.com/wp-content/uploads/2019/09/Long-Haired-German-Shepherd-What-To-Know-Before-Buying-Cover.jpg', NULL);

COMMIT;

