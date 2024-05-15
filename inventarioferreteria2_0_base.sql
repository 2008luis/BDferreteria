create database Ferreteria;
use Ferreteria;
create table rol (id_rol int primary key,
Nombre varchar(30));
insert into rol values (1,"Administrador");
insert into rol values(2,"Usuarios");

create table empleado(id_empleado int AUTO_INCREMENT primary key,
Nombre varchar(30),
usuario varchar(10),
clave varchar(12),
 fk_rol int,
foreign key(fk_rol) references rol(id_rol));
insert into empleado values(1,"LUIS","LUIS","5678",1);
insert into empleado values(2,"CAMILO","CAMILO","1234",2);
insert into empleado values(3,"DANILO","DANILO","danilo123",2);
insert into empleado values(4,"ANDRES","CAMILO","andres123",2);
insert into empleado values(5,"WILLIAM","WILLIAM","william589",2);
insert into empleado values(6,"ROBERT","ROBERT","robert456",2);

	
create table respaldoVenta(id_respaldo int  AUTO_INCREMENT primary key,
nombrecliente varchar(30),
fechaVenta date,
productoVendido varchar(30),
nombreEmpleado varchar(30)
);
create table cliente (id_Cliente int AUTO_INCREMENT primary key,
Nombre varchar(30),
Apellido varchar(30),
Telefono varchar(10),
Cedula varchar(10));
insert into cliente values(1,'DIANA','MANCHEGO', '3205295890', '53061133');
insert into cliente values(2,'RICARDO','JOSE', '3014659906', '1031812964');
insert into cliente values(3,'CAMILO','ANDRES', '3002589630', '123456789');


create table producto (id_producto  int AUTO_INCREMENT primary key ,
nombreProducto varchar(30),
codigo int,
categoria varchar(30),
precio double,
precioVenta double,
cantidad int
);

create table respaldoProducto(
idRespaldoProducto  int AUTO_INCREMENT primary key ,
nombre varchar(30),
fecha datetime,
cant int,
precio_Unitario double);



create table venta(id_venta int AUTO_INCREMENT primary key ,
nombreEmpleado varchar(30),
nombreProducto varchar(30),
cantidadVendida int,
nombreCliente varchar(30),
nitCliente varchar(10),
fechaVenta date,
totalpagar double,
fkempleado int,
fkproducto int,
fkcliente int,
foreign key (fkcliente) references cliente(id_Cliente),
foreign key (fkempleado) references empleado(id_empleado),
foreign key (fkproducto) references producto (id_producto));
Delimiter //

create procedure validarLogin(pusuario varchar(30), pclave varchar(10)
)
BEGIN
select id_empleado, fk_rol from empleado where usuario =pusuario and clave = pclave;
end;//

create procedure ingreso_empleado(pnombre varchar(30), pusuario  varchar(10), pclave  varchar(12), ptelefono  varchar(10))
begin
insert into empleado(Nombre, usuario, clave, telefono)
values(pnombre,usuario,clave,telefono);
end;//

create procedure agregarProducto(pnombreProducto  varchar(30) , pcodigo int, pcategoria  varchar(30),
 pprecio  double, pprecioVenta double, pcantidad int)
begin 
insert into producto (nombreProducto, codigo, categoria, precio, precioVenta, cantidad)
values(pnombreProducto, pcodigo, pcategoria, pprecio, pprecioVenta, pcantidad);
end;//
call agregarProducto('taladro',8520,'herramienta','40000','80000',100);//
call agregarProducto('Martillo',789,'herramienta','50000','100000',100);//
call agregarProducto('Rodillo de felpa',52,'herramienta','20000','40000',300);//
CALL agregarProducto('Sierra circular', 790, 'herramienta', 60000, 120000, 30);
CALL agregarProducto('Destornillador eléctrico', 53, 'herramienta', 25000, 50000, 80);
CALL agregarProducto('Llave ajustable', 129, 'herramienta', 15000, 30000, 100);
CALL agregarProducto('Cinta métrica', 634, 'herramienta', 8000, 16000, 150);
CALL agregarProducto('Pinzas de punta', 452, 'herramienta', 12000, 24000, 70);
CALL agregarProducto('Llave de tubo', 217, 'herramienta', 20000, 40000, 40);
CALL agregarProducto('Destornillador de estrella', 993, 'herramienta', 10000, 20000, 90);
CALL agregarProducto('Martillo de bola', 756, 'herramienta', 30000, 60000, 60);
CALL agregarProducto('Sierra de mano', 402, 'herramienta', 18000, 36000, 120);//

CREATE PROCEDURE agregarVenta(
    pnombreCliente VARCHAR(30),
    pnitCliente varchar(10),
    pnombreProducto VARCHAR(30),
	pcantidad int,
    pfechaVenta date,
    ptotalpagar DOUBLE,
	pnombreEmpleado VARCHAR(30),
    pfkempleado int,
    pfkcliente int


)
BEGIN
    DECLARE pfkproducto INT;
    declare pfkempleado int;
	DECLARE pprecioProducto DOUBLE;
    DECLARE ptotalpagar DOUBLE;

    SELECT id_producto INTO pfkproducto FROM producto WHERE nombreProducto = pnombreProducto;
	SELECT id_empleado INTO pfkempleado FROM empleado WHERE Nombre = pnombreEmpleado;
	SELECT precioVenta INTO pprecioProducto FROM producto WHERE nombreProducto = pnombreProducto;
   

    SET ptotalpagar = pprecioProducto * pcantidad;

    
    INSERT INTO venta (nombreEmpleado, nombreCliente, nitCliente, nombreProducto, cantidadVendida, fechaVenta, totalpagar,fkempleado, fkproducto,fkcliente)
    VALUES (pnombreEmpleado, pnombreCliente, pnitCliente, pnombreProducto, pcantidad, pfechaVenta, ptotalpagar, pfkempleado, pfkproducto, pfkcliente );

    UPDATE producto SET cantidad = cantidad - pcantidad WHERE nombreProducto = pnombreProducto;
END;//
select * from venta;//

create procedure comboProducto()
begin 
	select id_producto, nombreProducto from producto;
    end;//
    
   
create procedure mostrardatosProducto()
begin 
	    select nombreProducto, codigo, categoria, cantidad, precioVenta from producto;
    end;//
    
CREATE PROCEDURE generarReporteVentas(
    fecha_inicio DATE,
     fecha_fin DATE
)
BEGIN
    SELECT 
        DATE(fechaVenta) AS fecha,
        SUM(totalpagar) AS total_ventas
    FROM 
        venta
    WHERE 
        fechaVenta BETWEEN fecha_inicio AND fecha_fin
    GROUP BY 
        DATE(fechaVenta)
    ORDER BY 
        DATE(fechaVenta);
END //



create procedure productoMasVendido()
begin 
SELECT nombreProducto, SUM(cantidadVendida) AS TotalVendido
FROM venta
GROUP BY nombreProducto
ORDER BY TotalVendido desc
LIMIT 1;
end;//

CREATE PROCEDURE ventasEmpleado(
    pnombreEmpleado VARCHAR(30), 
    pfechaInicio DATE,
    pfechaFin DATE
)
BEGIN
    SELECT 
        v.nombreEmpleado AS Vendedor,
        COUNT(*) AS Ventas,
        p.nombreProducto AS Producto,
        p.precioVenta AS Precio,
        SUM(v.cantidadVendida) AS TotalCantidadVendida,
        SUM(v.totalpagar) AS TotalRecaudado
    FROM 
        venta v 
        INNER JOIN producto p ON v.fkproducto = p.id_producto
    WHERE 
        v.fechaVenta BETWEEN pfechaInicio AND pfechaFin
        AND v.nombreEmpleado = pnombreEmpleado
    GROUP BY 
        v.nombreEmpleado, p.nombreProducto, p.precioVenta;
END ;// 
CALL ventasEmpleado('luis', '2024-04-01', '2024-04-30');//


create procedure registrarCLientes(
pNombre varchar(30),
pApellido varchar(30),
pTelefono  varchar(10),
pCedula  varchar(10)
)
begin 
insert into cliente (Nombre, Apellido, Telefono, Cedula)
values(pNombre,pApellido,pTelefono,pCedula);
end;//

create procedure registrarEmpleados(
pnombre varchar(30),
pusuario varchar(10),
pclave varchar(12),
pfk_rol int
)
begin
insert into empleado (nombre,usuario,clave,fk_rol)
values (pnombre,pusuario,pclave,pfk_rol);
end;//

CREATE PROCEDURE generalReporteRecaudacion(
     fechaInicio DATE,
     fechaFin DATE
)
BEGIN

    SELECT 
        SUM(totalpagar) AS TotalRecaudadoGeneral
    FROM 
        venta
    WHERE 
        fechaVenta BETWEEN fechaInicio AND fechaFin;
end;//

CREATE PROCEDURe VendedorRecaudo(
     fechaInicio DATE,
     fechaFin DATE
)
BEGIN
SELECT 
        e.Nombre AS Vendedor,
        SUM(v.totalpagar) AS TotalRecaudadoPorVendedor
    FROM 
        venta v
        inner join empleado e on v.fkempleado =e.id_empleado
    WHERE 
        fechaVenta BETWEEN fechaInicio AND fechaFin
    GROUP BY 
         e.Nombre;
END;//

CREATE PROCEDURE obtenerVentasPorFecha(
     fechaInicio DATE,
     fechaFin DATE
)
BEGIN
         SELECT 
        nombreEmpleado, 
        nombreProducto, 
        cantidadVendida,
        nombreCliente, 
        nitCliente,
        fechaVenta,
        totalpagar
    FROM 
        venta
    WHERE 
        fechaventa  BETWEEN fechaInicio AND fechaFin;
END;//

CREATE PROCEDURE obtenerCantidadProducto(
     pnombreProducto VARCHAR(100)
)
BEGIN
select cantidad from producto where nombreProducto = pnombreProducto;
END;
//

create procedure busquedaCedula(pcedula varchar(20)
)
begin
SELECT id_cliente, nombre, apellido, telefono FROM cliente WHERE cedula = pcedula;
end;//

CREATE TRIGGER auditoria_venta
AFTER INSERT ON venta
FOR EACH ROW
BEGIN
    INSERT INTO respaldoventa (nombrecliente, fechaVenta, productoVendido, nombreEmpleado)
    VALUES (NEW.nombreCliente, NEW.fechaVenta, NEW.nombreProducto, new.nombreEmpleado);
END;//

CREATE TRIGGER IngresoProducto
AFTER INSERT ON producto
FOR EACH ROW
BEGIN
    INSERT INTO respaldoproducto (nombre, fecha, cant, precio_Unitario)
    VALUES (NEW.nombreProducto, now(), NEW.cantidad, new.precio);
END;//

CREATE OR REPLACE VIEW vistaEmpleado AS
SELECT 
    v.nombreEmpleado AS Vendedor,
    COUNT(*) AS Ventas,
    p.nombreProducto AS Producto,
    p.precioVenta AS Precio,
    SUM(v.cantidadVendida) AS TotalCantidadVendida,
    SUM(v.totalpagar) AS TotalRecaudado
FROM 
    venta v 
    INNER JOIN producto p ON v.fkproducto = p.id_producto
GROUP BY 
    v.nombreEmpleado, p.nombreProducto, p.precioVenta;//
    
CREATE PROCEDURE clienteMasCompra(
    p_fechaInicio DATE,
    p_fechaFin DATE
)
BEGIN
    SELECT nombreCliente as Cliente, COUNT(*) AS TotalCompras
    FROM venta
    WHERE fechaVenta BETWEEN p_fechaInicio AND p_fechaFin
    GROUP BY nombreCliente
    ORDER BY TotalCompras DESC
    LIMIT 1;
END;//

CREATE PROCEDURE vendedorMasVentas(
    p_fechaInicio DATE,
    p_fechaFin DATE
)
BEGIN
    SELECT nombreEmpleado AS Vendedor, COUNT(*) AS TotalVentas
    FROM venta
    WHERE fechaVenta BETWEEN p_fechaInicio AND p_fechaFin
    GROUP BY nombreEmpleado
    ORDER BY TotalVentas DESC
    LIMIT 1;
END;//
CREATE FUNCTION calcular_total_recaudacion(
    p_fechaInicio DATE,
    p_fechaFin DATE
)
RETURNS DOUBLE
DETERMINISTIC
READS SQL DATA
BEGIN
    DECLARE total_recaudacion DOUBLE;

    SELECT SUM(totalpagar) INTO total_recaudacion
    FROM venta
    WHERE fechaVenta BETWEEN p_fechaInicio AND p_fechaFin;

    RETURN total_recaudacion;
END;//

CREATE PROCEDURE validarProductoExistente(
    pnombreProducto VARCHAR(40),
	pcodigo INT
)
BEGIN
    SELECT COUNT(*) AS total
    FROM producto 
    WHERE nombreProducto = pnombreProducto OR codigo = pcodigo;
END;//
INSERT INTO venta (nombreEmpleado, nombreProducto, cantidadVendida, nombreCliente, nitCliente, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('CAMILO', 'Martillo', 1, 'RICARDO', '1031812964', '2024-04-29', 100000, 2, 2, 2);
INSERT INTO venta (nombreEmpleado, nombreProducto, cantidadVendida, nombreCliente, nitCliente, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('DANILO', 'Rodillo de felpa', 3, 'CAMILO', '123456789', '2024-04-30', 120000, 3, 3, 3);
INSERT INTO venta (nombreEmpleado, nombreProducto, cantidadVendida, nombreCliente, nitCliente, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('ANDRES', 'taladro', 1, 'DIANA', '53061133', '2024-05-01', 80000, 4, 1, 1);
INSERT INTO venta (nombreEmpleado, nombreProducto, cantidadVendida, nombreCliente, nitCliente, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('LUIS', 'Martillo', 2, 'RICARDO', '1031812964', '2024-05-02', 200000, 1, 2, 2);
INSERT INTO venta (nombreEmpleado, nombreProducto, cantidadVendida, nombreCliente, nitCliente, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('DANILO', 'Rodillo de felpa', 2, 'CAMILO', '123456789', '2024-05-03', 80000, 3, 3, 3);
INSERT INTO venta (nombreEmpleado, nombreProducto, cantidadVendida, nombreCliente, nitCliente, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('ANDRES', 'taladro', 3, 'DIANA', '53061133', '2024-05-04', 240000, 4, 1, 1);
INSERT INTO venta (nombreEmpleado, nombreProducto, cantidadVendida, nombreCliente, nitCliente, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('LUIS', 'Martillo', 1, 'RICARDO', '1031812964', '2024-05-05', 100000, 1, 2, 2);
INSERT INTO venta (nombreEmpleado, nombreProducto, cantidadVendida, nombreCliente, nitCliente, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('DANILO', 'Rodillo de felpa', 4, 'CAMILO', '123456789', '2024-05-06', 160000, 3, 3, 3);
INSERT INTO venta (nombreEmpleado, nombreProducto, cantidadVendida, nombreCliente, nitCliente, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('ANDRES', 'taladro', 2, 'DIANA', '53061133', '2024-05-07', 160000, 4, 1, 1);

INSERT INTO venta (nombreEmpleado, nombreProducto, cantidadVendida, nombreCliente, nitCliente, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('LUIS', 'Martillo', 2, 'RICARDO', '1031812964', '2024-05-08', 200000, 1, 2, 2);
INSERT INTO venta (nombreEmpleado, nombreProducto, cantidadVendida, nombreCliente, nitCliente, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('DANILO', 'Rodillo de felpa', 3, 'CAMILO', '123456789', '2024-05-09', 120000, 3, 3, 3);
INSERT INTO venta (nombreEmpleado, nombreProducto, cantidadVendida, nombreCliente, nitCliente, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('ANDRES', 'taladro', 1, 'DIANA', '53061133', '2024-05-10', 80000, 4, 1, 1);
INSERT INTO venta (nombreEmpleado, nombreProducto, cantidadVendida, nombreCliente, nitCliente, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('LUIS', 'Martillo', 1, 'RICARDO', '1031812964', '2024-05-11', 100000, 1, 2, 2);
INSERT INTO venta (nombreEmpleado, nombreProducto, cantidadVendida, nombreCliente, nitCliente, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('DANILO', 'Rodillo de felpa', 2, 'CAMILO', '123456789', '2024-05-12', 80000, 3, 3, 3);
INSERT INTO venta (nombreEmpleado, nombreProducto, cantidadVendida, nombreCliente, nitCliente, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('ANDRES', 'taladro', 3, 'DIANA', '53061133', '2024-05-13', 240000, 4, 1, 1);
INSERT INTO venta (nombreEmpleado, nombreProducto, cantidadVendida, nombreCliente, nitCliente, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('LUIS', 'Martillo', 2, 'RICARDO', '1031812964', '2024-05-14', 200000, 1, 2, 2);
INSERT INTO venta (nombreEmpleado, nombreProducto, cantidadVendida, nombreCliente, nitCliente, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('DANILO', 'Rodillo de felpa', 3, 'CAMILO', '123456789', '2024-05-15', 120000, 3, 3, 3);
INSERT INTO venta (nombreEmpleado, nombreProducto, cantidadVendida, nombreCliente, nitCliente, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('ANDRES', 'taladro', 1, 'DIANA', '53061133', '2024-05-16', 80000, 4, 1, 1);
INSERT INTO venta (nombreEmpleado, nombreProducto, cantidadVendida, nombreCliente, nitCliente, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('LUIS', 'Martillo', 1, 'RICARDO', '1031812964', '2024-05-17', 100000, 1, 2, 2);

INSERT INTO venta (nombreEmpleado, nombreCliente, nitCliente, nombreProducto, cantidadVendida, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('WILLIAM', 'DIANA', '53061133', 'taladro', 2, '2024-06-01', 160000, 5, 1, 1);
INSERT INTO venta (nombreEmpleado, nombreCliente, nitCliente, nombreProducto, cantidadVendida, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('ROBERT', 'RICARDO', '1031812964', 'Martillo de bola', 1, '2024-06-02', 60000, 6, 10, 2);
INSERT INTO venta (nombreEmpleado, nombreCliente, nitCliente, nombreProducto, cantidadVendida, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('WILLIAM', 'CAMILO', '123456789', 'Pinzas de punta', 3, '2024-06-03', 72000, 5, 5, 3);
INSERT INTO venta (nombreEmpleado, nombreCliente, nitCliente, nombreProducto, cantidadVendida, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('ROBERT', 'DIANA', '53061133', 'taladro', 1, '2024-06-04', 80000, 6, 1, 1);
INSERT INTO venta (nombreEmpleado, nombreCliente, nitCliente, nombreProducto, cantidadVendida, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('WILLIAM', 'RICARDO', '1031812964', 'Martillo de bola', 2, '2024-06-05', 120000, 5, 10, 2);
INSERT INTO venta (nombreEmpleado, nombreCliente, nitCliente, nombreProducto, cantidadVendida, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('ROBERT', 'CAMILO', '123456789', 'Sierra de mano', 2, '2024-06-06', 72000, 6, 9, 3);
INSERT INTO venta (nombreEmpleado, nombreCliente, nitCliente, nombreProducto, cantidadVendida, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('WILLIAM', 'DIANA', '53061133', 'Rodillo de felpa', 3, '2024-06-07', 120000, 5, 3, 1);
INSERT INTO venta (nombreEmpleado, nombreCliente, nitCliente, nombreProducto, cantidadVendida, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('ROBERT', 'RICARDO', '1031812964', 'Destornillador eléctrico', 1, '2024-06-08', 50000, 6, 11, 2);
INSERT INTO venta (nombreEmpleado, nombreCliente, nitCliente, nombreProducto, cantidadVendida, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('WILLIAM', 'CAMILO', '123456789', 'Sierra circular', 4, '2024-06-09', 480000, 5, 8, 3);
INSERT INTO venta (nombreEmpleado, nombreCliente, nitCliente, nombreProducto, cantidadVendida, fechaVenta, totalpagar, fkempleado, fkproducto, fkcliente)
VALUES ('ROBERT', 'DIANA', '53061133', 'Llave ajustable', 2, '2024-06-10', 60000, 6, 7, 1);//