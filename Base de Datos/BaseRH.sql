CREATE DATABASE apprh;
USE apprh;

CREATE TABLE reclutadores (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100),
    apellidoPaterno VARCHAR(50),
    apellidoMaterno VARCHAR(50),
    puesto VARCHAR(50),
    usuario VARCHAR(50) UNIQUE,
    contrasena VARCHAR(100),
    estado BOOLEAN
);

CREATE TABLE candidatos(
	id int auto_increment primary key,
    nombre VARCHAR(100),
    apellidoPaterno VARCHAR(50),
    apellidoMaterno VARCHAR(50),
    telefono varchar(10),
    correo varchar(50),
    puesto VARCHAR(50),
    estado boolean,
	rutapdf text,
    nomina float default(0)
);


