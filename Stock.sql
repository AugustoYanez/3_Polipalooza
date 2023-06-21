-- MySQL dump 10.13  Distrib 8.0.33, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: stock
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
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `categoria` (
  `idCategoria` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
INSERT INTO `categoria` VALUES (1,'Categoría 1');
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `codCliente` varchar(20) NOT NULL,
  `razonSocial` varchar(45) DEFAULT NULL,
  `contacto` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `codPost` varchar(10) DEFAULT NULL,
  `porcDescuento` decimal(10,2) DEFAULT NULL,
  `Provincia_idProvincia` int NOT NULL,
  `categoria` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codCliente`),
  KEY `fk_Cliente_Provincia` (`Provincia_idProvincia`),
  CONSTRAINT `fk_Cliente_Provincia` FOREIGN KEY (`Provincia_idProvincia`) REFERENCES `provincia` (`idProvincia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES ('CLT001','Cliente 1','Contacto 1','Dirección 1','123456789','12345',0.10,1,'Categoría 1'),('CLT002','Cliente 2','Contacto 2','Dirección 2','987654321','54321',0.05,2,'Categoría 1');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes_audit`
--

DROP TABLE IF EXISTS `clientes_audit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes_audit` (
  `idAudit` int NOT NULL AUTO_INCREMENT,
  `operacion` char(6) DEFAULT NULL,
  `user` varchar(45) DEFAULT NULL,
  `last_date_modified` date DEFAULT NULL,
  `codCliente` varchar(20) DEFAULT NULL,
  `razonSocial` varchar(45) DEFAULT NULL,
  `contacto` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `codPost` varchar(10) DEFAULT NULL,
  `porcDescuento` decimal(10,2) DEFAULT NULL,
  `Provincia_idProvincia` int DEFAULT NULL,
  PRIMARY KEY (`idAudit`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes_audit`
--

LOCK TABLES `clientes_audit` WRITE;
/*!40000 ALTER TABLE `clientes_audit` DISABLE KEYS */;
INSERT INTO `clientes_audit` VALUES (1,'INSERT','User 1','2023-06-21','CLT001','Cliente 1','Contacto 1','Dirección 1','123456789','12345',0.10,1),(2,'UPDATE','User 2','2023-06-22','CLT001','Cliente 1 Modificado','Contacto 1 Modificado','Dirección 1 Modificada','123456789','12345',0.15,1);
/*!40000 ALTER TABLE `clientes_audit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado` (
  `idEstado` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idEstado`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'Estado 1');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingresostock`
--

DROP TABLE IF EXISTS `ingresostock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingresostock` (
  `idIngreso` int NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `remitoNro` varchar(45) DEFAULT NULL,
  `Proveedor_idProveedor` int NOT NULL,
  PRIMARY KEY (`idIngreso`),
  KEY `fk_IngresoStock_Proveedor1_idx` (`Proveedor_idProveedor`),
  CONSTRAINT `fk_IngresoStock_Proveedor1` FOREIGN KEY (`Proveedor_idProveedor`) REFERENCES `proveedor` (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingresostock`
--

LOCK TABLES `ingresostock` WRITE;
/*!40000 ALTER TABLE `ingresostock` DISABLE KEYS */;
INSERT INTO `ingresostock` VALUES (1,'2023-06-21 00:00:00','Remito 1',1),(2,'2023-06-22 00:00:00','Remito 2',2);
/*!40000 ALTER TABLE `ingresostock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingresostock_producto`
--

DROP TABLE IF EXISTS `ingresostock_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ingresostock_producto` (
  `item` int NOT NULL,
  `cantidad` int DEFAULT NULL,
  `IngresoStock_idIngreso` int NOT NULL,
  `Producto_codProducto` int NOT NULL,
  PRIMARY KEY (`item`,`IngresoStock_idIngreso`),
  KEY `fk_IngresoStock_Producto_IngresoStock1_idx` (`IngresoStock_idIngreso`),
  KEY `fk_IngresoStock_Producto_Producto1_idx` (`Producto_codProducto`),
  CONSTRAINT `fk_IngresoStock_Producto_IngresoStock1` FOREIGN KEY (`IngresoStock_idIngreso`) REFERENCES `ingresostock` (`idIngreso`),
  CONSTRAINT `fk_IngresoStock_Producto_Producto1` FOREIGN KEY (`Producto_codProducto`) REFERENCES `producto` (`codProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingresostock_producto`
--

LOCK TABLES `ingresostock_producto` WRITE;
/*!40000 ALTER TABLE `ingresostock_producto` DISABLE KEYS */;
INSERT INTO `ingresostock_producto` VALUES (1,50,1,1),(2,25,1,2),(3,30,2,1);
/*!40000 ALTER TABLE `ingresostock_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido` (
  `idPedido` int NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `Estado_idEstado` int NOT NULL,
  `Cliente_codCliente` varchar(20) NOT NULL,
  PRIMARY KEY (`idPedido`),
  KEY `fk_Pedido_Estado1_idx` (`Estado_idEstado`),
  KEY `fk_Pedido_Cliente1_idx` (`Cliente_codCliente`),
  CONSTRAINT `fk_Pedido_Cliente1` FOREIGN KEY (`Cliente_codCliente`) REFERENCES `cliente` (`codCliente`),
  CONSTRAINT `fk_Pedido_Estado1` FOREIGN KEY (`Estado_idEstado`) REFERENCES `estado` (`idEstado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,'2023-06-21 00:00:00',1,'CLT001'),(2,'2023-06-22 00:00:00',1,'CLT002');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido_producto`
--

DROP TABLE IF EXISTS `pedido_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pedido_producto` (
  `item` int NOT NULL AUTO_INCREMENT,
  `cantidad` int DEFAULT NULL,
  `precioUnitario` decimal(10,2) DEFAULT NULL,
  `Producto_codProducto` int NOT NULL,
  `Pedido_idPedido` int NOT NULL,
  PRIMARY KEY (`item`,`Pedido_idPedido`),
  KEY `fk_Pedido_Producto_Producto1_idx` (`Producto_codProducto`),
  KEY `fk_Pedido_Producto_Pedido1_idx` (`Pedido_idPedido`),
  CONSTRAINT `fk_Pedido_Producto_Pedido1` FOREIGN KEY (`Pedido_idPedido`) REFERENCES `pedido` (`idPedido`),
  CONSTRAINT `fk_Pedido_Producto_Producto1` FOREIGN KEY (`Producto_codProducto`) REFERENCES `producto` (`codProducto`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido_producto`
--

LOCK TABLES `pedido_producto` WRITE;
/*!40000 ALTER TABLE `pedido_producto` DISABLE KEYS */;
INSERT INTO `pedido_producto` VALUES (1,10,10.50,1,1),(2,5,15.75,2,1),(3,8,10.50,1,2);
/*!40000 ALTER TABLE `pedido_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `codProducto` int NOT NULL AUTO_INCREMENT,
  `descripcion` varchar(100) DEFAULT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `Categoria_idCategoria` int NOT NULL,
  `stock` int DEFAULT NULL,
  PRIMARY KEY (`codProducto`),
  KEY `fk_Producto_Categoria1_idx` (`Categoria_idCategoria`),
  CONSTRAINT `fk_Producto_Categoria1` FOREIGN KEY (`Categoria_idCategoria`) REFERENCES `categoria` (`idCategoria`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES (1,'Producto 1',10.50,1,640),(2,'Producto 2',15.75,1,590);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_proveedor`
--

DROP TABLE IF EXISTS `producto_proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto_proveedor` (
  `Proveedor_idProveedor` int NOT NULL,
  `Producto_codProducto` int NOT NULL,
  `precio` decimal(10,2) DEFAULT NULL,
  `demoraEntrega` int DEFAULT NULL,
  PRIMARY KEY (`Proveedor_idProveedor`,`Producto_codProducto`),
  KEY `fk_Proveedor_has_Producto_Producto1_idx` (`Producto_codProducto`),
  KEY `fk_Proveedor_has_Producto_Proveedor1_idx` (`Proveedor_idProveedor`),
  CONSTRAINT `fk_Proveedor_has_Producto_Producto1` FOREIGN KEY (`Producto_codProducto`) REFERENCES `producto` (`codProducto`),
  CONSTRAINT `fk_Proveedor_has_Producto_Proveedor1` FOREIGN KEY (`Proveedor_idProveedor`) REFERENCES `proveedor` (`idProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_proveedor`
--

LOCK TABLES `producto_proveedor` WRITE;
/*!40000 ALTER TABLE `producto_proveedor` DISABLE KEYS */;
INSERT INTO `producto_proveedor` VALUES (1,1,10.50,7),(2,2,15.75,5);
/*!40000 ALTER TABLE `producto_proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto_ubicacion`
--

DROP TABLE IF EXISTS `producto_ubicacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto_ubicacion` (
  `idProducto_Ubicacion` int NOT NULL,
  `cantidad` int DEFAULT NULL,
  `estanteria` varchar(45) DEFAULT NULL,
  `Producto_codProducto` int NOT NULL,
  PRIMARY KEY (`idProducto_Ubicacion`),
  KEY `fk_Producto_Ubicacion_Producto1_idx` (`Producto_codProducto`),
  CONSTRAINT `fk_Producto_Ubicacion_Producto1` FOREIGN KEY (`Producto_codProducto`) REFERENCES `producto` (`codProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto_ubicacion`
--

LOCK TABLES `producto_ubicacion` WRITE;
/*!40000 ALTER TABLE `producto_ubicacion` DISABLE KEYS */;
INSERT INTO `producto_ubicacion` VALUES (1,50,'Estantería 1',1),(2,25,'Estantería 2',2);
/*!40000 ALTER TABLE `producto_ubicacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `idProveedor` int NOT NULL,
  `razonSocial` varchar(45) DEFAULT NULL,
  `contacto` varchar(45) DEFAULT NULL,
  `direccion` varchar(45) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `codPost` varchar(10) DEFAULT NULL,
  `Provincia_idProvincia` int NOT NULL,
  PRIMARY KEY (`idProveedor`),
  KEY `fk_Proveedor_Provincia1_idx` (`Provincia_idProvincia`),
  CONSTRAINT `fk_Proveedor_Provincia1` FOREIGN KEY (`Provincia_idProvincia`) REFERENCES `provincia` (`idProvincia`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'Proveedor 1','Contacto 1','Dirección 1','123456789','12345',1),(2,'Proveedor 2','Contacto 2','Dirección 2','987654321','54321',2);
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `provincia`
--

DROP TABLE IF EXISTS `provincia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `provincia` (
  `idProvincia` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idProvincia`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `provincia`
--

LOCK TABLES `provincia` WRITE;
/*!40000 ALTER TABLE `provincia` DISABLE KEYS */;
INSERT INTO `provincia` VALUES (1,'Provincia 1'),(2,'Provincia 2');
/*!40000 ALTER TABLE `provincia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'stock'
--
/*!50003 DROP PROCEDURE IF EXISTS `actualizarStockDiario` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`alumno`@`localhost` PROCEDURE `actualizarStockDiario`()
BEGIN
 DECLARE pedidos INT;
    DECLARE ingresos INT;
    
    -- Obtener la suma de las cantidades de los productos en los pedidos realizados en el día
    SELECT SUM(pp.cantidad)
    INTO pedidos
    FROM stock.pedido_producto pp
    JOIN stock.pedido p ON pp.Pedido_idPedido = p.idPedido
    WHERE DATE(p.fecha) = CURDATE();
    
    -- Obtener la suma de las cantidades de los productos en los ingresos realizados en el día
    SELECT SUM(ip.cantidad)
    INTO ingresos
    FROM stock.ingresostock_producto ip
    JOIN stock.ingresostock i ON ip.IngresoStock_idIngreso = i.idIngreso
    WHERE DATE(i.fecha) = CURDATE();
    
    -- Actualizar el stock de los productos
    UPDATE stock.producto
    SET stock = stock + ingresos - pedidos
    WHERE codProducto IN (
        SELECT Producto_codProducto
        FROM stock.pedido_producto
        WHERE Pedido_idPedido IN (
            SELECT idPedido
            FROM stock.pedido
            WHERE DATE(fecha) = CURDATE()
        )
    );
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listarProductosSinStockNoCompradosUltimos3Meses` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`alumno`@`localhost` PROCEDURE `listarProductosSinStockNoCompradosUltimos3Meses`()
BEGIN
    DECLARE fechaLimite DATE;
    SET fechaLimite = DATE_SUB(CURDATE(), INTERVAL 3 MONTH);
    
    SELECT p.codProducto, p.descripcion, p.stock
    FROM stock.producto p
    LEFT JOIN stock.pedido_producto pp ON p.codProducto = pp.Producto_codProducto
    LEFT JOIN stock.pedido pe ON pp.Pedido_idPedido = pe.idPedido
    WHERE p.stock = 0
        AND (pe.fecha IS NULL OR pe.fecha <= fechaLimite);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `productoPorPedido` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`alumno`@`localhost` PROCEDURE `productoPorPedido`()
BEGIN
SELECT p.codProducto, p.descripcion, pp.cantidad, pp.precioUnitario
FROM stock.pedido_producto pp
JOIN stock.producto p ON pp.Producto_codProducto = p.codProducto;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-21  9:45:59
