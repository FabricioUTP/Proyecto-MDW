CREATE DATABASE TIENDA;
use TIENDA;

create table formulario (
    id int auto_increment primary key not null,
    nombre varchar(50) not null,
    apellido varchar(50) not null,
    correo varchar(50) unique not null,
    contrasena varchar(50) not null
);

create table comentarios (
    id int auto_increment primary key not null,
    nombre varchar(50) not null,
    correo varchar(50) unique not null,
    comentario text not null,
    fecha datetime default current_timestamp
);

create table login (
	id int auto_increment primary key not null,
    correo varchar(50) unique not null,
    contrasena varchar(50) not null
);

describe formulario;
describe  comentarios;
describe login;

show tables;
select *from formulario;
select * from comentarios;
select * from login;
