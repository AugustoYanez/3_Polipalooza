INSERT INTO `Personas` (`nombre`, `apellido`, `fecha_nacimiento`, `celular`)
VALUES ('Nombre1', 'Apellido1', '1990-01-01', '1234567890'),
       ('Nombre2', 'Apellido2', '1995-02-02', '9876543210'),
       ('Nombre3', 'Apellido3', '1995-02-02', '9876543210'),
       ('Nombre4', 'Apellido4', '1995-02-02', '9876543210'),
       ('Nombre5', 'Apellido5', '1995-02-02', '9876543210'),
       ('Nombre6', 'Apellido6', '1995-02-02', '9876543210'),
       ('Nombre7', 'Apellido7', '1995-02-02', '9876543210'),
       ('Nombre8', 'Apellido8', '1995-02-02', '9876543010'),
       ('Nombre9', 'Apellido9', '1995-02-02', '9876543240'),
       ('Nombre10', 'Apellido10', '1995-02-02', '9876545210'),
       ('Nombre11', 'Apellido11', '1995-02-02', '1876543210'),
       ('Nombre12', 'Apellido12', '1995-02-02', '9276543210'),
       ('Nombre13', 'Apellido13', '1995-02-02', '9276543210'),
       ('Nombre14', 'Apellido14', '1995-02-02', '9271543210'),
       ('Nombre15', 'Apellido15', '1995-02-02', '9176543240'),
       ('Nombre16', 'Apellido16', '1995-02-02', '91716543240'),
       ('Nombre17', 'Apellido17', '1995-02-02', '9176523240'),
       ('Nombre18', 'Apellido18', '1995-02-02', '9176541240');
       
INSERT INTO `Artistas` 
VALUES (null,1,'Rock',1),
		(null,2,'Pop',0),
		(null,3,'Reggaeton',0),
		(null,4,'trap',0),
		(null,5,'rock',1),
		(null,6,'trap',1),
		(null,7,'Pop',0);
	

INSERT INTO `Asistentes` 
VALUES (null,8,1,'Ninguno'),
(null,9,1,'Ninguno'),
 (null,10,1,'Ninguno');

INSERT INTO `Canciones`
VALUES (null,1, 'Cancion'),
 (null,2, 'Cancion1'),
 (null,3, 'Cancion2'),
 (null,3, 'Cancion3'),
(null, 4, 'Cancion4');
       
       
INSERT INTO `Escenarios`
VALUES (null,'Riverplate', 10000),
       (null,'Polia arena', 20000),
       (null,'Movistas Arena', 100000);
      
       
       
INSERT INTO `roles` 
VALUES (null,'limpieza'),
	   (null,'Escenografo'),
	   (null,'Audicion');
       
INSERT INTO `PersonalProduccion`
VALUES (null,11, 1),
	   (null,12, 2),
       (null, 13, 3),
       (null,14, 3),
       (null,15, 1),
       (null,16, 1),
       (null,17, 2),
       (null,18, 2);

INSERT INTO `Presentaciones`
VALUES (1, 1, '2023-01-06 11:00:00', '2023-01-06 16:00:00'),
       (1, 2, '2023-01-06 16:00:00', '2023-01-06 20:00:00'),
       (1, 3, '2023-01-06 20:00:00', '2023-01-07 02:00:00'),
       (2, 4, '2023-01-07 11:00:00', '2023-01-07 16:00:00'),
       (2, 5, '2023-01-07 16:00:00', '2023-01-07 20:00:00'),
       (3, 6, '2023-01-08 11:00:00', '2023-01-08 17:00:00'),
       (3, 7, '2023-01-08 17:00:00', '2023-01-09 00:00:00');
INSERT INTO `ProduccionEscenarios` (`escenario_id`, `personal_id`)
VALUES (1, 1),
 (1, 2),
 (1, 3),
 (2, 4),
 (2, 5),
 (2, 6),
 (3, 7),
(3, 8);
