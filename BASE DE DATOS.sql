CREATE DATABASE TIENDA;
use TIENDA;
-- tabla del formulario de regstro
create table formulario (
    id int auto_increment primary key,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    correo varchar(100) not null unique,
    contrasena varchar(255) not null
);

-- la tabla de aca es de comentarios de la parte de contacto
create table comentarios (
    id int auto_increment primary key,
    nombre varchar(100) not null,
    correo varchar(100) not null,
    comentario text not null,
    fecha datetime default current_timestamp
);




show tables;

describe formulario;
describe  comentarios;

SELECT * FROM formulario;
SELECT * FROM comentarios;