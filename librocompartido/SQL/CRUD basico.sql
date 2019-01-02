/* CRUD basico*/
use javaee;

-- getAll

SELECT id, email, `password` FROM usuario ORDER BY id DESC LIMIT 1000;

-- getById
SELECT id, email, `password` FROM usuario WHERE id= 3;

-- nuevalinea
INSERT INTO usuario (email, `password`) VALUES ('uno@uno,com', '123456');
-- borrar
DELETE FROM usuario WHERE id=1;
-- actualizar
UPDATE usuario SET email="otro@otro.com", `password`="cambiando" WHERE id=1;

-- login
SELECT FROM usuario WHERE email="uno@uno.com" and `password`='1234';