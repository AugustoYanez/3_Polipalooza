-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema Polipalooza
-- -----------------------------------------------------
create database Polipalooza;
use Polipalooza;
-- -----------------------------------------------------
-- Schema Polipalooza
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Polipalooza` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `Polipalooza` ;

-- -----------------------------------------------------
-- Table `Polipalooza`.`Personas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polipalooza`.`Personas` (
  `persona_id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `apellido` VARCHAR(50) NULL DEFAULT NULL,
  `fecha_nacimiento` DATE NULL DEFAULT NULL,
  `celular` VARCHAR(20) NULL DEFAULT NULL,
  PRIMARY KEY (`persona_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Polipalooza`.`Artistas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polipalooza`.`Artistas` (
  `artista_id` INT NOT NULL AUTO_INCREMENT,
  `persona_id` INT NULL DEFAULT NULL,
  `genero_musical` VARCHAR(50) NULL DEFAULT NULL,
  `es_destacado` TINYINT(1) NULL DEFAULT NULL,
  PRIMARY KEY (`artista_id`),
  INDEX `persona_id` (`persona_id` ASC) VISIBLE,
  CONSTRAINT `Artistas_ibfk_1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `Polipalooza`.`Personas` (`persona_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Polipalooza`.`Asistentes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polipalooza`.`Asistentes` (
  `asistente_id` INT NOT NULL AUTO_INCREMENT,
  `persona_id` INT NULL DEFAULT NULL,
  `es_vip` TINYINT(1) NULL DEFAULT NULL,
  `requerimiento_especial` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`asistente_id`),
  INDEX `persona_id` (`persona_id` ASC) VISIBLE,
  CONSTRAINT `Asistentes_ibfk_1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `Polipalooza`.`Personas` (`persona_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Polipalooza`.`Canciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polipalooza`.`Canciones` (
  `cancion_id` INT NOT NULL AUTO_INCREMENT,
  `artista_id` INT NULL DEFAULT NULL,
  `nombre_cancion` VARCHAR(100) NULL DEFAULT NULL,
  PRIMARY KEY (`cancion_id`),
  INDEX `artista_id` (`artista_id` ASC) VISIBLE,
  CONSTRAINT `Canciones_ibfk_1`
    FOREIGN KEY (`artista_id`)
    REFERENCES `Polipalooza`.`Artistas` (`artista_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Polipalooza`.`Escenarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polipalooza`.`Escenarios` (
  `escenario_id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(50) NULL DEFAULT NULL,
  `capacidad_maxima` INT NULL DEFAULT NULL,
  PRIMARY KEY (`escenario_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Polipalooza`.`roles`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polipalooza`.`roles` (
  `rol` INT NOT NULL AUTO_INCREMENT,
  `nombreRol` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`rol`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Polipalooza`.`PersonalProduccion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polipalooza`.`PersonalProduccion` (
  `personal_id` INT NOT NULL AUTO_INCREMENT,
  `persona_id` INT NULL DEFAULT NULL,
  `roles_rol` INT NOT NULL,
  PRIMARY KEY (`personal_id`),
  INDEX `persona_id` (`persona_id` ASC) VISIBLE,
  INDEX `fk_PersonalProduccion_roles1_idx` (`roles_rol` ASC) VISIBLE,
  CONSTRAINT `fk_PersonalProduccion_roles1`
    FOREIGN KEY (`roles_rol`)
    REFERENCES `Polipalooza`.`roles` (`rol`),
  CONSTRAINT `PersonalProduccion_ibfk_1`
    FOREIGN KEY (`persona_id`)
    REFERENCES `Polipalooza`.`Personas` (`persona_id`))
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Polipalooza`.`Presentaciones`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polipalooza`.`Presentaciones` (
  `escenario_id` INT NOT NULL,
  `artista_id` INT NOT NULL,
  `horario_inicio` DATETIME NULL DEFAULT NULL,
  `horario_fin` DATETIME NULL DEFAULT NULL,
  PRIMARY KEY (`escenario_id`, `artista_id`),
  INDEX `escenario_id` (`escenario_id` ASC) VISIBLE,
  INDEX `artista_id` (`artista_id` ASC) VISIBLE,
  CONSTRAINT `Presentaciones_ibfk_1`
    FOREIGN KEY (`escenario_id`)
    REFERENCES `Polipalooza`.`Escenarios` (`escenario_id`),
  CONSTRAINT `Presentaciones_ibfk_2`
    FOREIGN KEY (`artista_id`)
    REFERENCES `Polipalooza`.`Artistas` (`artista_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `Polipalooza`.`ProduccionEscenarios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polipalooza`.`ProduccionEscenarios` (
  `escenario_id` INT NOT NULL,
  `personal_id` INT NOT NULL,
  PRIMARY KEY (`escenario_id`, `personal_id`),
  INDEX `personal_id` (`personal_id` ASC) VISIBLE,
  CONSTRAINT `ProduccionEscenarios_ibfk_1`
    FOREIGN KEY (`escenario_id`)
    REFERENCES `Polipalooza`.`Escenarios` (`escenario_id`),
  CONSTRAINT `ProduccionEscenarios_ibfk_2`
    FOREIGN KEY (`personal_id`)
    REFERENCES `Polipalooza`.`PersonalProduccion` (`personal_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

USE `Polipalooza` ;

-- -----------------------------------------------------
-- Placeholder table for view `Polipalooza`.`numeroGeneros`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Polipalooza`.`numeroGeneros` (`nombre` INT, `cantidad` INT);

-- -----------------------------------------------------
-- procedure AsignarPersonaEscenario
-- -----------------------------------------------------

DELIMITER $$
USE `Polipalooza`$$
CREATE DEFINER=`alumno`@`localhost` PROCEDURE `AsignarPersonaEscenario`(IN escenarioID INT)
BEGIN

DECLARE personaID INT;
    
    IF (select personalMinimo(escenarioID)) = 0 THEN
        -- Obtener una persona disponible del personal de producción
        SELECT personal_id INTO personaID
        FROM PersonalProduccion
        WHERE personal_id NOT IN (SELECT personal_id FROM ProduccionEscenarios) and 
        roles_rol not in 
        (select distinct(roles_rol) 
		from Escenarios
		join ProduccionEscenarios 
        on Escenarios.escenario_id = ProduccionEscenarios.escenario_id
		join PersonalProduccion 
        on PersonalProduccion.personal_id = ProduccionEscenarios.personal_id 
		where Escenarios.escenario_id = escenarioID) limit 1;
        
        -- Asignar la persona al escenario
        INSERT INTO ProduccionEscenarios (escenario_id, personal_id)
        VALUES (escenarioID, personaID);
        
        SELECT CONCAT('Se asignó la persona con ID ', personaID, ' al escenario con ID ', escenarioID) AS 'Mensaje';
    end if;
    IF personaID = null THEN
        SELECT 'no hay personal suficiente' AS 'Mensaje';
	ELSE
        SELECT 'El escenario ya cumple con el personal mínimo requerido' AS 'Mensaje';
    END IF;
    
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure escenarioArtistas
-- -----------------------------------------------------

DELIMITER $$
USE `Polipalooza`$$
CREATE DEFINER=`alumno`@`localhost` PROCEDURE `escenarioArtistas`()
BEGIN
select  Artistas.artista_id, Presentaciones.escenario_id
from Presentaciones
join Artistas on Presentaciones.artista_id = Artistas.artista_id 
join Personas on Personas.persona_id = Artistas.persona_id 
group by Presentaciones.escenario_id, Artistas.artista_id;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- function generoMayor
-- -----------------------------------------------------

DELIMITER $$
USE `Polipalooza`$$
CREATE DEFINER=`alumno`@`localhost` FUNCTION `generoMayor`() RETURNS varchar(45) CHARSET utf8mb4
    DETERMINISTIC
BEGIN

declare nom varchar(45) default "";

select nombre into nom 
from (select genero_musical as nombre, count(*) as cantidad from Artistas 
group by nombre having cantidad = (select max(cantidad) from numeroGeneros)) as artistas limit 1;

RETURN nom;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure new_procedure
-- -----------------------------------------------------

DELIMITER $$
USE `Polipalooza`$$
CREATE DEFINER=`alumno`@`localhost` PROCEDURE `new_procedure`()
BEGIN
DECLARE cantPersonal INT;
    DECLARE personaID INT;
    
    -- Verificar si el escenario cumple con el personal mínimo
    SELECT COUNT(DISTINCT roles_rol) INTO cantPersonal
    FROM Escenarios
    JOIN ProduccionEscenarios ON Escenarios.escenario_id = ProduccionEscenarios.escenario_id
    JOIN PersonalProduccion ON PersonalProduccion.personal_id = ProduccionEscenarios.personal_id 
    WHERE Escenarios.escenario_id = escenarioID;
    
    IF cantPersonal < 3 THEN
        -- Obtener una persona disponible del personal de producción
        SELECT personal_id INTO personaID
        FROM PersonalProduccion
        WHERE personal_id NOT IN (SELECT personal_id FROM ProduccionEscenarios);
        
        -- Asignar la persona al escenario
        INSERT INTO ProduccionEscenarios (escenario_id, personal_id)
        VALUES (escenarioID, personaID);
        
        SELECT CONCAT('Se asignó la persona con ID ', personaID, ' al escenario con ID ', escenarioID) AS 'Mensaje';
    ELSE
        SELECT 'El escenario ya cumple con el personal mínimo requerido' AS 'Mensaje';
    END IF;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- function personalMinimo
-- -----------------------------------------------------

DELIMITER $$
USE `Polipalooza`$$
CREATE DEFINER=`alumno`@`localhost` FUNCTION `personalMinimo`(esc int) RETURNS tinyint(1)
    DETERMINISTIC
BEGIN
declare cantPersonal int default 0;
declare condicion boolean default false;

select count(distinct(roles_rol)) into cantPersonal from Escenarios
join ProduccionEscenarios on Escenarios.escenario_id = ProduccionEscenarios.escenario_id
join PersonalProduccion on PersonalProduccion.personal_id = ProduccionEscenarios.personal_id 
where Escenarios.escenario_id = esc;

if cantPersonal >= 3 then
	set condicion = true;
end if;

RETURN condicion;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- procedure rolPersonas
-- -----------------------------------------------------

DELIMITER $$
USE `Polipalooza`$$
CREATE DEFINER=`alumno`@`localhost` PROCEDURE `rolPersonas`()
BEGIN
select roles.nombreRol, PersonalProduccion.personal_id  
from roles
join PersonalProduccion on roles.rol = PersonalProduccion.roles_rol
join Personas on PersonalProduccion.persona_id = Personas.persona_id
group by roles.nombreRol, PersonalProduccion.personal_id ;
END$$

DELIMITER ;

-- -----------------------------------------------------
-- View `Polipalooza`.`numeroGeneros`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Polipalooza`.`numeroGeneros`;
USE `Polipalooza`;
CREATE  OR REPLACE ALGORITHM=UNDEFINED DEFINER=`alumno`@`localhost` SQL SECURITY DEFINER VIEW `Polipalooza`.`numeroGeneros` AS select `Polipalooza`.`Artistas`.`genero_musical` AS `nombre`,count(0) AS `cantidad` from `Polipalooza`.`Artistas` group by `nombre`;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
