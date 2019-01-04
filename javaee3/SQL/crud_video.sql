/*GET BY ID*/
SELECT 
v.id AS 'video_id', v.titulo AS 'video_titulo', v.codigo AS 'video_codigo',
u.id AS 'usuario_id',  u.email AS 'usuario_email' , u.password  AS 'usuario_pass'
FROM video as v, usuario as u 
WHERE v.id_usuario = u.id AND v.id= ?;"

/*GET ALL*/
SELECT v.id AS 'video_id', v.titulo AS 'video_titulo', v.codigo AS 'video_codigo',
u.id AS 'usuario_id',  u.email AS 'usuario_email' , u.password  AS 'usuario_pass'
FROM video as v, usuario as u 
WHERE v.id_usuario = u.id ;


/*DELETE*/
DELETE FROM video WHERE id = '5';


/*UPDATE*/
UPDATE video 
SET id = '44', titulo = '44', codigo = '44444444444', id_usuario = '1' 
WHERE id = '12';


/*INSERT*/
INSERT INTO video (id, titulo, codigo, id_usuario) 
VALUES ('4', 'Video', '12345678901', '1');


/* SQL_GET_ALL_BY_NOMBRE */
 SELECT id, titulo, codigo FROM video WHERE titulo LIKE ? ORDER BY titulo ASC LIMIT 500;