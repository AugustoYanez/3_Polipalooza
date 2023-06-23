-- MySQL dump 10.13  Distrib 8.0.33, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: Polipalooza
-- ------------------------------------------------------
-- Server version	8.0.33-0ubuntu0.22.04.2

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Artistas`
--

DROP TABLE IF EXISTS `Artistas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Artistas` (
  `artista_id` int NOT NULL AUTO_INCREMENT,
  `persona_id` int DEFAULT NULL,
  `genero_musical` varchar(50) DEFAULT NULL,
  `es_destacado` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`artista_id`),
  KEY `persona_id` (`persona_id`),
  CONSTRAINT `Artistas_ibfk_1` FOREIGN KEY (`persona_id`) REFERENCES `Personas` (`persona_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Artistas`
--

LOCK TABLES `Artistas` WRITE;
/*!40000 ALTER TABLE `Artistas` DISABLE KEYS */;
/*!40000 ALTER TABLE `Artistas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Asistentes`
--

DROP TABLE IF EXISTS `Asistentes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Asistentes` (
  `asistente_id` int NOT NULL AUTO_INCREMENT,
  `persona_id` int DEFAULT NULL,
  `es_vip` tinyint(1) DEFAULT NULL,
  `requerimiento_especial` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`asistente_id`),
  KEY `persona_id` (`persona_id`),
  CONSTRAINT `Asistentes_ibfk_1` FOREIGN KEY (`persona_id`) REFERENCES `Personas` (`persona_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Asistentes`
--

LOCK TABLES `Asistentes` WRITE;
/*!40000 ALTER TABLE `Asistentes` DISABLE KEYS */;
/*!40000 ALTER TABLE `Asistentes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Canciones`
--

DROP TABLE IF EXISTS `Canciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Canciones` (
  `cancion_id` int NOT NULL,
  `artista_id` int DEFAULT NULL,
  `nombre_cancion` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`cancion_id`),
  KEY `artista_id` (`artista_id`),
  CONSTRAINT `Canciones_ibfk_1` FOREIGN KEY (`artista_id`) REFERENCES `Artistas` (`artista_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Canciones`
--

LOCK TABLES `Canciones` WRITE;
/*!40000 ALTER TABLE `Canciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `Canciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Escenarios`
--

DROP TABLE IF EXISTS `Escenarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Escenarios` (
  `escenario_id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `capacidad_maxima` int DEFAULT NULL,
  PRIMARY KEY (`escenario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Escenarios`
--

LOCK TABLES `Escenarios` WRITE;
/*!40000 ALTER TABLE `Escenarios` DISABLE KEYS */;
INSERT INTO `Escenarios` VALUES (1,NULL,NULL);
/*!40000 ALTER TABLE `Escenarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PersonalProduccion`
--

DROP TABLE IF EXISTS `PersonalProduccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PersonalProduccion` (
  `personal_id` int NOT NULL AUTO_INCREMENT,
  `persona_id` int DEFAULT NULL,
  `roles_rol` int NOT NULL,
  PRIMARY KEY (`personal_id`),
  KEY `persona_id` (`persona_id`),
  KEY `fk_PersonalProduccion_roles1_idx` (`roles_rol`),
  CONSTRAINT `fk_PersonalProduccion_roles1` FOREIGN KEY (`roles_rol`) REFERENCES `roles` (`rol`),
  CONSTRAINT `PersonalProduccion_ibfk_1` FOREIGN KEY (`persona_id`) REFERENCES `Personas` (`persona_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PersonalProduccion`
--

LOCK TABLES `PersonalProduccion` WRITE;
/*!40000 ALTER TABLE `PersonalProduccion` DISABLE KEYS */;
/*!40000 ALTER TABLE `PersonalProduccion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Personas`
--

DROP TABLE IF EXISTS `Personas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Personas` (
  `persona_id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `apellido` varchar(50) DEFAULT NULL,
  `fecha_nacimiento` date DEFAULT NULL,
  `celular` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`persona_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Personas`
--

LOCK TABLES `Personas` WRITE;
/*!40000 ALTER TABLE `Personas` DISABLE KEYS */;
/*!40000 ALTER TABLE `Personas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Presentaciones`
--

DROP TABLE IF EXISTS `Presentaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Presentaciones` (
  `presentacion_id` int NOT NULL,
  `escenario_id` int DEFAULT NULL,
  `artista_id` int DEFAULT NULL,
  `horario_inicio` datetime DEFAULT NULL,
  `horario_fin` datetime DEFAULT NULL,
  PRIMARY KEY (`presentacion_id`),
  KEY `escenario_id` (`escenario_id`),
  KEY `artista_id` (`artista_id`),
  CONSTRAINT `Presentaciones_ibfk_1` FOREIGN KEY (`escenario_id`) REFERENCES `Escenarios` (`escenario_id`),
  CONSTRAINT `Presentaciones_ibfk_2` FOREIGN KEY (`artista_id`) REFERENCES `Artistas` (`artista_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Presentaciones`
--

LOCK TABLES `Presentaciones` WRITE;
/*!40000 ALTER TABLE `Presentaciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `Presentaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProduccionEscenarios`
--

DROP TABLE IF EXISTS `ProduccionEscenarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ProduccionEscenarios` (
  `escenario_id` int NOT NULL,
  `personal_id` int NOT NULL,
  PRIMARY KEY (`escenario_id`,`personal_id`),
  KEY `personal_id` (`personal_id`),
  CONSTRAINT `ProduccionEscenarios_ibfk_1` FOREIGN KEY (`escenario_id`) REFERENCES `Escenarios` (`escenario_id`),
  CONSTRAINT `ProduccionEscenarios_ibfk_2` FOREIGN KEY (`personal_id`) REFERENCES `PersonalProduccion` (`personal_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProduccionEscenarios`
--

LOCK TABLES `ProduccionEscenarios` WRITE;
/*!40000 ALTER TABLE `ProduccionEscenarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `ProduccionEscenarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `numeroGeneros`
--

DROP TABLE IF EXISTS `numeroGeneros`;
/*!50001 DROP VIEW IF EXISTS `numeroGeneros`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `roles`
--

LOCK TABLES `roles` WRITE;
/*!40000 ALTER TABLE `roles` DISABLE KEYS */;
/*!40000 ALTER TABLE `roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'Polipalooza'
--
/*!50003 DROP FUNCTION IF EXISTS `generoMayor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`alumno`@`localhost` FUNCTION `generoMayor`() RETURNS varchar(45) CHARSET utf8mb4
    DETERMINISTIC
BEGIN

declare nom varchar(45) default "";

select nombre into nom from (select genero_musical as nombre, count(*) as cantidad from Artistas 
group by nombre having cantidad = (select max(cantidad) from numeroGeneros)) as artistas;

RETURN nom;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP FUNCTION IF EXISTS `personalMinimo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`alumno`@`localhost` FUNCTION `personalMinimo`(esc int) RETURNS tinyint(1)
    DETERMINISTIC
BEGIN
declare cantPersonal int default 0;
declare condicion boolean default false;

select count(distinct(rol)) into cantPersonal from Escenarios
join ProduccionEscenarios on Escenarios.escenario_id = ProduccionEscenarios.escenario_id
join PersonalProduccion on PersonalProduccion.personal_id = ProduccionEscenarios.personal_id 
where Escenarios.escenario_id = esc;

if cantPersonal >= 3 then
	set condicion = true;
end if;

RETURN condicion;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `escenarioArtistas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`alumno`@`localhost` PROCEDURE `escenarioArtistas`()
BEGIN
select  Artistas.artista_id, Presentaciones.escenario_id
from Presentaciones
join Artistas on Presentaciones.artista_id = Artistas.artista_id 
join Personas on Personas.persona_id = Artistas.persona_id 
group by Presentaciones.escenario_id, Artistas.artista_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `rolPersonas` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`alumno`@`localhost` PROCEDURE `rolPersonas`()
BEGIN
select roles.rol, PersonalProduccion.personal_id  
from roles
join PersonalProduccion on roles.rol = PersonalProduccion.rol
join Personas on PersonalProduccion.persona_id = Personas.persona_id
group by roles.rol, PersonalProduccion.personal_id ;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Final view structure for view `numeroGeneros`
--

/*!50001 DROP VIEW IF EXISTS `numeroGeneros`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`alumno`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `numeroGeneros` AS select `Artistas`.`genero_musical` AS `nombre`,count(0) AS `cantidad` from `Artistas` group by `nombre` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-23 13:54:21
