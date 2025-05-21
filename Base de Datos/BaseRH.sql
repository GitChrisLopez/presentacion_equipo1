drop database if exists apprh;
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
    estado BOOLEAN,
    nomina FLOAT NOT NULL DEFAULT 0
);

CREATE TABLE candidatos(
	id int auto_increment primary key,
    nombre VARCHAR(100),
    apellidoPaterno VARCHAR(50),
    apellidoMaterno VARCHAR(50),
    telefono VARCHAR(20),
    correo VARCHAR(30),
    puesto VARCHAR(50),
    estado boolean,
	rutapdf text,
    nomina FLOAT NOT NULL DEFAULT 0
);


-- para revisar
select * from reclutadores;
select *from candidatos;

-- para probar datos en las tablas desde la bd, no necesariamente tienen que ejecutar estos
INSERT INTO reclutadores (nombre, apellidoPaterno, apellidoMaterno, puesto, usuario, contrasena, estado, nomina) -- nomina
VALUES 
('Carlos', 'Ramírez', 'López', 'Analista de Reclutamiento', 'cramirez', 'contrasena123', TRUE, 15000.00),
('María', 'González', 'Hernández', 'Jefe de Selección', 'mgonzalez', 'segura456', TRUE, 20000.00);

INSERT INTO reclutadores (nombre, apellidoPaterno, apellidoMaterno, puesto, usuario, contrasena, estado) 
VALUES 
('Lucía', 'Mendoza', 'Ruiz', 'Reclutadora Junior', 'lmendoza', 'clave789', TRUE);

INSERT INTO candidatos (nombre, apellidoPaterno, apellidoMaterno, telefono, correo, puesto, estado, rutapdf, nomina) 
VALUES 
('Laura', 'Sánchez', 'García','(52)2345678', 'LauraS@gmail.com', 'Diseñadora Gráfica', TRUE, 'CVs/laura_sanchez.pdf', 12000.00),
('José', 'Martínez', 'Lopez','(51)24334478', 'JoseM@gmail.com', 'Desarrollador Backend', TRUE, 'CVs/jose_martinez.pdf', 18000.00),
('Ana', 'Pérez', 'Rodríguez','(1)21314478', 'AnaP@gmail.com', 'Marketing Digital', TRUE, 'CVs/ana_perez.pdf', 15000.00),
('Carlos', 'Gomez', 'Lopez','(2)24222278', 'CarlosG@gmail.com','Ingeniero en Software', TRUE, 'CVs/carlos_gomez.pdf', 12000.00),
('Francisco', 'Mercado', 'Franco','(42)567846', 'FranciscoM@gmail.com', 'Contador Público', TRUE, 'CVs/francisco_mercado.pdf', 18000.00),
('Jacqueline', 'Thompson', 'Blue','(58)8589150', 'JacquelineT@gmail.com', 'Marketing Digital', TRUE, 'CVs/jacqueline_thompson.pdf', 15000.00),
('Julian', 'Alonso', 'Barrera','(51)644133223', 'JulianA@gmail.com', 'Abogado', TRUE, 'CVs/julian_alonso.pdf', 17500.00);
