-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Polygon
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Polygon
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Polygon` DEFAULT CHARACTER SET utf8 ;
USE `Polygon` ;

-- -----------------------------------------------------
-- Table `Polygon`.`Zipcode`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polygon`.`Zipcode` (
  `zipId` INT NOT NULL AUTO_INCREMENT,
  `zip` INT NULL,
  `city` VARCHAR(45) NULL,
  PRIMARY KEY (`zipId`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Polygon`.`userAddress`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polygon`.`userAddress` (
  `addressId` INT NOT NULL AUTO_INCREMENT,
  `addressLine` VARCHAR(200) NOT NULL,
  `Zipcode_zipId` INT NOT NULL,
  PRIMARY KEY (`addressId`),
  INDEX `fk_userAddress_Zipcode1_idx` (`Zipcode_zipId` ASC),
  CONSTRAINT `fk_userAddress_Zipcode1`
    FOREIGN KEY (`Zipcode_zipId`)
    REFERENCES `Polygon`.`Zipcode` (`zipId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Polygon`.`User`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polygon`.`User` (
  `userId` INT NOT NULL AUTO_INCREMENT,
  `firstname` VARCHAR(45) NOT NULL,
  `lastname` VARCHAR(45) NOT NULL,
  `phone` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `userAddress_addressId` INT NOT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE INDEX `idUser_UNIQUE` (`userId` ASC),
  INDEX `fk_User_userAddress1_idx` (`userAddress_addressId` ASC),
  CONSTRAINT `fk_User_userAddress1`
    FOREIGN KEY (`userAddress_addressId`)
    REFERENCES `Polygon`.`userAddress` (`addressId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Polygon`.`Address`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polygon`.`Address` (
  `addressId` INT NOT NULL AUTO_INCREMENT,
  `addressline` VARCHAR(200) NOT NULL,
  `zipcode_addressId` INT NOT NULL,
  PRIMARY KEY (`addressId`),
  INDEX `fk_Address_zipcode_idx` (`zipcode_addressId` ASC),
  CONSTRAINT `fk_Address_zipcode`
    FOREIGN KEY (`zipcode_addressId`)
    REFERENCES `Polygon`.`Zipcode` (`zipId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Polygon`.`Building`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polygon`.`Building` (
  `buildingId` INT NOT NULL AUTO_INCREMENT,
  `hidden` INT NULL DEFAULT 0,
  `Address_addressId` INT NOT NULL,
  `rapportURL` VARCHAR(250) NOT NULL,
  `User_userId` INT NOT NULL,
  `buildingName` VARCHAR(150) NULL,
  PRIMARY KEY (`buildingId`),
  UNIQUE INDEX `buildingId_UNIQUE` (`buildingId` ASC),
  INDEX `fk_Building_Address1_idx` (`Address_addressId` ASC),
  INDEX `fk_Building_User1_idx` (`User_userId` ASC),
  CONSTRAINT `fk_Building_Address1`
    FOREIGN KEY (`Address_addressId`)
    REFERENCES `Polygon`.`Address` (`addressId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Building_User1`
    FOREIGN KEY (`User_userId`)
    REFERENCES `Polygon`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Polygon`.`Picture`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polygon`.`Picture` (
  `pictureId` INT NOT NULL AUTO_INCREMENT,
  `pictureURL` VARCHAR(250) NULL,
  `Building_buildingId` INT NOT NULL,
  PRIMARY KEY (`pictureId`),
  INDEX `fk_picture_Building1_idx` (`Building_buildingId` ASC),
  CONSTRAINT `fk_picture_Building1`
    FOREIGN KEY (`Building_buildingId`)
    REFERENCES `Polygon`.`Building` (`buildingId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Polygon`.`Document`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polygon`.`Document` (
  `documentId` INT NOT NULL AUTO_INCREMENT,
  `file` MEDIUMBLOB NOT NULL,
  `note` VARCHAR(250) NULL,
  `Building_buildingId` INT NOT NULL,
  PRIMARY KEY (`documentId`),
  INDEX `fk_Docs_Building1_idx` (`Building_buildingId` ASC),
  CONSTRAINT `fk_Docs_Building1`
    FOREIGN KEY (`Building_buildingId`)
    REFERENCES `Polygon`.`Building` (`buildingId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Polygon`.`Damage`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polygon`.`Damage` (
  `damageId` INT NOT NULL AUTO_INCREMENT,
  `room` VARCHAR(150) NULL,
  `comments` INT NULL,
  `roomDamaged` INT NULL,
  `when` VARCHAR(150) NULL,
  `where` VARCHAR(150) NULL,
  `whatHappend` VARCHAR(150) NULL,
  `whatRepaired` VARCHAR(150) NULL,
  `damageNr` INT NULL,
  `other` VARCHAR(150) NULL,
  `Building_buildingId` INT NOT NULL,
  `categorized` INT NULL,
  PRIMARY KEY (`damageId`),
  UNIQUE INDEX `damageId_UNIQUE` (`damageId` ASC),
  INDEX `fk_Damage_Building1_idx` (`Building_buildingId` ASC),
  CONSTRAINT `fk_Damage_Building1`
    FOREIGN KEY (`Building_buildingId`)
    REFERENCES `Polygon`.`Building` (`buildingId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Polygon`.`Request`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polygon`.`Request` (
  `requestId` INT NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(100) NULL,
  PRIMARY KEY (`requestId`),
  UNIQUE INDEX `requestId_UNIQUE` (`requestId` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Polygon`.`Request_has_Building`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polygon`.`Request_has_Building` (
  `Request_requestId` INT NOT NULL,
  `Building_buildingId` INT NOT NULL,
  PRIMARY KEY (`Request_requestId`, `Building_buildingId`),
  INDEX `fk_Request_has_Building_Building1_idx` (`Building_buildingId` ASC),
  INDEX `fk_Request_has_Building_Request1_idx` (`Request_requestId` ASC),
  CONSTRAINT `fk_Request_has_Building_Request1`
    FOREIGN KEY (`Request_requestId`)
    REFERENCES `Polygon`.`Request` (`requestId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Request_has_Building_Building1`
    FOREIGN KEY (`Building_buildingId`)
    REFERENCES `Polygon`.`Building` (`buildingId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Polygon`.`Newsletter`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polygon`.`Newsletter` (
  `newsletterId` INT NOT NULL AUTO_INCREMENT,
  `User_userId` INT NOT NULL,
  PRIMARY KEY (`newsletterId`),
  UNIQUE INDEX `newsletterId_UNIQUE` (`newsletterId` ASC),
  INDEX `fk_Newsletter_User1_idx` (`User_userId` ASC),
  CONSTRAINT `fk_Newsletter_User1`
    FOREIGN KEY (`User_userId`)
    REFERENCES `Polygon`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Polygon`.`Login`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polygon`.`Login` (
  `loginId` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(30) NOT NULL,
  `password` VARCHAR(30) NOT NULL,
  `rank` INT NULL,
  `User_userId` INT NOT NULL,
  PRIMARY KEY (`loginId`),
  UNIQUE INDEX `loginId_UNIQUE` (`loginId` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `password_UNIQUE` (`password` ASC),
  INDEX `fk_Login_User1_idx` (`User_userId` ASC),
  CONSTRAINT `fk_Login_User1`
    FOREIGN KEY (`User_userId`)
    REFERENCES `Polygon`.`User` (`userId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Polygon`.`BuildingInfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polygon`.`BuildingInfo` (
  `buildingInfoId` INT NOT NULL AUTO_INCREMENT,
  `buildYear` VARCHAR(100) NULL,
  `area` VARCHAR(100) NULL,
  `use` VARCHAR(150) NULL,
  `Building_buildingId` INT NOT NULL,
  PRIMARY KEY (`buildingInfoId`),
  INDEX `fk_BuildingInfo_Building1_idx` (`Building_buildingId` ASC),
  CONSTRAINT `fk_BuildingInfo_Building1`
    FOREIGN KEY (`Building_buildingId`)
    REFERENCES `Polygon`.`Building` (`buildingId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Polygon`.`BuildingExamination`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polygon`.`BuildingExamination` (
  `buildingExaminationId` INT NOT NULL AUTO_INCREMENT,
  `reviewing` VARCHAR(100) NULL,
  `description` VARCHAR(1000) NULL,
  `comments` INT NULL,
  `picture` INT NULL,
  `Building_buildingId` INT NOT NULL,
  PRIMARY KEY (`buildingExaminationId`),
  INDEX `fk_BuildingExamination_Building1_idx` (`Building_buildingId` ASC),
  CONSTRAINT `fk_BuildingExamination_Building1`
    FOREIGN KEY (`Building_buildingId`)
    REFERENCES `Polygon`.`Building` (`buildingId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Polygon`.`Humidity`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polygon`.`Humidity` (
  `humidityId` INT NOT NULL AUTO_INCREMENT,
  `scanning` INT NULL,
  `humidityScan` VARCHAR(150) NULL,
  `point` VARCHAR(150) NULL,
  `description` VARCHAR(450) NULL,
  `Building_buildingId` INT NOT NULL,
  PRIMARY KEY (`humidityId`),
  INDEX `fk_Humidity_Building1_idx` (`Building_buildingId` ASC),
  CONSTRAINT `fk_Humidity_Building1`
    FOREIGN KEY (`Building_buildingId`)
    REFERENCES `Polygon`.`Building` (`buildingId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Polygon`.`Conclusion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polygon`.`Conclusion` (
  `conclusionId` INT NOT NULL AUTO_INCREMENT,
  `room` VARCHAR(150) NULL,
  `recommendations` VARCHAR(350) NULL,
  `Building_buildingId` INT NOT NULL,
  PRIMARY KEY (`conclusionId`),
  INDEX `fk_Conclusion_Building1_idx` (`Building_buildingId` ASC),
  CONSTRAINT `fk_Conclusion_Building1`
    FOREIGN KEY (`Building_buildingId`)
    REFERENCES `Polygon`.`Building` (`buildingId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Polygon`.`RapportInfo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polygon`.`RapportInfo` (
  `rapportInfoId` INT NOT NULL AUTO_INCREMENT,
  `date` DATE NULL,
  `author` VARCHAR(150) NULL,
  `cooperation` VARCHAR(150) NULL,
  `rapportNr` VARCHAR(45) NULL,
  `Building_buildingId` INT NOT NULL,
  PRIMARY KEY (`rapportInfoId`),
  INDEX `fk_RapportInfo_Building1_idx` (`Building_buildingId` ASC),
  CONSTRAINT `fk_RapportInfo_Building1`
    FOREIGN KEY (`Building_buildingId`)
    REFERENCES `Polygon`.`Building` (`buildingId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
