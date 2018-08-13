CREATE DATABASE votos_os;

USE votos_os;

CREATE TABLE sistema_operativo(
    id CHAR(38), 
    nombre VARCHAR(100),
    PRIMARY KEY(id)
);

INSERT INTO sistema_operativo VALUES(UUID(), 'Linux');
INSERT INTO sistema_operativo VALUES(UUID(), 'Windows');
INSERT INTO sistema_operativo VALUES(UUID(), 'Mac OS');
INSERT INTO sistema_operativo VALUES(UUID(), 'Solaris');
INSERT INTO sistema_operativo VALUES(UUID(), 'Android');
INSERT INTO sistema_operativo VALUES(UUID(), 'Symbian');

SELECT * FROM sistema_operativo;

CREATE TABLE voto(
    id CHAR(38),    
    fk_sistema_operativo CHAR(38),
    fecha DATETIME,
    PRIMARY KEY(id),
    FOREIGN KEY(fk_sistema_operativo) REFERENCES sistema_operativo(id)
);

SELECT * FROM voto;

/*1.- Contar votos*/
CREATE VIEW conteoVotos AS
SELECT 
    so.nombre 'Sistema Operativo',
    COUNT(v.fk_sistema_operativo) 'Votos'
FROM
    sistema_operativo so
INNER JOIN voto v ON so.id = v.fk_sistema_operativo
GROUP BY so.nombre
ORDER BY COUNT(v.fk_sistema_operativo) DESC;

SELECT * FROM conteoVotos;

