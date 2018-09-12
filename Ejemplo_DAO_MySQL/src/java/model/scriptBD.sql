CREATE DATABASE bd_prueba_DAO;
USE bd_prueba_DAO;

CREATE TABLE cliente(
    id CHAR(38),
    nombre VARCHAR(100),
    direccion VARCHAR(100),
    PRIMARY KEY(id)
);

CREATE TABLE producto(
    id CHAR(38),
    nombre VARCHAR(100),
    stock INT,
    precio INT,
    PRIMARY KEY(id)
);

CREATE TABLE usuario(
    id INT AUTO_INCREMENT,
    rut VARCHAR(12),
    nombre VARCHAR(100),
    PRIMARY KEY(id)
);

INSERT INTO usuario VALUES(NULL, '11-1', 'Josesito Chiquitito');

SELECT * FROM cliente;
SELECT * FROM producto;
SELECT * FROM usuario;

DROP DATABASE bd_prueba_DAO;