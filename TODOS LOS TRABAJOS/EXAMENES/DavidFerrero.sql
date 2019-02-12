SELECT * FROM dembolan;


-- 1 Listado departamentos ordenados por nombre ascendente
SELECT 
	d.nombre as 'nombre departamento',
	d.id as 'id departamento'
FROM departamento AS d 
ORDER BY d.nombre 
ASC limit 100;


-- 2 Listado empresas ordenados por nombre descendente
SELECT
	e.nombre as 'nombre empresa', 
	e.id as 'id empresa'	
FROM empresa AS e 
ORDER BY e.nombre 
DESC limit 100;

-- 3 Listado puesto de trabajo ordenados por identificador descendente
SELECT
	p.nombre as 'Puestos de Trabajo', 
	p.id as 'id puesto'	
FROM puesto AS p 
ORDER BY p.id
DESC limit 100;

-- 4 Total de contratos
SELECT 
COUNT(*) AS 'Total Contratos'
FROM contratos;

-- 5 Listado contratos del año 2018 
SELECT 
	fecha_inicio as 'Contratos año 2018',
    fecha_fin as 'Fecha finalización del contrato',
	id_empleado,
	id_empresa
FROM contratos
WHERE year(fecha_inicio) = 2018;


-- 6 Listado contratos del año 2018 con detalle del empleado y la empresa
SELECT 
	e.id AS 'id empleado',
	e.nombre AS 'nombre empleado',
	e.sueldo AS 'sueldo empleado',
	e.id_puesto AS 'id.puesto',
	p.nombre AS 'puesto',
	e.sueldo AS 'sueldo empleado',
	emp.id AS ' id empresa',
	emp.nombre AS 'nombre empresa',
	fecha_inicio as 'inicio en 2018'
FROM 
	contratos AS c, 
	empleado AS e, empresa AS 
	emp , puesto AS p
WHERE 
	c.id_empresa = emp.id AND
	c.id_empleado = e.id AND 
	e.id_puesto = p.id AND
	year(fecha_inicio) = 2018;
    

-- 7. Listado contratos empleado con identificador 22
SELECT 
	id_empleado,
	id_empresa,
	fecha_inicio,
	fecha_fin
FROM contratos AS c
WHERE  c.id_empleado = 22;


-- 8 Total de contratos por empresa
SELECT 
	c.id_empresa,
	e.nombre AS 'Nombre de empresa',
COUNT(*) AS 'Nº de contratos'
FROM 
	contratos as c, 
	empresa as e
WHERE c.id_empresa = e.id
GROUP BY c.id_empresa;

-- 9 Total sueldos de todos los empleados, también queremos el máximo sueldo, mínimo y la media
SELECT 
	ROUND(SUM(sueldo),2) AS 'Total sueldos',
	MAX(sueldo) AS 'Mayor salario',
	MIN(sueldo) AS 'Menor salario',
	ROUND(AVG(sueldo),2)AS 'media salarios'
FROM empleado;

-- 10 Lo mismo que lo anterior pero ordenado por departamento
SELECT 
	d.nombre AS 'Nombre departamento',
	ROUND(SUM(sueldo),2) AS 'Total sueldos',
	MAX(sueldo) AS 'Mayor salario',
	MIN(sueldo) AS 'Menor salario',
	ROUND(AVG(sueldo),2)AS 'media salarios'
FROM 
	empleado as e, 
	departamento as d
WHERE e.id_departamento= d.id 
GROUP BY e.id_departamento
ORDER BY d.nombre LIMIT 100;


