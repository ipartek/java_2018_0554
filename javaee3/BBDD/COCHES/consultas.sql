
/*TOTAL DE MULTAS EN EL AÑO 2019*/
SELECT COUNT(*) AS 'TOTAL_MULTAS_2019' FROM multa WHERE fecha > '2019-01-01 00:00:00';
SELECT COUNT(*) AS 'TOTAL MULTAS 2019' FROM multa WHERE year(fecha) = 2019;

/*LISTADO DE COCHES MULTADOS EN EL 2019*/
SELECT coche.modelo  FROM coche, multa where coche.id=multa.id_coche AND fecha > '2019-01-01 00:00:00';
SELECT coche.modelo  FROM coche, multa where coche.id=multa.id_coche AND year(fecha) = 2019;


/*DETALLE DE TODAS LAS MULTAS DEL COCHE COn MATRICULA '3548MKZ'*/
SELECT * FROM multa, coche where coche.id=multa.id_coche AND coche.matricula='3548MKZ';
SELECT multa.id, multa.importe, multa.fecha, coche.matricula FROM multa, coche where coche.id=multa.id_coche AND coche.matricula='3548MKZ';


/*LISTADO DE TOSO LOS COCHES COH MAS DE 1000KM*/
SELECT * FROM coche where km>1000;


-- SUMAR EL TOTAL DE KM DE TODOS LOS COCHES
SELECT SUM(coche.km) AS 'KM_TOTALES' FROM coche;


-- SUMAR LOS EUROS RECAUDADOS EN 2019
SELECT SUM(multa.importe) AS 'EUROS_2019' FROM multa WHERE fecha > '2019-01-01 00:00:00';
 SELECT SUM(multa.importe) AS 'EUROS_2019' FROM multa WHERE year(fecha) = 2019;



-- LISTADO DE COCHES CON MAS DE UNA MULTA
SELECT DISTINCT coche.modelo, COUNT(*) AS 'n_veces_multado' FROM multa, coche
WHERE multa.id_coche=coche.id
GROUP BY multa.id_coche
HAVING COUNT(*)>1