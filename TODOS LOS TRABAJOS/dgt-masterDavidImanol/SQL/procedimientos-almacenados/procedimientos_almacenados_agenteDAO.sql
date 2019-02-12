 
-- AGENTE DAO GET BY ID --

CREATE DEFINER=`root`@`localhost` PROCEDURE `agente_getById`( 
IN p_id LONG )
BEGIN    
SELECT id, nombre, placa, id_departamento FROM agente WHERE id = p_id;
END


-- AGENTE DAO MULTAS ACTIVAS --

CREATE DEFINER=`root`@`localhost` PROCEDURE `agente_getMultas`( 
IN  p_id LONG)
BEGIN
SELECT m.id AS 'id_multa', c.id AS 'id_coche',fecha, importe, concepto, matricula, modelo,km FROM agente AS a, multa AS m, coche AS c WHERE a.id=m.id_agente AND m.id_coche=c.id AND a.id=p_id AND m.fecha_baja IS NULL ORDER BY m.fecha DESC;
END


-- AGENTE DAO MULTAS ANULADAS --

CREATE DEFINER=`root`@`localhost` PROCEDURE `agente_getMultasAnuladas`( 
IN  p_id LONG)
BEGIN
SELECT m.id AS 'id_multa', c.id AS 'id_coche',fecha, importe, concepto, matricula, modelo,km FROM agente AS a, multa AS m, coche AS c WHERE a.id=m.id_agente AND m.id_coche=c.id AND a.id=p_id AND m.fecha_baja IS NOT NULL ORDER BY m.fecha DESC ;
END