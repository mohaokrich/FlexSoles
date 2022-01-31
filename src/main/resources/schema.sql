DROP DATABASE IF EXISTS FlexSoles;
CREATE DATABASE FlexSoles;
USE FlexSoles;

/*AÑADIR TABLAS productoS*/
CREATE TABLE IF NOT EXISTS producto(
	 id bigint not null primary key auto_increment,
	 titulo varchar(50) not null,
	 descripcion varchar(200) not null,
	 precio double not null,
	 descuento int not null);
/*AÑADIR TABLAS USUARIOS , compra */
CREATE TABLE IF NOT EXISTS roles(
	 id bigint not null primary key auto_increment,
	 nombre_rol varchar(20) not null);

CREATE TABLE IF NOT EXISTS usuario_rol(
	 id bigint not null primary key auto_increment,
	 idUsuario bigint not null,
	 FOREIGN KEY (id) REFERENCES roles(id));
     

CREATE TABLE IF NOT EXISTS usuario_security(
	 id bigint not null primary key auto_increment,
	 nombre varchar(40) not null unique,
	 apellidos varchar(60) not null,
	 rol varchar(100),
	 email varchar(60) not null,
	 passwd varchar(100) not null,
	 fecha_nacimiento varchar(80) not null);
CREATE TABLE IF NOT EXISTS compra(
	  id bigint not null primary key auto_increment,
	  idUsuario bigint not null,
	  idproducto bigint not null,
	  unidades int not null,
	  FOREIGN KEY (idUsuario) REFERENCES usuario_security(id),
	  FOREIGN KEY(idproducto) REFERENCES producto(id));

/*TABLAS INTERMEDIAS HIBERNATE*/

CREATE TABLE IF NOT EXISTS compra_producto(
	id bigint not null primary key auto_increment primary key,
    idCompra bigint not null,
    idproducto bigint not null,
    unidades int not null,
    FOREIGN KEY (idCompra) REFERENCES compra(id),
    FOREIGN KEY (idproducto) REFERENCES producto(id)
);

CREATE TABLE IF NOT EXISTS compra_producto_id(
	idCompra bigint not null,
	idproducto bigint not null,
    FOREIGN KEY (IdCompra) REFERENCES compra_producto(idCompra),
    FOREIGN KEY (Idproducto) REFERENCES compra_producto(idproducto)
);




/*MODIFICAR TABLAS*/

/*ALTER TABLE compra ADD FOREIGN KEY(idUsuario) REFERENCES usuario_security(id);*/
ALTER TABLE usuario_rol ADD FOREIGN KEY(id) REFERENCES usuario_security(id);


/*DATOS*/





