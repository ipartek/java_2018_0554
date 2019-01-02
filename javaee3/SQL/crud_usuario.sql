/* Operaciones de CRUD básicas */

use javaee;

-- getAll
 SELECT id, email, `password` FROM usuario ORDER BY id DESC LIMIT 1000;

-- getByID
 SELECT id, email, `password` FROM usuario WHERE id=1

-- insert
 INSERT INTO usuario (email, `password`) VALUES ("ander@solana.com", "Pa$$w0rd")
 INSERT INTO usuario (email, `password`) VALUES ("daniel@zallo.com", "Pa$$w0rd")
 INSERT INTO usuario (email, `password`) VALUES ("manolo@bombo.com", "Pa$$w0rd")
 INSERT INTO usuario (email, `password`) VALUES ("juan@perez.com", "Pa$$w0rd")
 INSERT INTO usuario (email, `password`) VALUES ("sancho@panza.com", "Pa$$w0rd")

-- delete
 DELETE FROM usuario WHERE id=5;

-- update
 UPDATE usuario SET email = "ander.solana@gmail.com", `password` = "1234Ander." WHERE id=1;

-- login
SELECT id, email, `password` FROM usuario WHERE email="ander.solana@gmail.com" AND `password`="1234Ander."