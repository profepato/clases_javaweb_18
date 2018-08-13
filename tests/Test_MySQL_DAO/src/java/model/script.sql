CREATE DATABASE bd_votos;

USE bd_votos;

CREATE TABLE sistema_operativo(
    id INT AUTO_INCREMENT,
    nombre VARCHAR(100),
    PRIMARY KEY(id)
);

INSERT INTO sistema_operativo VALUES(NULL, 'Linux');
INSERT INTO sistema_operativo VALUES(NULL, 'Windows');
INSERT INTO sistema_operativo VALUES(NULL, 'Mac OS');
INSERT INTO sistema_operativo VALUES(NULL, 'Solaris');

SELECT * FROM sistema_operativo;

CREATE TABLE voto(
    id INT AUTO_INCREMENT,
    fk_sistema_operativo INT,
    fecha DATETIME,
    PRIMARY KEY(id),
    FOREIGN KEY(fk_sistema_operativo) REFERENCES sistema_operativo(id)
);

SELECT * FROM voto;

/*Listado de votos contados*/
CREATE VIEW contarVotos AS
SELECT 
    so.nombre AS 'Sistema Operativo',
    COUNT(v.fk_sistema_operativo) AS 'Cantidad'
FROM 
    sistema_operativo so
    INNER JOIN voto v ON so.id = v.fk_sistema_operativo
GROUP BY 
    so.nombre
ORDER BY
    COUNT(v.fk_sistema_operativo) DESC;


SELECT * FROM contarVotos;