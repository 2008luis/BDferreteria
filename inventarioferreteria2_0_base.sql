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
insert into cliente values(1,'Diana','Manchego', '3205295890', '53061133');

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
call agregarProducto('taladro',8520,'herramienta','40000','80000',42);//
call agregarProducto('Martillo',789,'herramienta','50000','100000',10);//
call agregarProducto('Rodillo de felpa',52,'herramienta','20000','40000',30);//

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
    -- Obtener el ID del empleado y del producto
    SELECT id_producto INTO pfkproducto FROM producto WHERE nombreProducto = pnombreProducto;
	SELECT id_empleado INTO pfkempleado FROM empleado WHERE Nombre = pnombreEmpleado;
	SELECT precioVenta INTO pprecioProducto FROM producto WHERE nombreProducto = pnombreProducto;
   
    -- Calcular el total a pagar
    SET ptotalpagar = pprecioProducto * pcantidad;

    -- Insertar la venta
    INSERT INTO venta (nombreEmpleado, nombreCliente, nitCliente, nombreProducto, cantidadVendida, fechaVenta, totalpagar,fkempleado, fkproducto,fkcliente)
    VALUES (pnombreEmpleado, pnombreCliente, pnitCliente, pnombreProducto, pcantidad, pfechaVenta, ptotalpagar, pfkempleado, pfkproducto, pfkcliente );
    
     -- Actualizar la cantidad de productos vendidos
    UPDATE producto SET cantidad = cantidad - pcantidad WHERE nombreProducto = pnombreProducto;
END;//

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
    
create procedure clienteMasCompra(
)
begin 
SELECT nombreCliente, COUNT(*) AS TotalCompras
FROM venta
GROUP BY nombreCliente
ORDER BY TotalCompras DESC
LIMIT 1;
end;//

