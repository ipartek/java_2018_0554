use dgt;
-- INSERT INTO coche (matricula, modelo, km) VALUES ('', 'NO VALE', 47500);
-- DELETE FROM coche WHERE id = 10;
-- UPDATE coche SET modelo = 'fiat multipla' WHERE id = 7;
-- SELECT * FROM coche;
-- INSERT INTO multa (importe, concepto, id_coche) VALUES (700, 'por empinar codo 8.0', 1);
-- SELECT * FROM multa

-- TOTAL DE MULTAS EN EL 2019
-- SELECT COUNT(*) as total_multas FROM MULTA;
-- LISTADO DE COCHES MULTADOS EN EL 2019
-- SELECT coche.modelo as coches_multados_2019 FROM COCHE INNER JOIN multa on multa.id_coche = coche.id;
-- DETALLE DE TODAS LAS MULTAS DEL COCHE CON MATRICULA '3548MKZ'
-- SELECT concepto FROM multa WHERE id_coche in (SELECT id FROM coche WHERE matricula='3548MKZ');
-- LISTADO DE COCHES CON MAS DE 1000 KM
-- SELECT modelo FROM coche WHERE km > 1000 ORDER BY ID DESC LIMIT 1000;
-- SUMAR EL TOTAL DE KM DE TODOS LOS COCHES
-- SELECT sum(km) AS total_kms_coches FROM coche;
-- SUMAR LOS EUROS RECAUDADOS EN 2019 CON MULTAS
-- SELECT sum(importe) AS total_euros_multas_2019 FROM multa WHERE fecha like '2019%';
-- SELECT COUNT(*) AS total_euros_multas_2019 FROM multa WHERE YEAR(fecha) = 2019;
-- LISTADO DE COCHES CON MAS DE 1 MULTA
-- SELECT modelo as coches_con_mas_de_una_multa FROM coche WHERE id in (SELECT id_coche FROM multa HAVING COUNT(id_coche) > 1);
-- Listado de todos los agentes y las multas que han puesto en el 2019
SELECT agente.id AS ID_Agente, agente.nombre AS Nombre_Agente, 
	   multa.id AS ID_Multa,
       multa.importe AS Importe_Multa, 
       multa.concepto AS Concepto_Multa 
       FROM agente 
       LEFT JOIN multa ON multa.id_agente = agente.id 
       WHERE YEAR(multa.fecha) = 2019 OR fecha IS NULL
       ORDER BY agente.id DESC;


-- SELECT * FROM agente LEFT JOIN multa ON multa.id_agente = agente.id WHERE YEAR(multa.fecha) = 2019 OR fecha IS NULL ORDER BY agente.id DESC;
-- Detalle de multas para coche con matricula = 3548MKZ, nombre y placa del agente (INNER JOIN)
SELECT coche.matricula AS Matricula_Coche,
	   coche.modelo AS Modelo_Coche, 
       multa.importe AS Importe_Multa,
       multa.concepto AS Concepto_Multa,
       agente.nombre AS Nombre_Agente,
       agente.placa AS Placa_Agente 
       FROM coche 
       INNER JOIN multa ON multa.id_coche = coche.id 
       INNER JOIN agente ON multa.id_agente = agente.id
       WHERE coche.matricula='3548MKZ'
       ORDER BY agente.id DESC;
       
       
-- Todos los empleados que tengan departamentos
-- Listado de todos los empleados que no tengan departamento
-- Todos los departamentos que no tengan empleados

