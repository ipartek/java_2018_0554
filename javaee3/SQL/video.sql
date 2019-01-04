use javaee;
-- GET ALL Listado de videos con detalle usuario
SELECT 
	v.id AS idVideo, 
    u.id AS idUsuario,
    v.nombre,
    v.codigo,
    u.email, 
    u.`password` 
FROM video AS v INNER JOIN usuario AS u ON v.id_usuario = u.id WHERE u.id = 1 
ORDER BY v.id LIMIT 100;
-- GET BY ID detalle video 1
SELECT v.id as id_video,u.id as id_usuario,v.nombre,v.codigo,u.email,u.password FROM video AS v INNER JOIN usuario AS u ON v.id_usuario = u.id WHERE v.id=1;
Select v.id as id_video,u.id as id_usuario,v.nombre,v.codigo,u.email,u.password FROM video AS v INNER JOIN usuario AS u ON v.id_usuario = u.id order by v.id desc limit 100;

-- INSERTAR
INSERT INTO video (nombre,codigo,id_usuario) VALUES("Equipo de Inverigacion: Pedales de competicion","34BvIt-gHSA",1);
-- DELETE
DELETE FROM video WHERE id=8;
-- UPDATE
UPDATE video SET nombre="Madrid Riders", codigo="CN5gedYFGja", id_usuario=10 WHERE id=2;