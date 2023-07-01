-- MySQL dump 10.13  Distrib 8.0.33, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: Polipalooza
-- ------------------------------------------------------
-- Server version	8.0.33-0ubuntu0.22.04.2

--
-- Table structure for table `Artistas`
--
create database Polipalooza;
use Polipalooza;

DROP TABLE IF EXISTS `Artistas`;
CREATE TABLE `Artistas` (
  `artista_id` int NOT NULL AUTO_INCREMENT,
  `persona_id` int DEFAULT NULL,
  `genero_musical` varchar(50) DEFAULT NULL,
  `es_destacado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`artista_id`),
  KEY `persona_id` (`persona_id`),
  CONSTRAINT `Artistas_ibfk_1` FOREIGN KEY (`persona_id`) REFERENCES `Personas` (`persona_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4;

--
-- Table structure for table `Asistentes`
--

DROP TABLE IF EXISTS `Asistentes`;
CREATE TABLE `Asistentes` (
  `asistente_id` int NOT NULL AUTO_INCREMENT,
  `persona_id` int DEFAULT NULL,
  `es_vip` tinyint(1) DEFAULT NULL,
  `requerimiento_especial` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`asistente_id`),
  KEY `persona_id` (`persona_id`),
  CONSTRAINT `Asistentes_ibfk_1` FOREIGN KEY (`persona_id`) REFERENCES `Personas` (`persona_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 ;

--
-- Table structure for table `Canciones`
--

DROP TABLE IF EXISTS `Canciones`;
CREATE TABLE `Canciones` (
  `cancion_id` int NOT NULL AUTO_INCREMENT,
  `artista_id` int DEFAULT NULL,
  `nombre_cancion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cancion_id`),
  KEY `artista_id` (`artista_id`),
  CONSTRAINT `Canciones_ibfk_1` FOREIGN KEY (`artista_id`) REFERENCES `Artistas` (`artista_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 ;

--
-- Table structure for table `Escenarios`
--

DROP TABLE IF EXISTS `Escenarios`;
CREATE TABLE `Escenarios` (
  `escenario_id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `capacidad_maxima` int DEFAULT NULL,
  PRIMARY KEY (`escenario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 ;

--
-- Table structure for table `PersonalProduccion`
--

DROP TABLE IF EXISTS `PersonalProduccion`;
CREATE TABLE `PersonalProduccion` (
  `personal_id` int NOT NULL AUTO_INCREMENT,
  `persona_id` int DEFAULT NULL,
  `roles_rol` int NOT NULL,
  PRIMARY KEY (`personal_id`),
  KEY `persona_id` (`persona_id`),
  KEY `fk_PersonalProduccion_roles1_idx` (`roles_rol`),
  CONSTRAINT `fk_PersonalProduccion_roles1` FOREIGN KEY (`roles_rol`) REFERENCES `roles` (`rol`),
  CONSTRAINT `PersonalProduccion_ibfk_1` FOREIGN KEY (`persona_id`) REFERENCES `Personas` (`persona_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 ;

--
-- Table structure for table `Personas`
--

DROP TABLE IF EXISTS `Personas`;
CREATE TABLE `Personas` (
  `persona_id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `celular` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`persona_id`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 ;

--
-- Table structure for table `Presentaciones`
--

DROP TABLE IF EXISTS `Presentaciones`;
CREATE TABLE `Presentaciones` (
  `escenario_id` int NOT NULL,
  `artista_id` int NOT NULL,
  `horario_inicio` datetime DEFAULT NULL,
  `horario_fin` datetime DEFAULT NULL,
  PRIMARY KEY (`escenario_id`,`artista_id`),
  KEY `escenario_id` (`escenario_id`),
  KEY `artista_id` (`artista_id`),
  CONSTRAINT `Presentaciones_ibfk_1` FOREIGN KEY (`escenario_id`) REFERENCES `Escenarios` (`escenario_id`),
  CONSTRAINT `Presentaciones_ibfk_2` FOREIGN KEY (`artista_id`) REFERENCES `Artistas` (`artista_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

--
-- Table structure for table `ProduccionEscenarios`
--

DROP TABLE IF EXISTS `ProduccionEscenarios`;
CREATE TABLE `ProduccionEscenarios` (
  `escenario_id` int NOT NULL,
  `personal_id` int NOT NULL,
  PRIMARY KEY (`escenario_id`,`personal_id`),
  KEY `personal_id` (`personal_id`),
  CONSTRAINT `ProduccionEscenarios_ibfk_1` FOREIGN KEY (`escenario_id`) REFERENCES `Escenarios` (`escenario_id`),
  CONSTRAINT `ProduccionEscenarios_ibfk_2` FOREIGN KEY (`personal_id`) REFERENCES `PersonalProduccion` (`personal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ;

--
-- Temporary view structure for view `numeroGeneros`
--

DROP TABLE IF EXISTS `numeroGeneros`;
/*!50001 DROP VIEW IF EXISTS `numeroGeneros`*/;
/*!50001 CREATE VIEW `numeroGeneros` AS SELECT 
 1 AS `nombre`,
 1 AS `cantidad`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `roles`
--

DROP TABLE IF EXISTS `roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `roles` (
  `rol` int NOT NULL AUTO_INCREMENT,
  `nombreRol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`rol`)
) ENGINE=InnoDB AUTO_INCREMENT=0 DEFAULT CHARSET=utf8mb4 ;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'Polipalooza'

DELIMITER ;;
CREATE FUNCTION `generoMayor`() RETURNS varchar(45) CHARSET utf8mb4
    DETERMINISTIC
BEGIN

declare nom varchar(45) default "";

select nombre into nom 
from (select genero_musical as nombre, count(*) as cantidad from Artistas 
group by nombre having cantidad = (select max(cantidad) from numeroGeneros)) as artistas limit 1;

RETURN nom;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE FUNCTION `personalMinimo`(esc int) RETURNS tinyint(1)
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
END ;;
DELIMITER ;

DELIMITER ;;
CREATE PROCEDURE `AsignarPersonaEscenario`(IN escenarioID INT)
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
    
END ;;
DELIMITER ;

DELIMITER ;;
CREATE PROCEDURE `cargarPresentaciones`(in id int)
BEGIN
select  Personas.nombre, genero_musical, es_destacado, Presentaciones.escenario_id, horario_fin, horario_inicio
from Escenarios
join Presentaciones on Escenarios.escenario_id = Presentaciones.escenario_id
join Artistas on Presentaciones.artista_id = Artistas.artista_id 
join Personas on Personas.persona_id = Artistas.persona_id
where Escenarios.escenario_id = id
group by Presentaciones.escenario_id, genero_musical, es_destacado, Personas.nombre, horario_fin, horario_inicio;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE PROCEDURE `escenarioArtistas`()
BEGIN
select  Personas.nombre, Presentaciones.escenario_id
from Presentaciones
join Artistas on Presentaciones.artista_id = Artistas.artista_id 
join Personas on Personas.persona_id = Artistas.persona_id 
group by Presentaciones.escenario_id, Personas.nombre;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE PROCEDURE `escenarioPersonal`(in id int)
BEGIN
select PersonalProduccion.personal_id, nombreRol
from Escenarios
join ProduccionEscenarios on ProduccionEscenarios.escenario_id = Escenarios.escenario_id
join PersonalProduccion on PersonalProduccion.personal_id = ProduccionEscenarios.personal_id
join roles on rol = roles_rol
where Escenarios.escenario_id = id;
END ;;
DELIMITER ;

DELIMITER ;;
CREATE PROCEDURE `personalHorarios`(personal int)
BEGIN
select horario_inicio, horario_fin, PersonalProduccion.personal_id from PersonalProduccion
Join ProduccionEscenarios on PersonalProduccion.personal_id = ProduccionEscenarios.personal_id
join Escenarios on ProduccionEscenarios.escenario_id = Escenarios.escenario_id
join Presentaciones on Presentaciones.escenario_id = Escenarios.escenario_id
where PersonalProduccion.personal_id = personal;
END ;;
DELIMITER ;


DELIMITER ;;
CREATE PROCEDURE `rolPersonas`()
BEGIN
select roles.nombreRol, count(PersonalProduccion.personal_id)  
from roles
join PersonalProduccion on roles.rol = PersonalProduccion.roles_rol
join Personas on PersonalProduccion.persona_id = Personas.persona_id
group by roles.nombreRol;
END ;;
DELIMITER ;



