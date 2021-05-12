DROP DATABASE IF EXISTS `tienda_luis_mangas_ruiz`; 
CREATE DATABASE `tienda_luis_mangas_ruiz` CHARACTER SET utf8mb4;
USE `tienda_luis_mangas_ruiz`;


CREATE TABLE `categorias` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL
) ;


INSERT INTO `categorias` (`id`, `nombre`, `descripcion`) VALUES
(1, 'Tecnologia', 'Categoría que agrupa todos los productos que tienen que ver con la tecnología.'),
(2, 'Libros', 'Esta sección tiene que ver con libros');


CREATE TABLE `configuracion` (
  `id` int(11) NOT NULL,
  `clave` varchar(255) DEFAULT NULL,
  `valor` varchar(255) DEFAULT NULL,
  `tipo` varchar(255) DEFAULT NULL
);

CREATE TABLE `descuentos` (
  `id` int(11) NOT NULL,
  `codigo` varchar(255) DEFAULT NULL,
  `descuento` float DEFAULT NULL,
  `fecha_inicio` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `fecha_fin` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00'
) ;


CREATE TABLE `detalles_pedido` (
  `id` int(11) NOT NULL,
  `id_pedido` int(11) DEFAULT NULL,
  `id_producto` int(11) DEFAULT NULL,
  `precio_unidad` float DEFAULT NULL,
  `unidades` int(11) DEFAULT NULL,
  `impuesto` float DEFAULT NULL,
  `total` double DEFAULT NULL
);

INSERT INTO `detalles_pedido` (`id`, `id_pedido`, `id_producto`, `precio_unidad`, `unidades`, `impuesto`, `total`) VALUES
(1, 5, 3, 15, 1, 21, 15),
(2, 5, 4, 150.55, 1, 21, 150.55),
(3, 5, 8, 750, 1, 21, 750);

CREATE TABLE `impuestos` (
  `id` int(11) NOT NULL,
  `impuesto` float DEFAULT NULL
) ;


CREATE TABLE `metodos_pago` (
  `id` int(11) NOT NULL,
  `metodo_pago` varchar(255) DEFAULT NULL
);

INSERT INTO `metodos_pago` (`id`, `metodo_pago`) VALUES
(1, 'Tarjeta'),
(2, 'PayPal');

CREATE TABLE `opciones_menu` (
  `id` int(11) NOT NULL,
  `id_rol` int(11) DEFAULT NULL,
  `opcion` varchar(255) DEFAULT NULL,
  `url_opcion` varchar(255) NOT NULL
);

INSERT INTO `opciones_menu` (`id`, `id_rol`, `opcion`, `url_opcion`) VALUES
(1, 4, 'Productos', '/'),
(2, 4, 'Categorias', ''),
(3, 4, 'Registrarse', '/registro'),
(4, 4, 'Iniciar sesión', '/login\r\n'),
(7, 4, 'Carro', '/carro'),
(8, 3, 'Productos', '/'),
(9, 3, 'Categorias', ''),
(10, 3, 'Perfil', ''),
(11, 3, 'Carro', '/carro'),
(12, 2, 'Productos', '/tabla'),
(13, 2, 'Clientes', '/usuario/cliente/tabla'),
(14, 2, 'Pedidos', '/pedido/tabla'),
(15, 2, 'Perfil', ''),
(16, 1, 'Productos', '/tabla'),
(17, 1, 'Clientes', '/usuario/cliente/tabla'),
(18, 1, 'Empleados', '/usuario/empleado/tabla'),
(19, 1, 'Pedidos', '/pedido/tabla'),
(20, 1, 'Perfil', '');

CREATE TABLE `pedidos` (
  `id` int(11) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `metodo_pago` varchar(255) DEFAULT NULL,
  `estado` varchar(255) DEFAULT NULL,
  `num_factura` varchar(255) DEFAULT NULL,
  `total` double DEFAULT NULL
);

INSERT INTO `pedidos` (`id`, `id_usuario`, `fecha`, `metodo_pago`, `estado`, `num_factura`, `total`) VALUES
(5, 19, '2021-05-12 15:48:45', 'Tarjeta', 'pendiente', '202119', 915.55);

CREATE TABLE `productos` (
  `id` int(11) NOT NULL,
  `id_categoria` int(11) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `descripcion` varchar(255) DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `fecha_alta` date DEFAULT NULL,
  `fecha_baja` date DEFAULT NULL,
  `impuesto` float DEFAULT NULL
);

INSERT INTO `productos` (`id`, `id_categoria`, `nombre`, `descripcion`, `precio`, `stock`, `fecha_alta`, `fecha_baja`, `impuesto`) VALUES
(1, 1, 'Portátil', 'Es un portátil de prueba.', 500.99, NULL, NULL, NULL, 21),
(2, 1, 'Monitor', 'Esto es un monitor de prueba.', 10.5, 10, '2021-05-02', '2021-05-21', 21),
(3, 1, 'Ratón HP', 'Es un ratón HP', 15, 0, '2021-05-07', '2021-06-17', 21),
(4, 1, 'Auriculares Razer', '', 150.55, 10, '2021-05-07', '2021-06-17', 21),
(5, 1, 'Air pods', 'Auriculares de Apple', 250.5, 10, '2021-05-07', '2021-06-17', 21),
(6, 1, 'Pantallón', 'Pantalla de 100\"', 1500, 10, '2021-05-07', '2021-06-17', 21),
(7, 1, 'Cargador ASUS', 'Cargador ASUS para portátiles que no existen', 15, 10, '2021-05-07', '2021-06-17', 21),
(8, 1, 'Ordenador gaming', 'Pues que tiene luces RGB y es gaming', 750, 2, '2021-05-07', '2021-06-17', 21),
(9, 1, 'Impresora Canon', '', 65.5, 4, '2021-05-07', '2021-06-17', 21),
(10, 2, 'Producto 1', '', 1, 13, '2021-05-07', '2021-06-17', 21),
(11, 2, 'Producto 2', '', 1.5, 54, '2021-05-07', '2021-06-17', 21),
(12, 2, 'Producto 3', '', 1.5, 21, '2021-05-07', '2021-06-17', 21),
(13, 2, 'Producto 4', '', 1.5, 3, '2021-05-07', '2021-06-17', 21),
(25, 1, '1', '1', 1, NULL, NULL, NULL, 1);

CREATE TABLE `proveedores` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `direccion` varchar(255) DEFAULT NULL,
  `localidad` varchar(255) DEFAULT NULL,
  `provincia` varchar(255) DEFAULT NULL,
  `telefono` varchar(255) DEFAULT NULL,
  `cif` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL
);

CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `rol` varchar(255) DEFAULT NULL
);

INSERT INTO `roles` (`id`, `rol`) VALUES
(1, 'Admin'),
(2, 'Empleado'),
(3, 'Cliente'),
(4, 'Anonimo');

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
);

INSERT INTO `usuarios` (`id`, `id_rol`, `email`, `clave`, `nombre`, `apellido1`, `apellido2`, `direccion`, `localidad`, `provincia`, `telefono`, `dni`) VALUES
(8, 1, 'admin@tiendaonline.es', '+mhTnrj4byDqtudAlNoE2rlfymxCZh+kJQ8wGFjknpQaVGwFSMfrAuXxPCIjqlSw', 'Admin', '1', '1', NULL, NULL, NULL, NULL, NULL),
(9, 2, 'luis@gmail.es', '/yQIlPdOxUlaoz2hmN8xVwP9J51xG6qR/qhmgiH6Skj4s+JhlM4mv65VfAyNV1Yf', 'Luis', 'Mangas', 'Ruiz', NULL, NULL, NULL, NULL, NULL),
(13, 1, 'admin@admin.es', 'TPW8oa2EBJ6r6MtwY8ErqX0WeBcuVw3eieC8xEyYr30wDFuyPpTswmr/Sns7bGrm', 'Admin', 'aa', 'aa', NULL, NULL, NULL, NULL, NULL),
(16, 2, 'empleado@gmail.com', 'UPIo9D2pRnEu3CoXQqY74r1wBPtH9i+VQrK+hTTAJ6fIkE3sPqzjfXjNzWG3OAC3', 'em', 'em', 'em', 'em', 'em', 'em', '999999999', '9999999e'),
(17, 3, 'luis.manrui@educa.jcyl.es', 'WyBxG5Vx6k5Cm1EQiESe/X4anZ5+0juj6GrZnwuSj9RvXj8uehqzHrvpMzJRUf/4', 'ewqrqrwe', 'aaaa', 'aaaadsafads', 'a', 'a', 'a', '123456789', '4ww333'),
(18, 3, 'aaaam@hsaf.com', 'ctg7lxr87v7TXhqVeswz1U1jJZNojcxF78vVTBKMApwckLBa1R2gEPq+kyrodt55', 'bbbbbbbbbb', 'bbbbbbbbbbbb', 'u', 'ua', 'u', 'u', '987654312', 'u'),
(19, 3, 'alvaro.morfer@educa.jcyl.es', 'qt9OAFjXhmxnj1kX4b48ngiKRbr2trjOTRn9Yyu08h+XvisMWeG4RVnDfGS+AaTc', 'Yorch', 'Carrero', 'vrallan', NULL, NULL, NULL, NULL, NULL);

CREATE TABLE `valoraciones` (
  `id` int(11) NOT NULL,
  `id_producto` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `valoracion` int(11) DEFAULT NULL,
  `comentario` varchar(255) DEFAULT NULL
);
ALTER TABLE `categorias`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `configuracion`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `descuentos`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `detalles_pedido`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `impuestos`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `metodos_pago`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `opciones_menu`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `proveedores`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `roles`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

ALTER TABLE `valoraciones`
  ADD PRIMARY KEY (`id`);


ALTER TABLE `categorias`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `configuracion`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `descuentos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `detalles_pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

ALTER TABLE `impuestos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `metodos_pago`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

ALTER TABLE `opciones_menu`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

ALTER TABLE `pedidos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

ALTER TABLE `productos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

ALTER TABLE `proveedores`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

ALTER TABLE `roles`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

ALTER TABLE `usuarios`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

ALTER TABLE `valoraciones`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;