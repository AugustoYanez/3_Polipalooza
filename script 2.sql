
/*insert into Personas values(null, NULL, NULL, NULL, NULL);
insert into Personas values(null, NULL, NULL, NULL, NULL);
insert into Personas values(null, NULL, NULL, NULL, NULL);
insert into Personas values(null, NULL, NULL, NULL, NULL);
insert into Personas values(null, NULL, NULL, NULL, NULL);
insert into Personas values(null, NULL, NULL, NULL, NULL);
insert into Personas values(null, NULL, NULL, NULL, NULL);
insert into Personas values(null, NULL, NULL, NULL, NULL);

insert into Artistas values(1, 3, "pop", 1);
insert into Artistas values(2, 4, "cumbia", 1);
insert into Artistas values(3, 5, "rock", 0);
insert into Artistas values(4, 6, "rock", 0);
insert into Artistas values(5, 7, "rock", 1);

insert into roles values(null,'iluminacion');
insert into roles values(null,'sonido');
insert into roles values(null,'tecnico');

insert into PersonalProduccion values(0, 2, 0);
insert into PersonalProduccion values(1, 3, 1);
insert into PersonalProduccion values(2, 4, 2);

insert into Escenarios values(0, null, null);
insert into Escenarios values(1, null, null);

insert into Presentaciones values();
insert into Presentaciones values();

insert into ProduccionEscenarios values(0, 0);
insert into ProduccionEscenarios values(0, 1);
insert into ProduccionEscenarios values(0, 2);
*/
INSERT INTO `Polipalooza`.`Personas` (`nombre`, `apellido`, `fecha_nacimiento`, `celular`)
VALUES ('Nombre1', 'Apellido1', '1990-01-01', '1234567890'),
       ('Nombre2', 'Apellido2', '1995-02-02', '9876543210');
INSERT INTO `Polipalooza`.`Artistas` (`persona_id`, `genero_musical`, `es_destacado`)
VALUES (1, 'Rock', 1),
       (2, 'Pop', 0);
INSERT INTO `Polipalooza`.`Asistentes` (`persona_id`, `es_vip`, `requerimiento_especial`)
VALUES (1, 1, 'Ninguno'),
       (2, 0, 'Alergia al maní');
INSERT INTO `Polipalooza`.`Canciones` (`cancion_id`, `artista_id`, `nombre_cancion`)
VALUES (1, 1, 'Cancion1'),
       (2, 2, 'Cancion2');
INSERT INTO `Polipalooza`.`Escenarios` (`nombre`, `capacidad_maxima`)
VALUES ('Escenario1', 1000),
       ('Escenario2', 2000);
INSERT INTO `Polipalooza`.`roles` (`nombreRol`)
VALUES ('Rol1'),
       ('Rol2');
INSERT INTO `Polipalooza`.`PersonalProduccion` (`persona_id`, `roles_rol`)
VALUES (1, 1),
       (2, 2);
INSERT INTO `Polipalooza`.`Presentaciones` (`presentacion_id`, `escenario_id`, `artista_id`, `horario_inicio`, `horario_fin`)
VALUES (1, 1, 1, '2023-01-01 10:00:00', '2023-01-01 12:00:00'),
       (2, 2, 2, '2023-01-02 14:00:00', '2023-01-02 16:00:00');
INSERT INTO `Polipalooza`.`ProduccionEscenarios` (`escenario_id`, `personal_id`)
VALUES (1, 1),
       (2, 2);
