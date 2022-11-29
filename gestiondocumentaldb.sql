-- MariaDB dump 10.19  Distrib 10.4.24-MariaDB, for Win64 (AMD64)
--
-- Host: localhost    Database: gestiondocumentaldb
-- ------------------------------------------------------
-- Server version	10.4.24-MariaDB

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
-- Table structure for table `destinatario`
--

DROP TABLE IF EXISTS `destinatario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `destinatario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `documento` varchar(20) NOT NULL,
  `nombres` varchar(40) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `cargo` varchar(20) NOT NULL,
  `area` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destinatario`
--

LOCK TABLES `destinatario` WRITE;
/*!40000 ALTER TABLE `destinatario` DISABLE KEYS */;
/*!40000 ALTER TABLE `destinatario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `destinatario_doc`
--

DROP TABLE IF EXISTS `destinatario_doc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `destinatario_doc` (
  `id_destinatario` int(11) NOT NULL,
  `id_documento` int(11) NOT NULL,
  KEY `id_destinatario` (`id_destinatario`),
  KEY `id_documento` (`id_documento`),
  CONSTRAINT `destinatario_doc_ibfk_1` FOREIGN KEY (`id_destinatario`) REFERENCES `destinatario` (`id`) ON DELETE CASCADE,
  CONSTRAINT `destinatario_doc_ibfk_2` FOREIGN KEY (`id_documento`) REFERENCES `documento` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `destinatario_doc`
--

LOCK TABLES `destinatario_doc` WRITE;
/*!40000 ALTER TABLE `destinatario_doc` DISABLE KEYS */;
/*!40000 ALTER TABLE `destinatario_doc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documento`
--

DROP TABLE IF EXISTS `documento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `documento` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_archivo` varchar(30) NOT NULL,
  `ruta_archivo` varchar(50) NOT NULL,
  `fecha` date NOT NULL,
  `num_radicado` varchar(20) NOT NULL,
  `tipo_radicado` tinyint(1) NOT NULL,
  `tipo_documento` int(11) NOT NULL,
  `asunto` varchar(50) NOT NULL,
  `anexos` varchar(50) NOT NULL,
  `req_respuesta` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento`
--

LOCK TABLES `documento` WRITE;
/*!40000 ALTER TABLE `documento` DISABLE KEYS */;
/*!40000 ALTER TABLE `documento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `documento` varchar(20) DEFAULT NULL,
  `nombres` varchar(40) NOT NULL,
  `apellidos` varchar(40) DEFAULT NULL,
  `correo` varchar(30) NOT NULL,
  `nombre_empresa` varchar(20) NOT NULL,
  `nit` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empresa_doc`
--

DROP TABLE IF EXISTS `empresa_doc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empresa_doc` (
  `id_empresa` int(11) NOT NULL,
  `id_documento` int(11) NOT NULL,
  KEY `id_empresa` (`id_empresa`),
  KEY `id_documento` (`id_documento`),
  CONSTRAINT `empresa_doc_ibfk_1` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`) ON DELETE CASCADE,
  CONSTRAINT `empresa_doc_ibfk_2` FOREIGN KEY (`id_documento`) REFERENCES `documento` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa_doc`
--

LOCK TABLES `empresa_doc` WRITE;
/*!40000 ALTER TABLE `empresa_doc` DISABLE KEYS */;
/*!40000 ALTER TABLE `empresa_doc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante`
--

DROP TABLE IF EXISTS `estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estudiante` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `documento` varchar(20) NOT NULL,
  `nombres` varchar(40) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `carrera` int(11) NOT NULL,
  `semestre` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante`
--

LOCK TABLES `estudiante` WRITE;
/*!40000 ALTER TABLE `estudiante` DISABLE KEYS */;
/*!40000 ALTER TABLE `estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estudiante_doc`
--

DROP TABLE IF EXISTS `estudiante_doc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estudiante_doc` (
  `id_estudiante` int(11) NOT NULL,
  `id_documento` int(11) NOT NULL,
  KEY `id_estudiante` (`id_estudiante`),
  KEY `id_documento` (`id_documento`),
  CONSTRAINT `estudiante_doc_ibfk_1` FOREIGN KEY (`id_estudiante`) REFERENCES `estudiante` (`id`) ON DELETE CASCADE,
  CONSTRAINT `estudiante_doc_ibfk_2` FOREIGN KEY (`id_documento`) REFERENCES `documento` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estudiante_doc`
--

LOCK TABLES `estudiante_doc` WRITE;
/*!40000 ALTER TABLE `estudiante_doc` DISABLE KEYS */;
/*!40000 ALTER TABLE `estudiante_doc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `login` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `clave` varchar(40) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `respuesta_entrega`
--

DROP TABLE IF EXISTS `respuesta_entrega`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `respuesta_entrega` (
  `id_respuesta` int(11) NOT NULL,
  `id_entrega` int(11) NOT NULL,
  KEY `id_respuesta` (`id_respuesta`),
  KEY `id_entrega` (`id_entrega`),
  CONSTRAINT `respuesta_entrega_ibfk_1` FOREIGN KEY (`id_respuesta`) REFERENCES `documento` (`id`) ON DELETE CASCADE,
  CONSTRAINT `respuesta_entrega_ibfk_2` FOREIGN KEY (`id_entrega`) REFERENCES `documento` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `respuesta_entrega`
--

LOCK TABLES `respuesta_entrega` WRITE;
/*!40000 ALTER TABLE `respuesta_entrega` DISABLE KEYS */;
/*!40000 ALTER TABLE `respuesta_entrega` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefono`
--

DROP TABLE IF EXISTS `telefono`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefono` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `num_telefono` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefono`
--

LOCK TABLES `telefono` WRITE;
/*!40000 ALTER TABLE `telefono` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefono` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefono_destinatario`
--

DROP TABLE IF EXISTS `telefono_destinatario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefono_destinatario` (
  `id_telefono` int(11) NOT NULL,
  `id_destinatario` int(11) NOT NULL,
  KEY `id_telefono` (`id_telefono`),
  KEY `id_destinatario` (`id_destinatario`),
  CONSTRAINT `telefono_destinatario_ibfk_1` FOREIGN KEY (`id_telefono`) REFERENCES `telefono` (`id`) ON DELETE CASCADE,
  CONSTRAINT `telefono_destinatario_ibfk_2` FOREIGN KEY (`id_destinatario`) REFERENCES `destinatario` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefono_destinatario`
--

LOCK TABLES `telefono_destinatario` WRITE;
/*!40000 ALTER TABLE `telefono_destinatario` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefono_destinatario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefono_empresa`
--

DROP TABLE IF EXISTS `telefono_empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefono_empresa` (
  `id_telefono` int(11) NOT NULL,
  `id_empresa` int(11) NOT NULL,
  KEY `id_telefono` (`id_telefono`),
  KEY `id_empresa` (`id_empresa`),
  CONSTRAINT `telefono_empresa_ibfk_1` FOREIGN KEY (`id_telefono`) REFERENCES `telefono` (`id`) ON DELETE CASCADE,
  CONSTRAINT `telefono_empresa_ibfk_2` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefono_empresa`
--

LOCK TABLES `telefono_empresa` WRITE;
/*!40000 ALTER TABLE `telefono_empresa` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefono_empresa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefono_estudiante`
--

DROP TABLE IF EXISTS `telefono_estudiante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefono_estudiante` (
  `id_telefono` int(11) NOT NULL,
  `id_estudiante` int(11) NOT NULL,
  KEY `id_telefono` (`id_telefono`),
  KEY `id_estudiante` (`id_estudiante`),
  CONSTRAINT `telefono_estudiante_ibfk_1` FOREIGN KEY (`id_telefono`) REFERENCES `telefono` (`id`) ON DELETE CASCADE,
  CONSTRAINT `telefono_estudiante_ibfk_2` FOREIGN KEY (`id_estudiante`) REFERENCES `estudiante` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefono_estudiante`
--

LOCK TABLES `telefono_estudiante` WRITE;
/*!40000 ALTER TABLE `telefono_estudiante` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefono_estudiante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `documento` varchar(20) NOT NULL,
  `nombres` varchar(40) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `cargo` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_login`
--

DROP TABLE IF EXISTS `usuario_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario_login` (
  `id_usuario` int(11) NOT NULL,
  `id_login` int(11) NOT NULL,
  KEY `id_usuario` (`id_usuario`),
  KEY `id_login` (`id_login`),
  CONSTRAINT `usuario_login_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE,
  CONSTRAINT `usuario_login_ibfk_2` FOREIGN KEY (`id_login`) REFERENCES `login` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_login`
--

LOCK TABLES `usuario_login` WRITE;
/*!40000 ALTER TABLE `usuario_login` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuario_login` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-29 17:00:53
