INSERT INTO `detalles_pedido` (`id`, `id_pedido`, `id_producto`, `precio_unidad`, `unidades`, `impuesto`, `total`) VALUES
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
(25, 14, 3, 15, 1, 21, 15);

INSERT INTO `opciones_menu` (`id`, `id_rol`, `opcion`, `url_opcion`) VALUES
(21, 2, 'Categorias', '/categoria/tabla'),
(22, 1, 'Categorias', '/categoria/tabla'),
(23, 1, 'Configuración', '/configuracion/tabla'),
(24, 2, 'Proveedores', '/proveedores/tabla'),
(25, 1, 'Proveedores', '/proveedores/tabla'),
(26, 1, 'Administradores', '/usuario/admin/tabla'),
(50, 3, 'Perfil', ''),
(51, 3, 'Carro', '/carro'),
(55, 2, 'Perfil', ''),
(60, 1, 'Perfil', '');

INSERT INTO `pedidos` (`id`, `id_usuario`, `fecha`, `metodo_pago`, `estado`, `num_factura`, `total`) VALUES
(7, 20, '2021-05-12 19:49:51', 'PayPal', 'pendiente', '202120', 10.5),
(8, 20, '2021-05-11 22:00:00', 'PayPal', 'cancelado', '202120', 511.49),
(9, 20, '2021-05-11 22:00:00', 'Tarjeta', 'enviado', '202120', 3),
(10, 20, '2021-05-11 22:00:00', 'Tarjeta', 'cancelado', '202120', 900.55),
(11, 20, '2021-05-11 22:00:00', 'Tarjeta', 'cancelar pendiente', '202120', 1001.98),
(12, 20, '2021-05-12 22:00:00', 'Tarjeta', 'enviado', '202152', 752.99),
(13, 20, '2021-05-12 22:00:00', 'Tarjeta', 'enviado', '20215374', 3180.55),
(14, 20, '2021-05-12 22:00:00', 'Tarjeta', 'enviado', '202152', 541.49);

INSERT INTO `usuarios` (`id`, `id_rol`, `email`, `clave`, `nombre`, `apellido1`, `apellido2`, `direccion`, `localidad`, `provincia`, `telefono`, `dni`) VALUES
(20, 3, 'cliente@gmail.com', 'fqQJjhw8eAIhF0XMNMDOYkV9ra6UUm6NaZnimWBWVcLNcTxrp+HcFpZMAMZEyPb0', 'Cliente', 'Cliente1', 'Cliente', 'calle', 'Zamora', 'Zamora', '123456789', '23455');
