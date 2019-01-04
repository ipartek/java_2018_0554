--/* operaciones de CRUD basicas */
--
--use javaee;
--
---- getAll
--SELECT id,email, password FROM usuario ORDER BY id DESC LIMIT 1000;
--
---- getById
--SELECT id,email, password FROM usuario WHERE id = 1;
--
---- insert
--INSERT INTO `usuario` (`email`, `password`) VALUES ('auraga2@ipartek.com', '12345678');
--
--
---- update
--UPDATE `usuario` SET `email`='auraga@ipartek.com', `password`='222' WHERE `id`=1;
--
--
---- delete
--DELETE FROM `usuario` WHERE  `id`=3;
--
---- login
--SELECT id,email, password FROM usuario WHERE email='auraga@ipartek.com' AND `password`='222';


use javaee;
SELECT * from video;

 -- Listado de videos con detalle de usuario
SELECT v.id as 'id_video', u.id as 'id_usuario', nombre, codigo, email, password FROM video as v INNER JOIN usuario as u ON u.id=v.id_usuario;       

-- getbyid
SELECT  id, nombre, codigo, id_usuario from video WHERE id=1; 

-- getall

SELECT  nombre, codigo, v.id as 'id_video' from video as v INNER JOIN usuario ON v.id_usuario = usuario.id;
-- delete
DELETE id, nombre, codigo, id_usuario from video where id=1;
-- update
-- UPDATE video SET nombre="prueba2" WHERE id=1;

-- insert

INSERT INTO `video` VALUES ('2', 'prueba1', 'TiCxqhu9cin', '2');