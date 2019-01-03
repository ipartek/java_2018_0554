-- Operaciones de CRUD básicas

use javaee;

-- getAll

SELECT id, nombre, codigo
FROM video
ORDER BY id DESC
LIMIT 5;

-- getById

SELECT id, nombre, codigo
FROM video
WHERE id = 1
ORDER BY id DESC
LIMIT 5;

-- insert

INSERT INTO `video` (`nombre`, `codigo`) 
VALUES ('', '');

-- delete

DELETE FROM `video` 
WHERE `id` = '';

-- update

UPDATE `video` 
SET `nombre` = '',
`codigo` = ''
WHERE `id` = '';