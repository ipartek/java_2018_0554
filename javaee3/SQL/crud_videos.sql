-- SELECT * FROM javaee.video;

-- SELECT* FROM video v INNER JOIN  usuario u ON u.id=v.id_usuario;

USE javaee;

SELECT v.id AS 'id_video',
		u.id AS 'id_usuario',
        nombre,
        codigo,
        email,
        `password`
FROM video AS v INNER JOIN usuario AS u ON u.id = v.id_usuario
ORDER BY v.id DESC LIMIT 1000;        

SELECT v.id AS 'id_video', v.id, v.nombre, v.codigo FROM video AS v , usuario AS u WHERE v.id_usuario = u.id AND  v.id= ?;

INSERT INTO `javaee`.`video` (`nombre`, `codigo`,`id_usuario`) VALUES ( 'Rage - Refuge', 'd0_vu4biME8', 2);

DELETE FROM `javaee`.`video` WHERE `id`=7;

UPDATE `javaee`.`video` SET `nombre` = 'Bruce Dickinson - Tears of The Dragon', `codigo`='vXClBjNxiOA', `id_usuario` = 2 WHERE (`id` = 4);