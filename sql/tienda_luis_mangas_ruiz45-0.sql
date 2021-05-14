-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-05-2021 a las 03:12:40
-- Versión del servidor: 10.4.14-MariaDB
-- Versión de PHP: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tienda_luis_mangas_ruiz`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categorias`
--

CREATE TABLE `categorias` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `categorias`
--

INSERT INTO `categorias` (`id`, `nombre`, `descripcion`) VALUES
(1, 'Tecnologia', 'Categoría que agrupa todos los productos que tienen que ver con la tecnología.'),
(2, 'Libros', 'Esta sección tiene que ver con libros');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `configuracion`
--

CREATE TABLE `configuracion` (
  `id` int(11) NOT NULL,
  `clave` varchar(255) DEFAULT NULL,
  `valor` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `configuracion`
--

INSERT INTO `configuracion` (`id`, `clave`, `valor`, `tipo`) VALUES
(1, 'numFactura', '4', 'Integer'),
(2, 'nombreTienda', 'Luis.com', 'String'),
(3, 'cif', '1234567890a', 'String'),
(4, 'direccion', 'Cortinas de san Miguel', 'String'),
(5, 'ciudad', 'Zamora', 'String');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `descuentos`
--

CREATE TABLE `descuentos` (
  `id` int(11) NOT NULL,
  `codigo` varchar(255) DEFAULT NULL,
  `descuento` float DEFAULT NULL,
  `fecha_inicio` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `fecha_fin` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalles_pedido`
--

CREATE TABLE `detalles_pedido` (
  `id` int(11) NOT NULL,
  `id_pedido` int(11) DEFAULT NULL,
  `id_producto` int(11) DEFAULT NULL,
  `precio_unidad` float DEFAULT NULL,
  `unidades` int(11) DEFAULT NULL,
  `impuesto` float DEFAULT NULL,
  `total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `detalles_pedido`
--

INSERT INTO `detalles_pedido` (`id`, `id_pedido`, `id_producto`, `precio_unidad`, `unidades`, `impuesto`, `total`) VALUES
(1, 5, 3, 15, 1, 21, 15),
(2, 5, 4, 150.55, 1, 21, 150.55),
(3, 5, 8, 750, 1, 21, 750),
(4, 7, 2, 10.5, 1, 21, 10.5),
(5, 8, 1, 500.99, 1, 21, 500.99),
(6, 8, 2, 10.5, 1, 21, 10.5),
(7, 9, 11, 1.5, 1, 21, 1.5),
(8, 9, 13, 1.5, 1, 21, 1.5),
(9, 10, 4, 150.55, 1, 21, 150.55),
(10, 10, 8, 750, 1, 21, 750),
(11, 11, 1, 500.99, 1, 21, 500.99),
(12, 11, 1, 500.99, 1, 21, 500.99),
(13, 12, 11, 1.5, 1, 21, 1.5),
(14, 12, 5, 250.5, 1, 21, 250.5),
(15, 12, 1, 500.99, 1, 21, 500.99),
(16, 13, 3, 15, 1, 21, 15),
(17, 13, 4, 150.55, 1, 21, 150.55),
(18, 13, 8, 750, 1, 21, 750),
(19, 13, 8, 750, 1, 21, 750),
(20, 13, 7, 15, 1, 21, 15),
(21, 13, 6, 1500, 1, 21, 1500),
(22, 14, 1, 500.99, 1, 21, 500.99),
(23, 14, 2, 10.5, 1, 21, 10.5),
(24, 14, 3, 15, 1, 21, 15),
(25, 14, 3, 15, 1, 21, 15),
(26, 15, 6, 1500, 1, 21, 1500),
(30, 17, 3, 15, 1, 21, 15),
(32, 17, 4, 150.55, 1, 21, 150.55),
(33, 18, 3, 15, 1, 21, 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `impuestos`
--

CREATE TABLE `impuestos` (
  `id` int(11) NOT NULL,
  `impuesto` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `metodos_pago`
--

CREATE TABLE `metodos_pago` (
  `id` int(11) NOT NULL,
  `metodo_pago` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `metodos_pago`
--

INSERT INTO `metodos_pago` (`id`, `metodo_pago`) VALUES
(1, 'Tarjeta'),
(2, 'PayPal');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `opciones_menu`
--

CREATE TABLE `opciones_menu` (
  `id` int(11) NOT NULL,
  `id_rol` int(11) DEFAULT NULL,
  `opcion` varchar(255) DEFAULT NULL,
  `url_opcion` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `opciones_menu`
--

INSERT INTO `opciones_menu` (`id`, `id_rol`, `opcion`, `url_opcion`) VALUES
(1, 4, 'Productos', '/'),
(2, 4, 'Categorias', ''),
(3, 4, 'Registrarse', '/registro'),
(4, 4, 'Iniciar sesión', '/login\r\n'),
(7, 4, 'Carro', '/carro'),
(8, 3, 'Productos', '/'),
(9, 3, 'Categorias', ''),
(12, 2, 'Productos', '/tabla'),
(13, 2, 'Clientes', '/usuario/cliente/tabla'),
(14, 2, 'Pedidos', '/pedido/tabla'),
(16, 1, 'Productos', '/tabla'),
(17, 1, 'Clientes', '/usuario/cliente/tabla'),
(18, 1, 'Empleados', '/usuario/empleado/tabla'),
(19, 1, 'Pedidos', '/pedido/tabla'),
(21, 2, 'Categorias', '/categoria/tabla'),
(22, 1, 'Categorias', '/categoria/tabla'),
(23, 1, 'Configuración', '/configuracion/tabla'),
(24, 2, 'Proveedores', '/proveedor/tabla'),
(25, 1, 'Proveedores', '/proveedor/tabla'),
(26, 1, 'Administradores', '/usuario/admin/tabla'),
(50, 3, 'Perfil', ''),
(51, 3, 'Carro', '/carro'),
(55, 2, 'Perfil', ''),
(60, 1, 'Perfil', '');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `id` int(11) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `metodo_pago` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `num_factura` varchar(255) DEFAULT NULL,
  `total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`id`, `id_usuario`, `fecha`, `metodo_pago`, `estado`, `num_factura`, `total`) VALUES
(5, 19, '2021-05-11 22:00:00', 'Tarjeta', 'enviado', '202119', 915.55),
(7, 20, '2021-05-11 22:00:00', 'PayPal', 'enviado', '202153', 10.5),
(8, 20, '2021-05-11 22:00:00', 'PayPal', 'cancelado', '202120', 511.49),
(9, 20, '2021-05-11 22:00:00', 'Tarjeta', 'enviado', '202120', 3),
(10, 20, '2021-05-11 22:00:00', 'Tarjeta', 'cancelado', '202120', 900.55),
(11, 20, '2021-05-11 22:00:00', 'Tarjeta', 'cancelar pendiente', '202120', 1001.98),
(12, 20, '2021-05-12 22:00:00', 'Tarjeta', 'enviado', '202152', 752.99),
(13, 20, '2021-05-12 22:00:00', 'Tarjeta', 'enviado', '20215374', 3180.55),
(14, 20, '2021-05-12 22:00:00', 'Tarjeta', 'enviado', '202152', 541.49),
(15, 25, '2021-05-12 22:00:00', 'PayPal', 'cancelado', NULL, 1500),
(16, 25, '2021-05-12 22:00:00', 'PayPal', 'cancelado', NULL, 40.5),
(17, 25, '2021-05-13 22:00:00', 'Tarjeta', 'pendiente', NULL, 165.55),
(18, 25, '2021-05-13 22:00:00', 'Tarjeta', 'enviado', '202154', 15);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `id_categoria` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `fecha_alta` date DEFAULT NULL,
  `fecha_baja` date DEFAULT NULL,
  `impuesto` float DEFAULT NULL,
  `imagen` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `id_categoria`, `nombre`, `descripcion`, `precio`, `stock`, `fecha_alta`, `fecha_baja`, `impuesto`, `imagen`) VALUES
(1, 1, 'Portátil', 'Es un portátil de prueba.', 500.99, NULL, NULL, NULL, 21, 'portatil.jpg'),
(2, 1, 'Monitor', 'Esto es un monitor de prueba.', 10.5, NULL, NULL, NULL, 21, 'producto1.jpg'),
(3, 1, 'Ratón HP', 'Es un ratón HP', 15, NULL, NULL, NULL, 21, 'ratonhp.jpg'),
(4, 1, 'Auriculares Razer', 'Auriculares', 150.55, NULL, NULL, NULL, 21, 'auricularesrazer.jpg'),
(5, 1, 'Air pods', 'Auriculares de Apple', 250.5, NULL, NULL, NULL, 21, 'airpods.jpg'),
(6, 1, 'Pantallón', 'Pantalla de 100\"', 1500, NULL, NULL, NULL, 21, 'pantallon.png'),
(7, 1, 'Cargador ASUS', 'Cargador ASUS para portátiles que no existen', 15, NULL, NULL, NULL, 21, 'cargadorasus.jpg'),
(8, 1, 'Ordenador gaming', 'Pues que tiene luces RGB y es gaming', 750, NULL, NULL, NULL, 21, 'ordenadorgaming.jpg'),
(9, 1, 'Impresora Canon', 'imprime', 65.5, NULL, NULL, NULL, 21, 'impresoracanon.jpg'),
(10, 2, 'Cicatriz', 'Un libro', 19, NULL, NULL, NULL, 21, 'cicatriz.jpg'),
(11, 2, 'Don quijote', 'En un lugar de la mancha', 15, NULL, NULL, NULL, 21, 'donquijote.png'),
(12, 2, 'Nacidos de la bruma V', 'Quinto libro', 25, NULL, NULL, NULL, 21, 'mistborn.jpg'),
(13, 2, 'Marcapáginas', 'Marcapáginas', 1.5, NULL, NULL, NULL, 21, 'marcapaginas.jpeg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedores`
--

CREATE TABLE `proveedores` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `localidad` varchar(255) DEFAULT NULL,
  `provincia` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `cif` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proveedores`
--

INSERT INTO `proveedores` (`id`, `nombre`, `direccion`, `localidad`, `provincia`, `telefono`, `cif`, `email`, `dni`) VALUES
(1, 'Asun', 'Calle Aire', NULL, NULL, NULL, '7966', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `rol` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`id`, `rol`) VALUES
(1, 'Admin'),
(2, 'Empleado'),
(3, 'Cliente'),
(4, 'Anonimo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL,
  `id_rol` int(11) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `clave` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `apellido1` varchar(255) DEFAULT NULL,
  `apellido2` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `localidad` varchar(255) DEFAULT NULL,
  `provincia` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `dni` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `id_rol`, `email`, `clave`, `nombre`, `apellido1`, `apellido2`, `direccion`, `localidad`, `provincia`, `telefono`, `dni`) VALUES
(8, 1, 'admin@tiendaonline.es', '+mhTnrj4byDqtudAlNoE2rlfymxCZh+kJQ8wGFjknpQaVGwFSMfrAuXxPCIjqlSw', 'admin1', '1', '1', 'ca', 'zamora', 'zamora', '11111', '2222'),
(9, 2, 'luis@gmail.com', '/yQIlPdOxUlaoz2hmN8xVwP9J51xG6qR/qhmgiH6Skj4s+JhlM4mv65VfAyNV1Yf', 'Luis', 'Mangas', 'Mangas', 'C/ blas', 'Zamora', 'Zamora', '000000000', '1'),
(13, 1, 'admin@a', 'TPW8oa2EBJ6r6MtwY8ErqX0WeBcuVw3eieC8xEyYr30wDFuyPpTswmr/Sns7bGrm', 'Admin1', 'aa', 'aa', 'a', 'a', 'a', 'a', 'a'),
(16, 2, 'empleado@gmail.com', 'UPIo9D2pRnEu3CoXQqY74r1wBPtH9i+VQrK+hTTAJ6fIkE3sPqzjfXjNzWG3OAC3', 'em', 'em', 'em', 'em', 'em', 'em', '9999999dasfas99', '9999999e'),
(17, 3, 'luis.manrui@educa.jcyl.es', 'WyBxG5Vx6k5Cm1EQiESe/X4anZ5+0juj6GrZnwuSj9RvXj8uehqzHrvpMzJRUf/4', 'ewqrqrwe', 'aaaa', 'aaaadsafads', 'a', 'a', 'samora', '123456789', '4ww333'),
(19, 3, 'alvaro.morfer@educa.jcyl.es', 'qt9OAFjXhmxnj1kX4b48ngiKRbr2trjOTRn9Yyu08h+XvisMWeG4RVnDfGS+AaTc', 'Yorch', 'Carrero', 'vrallan', 'a', 'a', 'a', '111111111', 'a'),
(20, 3, 'cliente@gmail.com', 'fqQJjhw8eAIhF0XMNMDOYkV9ra6UUm6NaZnimWBWVcLNcTxrp+HcFpZMAMZEyPb0', 'Cliente', 'Cliente1', 'Cliente', 'calle', 'Zamora', 'Zamora', '123456789', '23455'),
(25, 3, 'juan@gmail.com', 'Fp0NM4jm9Q3sffmuMHM4C1zE9Rw3jJD7IA2Xk9pQ4AtrolrDj+37BSBrDiApaUF3', 'Juan', 'Mangas', 'Ruiz', NULL, NULL, NULL, NULL, NULL),
(27, 1, 'admin@admin.com', '0XqyyRcWR3ohiyfnqGWgPdhI0UPJi57/5SztMslnZ9r7gynE1UJtuRjw40fARHDl', 'admin', ' .', ' .', NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `valoraciones`
--

CREATE TABLE `valoraciones` (
  `id` int(11) NOT NULL,
  `id_producto` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `valoracion` int(11) DEFAULT NULL,
  `comentario` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `categorias`
--
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `configuracion`
--
ALTER TABLE `configuracion`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `descuentos`
--
ALTER TABLE `descuentos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `detalles_pedido`
--
ALTER TABLE `detalles_pedido`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `impuestos`
--
ALTER TABLE `impuestos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `metodos_pago`
--
ALTER TABLE `metodos_pago`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `opciones_menu`
--
ALTER TABLE `opciones_menu`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `valoraciones`
--
ALTER TABLE `valoraciones`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `categorias`
--
ALTER TABLE `categorias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `configuracion`
--
ALTER TABLE `configuracion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `descuentos`
--
ALTER TABLE `descuentos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalles_pedido`
--
ALTER TABLE `detalles_pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de la tabla `impuestos`
--
ALTER TABLE `impuestos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `metodos_pago`
--
ALTER TABLE `metodos_pago`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `opciones_menu`
--
ALTER TABLE `opciones_menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de la tabla `proveedores`
--
ALTER TABLE `proveedores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `roles`
--
ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `valoraciones`
--
ALTER TABLE `valoraciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
