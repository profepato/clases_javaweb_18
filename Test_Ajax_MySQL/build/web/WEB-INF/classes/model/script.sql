CREATE DATABASE bd_regiones;

USE bd_regiones;

CREATE TABLE region(
    id INT AUTO_INCREMENT,
    nombre VARCHAR(100),
    PRIMARY KEY(id)
);

INSERT INTO region VALUES(NULL, 'I Región - Tarapacá');
INSERT INTO region VALUES(NULL, 'II Región - Antofagasta');
INSERT INTO region VALUES(NULL, 'III Región - Atacama');

CREATE TABLE ciudad(
    id INT AUTO_INCREMENT,
    nombre VARCHAR(100),
    fk_region INT,
    PRIMARY KEY(id),
    FOREIGN KEY(fk_region) REFERENCES region(id)
);

/*3 ciudades de la primera región*/
INSERT INTO ciudad VALUES(NULL, 'Iquique', 1);
INSERT INTO ciudad VALUES(NULL, 'Alto Hospicio', 1);
INSERT INTO ciudad VALUES(NULL, 'Pozo Almonte', 1);

/*4 ciudades de la segunda región*/
INSERT INTO ciudad VALUES(NULL, 'Tocopilla', 2);
INSERT INTO ciudad VALUES(NULL, 'Mejillones', 2);
INSERT INTO ciudad VALUES(NULL, 'Taltal', 2);
INSERT INTO ciudad VALUES(NULL, 'Sierra Gorda', 2);

/*5 ciudades de la tercera región*/
INSERT INTO ciudad VALUES(NULL, 'Copiapó', 3);
INSERT INTO ciudad VALUES(NULL, 'Caldera', 3);
INSERT INTO ciudad VALUES(NULL, 'Vallenar', 3);
INSERT INTO ciudad VALUES(NULL, 'Huasco', 3);
INSERT INTO ciudad VALUES(NULL, 'Chañaral', 3);

SELECT * FROM region;
SELECT * FROM ciudad;

SELECT region.nombre, ciudad.nombre
FROM ciudad , region
WHERE ciudad.fk_region = region.id;

SELECT region.nombre, ciudad.nombre
FROM ciudad 
INNER JOIN region
ON ciudad.fk_region = region.id;

/*Listado de ciudades por región*/
