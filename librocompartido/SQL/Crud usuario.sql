/* Operaciones de CRUD básicas */

use javaee;

-- getAll 
-- getById
-- insert
-- delete
-- update

-- getAll 
	SELECT id, email, `password` FROM usuario ORDER BY id DESC LIMIT 1000;

-- getById

	SELECT id, email, password from usuario where id=1;

-- insert
	INSERT INTO `usuario` (`email`, `password`) VALUES ('auraga2@ipartek.com','12345678');

-- update
	UPDATE `usuario` SET `email`='auraga2@ipartek.com',`password` ='222'WHERE  `id`=1;

-- delete
	DELETE from usuario where `id`=3;
    
-- login

	SELECT id, email, password FROM  usuario WHERE email='auraga2@ipartek.com' AND `password` ='222';
    
