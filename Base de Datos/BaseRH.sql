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
    nomina float default(0)
);

CREATE TABLE candidatos(
	id int auto_increment primary key,
    nombre VARCHAR(100),
    apellidoPaterno VARCHAR(50),
    apellidoMaterno VARCHAR(50),
    puesto VARCHAR(50),
    estado boolean,
	rutapdf text,
    nomina float default(0)
);


-- para revisar
-- select *
-- from reclutadores;
-- select *
-- from candidatos;

-- para probar datos en las tablas desde la bd, no necesariamente tienen que ejecutar estos
INSERT INTO reclutadores (nombre, apellidoPaterno, apellidoMaterno, puesto, usuario, contrasena, estado, nomina) -- nomina
VALUES 
('Carlos', 'Ramírez', 'López', 'Analista de Reclutamiento', 'cramirez', 'contrasena123', TRUE, 15000.00),
('María', 'González', 'Hernández', 'Jefe de Selección', 'mgonzalez', 'segura456', TRUE, 20000.00);

INSERT INTO reclutadores (nombre, apellidoPaterno, apellidoMaterno, puesto, usuario, contrasena, estado) 
VALUES 
('Lucía', 'Mendoza', 'Ruiz', 'Reclutadora Junior', 'lmendoza', 'clave789', TRUE);

INSERT INTO candidatos (nombre, apellidoPaterno, apellidoMaterno, puesto, estado, rutapdf, nomina) 
VALUES 
('Laura', 'Sánchez', 'García', 'Diseñadora Gráfica', TRUE, 'CVs/laura_sanchez.pdf', 12000.00),
('José', 'Martínez', 'Lopez', 'Desarrollador Backend', TRUE, 'CVs/jose_martinez.pdf', 18000.00),
('Ana', 'Pérez', 'Rodríguez', 'Marketing Digital', TRUE, 'CVs/ana_perez.pdf', 15000.00),
('Carlos', 'Gomez', 'Lopez', 'Ingeniero en Software', TRUE, 'CVs/carlos_gomez.pdf', 12000.00),
('Francisco', 'Mercado', 'Franco', 'Contador Público', TRUE, 'CVs/francisco_mercado.pdf', 18000.00),
('Jacqueline', 'Thompson', 'Blue', 'Marketing Digital', TRUE, 'CVs/jacqueline_thompson.pdf', 15000.00),
('Julian', 'Alonso', 'Barrera', 'Abogado', TRUE, 'CVs/julian_alonso.pdf', 17500.00);
