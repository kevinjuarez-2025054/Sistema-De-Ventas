Drop database if exists db_sistema_ventas_in5cm;
create database db_sistema_ventas_in5cm;
use db_sistema_ventas_in5cm;

create table Clientes (
    dpi_cliente int primary key not null,
    nombre_cliente varchar(50),
    apellido_cliente varchar(50),
    direccion varchar(100),
    estado int
);

create table Usuarios (
    codigo_usuario int primary key not null auto_increment,
    username varchar(45),
    password varchar(45),
    email varchar(60),
    rol varchar(45),
    estado int
);

create table Productos (
    codigo_producto int primary key auto_increment,
    nombre_producto varchar(60),
    precio decimal(10,2),
    stock int,
    estado int
);

create table Ventas (
    codigo_venta int primary key not null auto_increment,
    fecha_venta date,
    total decimal(10,2),
    estado int,
    clientes_dpi_cliente int,
    usuarios_codigo_usuario int,
    foreign key (clientes_dpi_cliente) references Clientes(dpi_cliente) on delete cascade,
    foreign key (usuarios_codigo_usuario) references Usuarios(codigo_usuario) on delete cascade
);

create table Detalle_venta (
    codigo_detalle_venta int primary key not null auto_increment,
    cantidad int,
    precio_unitario decimal(10,2),
    subtotal decimal(10,2),
    productos_codigo_producto int,
    ventas_codigo_venta int,
    foreign key (productos_codigo_producto) references Productos(codigo_producto) on delete cascade,
    foreign key (ventas_codigo_venta) references Ventas(codigo_venta) on delete cascade
);

-- ======== Procedimientos Almacenados ======== --


-- ===== clientes =====
delimiter $$
create procedure sp_create_Cliente(in p_dpi int,in p_nombre varchar(50),
    in p_apellido varchar(50),in p_direccion varchar(100),in p_estado int
)
begin
    insert into Clientes values(p_dpi, p_nombre, p_apellido, p_direccion, p_estado);
end$$
delimiter ;

CALL sp_create_Cliente(1001,'Juan','Pérez','Zona 1',1);
CALL sp_create_Cliente(1002,'María','Gómez','Zona 2',1);
CALL sp_create_Cliente(1003,'Carlos','López','Zona 3',1);
CALL sp_create_Cliente(1004,'Ana','Hernández','Zona 4',1);
CALL sp_create_Cliente(1005,'Luis','Martínez','Zona 5',1);
CALL sp_create_Cliente(1006,'Sofía','Ramírez','Zona 6',1);
CALL sp_create_Cliente(1007,'Pedro','Castillo','Zona 7',1);
CALL sp_create_Cliente(1008,'Lucía','Díaz','Zona 8',1);
CALL sp_create_Cliente(1009,'José','Flores','Zona 9',1);
CALL sp_create_Cliente(1010,'Elena','Morales','Zona 10',1);

delimiter $$
create procedure sp_read_all_Clientes()
begin
    select * from Clientes;
end$$
delimiter ;

delimiter $$
create procedure sp_update_Cliente(in p_dpi int,in p_nombre varchar(50),
    in p_apellido varchar(50),in p_direccion varchar(100),in p_estado int
)
begin
    update Clientes
    set nombre_cliente = p_nombre,
        apellido_cliente = p_apellido,
        direccion = p_direccion,
        estado = p_estado
    where dpi_cliente = p_dpi;
end$$
delimiter ;

delimiter $$
create procedure sp_delete_Cliente(in p_dpi int)
begin
    delete from Clientes where dpi_cliente = p_dpi;
end$$
delimiter ;

-- ===== usuarios =====
delimiter $$
create procedure sp_create_Usuario(in p_username varchar(45),
    in p_password varchar(45),in p_email varchar(60),in p_rol varchar(45),in p_estado int
)
begin
    insert into Usuarios (username,password,email,rol,estado) values(p_username, p_password, p_email, p_rol, p_estado);
end$$
delimiter ;

CALL sp_create_Usuario('admin','1234','admin@servicioventas.com','ADMIN',1);
CALL sp_create_Usuario('juan','1234','juan@gmail.com','USER',1);
CALL sp_create_Usuario('maria','1234','maria@gmail.com','USER',1);
CALL sp_create_Usuario('carlos','1234','carlos@gmail.com','USER',1);
CALL sp_create_Usuario('ana','1234','ana@gmail.com','USER',1);
CALL sp_create_Usuario('luis','1234','luis@gmail.com','USER',1);
CALL sp_create_Usuario('sofia','1234','sofia@gmail.com','USER',1);
CALL sp_create_Usuario('pedro','1234','pedro@gmail.com','USER',1);
CALL sp_create_Usuario('lucia','1234','lucia@gmail.com','USER',1);
CALL sp_create_Usuario('elena','1234','elena@gmail.com','USER',1);

delimiter $$
create procedure sp_read_all_Usuarios()
begin
    select * from Usuarios;
end$$
delimiter ;

delimiter $$
create procedure sp_update_Usuario(in p_codigo int,in p_username varchar(45),
    in p_password varchar(45),in p_email varchar(60),in p_rol varchar(45),in p_estado int
)
begin
    update Usuarios
    set username = p_username,
        password = p_password,
        email = p_email,
        rol = p_rol,
        estado = p_estado
    where codigo_usuario = p_codigo;
end$$
delimiter ;

delimiter $$
create procedure sp_delete_Usuario(in p_codigo int)
begin
    delete from Usuarios where codigo_usuario = p_codigo;
end$$
delimiter ;

-- ===== productos =====
delimiter $$
create procedure sp_create_Producto(in p_codigo int,in p_nombre varchar(60),
    in p_precio decimal(10,2),in p_stock int,in p_estado int
)
begin
    insert into Productos values(p_codigo, p_nombre, p_precio, p_stock, p_estado);
end$$
delimiter ;

CALL sp_create_Producto(1,'Laptop',5500.00,10,1);
CALL sp_create_Producto(2,'Mouse',150.00,50,1);
CALL sp_create_Producto(3,'Teclado',250.00,40,1);
CALL sp_create_Producto(4,'Monitor',1200.00,15,1);
CALL sp_create_Producto(5,'Impresora',1800.00,10,1);
CALL sp_create_Producto(6,'USB 32GB',80.00,100,1);
CALL sp_create_Producto(7,'Disco Duro',650.00,25,1);
CALL sp_create_Producto(8,'Audífonos',300.00,60,1);
CALL sp_create_Producto(9,'Tablet',2200.00,20,1);
CALL sp_create_Producto(10,'Silla Gamer',1500.00,12,1);

delimiter $$
create procedure sp_read_all_Productos()
begin
    select * from Productos;
end$$
delimiter ;

delimiter $$
create procedure sp_update_Producto(in p_codigo int,in p_nombre varchar(60),
    in p_precio decimal(10,2),in p_stock int,in p_estado int
)
begin
    update Productos
    set nombre_producto = p_nombre,
        precio = p_precio,
        stock = p_stock,
        estado = p_estado
    where codigo_producto = p_codigo;
end$$
delimiter ;

delimiter $$
create procedure sp_delete_Producto(in p_codigo int)
begin
    delete from Productos where codigo_producto = p_codigo;
end$$
delimiter ;

-- ===== ventas =====
delimiter $$
create procedure sp_create_Venta(in p_codigo int,in p_fecha date,
    in p_total decimal(10,2),in p_estado int,in p_cliente int,in p_usuario int
)
begin
    insert into Ventas values(p_codigo, p_fecha, p_total, p_estado, p_cliente, p_usuario);
end$$
delimiter ;

CALL sp_create_Venta(1,'2026-04-01',5500.00,1,1001,1);
CALL sp_create_Venta(2,'2026-04-02',150.00,1,1002,2);
CALL sp_create_Venta(3,'2026-04-03',250.00,1,1003,3);
CALL sp_create_Venta(4,'2026-04-04',1200.00,1,1004,4);
CALL sp_create_Venta(5,'2026-04-05',1800.00,1,1005,5);
CALL sp_create_Venta(6,'2026-04-06',80.00,1,1006,6);
CALL sp_create_Venta(7,'2026-04-07',650.00,1,1007,7);
CALL sp_create_Venta(8,'2026-04-08',300.00,1,1008,8);
CALL sp_create_Venta(9,'2026-04-09',2200.00,1,1009,9);
CALL sp_create_Venta(10,'2026-04-10',1500.00,1,1010,10);

delimiter $$
create procedure sp_read_all_Ventas()
begin
    select * from Ventas;
end$$
delimiter ;

delimiter $$
create procedure sp_delete_venta(in p_codigo int)
begin
    delete from Ventas where codigo_venta = p_codigo;
end$$
delimiter ;

-- ===== detalle_venta =====
delimiter $$
create procedure sp_create_Detalle_venta(in p_codigo int,in p_cantidad int,
    in p_precio decimal(10,2),in p_subtotal decimal(10,2),in p_producto int,in p_venta int
)
begin
    insert into Detalle_venta values(p_codigo, p_cantidad, p_precio, p_subtotal, p_producto, p_venta);
end$$
delimiter ;

CALL sp_create_Detalle_venta(1,1,5500.00,5500.00,1,1);
CALL sp_create_Detalle_venta(2,1,150.00,150.00,2,2);
CALL sp_create_Detalle_venta(3,1,250.00,250.00,3,3);
CALL sp_create_Detalle_venta(4,1,1200.00,1200.00,4,4);
CALL sp_create_Detalle_venta(5,1,1800.00,1800.00,5,5);
CALL sp_create_Detalle_venta(6,1,80.00,80.00,6,6);
CALL sp_create_Detalle_venta(7,1,650.00,650.00,7,7);
CALL sp_create_Detalle_venta(8,1,300.00,300.00,8,8);
CALL sp_create_Detalle_venta(9,1,2200.00,2200.00,9,9);
CALL sp_create_Detalle_venta(10,1,1500.00,1500.00,10,10);

delimiter $$
create procedure sp_read_all_Detalle_venta()
begin
    select * from Detalle_venta;
end$$
delimiter ;

delimiter $$
create procedure sp_update_Detalle_venta(in p_codigo int,in p_cantidad int,
    in p_precio decimal(10,2),in p_subtotal decimal(10,2),in p_producto int,in p_venta int
)
begin
    update Detalle_venta
    set cantidad = p_cantidad,
        precio_unitario = p_precio,
        subtotal = p_subtotal,
        productos_codigo_producto = p_producto,
        ventas_codigo_venta = p_venta
    where codigo_detalle_venta = p_codigo;
end$$
delimiter ;

delimiter $$
create procedure sp_delete_Detalle_venta(in p_codigo int)
begin
    delete from Detalle_venta where codigo_detalle_venta = p_codigo;
end$$
delimiter ;