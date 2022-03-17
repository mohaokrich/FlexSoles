DROP TABLE IF EXISTS compra_producto;
DROP TABLE IF EXISTS producto_imagen;
DROP TABLE IF EXISTS producto;
DROP TABLE IF EXISTS compra;
DROP TABLE IF EXISTS usuario_rol;
DROP TABLE IF EXISTS roles;
DROP TABLE IF EXISTS usuario_security;


CREATE TABLE IF NOT EXISTS producto(
	 id SERIAL not null primary key,
	 titulo text not null,
	 descripcion text not null,
	 precio decimal not null,
	 descuento int not null);
	 

CREATE TABLE IF NOT EXISTS roles(
	 id SERIAL not null primary key,
	 nombre_rol text not null);
 

CREATE TABLE IF NOT EXISTS usuario_security(
	 id SERIAL not null primary key,
	 nombre text not null unique,
	 apellidos text not null,
	 rol text,
	 email text not null,
	 passwd text not null,
	 fecha_nacimiento text not null);
	 
CREATE TABLE IF NOT EXISTS usuario_rol(
	 id SERIAL not null, 
	 id_usuario SERIAL not null,
     primary key(id, id_usuario),
	 FOREIGN KEY (id) REFERENCES roles(id),
     FOREIGN KEY(id_usuario) REFERENCES usuario_security(id));


CREATE TABLE IF NOT EXISTS compra(
	  id SERIAL not null primary key,
	  id_usuario SERIAL not null,
	  FOREIGN KEY (id_usuario) REFERENCES usuario_security(id)
	  );

CREATE TABLE IF NOT EXISTS compra_producto(
	id SERIAL not null primary key,
    id_compra SERIAL not null,
    id_producto SERIAL not null,
    unidades int not null,
    FOREIGN KEY (id_compra) REFERENCES compra(id),
    FOREIGN KEY (id_producto) REFERENCES producto(id)
);

CREATE TABLE IF NOT EXISTS producto_imagen(
	id SERIAL not null primary key,
	nombre text,
	imagen bytea NOT NULL,
    id_producto SERIAL,
	FOREIGN KEY (id_producto) REFERENCES producto(id)
);



