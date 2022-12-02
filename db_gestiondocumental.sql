-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 02-12-2022 a las 05:44:50
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
-- Base de datos: `prueba2`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `destinatario`
--

CREATE TABLE `destinatario` (
  `idDestinatario` int(11) NOT NULL,
  `docDestinatario` varchar(100) NOT NULL,
  `cargo` varchar(100) NOT NULL,
  `nombreDestinatario` varchar(100) NOT NULL,
  `apellidoDestinatario` varchar(100) NOT NULL,
  `area` varchar(100) NOT NULL,
  `correoDestinatario` varchar(100) NOT NULL,
  `telefonoDestinatario` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `destinatario`
--

INSERT INTO `destinatario` (`idDestinatario`, `docDestinatario`, `cargo`, `nombreDestinatario`, `apellidoDestinatario`, `area`, `correoDestinatario`, `telefonoDestinatario`) VALUES
(19, 'ewfewf', 'efwf', 'efewf', 'ewfwef', 'ewf', 'fewf', 'efew'),
(20, '124432545', 'Cajero', 'julian ', 'Perez', 'caja', '@fesc', '3123521213');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `documento`
--

CREATE TABLE `documento` (
  `idDocumento` int(11) NOT NULL,
  `nombreArchivo` varchar(300) NOT NULL,
  `asunto` varchar(100) NOT NULL,
  `numeroRadicado` varchar(100) NOT NULL,
  `numeroAnexo` varchar(100) NOT NULL,
  `fecha` date NOT NULL,
  `tipoRadicado` varchar(100) NOT NULL,
  `tipoDocumento` varchar(100) NOT NULL,
  `estudianteNombre` varchar(100) NOT NULL,
  `empresaNombre` varchar(100) NOT NULL,
  `destinatarioNombre` varchar(100) NOT NULL,
  `reqRespuesta` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `documento`
--

INSERT INTO `documento` (`idDocumento`, `nombreArchivo`, `asunto`, `numeroRadicado`, `numeroAnexo`, `fecha`, `tipoRadicado`, `tipoDocumento`, `estudianteNombre`, `empresaNombre`, `destinatarioNombre`, `reqRespuesta`) VALUES
(19, 'Desc', '21', 'df', 'fewfewf', '2022-12-07', '1', '5', 'fwefewf - ewfew fewfewfew', 'Ninguno', 'ewfewf - efewf ewfwef', 0),
(20, 'Demostracion', 'demostracion', '243423', '2324', '2015-08-07', '1', '11', '121443 - daniel velandia', 'Ninguno', '124432545 - julian  Perez', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE `empresa` (
  `idEmpresa` int(11) NOT NULL,
  `docEmpresa` varchar(100) NOT NULL,
  `nombreEmpresa` varchar(100) NOT NULL,
  `nit` varchar(100) NOT NULL,
  `nombreEmpleado` varchar(100) NOT NULL,
  `apellidoEmpleado` varchar(50) NOT NULL,
  `correoEmpresa` varchar(100) NOT NULL,
  `telefonoEmpresa` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`idEmpresa`, `docEmpresa`, `nombreEmpresa`, `nit`, `nombreEmpleado`, `apellidoEmpleado`, `correoEmpresa`, `telefonoEmpresa`) VALUES
(19, '232432432', 'fesc', '7245435-75978', 'Juliana', 'Ospina', '@gesc', '24325352');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE `estudiante` (
  `idEstudiante` int(11) NOT NULL,
  `docEstudiante` varchar(100) NOT NULL,
  `nombresEstudiante` varchar(100) NOT NULL,
  `apellidosEstudiante` varchar(50) NOT NULL,
  `carrera` varchar(100) NOT NULL,
  `semestre` varchar(100) NOT NULL,
  `correoEstudiante` varchar(100) NOT NULL,
  `telefonoEstudiante` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estudiante`
--

INSERT INTO `estudiante` (`idEstudiante`, `docEstudiante`, `nombresEstudiante`, `apellidosEstudiante`, `carrera`, `semestre`, `correoEstudiante`, `telefonoEstudiante`) VALUES
(39, 'fwefewf', 'ewfew', 'fewfewfew', '1', 'fewfew', 'fewfew', 'fewfewfew'),
(40, '121443', 'daniel', 'velandia', '4', '4', '@fesc', '13443232');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registrousuario`
--

CREATE TABLE `registrousuario` (
  `idUsuario` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `apellido` varchar(100) NOT NULL,
  `correoUsuario` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `ROL` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `registrousuario`
--

INSERT INTO `registrousuario` (`idUsuario`, `nombre`, `apellido`, `correoUsuario`, `password`, `ROL`) VALUES
(8, 'jhon', 'el peor', 'fesc', '12', '1'),
(9, 'jhon', 'rodriguez', '@fesc', '123', '1');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `destinatario`
--
ALTER TABLE `destinatario`
  ADD PRIMARY KEY (`idDestinatario`);

--
-- Indices de la tabla `documento`
--
ALTER TABLE `documento`
  ADD PRIMARY KEY (`idDocumento`);

--
-- Indices de la tabla `empresa`
--
ALTER TABLE `empresa`
  ADD PRIMARY KEY (`idEmpresa`);

--
-- Indices de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD PRIMARY KEY (`idEstudiante`);

--
-- Indices de la tabla `registrousuario`
--
ALTER TABLE `registrousuario`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `destinatario`
--
ALTER TABLE `destinatario`
  MODIFY `idDestinatario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `documento`
--
ALTER TABLE `documento`
  MODIFY `idDocumento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT de la tabla `empresa`
--
ALTER TABLE `empresa`
  MODIFY `idEmpresa` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  MODIFY `idEstudiante` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT de la tabla `registrousuario`
--
ALTER TABLE `registrousuario`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
