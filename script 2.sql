
INSERT INTO `polipalooza`.`Personas` (`nombre`, `apellido`, `fecha_nacimiento`, `celular`)
VALUES ('Nombre3', 'Apellido3', '1990-01-01', '1234567890'),
       ('Nombre4', 'Apellido4', '1995-02-02', '9876543210');
INSERT INTO `polipalooza`.`Artistas` (`persona_id`, `genero_musical`, `es_destacado`)
VALUES (1, 'Rock', 1),
       (2, 'Pop', 0);
INSERT INTO `polipalooza`.`Asistentes` (`persona_id`, `es_vip`, `requerimiento_especial`)
VALUES (1, 1, 'Ninguno'),
       (2, 0, 'Alergia al maní');
INSERT INTO `polipalooza`.`Canciones` (`cancion_id`, `artista_id`, `nombre_cancion`)
VALUES (1, 1, 'Cancion1'),
       (2, 2, 'Cancion2');
INSERT INTO `polipalooza`.`Escenarios` (`nombre`, `capacidad_maxima`)
VALUES ('Escenario1', 1000),
       ('Escenario2', 2000);
INSERT INTO `polipalooza`.`roles` (`nombreRol`)
VALUES ('Rol1'),
       ('Rol2');
INSERT INTO `polipalooza`.`PersonalProduccion` (`persona_id`, `roles_rol`)
VALUES (3, 3),
       (4, 4);
INSERT INTO `polipalooza`.`Presentaciones` (`presentacion_id`, `escenario_id`, `artista_id`, `horario_inicio`, `horario_fin`)
VALUES (1, 1, 1, '2023-01-01 10:00:00', '2023-01-01 12:00:00'),
       (2, 2, 2, '2023-01-02 14:00:00', '2023-01-02 16:00:00');
INSERT INTO `polipalooza`.`ProduccionEscenarios` (`escenario_id`, `personal_id`)
VALUES (1, 1),
       (2, 2);
