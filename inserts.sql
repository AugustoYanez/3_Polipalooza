INSERT INTO `Personas` (`nombre`, `apellido`, `fecha_nacimiento`, `celular`)
VALUES ('Nombre1', 'Apellido1', '1990-01-01', '1234567890'),
       ('Nombre2', 'Apellido2', '1995-02-02', '9876543210'),
       ('Nombre3', 'Apellido3', '1995-02-02', '9876543210'),
       ('Nombre4', 'Apellido4', '1995-02-02', '9876543210'),
       ('Nombre5', 'Apellido5', '1995-02-02', '9876543210'),
       ('Nombre6', 'Apellido6', '1995-02-02', '9876543210'),
       ('Nombre7', 'Apellido7', '1995-02-02', '9876543210'),
       ('Nombre8', 'Apellido8', '1995-02-02', '9876543210');
INSERT INTO `Artistas` 
VALUES (null,1,'Rock',1),
		(null,2,'Pop',0);

INSERT INTO `Asistentes` 
VALUES (null,3,1,'Ninguno');

INSERT INTO `Canciones`
VALUES (null,1, 'Cancion1'),
       (null, 2, 'Cancion2');
INSERT INTO `Escenarios`
VALUES (null,'Escenario1', 1000),
       (null,'Escenario2', 2000);
       
       
INSERT INTO `roles` 
VALUES (null,'Rol1'),
	   (null,'Rol2'),
	   (null,'Rol3');
INSERT INTO `PersonalProduccion`
VALUES (null,4, 1),
	   (null,5, 2),
       (null,6, 3),
       (null,7, 3),
       (null,8, 2);

INSERT INTO `Presentaciones`
VALUES (1, 1, '2023-01-01 10:00:00', '2023-01-01 12:00:00'),
       (2, 2, '2023-01-02 14:00:00', '2023-01-02 16:00:00');
INSERT INTO `ProduccionEscenarios` (`escenario_id`, `personal_id`)
VALUES (1, 1),
       (2, 2);
