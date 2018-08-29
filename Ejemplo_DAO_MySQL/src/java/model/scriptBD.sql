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

SELECT * FROM cliente;
SELECT * FROM producto;

DROP DATABASE bd_prueba_DAO;