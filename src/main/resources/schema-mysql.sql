DROP DATABASE IF EXISTS FlexSoles;
CREATE DATABASE IF NOT EXISTS FlexSoles;
USE FlexSoles;

CREATE TABLE IF NOT EXISTS producto(
	 id bigint not null primary key auto_increment,
	 titulo varchar(50) not null,
	 descripcion varchar(200) not null,
	 precio double not null,
	 descuento int not null);
	 

CREATE TABLE IF NOT EXISTS roles(
	 id bigint not null primary key auto_increment,
	 nombre_rol varchar(20) not null);
 

CREATE TABLE IF NOT EXISTS usuario_security(
	 id bigint not null primary key auto_increment,
	 nombre varchar(40) not null unique,
	 apellidos varchar(60) not null,
	 rol varchar(20),
	 email varchar(60) not null,
	 passwd varchar(100) not null,
	 fecha_nacimiento varchar(80) not null);
	 
CREATE TABLE IF NOT EXISTS usuario_rol(
	 id bigint not null, 
	 id_usuario bigint not null,
     primary key(id, id_usuario),
	 FOREIGN KEY (id) REFERENCES roles(id),
     FOREIGN KEY(id_usuario) REFERENCES usuario_security(id));


CREATE TABLE IF NOT EXISTS compra(
	  id bigint not null primary key auto_increment,
	  id_usuario bigint not null,
	  FOREIGN KEY (id_usuario) REFERENCES usuario_security(id)
	  );

CREATE TABLE IF NOT EXISTS compra_producto(
	id bigint not null primary key auto_increment,
    id_compra bigint not null,
    id_producto bigint not null,
    unidades int not null,
    FOREIGN KEY (id_compra) REFERENCES compra(id),
    FOREIGN KEY (id_producto) REFERENCES producto(id)
);


CREATE TABLE IF NOT EXISTS pregunta(
	id bigint not null primary key auto_increment,
	pregunta varchar(300) not null,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    id_producto bigint not null,
    id_usuario bigint not null,
    FOREIGN KEY(id_producto) REFERENCES producto(id),
	FOREIGN KEY(id_usuario) REFERENCES usuario_security(id)
);

CREATE TABLE IF NOT EXISTS respuesta(
	id_respuesta bigint not null primary key auto_increment,
	respuesta varchar(400) not null,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
	id_pregunta bigint not null,
    id_usuario bigint not null,
	FOREIGN KEY (id_pregunta) REFERENCES pregunta(id),
    FOREIGN KEY(id_usuario) REFERENCES usuario_security(id)
);

CREATE TABLE IF NOT EXISTS producto_imagen(
	id bigint not null auto_increment primary key,
	nombre varchar(40),
	imagen LONGBLOB NOT NULL,
    id_producto bigint,
	FOREIGN KEY (id_producto) REFERENCES producto(id)
);




CREATE TABLE SPRING_SESSION (
  PRIMARY_ID char(36) NOT NULL,
  SESSION_ID char(36) NOT NULL,
  CREATION_TIME bigint NOT NULL,
  LAST_ACCESS_TIME bigint NOT NULL,
  MAX_INACTIVE_INTERVAL int NOT NULL,
  EXPIRY_TIME bigint NOT NULL,
  PRINCIPAL_NAME varchar(100) DEFAULT NULL,
  PRIMARY KEY (PRIMARY_ID),
  UNIQUE KEY SPRING_SESSION_IX1 (SESSION_ID),
  KEY SPRING_SESSION_IX2 (EXPIRY_TIME),
  KEY SPRING_SESSION_IX3 (PRINCIPAL_NAME)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;


CREATE TABLE SPRING_SESSION_ATTRIBUTES (
  SESSION_PRIMARY_ID char(36) NOT NULL,
  ATTRIBUTE_NAME varchar(200) NOT NULL,
  ATTRIBUTE_BYTES blob NOT NULL,
  PRIMARY KEY (SESSION_PRIMARY_ID,ATTRIBUTE_NAME),
  CONSTRAINT SPRING_SESSION_ATTRIBUTES_FK FOREIGN KEY (SESSION_PRIMARY_ID) REFERENCES SPRING_SESSION (PRIMARY_ID) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;




