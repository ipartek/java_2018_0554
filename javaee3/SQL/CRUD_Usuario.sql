-- Operaciones de CRUD básicas

use javaee;

-- getAll

SELECT id, email, `password`
FROM usuario
ORDER BY id DESC
LIMIT 5;

-- getById

SELECT id, email, `password`
FROM usuario
WHERE id = 1
ORDER BY id DESC
LIMIT 5;

-- insert

INSERT INTO `usuario` (`email`, `password`) 
VALUES ('Hector@Serrano.com', 'Qw3rt1');

-- delete

DELETE FROM `usuario` 
WHERE (`id` = '1');

-- update

UPDATE `usuario` 
SET `email` = 'Hector@Hector.com',
`password` = '222'
WHERE (`id` = '3');

-- login 

SELECT id, email, `password`
FROM usuario
WHERE email = ''
AND `password` = '';