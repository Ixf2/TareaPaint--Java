-- MariaDB dump 10.19  Distrib 10.4.32-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: Paint
-- ------------------------------------------------------
-- Server version	10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `circulos`
--

DROP TABLE IF EXISTS `circulos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `circulos` (
  `figura_id` int(11) NOT NULL,
  `xCentro` int(11) DEFAULT NULL,
  `yCentro` int(11) DEFAULT NULL,
  `radio` int(11) DEFAULT NULL,
  PRIMARY KEY (`figura_id`),
  CONSTRAINT `circulos_ibfk_1` FOREIGN KEY (`figura_id`) REFERENCES `figuras` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `circulos`
--

LOCK TABLES `circulos` WRITE;
/*!40000 ALTER TABLE `circulos` DISABLE KEYS */;
/*!40000 ALTER TABLE `circulos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dibujos`
--

DROP TABLE IF EXISTS `dibujos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dibujos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dibujos`
--

LOCK TABLES `dibujos` WRITE;
/*!40000 ALTER TABLE `dibujos` DISABLE KEYS */;
INSERT INTO `dibujos` VALUES (2,'Mi dibujo'),(3,'Mi dibujo'),(4,'Mi dibujo'),(5,'Mi dibujo');
/*!40000 ALTER TABLE `dibujos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `figuras`
--

DROP TABLE IF EXISTS `figuras`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `figuras` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dibujo_id` int(11) DEFAULT NULL,
  `tipo` varchar(50) DEFAULT NULL,
  `orden_figura` int(11) DEFAULT NULL,
  `color_borde` varchar(20) DEFAULT NULL,
  `color_relleno` varchar(20) DEFAULT NULL,
  `relleno` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dibujo_id` (`dibujo_id`),
  CONSTRAINT `figuras_ibfk_1` FOREIGN KEY (`dibujo_id`) REFERENCES `dibujos` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `figuras`
--

LOCK TABLES `figuras` WRITE;
/*!40000 ALTER TABLE `figuras` DISABLE KEYS */;
/*!40000 ALTER TABLE `figuras` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `poligonos_regulares`
--

DROP TABLE IF EXISTS `poligonos_regulares`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `poligonos_regulares` (
  `figura_id` int(11) NOT NULL,
  `xCentro` int(11) DEFAULT NULL,
  `yCentro` int(11) DEFAULT NULL,
  `radio` int(11) DEFAULT NULL,
  `lados` int(11) DEFAULT NULL,
  `anguloInicial` double DEFAULT NULL,
  PRIMARY KEY (`figura_id`),
  CONSTRAINT `poligonos_regulares_ibfk_1` FOREIGN KEY (`figura_id`) REFERENCES `figuras` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `poligonos_regulares`
--

LOCK TABLES `poligonos_regulares` WRITE;
/*!40000 ALTER TABLE `poligonos_regulares` DISABLE KEYS */;
/*!40000 ALTER TABLE `poligonos_regulares` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `puntos`
--

DROP TABLE IF EXISTS `puntos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `puntos` (
  `figura_id` int(11) NOT NULL,
  `x` int(11) DEFAULT NULL,
  `y` int(11) DEFAULT NULL,
  PRIMARY KEY (`figura_id`),
  CONSTRAINT `puntos_ibfk_1` FOREIGN KEY (`figura_id`) REFERENCES `figuras` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `puntos`
--

LOCK TABLES `puntos` WRITE;
/*!40000 ALTER TABLE `puntos` DISABLE KEYS */;
/*!40000 ALTER TABLE `puntos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rectas`
--

DROP TABLE IF EXISTS `rectas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rectas` (
  `figura_id` int(11) NOT NULL,
  `x1` int(11) DEFAULT NULL,
  `y1` int(11) DEFAULT NULL,
  `x2` int(11) DEFAULT NULL,
  `y2` int(11) DEFAULT NULL,
  PRIMARY KEY (`figura_id`),
  CONSTRAINT `rectas_ibfk_1` FOREIGN KEY (`figura_id`) REFERENCES `figuras` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rectas`
--

LOCK TABLES `rectas` WRITE;
/*!40000 ALTER TABLE `rectas` DISABLE KEYS */;
/*!40000 ALTER TABLE `rectas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vertices_poligonos`
--

DROP TABLE IF EXISTS `vertices_poligonos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vertices_poligonos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `figura_id` int(11) DEFAULT NULL,
  `x` int(11) DEFAULT NULL,
  `y` int(11) DEFAULT NULL,
  `orden_vertice` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `figura_id` (`figura_id`),
  CONSTRAINT `vertices_poligonos_ibfk_1` FOREIGN KEY (`figura_id`) REFERENCES `figuras` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vertices_poligonos`
--

LOCK TABLES `vertices_poligonos` WRITE;
/*!40000 ALTER TABLE `vertices_poligonos` DISABLE KEYS */;
/*!40000 ALTER TABLE `vertices_poligonos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-19 15:01:40
