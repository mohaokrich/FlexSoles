INSERT INTO producto(titulo,descripcion,precio,descuento) VALUES("Blazer MID Unisex","Modelo Blazer Mid color blanco para hombre y mujer",79.95,10);
INSERT INTO producto(titulo,descripcion,precio,descuento) VALUES("Legend Essential 2","Modelo Legend essential 2 color rosa para mujer",47.95,10);
INSERT INTO producto(titulo,descripcion,precio,descuento) VALUES("Force 1 Unisex","Modelo Force 1 color negro para hombre y mujer",0,10);
INSERT INTO producto(titulo,descripcion,precio,descuento) VALUES("Air 1 MID","Modelo Air 1 MID color negro de la gama Jordan",119.95,15);
INSERT INTO producto(titulo,descripcion,precio,descuento) VALUES("MS327","Modelo MS327 color negro y blanco para hombre",89.95,10);
INSERT INTO producto(titulo,descripcion,precio,descuento) VALUES("Chuck Taylor All Star","Modelo Chuck Taylor All Star color blanco, zapatilla alta",67.95,20);
INSERT INTO producto(titulo,descripcion,precio,descuento) VALUES("SK8-HI Unisex","Modelo SK8-HI color blanco y negro para hombre y mujer, zapatilla alta",59.45,20);
INSERT INTO producto(titulo,descripcion,precio,descuento) VALUES("Reebok Classic Legacy","Modelo Rebook Classic Legacy multicolor",71.95,30);

INSERT INTO roles(nombre_rol) VALUES("USER");
INSERT INTO roles(nombre_rol) VALUES("ADMIN");

INSERT INTO usuario_security(nombre, apellidos, rol, email, passwd, fecha_nacimiento) values("chu","david","USER","davidchiskano98@gmail.com","$2a$10$AWwD.180VYMIDyClq9zNjO5C3pdMx5WX93g5GXsFbjh7Fn0cyxPki","1998-01-04"); 
INSERT INTO usuario_security(nombre, apellidos, rol, email, passwd, fecha_nacimiento) values("jamon","jamon","ADMIN","davidchiskano98@gmail.com","david","1998-01-04"); 
INSERT INTO compra(idUsuario, idproducto, unidades) values(1,5,1); 
INSERT INTO compra(idUsuario, idproducto, unidades) values(2,5,1); 