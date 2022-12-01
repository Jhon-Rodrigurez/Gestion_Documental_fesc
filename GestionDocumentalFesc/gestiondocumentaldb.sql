-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 01-12-2022 a las 01:37:12
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 8.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `gestiondocumentaldb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `destinatario`
--

CREATE TABLE `destinatario` (
  `id` int(11) NOT NULL,
  `documento` varchar(20) NOT NULL,
  `nombres` varchar(40) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `cargo` varchar(20) NOT NULL,
  `area` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `destinatario`
--

INSERT INTO `destinatario` (`id`, `documento`, `nombres`, `apellidos`, `correo`, `cargo`, `area`) VALUES
(1, 'cascsac', 'ascvwev', 'eef', 'efewf', 'ewfew', 'efwfef'),
(2, '561854196', 'Isleyer Tatiana', 'Roa Rojas', '@fesc.edu.co', 'Archivista', 'Archivo'),
(3, '10201541', 'Harold', 'Niño', '@suv.com', 'Gerente', 'Gerencia');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `destinatario_doc`
--

CREATE TABLE `destinatario_doc` (
  `id_destinatario` int(11) NOT NULL,
  `id_documento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `documento`
--

CREATE TABLE `documento` (
  `id` int(11) NOT NULL,
  `nombre_archivo` varchar(30) DEFAULT NULL,
  `ruta_archivo` varchar(1000) NOT NULL,
  `fecha` date NOT NULL,
  `num_radicado` varchar(20) NOT NULL,
  `tipo_radicado` tinyint(1) NOT NULL,
  `tipo_documento` varchar(3) NOT NULL,
  `asunto` varchar(50) NOT NULL,
  `anexos` varchar(50) NOT NULL,
  `req_respuesta` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `documento`
--

INSERT INTO `documento` (`id`, `nombre_archivo`, `ruta_archivo`, `fecha`, `num_radicado`, `tipo_radicado`, `tipo_documento`, `asunto`, `anexos`, `req_respuesta`) VALUES
(8, 'Certificado POO software', 'C:\\Users\\Lenovo\\OneDrive\\Documents\\ALEXANDER\\Certificados\\Certificado - POO Software.pdf', '2017-07-07', '25163', 1, '6', 'Prueba', '1', 0),
(9, 'MINUBUBU', 'C:\\Users\\Lenovo\\OneDrive\\Documents\\ALEXANDER\\Certificados\\Certificado - Diseñador UX.pdf', '2022-11-20', '515184', 1, '1', '165148', '4848', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `id` int(11) NOT NULL,
  `documento` varchar(20) DEFAULT NULL,
  `nombres` varchar(40) NOT NULL,
  `apellidos` varchar(40) DEFAULT NULL,
  `correo` varchar(30) NOT NULL,
  `nombre_empresa` varchar(20) NOT NULL,
  `nit` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`id`, `documento`, `nombres`, `apellidos`, `correo`, `nombre_empresa`, `nit`) VALUES
(1, 'wdwd', 'ascsc', 'fefsac', '@yevye', 'dsaxs', 'qwfqf'),
(2, '245963154', 'Julian', 'Medina Osorio', '@exito.co', 'EXITO', '218541149-45'),
(3, '12345', 'Isleyer', 'Roa', '@fecs.udo', 'FESC', '151548-26');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa_doc`
--

CREATE TABLE `empresa_doc` (
  `id_empresa` int(11) NOT NULL,
  `id_documento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE `estudiante` (
  `id` int(11) NOT NULL,
  `documento` varchar(20) NOT NULL,
  `nombres` varchar(40) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `carrera` varchar(50) NOT NULL,
  `semestre` varchar(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estudiante`
--

INSERT INTO `estudiante` (`id`, `documento`, `nombres`, `apellidos`, `correo`, `carrera`, `semestre`) VALUES
(1, 'dwdw', 'dwdwd', 'wdwd', 'w', '4', '6'),
(2, 'dwdw', 'dwdw', 'dwdw', 'wd', '4', '5'),
(3, '58498156', 'Johan Camilo', 'Alvarez Perez', '@fesc', '4', '5'),
(4, '1004811006', 'Jhon', 'Zapata', '@fesc', '4', '6'),
(5, '12745145235', 'gergrg', 'regrg', 'regre', '2', '5'),
(6, '12456389', 'Iberson Andrey', 'Rincon Lopez', '@fesc.com', '4', '5'),
(7, '12345', 'Juan', 'Orjuela', '@fesc.com', '5', '5'),
(8, '1245', 'efewf', 'ewfefw', 'fewfwe', '4', '5');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante_doc`
--

CREATE TABLE `estudiante_doc` (
  `id_estudiante` int(11) NOT NULL,
  `id_documento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE `login` (
  `id` int(11) NOT NULL,
  `clave` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `respuesta_entrega`
--

CREATE TABLE `respuesta_entrega` (
  `id_respuesta` int(11) NOT NULL,
  `id_entrega` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `telefono`
--

CREATE TABLE `telefono` (
  `id` int(11) NOT NULL,
  `num_telefono` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `telefono_destinatario`
--

CREATE TABLE `telefono_destinatario` (
  `id_telefono` int(11) NOT NULL,
  `id_destinatario` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `telefono_empresa`
--

CREATE TABLE `telefono_empresa` (
  `id_telefono` int(11) NOT NULL,
  `id_empresa` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `telefono_estudiante`
--

CREATE TABLE `telefono_estudiante` (
  `id_telefono` int(11) NOT NULL,
  `id_estudiante` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `id` int(11) NOT NULL,
  `documento` varchar(20) DEFAULT NULL,
  `nombres` varchar(40) NOT NULL,
  `apellidos` varchar(40) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `cargo` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`id`, `documento`, `nombres`, `apellidos`, `correo`, `cargo`) VALUES
(5, '', 'dwdw', 'dwdwd', '@fesc.edu.co', '2'),
(6, NULL, 'edwin', 'Gomez', '@fesc.com', '1'),
(7, NULL, 'edwin', 'elkin', 'caaas', '1');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario_login`
--

CREATE TABLE `usuario_login` (
  `id_usuario` int(11) NOT NULL,
  `id_login` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `destinatario`
--
ALTER TABLE `destinatario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `destinatario_doc`
--
ALTER TABLE `destinatario_doc`
  ADD KEY `id_destinatario` (`id_destinatario`),
  ADD KEY `id_documento` (`id_documento`);

--
-- Indices de la tabla `documento`
--
ALTER TABLE `documento`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `empresa_doc`
--
ALTER TABLE `empresa_doc`
  ADD KEY `id_empresa` (`id_empresa`),
  ADD KEY `id_documento` (`id_documento`);

--
-- Indices de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `estudiante_doc`
--
ALTER TABLE `estudiante_doc`
  ADD KEY `id_estudiante` (`id_estudiante`),
  ADD KEY `id_documento` (`id_documento`);

--
-- Indices de la tabla `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `respuesta_entrega`
--
ALTER TABLE `respuesta_entrega`
  ADD KEY `id_respuesta` (`id_respuesta`),
  ADD KEY `id_entrega` (`id_entrega`);

--
-- Indices de la tabla `telefono`
--
ALTER TABLE `telefono`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `telefono_destinatario`
--
ALTER TABLE `telefono_destinatario`
  ADD KEY `id_telefono` (`id_telefono`),
  ADD KEY `id_destinatario` (`id_destinatario`);

--
-- Indices de la tabla `telefono_empresa`
--
ALTER TABLE `telefono_empresa`
  ADD KEY `id_telefono` (`id_telefono`),
  ADD KEY `id_empresa` (`id_empresa`);

--
-- Indices de la tabla `telefono_estudiante`
--
ALTER TABLE `telefono_estudiante`
  ADD KEY `id_telefono` (`id_telefono`),
  ADD KEY `id_estudiante` (`id_estudiante`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuario_login`
--
ALTER TABLE `usuario_login`
  ADD KEY `id_usuario` (`id_usuario`),
  ADD KEY `id_login` (`id_login`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `destinatario`
--
ALTER TABLE `destinatario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `documento`
--
ALTER TABLE `documento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `empresa`
--
ALTER TABLE `empresa`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `login`
--
ALTER TABLE `login`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `telefono`
--
ALTER TABLE `telefono`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `destinatario_doc`
--
ALTER TABLE `destinatario_doc`
  ADD CONSTRAINT `destinatario_doc_ibfk_1` FOREIGN KEY (`id_destinatario`) REFERENCES `destinatario` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `destinatario_doc_ibfk_2` FOREIGN KEY (`id_documento`) REFERENCES `documento` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `empresa_doc`
--
ALTER TABLE `empresa_doc`
  ADD CONSTRAINT `empresa_doc_ibfk_1` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `empresa_doc_ibfk_2` FOREIGN KEY (`id_documento`) REFERENCES `documento` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `estudiante_doc`
--
ALTER TABLE `estudiante_doc`
  ADD CONSTRAINT `estudiante_doc_ibfk_1` FOREIGN KEY (`id_estudiante`) REFERENCES `estudiante` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `estudiante_doc_ibfk_2` FOREIGN KEY (`id_documento`) REFERENCES `documento` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `respuesta_entrega`
--
ALTER TABLE `respuesta_entrega`
  ADD CONSTRAINT `respuesta_entrega_ibfk_1` FOREIGN KEY (`id_respuesta`) REFERENCES `documento` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `respuesta_entrega_ibfk_2` FOREIGN KEY (`id_entrega`) REFERENCES `documento` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `telefono_destinatario`
--
ALTER TABLE `telefono_destinatario`
  ADD CONSTRAINT `telefono_destinatario_ibfk_1` FOREIGN KEY (`id_telefono`) REFERENCES `telefono` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `telefono_destinatario_ibfk_2` FOREIGN KEY (`id_destinatario`) REFERENCES `destinatario` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `telefono_empresa`
--
ALTER TABLE `telefono_empresa`
  ADD CONSTRAINT `telefono_empresa_ibfk_1` FOREIGN KEY (`id_telefono`) REFERENCES `telefono` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `telefono_empresa_ibfk_2` FOREIGN KEY (`id_empresa`) REFERENCES `empresa` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `telefono_estudiante`
--
ALTER TABLE `telefono_estudiante`
  ADD CONSTRAINT `telefono_estudiante_ibfk_1` FOREIGN KEY (`id_telefono`) REFERENCES `telefono` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `telefono_estudiante_ibfk_2` FOREIGN KEY (`id_estudiante`) REFERENCES `estudiante` (`id`) ON DELETE CASCADE;

--
-- Filtros para la tabla `usuario_login`
--
ALTER TABLE `usuario_login`
  ADD CONSTRAINT `usuario_login_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `usuario_login_ibfk_2` FOREIGN KEY (`id_login`) REFERENCES `login` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
