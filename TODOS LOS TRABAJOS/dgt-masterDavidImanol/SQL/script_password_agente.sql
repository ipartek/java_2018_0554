ALTER TABLE `dgt`.`agente` 
ADD COLUMN `password` VARCHAR(145) NOT NULL AFTER `id_departamento`;

UPDATE `dgt`.`agente` SET `password` = '123456' WHERE (`id` = '1');

UPDATE `dgt`.`agente` SET `password` = '123456' WHERE (`id` = '2');

UPDATE `dgt`.`agente` SET `password` = '123456' WHERE (`id` = '3');

UPDATE `dgt`.`agente` SET `password` = '123456' WHERE (`id` = '4');

UPDATE `dgt`.`agente` SET `password` = '123456' WHERE (`id` = '5');
