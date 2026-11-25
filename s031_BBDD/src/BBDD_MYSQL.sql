CREATE DATABASE IF NOT EXISTS BBDD_MYSQL;
USE BBDD_MYSQL;

-- Elimina las tablas para poder volver a ejecutar el script desde cero.
DROP TABLE IF EXISTS Pedidos;
DROP TABLE IF EXISTS Curso;
DROP TABLE IF EXISTS Platos;
DROP TABLE IF EXISTS Alumnos;
DROP TABLE IF EXISTS Clientes;
DROP TABLE IF EXISTS Empresa;
DROP TABLE IF EXISTS CentroEducativo;
DROP TABLE IF EXISTS tienda;
DROP TABLE IF EXISTS biblioteca;

CREATE TABLE biblioteca (
    id_libro INT PRIMARY KEY AUTO_INCREMENT,
    titulo VARCHAR(100) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    editorial VARCHAR(100),
    anio INT NOT NULL,
    disponible BOOLEAN
);

INSERT INTO biblioteca (titulo, autor, editorial, anio, disponible)
VALUES
    ('El Quijote', 'Cervantes', 'Anaya', 1605, 1),
    ('Cien años de soledad', 'García Márquez', 'Sudamericana', 1967, 1),
    ('La sombra del viento', 'Carlos Ruiz Zafón', 'Planeta', 2001, 0),
    ('El principito', 'Saint-Exupéry', 'Salamandra', 1943, 1),
    ('1984', 'George Orwell', 'Destino', 1949, 0);

CREATE TABLE tienda (
    id_producto INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    categoria VARCHAR(50),
    precio DECIMAL(10,2),
    stock INT
);

INSERT INTO tienda (nombre, categoria, precio, stock)
VALUES
    ('Ratón', 'Informática', 15.50, 20),
    ('Teclado', 'Informática', 25.90, 15),
    ('Monitor', 'Informática', 180, 8),
    ('Auriculares', 'Audio', 35, 12),
    ('Altavoces', 'Audio', 45, 5);

CREATE TABLE CentroEducativo (
    id_alumno INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    edad INT NOT NULL,
    curso VARCHAR(50),
    nota DECIMAL(4,2)
);

INSERT INTO CentroEducativo (nombre, apellidos, edad, curso, nota)
VALUES
    ('Ana', 'López García', 20, 'DAM', 8.5),
    ('Pedro', 'Martín Ruiz', 22, 'DAW', 6.5),
    ('Laura', 'Sánchez Díaz', 19, 'DAM', 9),
    ('Carlos', 'Pérez Gómez', 21, 'ASIR', 5),
    ('Marta', 'Fernández León', 20, 'DAW', 7.5);

CREATE TABLE Empresa (
    id_empleado INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    departamento VARCHAR(50),
    salario DECIMAL(10,2),
    edad INT NOT NULL,
    ciudad VARCHAR(50)
);

INSERT INTO Empresa (nombre, departamento, salario, edad, ciudad)
VALUES
    ('Antonio', 'Informática', 1800, 30, 'Sevilla'),
    ('María', 'Administración', 1500, 25, 'Málaga'),
    ('Juan', 'Informática', 2200, 35, 'Sevilla'),
    ('Elena', 'Marketing', 1700, 28, 'Cádiz'),
    ('David', 'Administración', 1600, 40, 'Córdoba');

CREATE TABLE Clientes (
    id_cliente INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    telefono VARCHAR(15),
    email VARCHAR(100),
    ciudad VARCHAR(50)
);

INSERT INTO Clientes (nombre, apellidos, telefono, email, ciudad)
VALUES
    ('Ana', 'López', '600111222', 'ana@gmail.com', 'Sevilla'),
    ('Pedro', 'Martín', '600222333', 'pedro@gmail.com', 'Málaga'),
    ('Laura', 'Sánchez', '600333444', 'laura@gmail.com', 'Sevilla'),
    ('Carlos', 'Pérez', '600444555', 'carlos@gmail.com', 'Cádiz'),
    ('Marta', 'Fernández', '600555666', 'marta@gmail.com', 'Córdoba');

CREATE TABLE Alumnos (
    id_alumno INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    apellidos VARCHAR(100) NOT NULL,
    edad INT
);

INSERT INTO Alumnos (nombre, apellidos, edad)
VALUES
    ('Ana', 'López', 20),
    ('Pedro', 'Martín', 22),
    ('Laura', 'Sánchez', 19);

CREATE TABLE Curso (
    id_curso INT PRIMARY KEY AUTO_INCREMENT,
    nombre_curso VARCHAR(100),
    duracion INT,
    precio DECIMAL(10,2),
    id_alumno INT
);

INSERT INTO Curso (nombre_curso, duracion, precio, id_alumno)
VALUES
    ('Java', 100, 250, 1),
    ('MySQL', 80, 200, 2),
    ('Python', 120, 300, 3);

CREATE TABLE Platos (
    id_plato INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100),
    categoria VARCHAR(50),
    precio DECIMAL(10,2)
);

CREATE TABLE Pedidos (
    id_pedido INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE,
    cantidad INT,
    id_plato INT,
    FOREIGN KEY (id_plato) REFERENCES Platos(id_plato)
);

INSERT INTO Platos (nombre, categoria, precio)
VALUES
    ('Paella', 'Arroz', 12.00),
    ('Pizza', 'Italiano', 10.00),
    ('Hamburguesa', 'Carne', 9.00),
    ('Ensalada', 'Vegetal', 7.00),
    ('Pasta', 'Italiano', 11.00);

INSERT INTO Pedidos (fecha, cantidad, id_plato)
VALUES
    ('2026-01-10', 2, 1),
    ('2026-01-10', 1, 2),
    ('2026-01-11', 3, 3),
    ('2026-01-12', 2, 4),
    ('2026-01-12', 1, 5);

