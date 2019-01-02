/*Operaciones de CRUD básicas*/


use javaee;

-- getAll
SELECT id, email, `password` FROM usuario ORDER BY id DESC LIMIT 1000;


-- insert

INSERT INTO `javaee`.`usuario` (`email`, `password`) VALUES ( 'xabier@ipartek.com', 'Pa$$w0rd');


SELECT id, email, `password` FROM usuario ORDER BY id DESC LIMIT 1000;

INSERT INTO `javaee`.`usuario` (`email`, `password`) VALUES ( 'david@ipartek.com', 'SuPa$$w0rd');

-- getById
SELECT id, email, `password` FROM usuario WHERE id=1;


-- update
UPDATE `javaee`.`usuario` SET `email` = 'usuarioupdate@ipartek.com' WHERE (`id` = '1');

UPDATE `javaee`.`usuario` SET `password` = 'davidPa$$word' WHERE (`id` = '3');

-- delete

DELETE FROM `usuario` WHERE `id`=3;

-- login

SELECT id, email, `password` FROM usuario WHERE email= 'usuarioupdate@ipartek.com' AND `password`= 123456;
