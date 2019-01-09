SELECT * FROM multas;
SELECT COUNT(*) FROM dgt.multa;
SELECT COUNT(*) AS 'total_multas_2019' FROM multa WHERE YEAR(fecha)=2019;

-- FUNCIONES AGREGACION
SELECT 
 COUNT(*) AS 'total_2019',
 MIN(importe) AS 'min',
 MAX(importe) AS 'max',
 AVG(importe) AS empleado'avg',
 SUM(importe) AS 'sum' 
 FROM multa 
 WHERE YEAR(fecha)=2019;
 
 -- TOTAL MULTAS AGRUPADO POR AGENTE
 SELECT 
 COUNT(*) AS 'total_2019',
 MIN(importe) AS 'min',
 MAX(importe) AS 'max',
 ROUND(AVG(importe),2) AS 'avg',
 SUM(importe) AS 'sum' 
 FROM multa 
 WHERE YEAR(fecha)=2019
 GROUP BY id_agente;
 
 --  Multas por año ascendente
 SELECT 
 YEAR(fecha) AS 'fecha',
 COUNT(*) AS 'total_2019',
 MIN(importe) AS 'min',
 MAX(importe) AS 'max',
 AVG(importe) AS 'avg',
 SUM(importe) AS 'sum' 
 FROM multa 
 GROUP BY YEAR(fecha)=2019
 ORDER BY fecha ASC;