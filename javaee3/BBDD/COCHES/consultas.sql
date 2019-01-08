-- SUMAR EL TOTAL DE KM DE TODOS LOS COCHES
SELECT SUM(coche.km) AS 'KM_TOTALES' FROM coche ;


-- SUMAR LOS EUROS RECAUDADOS EN 2019
SELECT SUM(multa.importe) AS 'EUROS_2019' FROM multa WHERE fecha > '2019-01-01 00:00:00';
 SELECT SUM(multa.importe) AS 'EUROS_2019' FROM multa WHERE year(fecha) = 2019;



-- LISTADO DE COCHES CON MAS DE UNA MULTA
SELECT DISTINCT coche.modelo, COUNT(*) AS 'n_veces_multado' 
FROM multa, coche
WHERE multa.id_coche=coche.id
GROUP BY multa.id_coche
HAVING COUNT(multa.id_coche)>1;



-- LISTADO DE TODOS LOS AGENTES  Y LAS MULTAS DEL 2019
--solo estoy sacando los agentes que ha puesto multas
SELECT DISTINCT agente.nombre, COUNT(multa.id) as 'contaje'
FROM multa, agente
WHERE  multa.id_agente(+) = agente.id
AND year(fecha) = 2019
GROUP BY  agente.id
ORDER by contaje DESC;

SELECT * 
FROM agente left join multa 
ON agente.id= multa.id_agente
WHERE YEAR(fecha) Or fecha is null;





SELECT multa.concepto, coche.modelo, agente.nombre
FROM multa, coche, agente
where coche.id=multa.id_coche 
AND agente.id = multa.id_agente
AND coche.matricula='3548MKZ';






-- DETALLE MULTA y DEPARTAMENTO y AGENTE IMPLICITO

SELECT
	a.id AS 'id_agente',
	d.id AS 'id_departamento',
	m.id AS 'id_multa',
	c.id AS 'id_coche',
	a.nombre AS 'nombre',
	d.nombre AS 'nombre_departamento',
	m.concepto AS 'conepto_multa',
	m.importe AS 'importe_multa',
	c.matricula AS 'matricula',
	c.modelo AS 'modelo'
FROM 
	agente AS a, 
    departamento AS d, 
    multa AS m, 
    coche AS c
WHERE 
	a.id_departamento=d.id 
	AND a.id=m.id_agente
	AND c.id=m.id_coche;




-- JOIN EXPLICITA
SELECT
	a.id AS 'id_agente',
	d.id AS 'id_departamento',
	m.id AS 'id_multa',
	c.id AS 'id_coche',
	a.nombre AS 'nombre',
	d.nombre AS 'nombre_departamento',
	m.concepto AS 'conepto_multa',
	m.importe AS 'importe_multa',
	c.matricula AS 'matricula',
	c.modelo AS 'modelo'
FROM 
	agente AS a 
	INNER JOIN departamento AS d ON a.id_departamento=d.id 
	INNER JOIN multa AS m ON a.id=m.id_agente
	INNER JOIN coche AS c ON c.id=m.id_coche;



