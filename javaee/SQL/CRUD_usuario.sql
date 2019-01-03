/* Operaciones de CRUD básicas */

use javaee;

-- getAll
SELECT id, email, `password` FROM usuario ORDER BY id DESC LIMIT 1000;

-- getById
SELECT id, email, `password` FROM usuario WHERE id = 1;

-- insert
INSERT INTO `usuario` (`email`, `password`) VALUES ('amaia@delolmo.com', '123456');

-- update
UPDATE `usuario` SET `email`='amaia@delolmo.com', `password`='123456' WHERE `id`='1';

-- delete
DELETE FROM `usuario` WHERE `id` = '3';

-- login
SELECT id, email, `password` FROM usuario WHERE email='amaia@delolmo.com' AND `password`='123456';