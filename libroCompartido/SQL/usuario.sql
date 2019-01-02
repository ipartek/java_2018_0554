/*Operaciones de CRUD basicas*/
use javaee;
-- getAll
SELECT id, email, `password` FROM usuario ORDER BY id DESC LIMIT 1000;

-- getById
SELECT id, email, `password` FROM usuario where id =1;

-- insert
-- INSERT INTO usuario (email,`password`) VALUES('danielzallo@gmail.com', 'Daniel1234.');

-- update
UPDATE usuario SET email='danielZallo@gmail.com', `password`='222' WHERE id=1;

-- delete
DELETE FROM usuario WHERE id=1;

-- login
Select id, email,`password` from usuario where email='danielzallo@gmail.com' AND `password`='222';
