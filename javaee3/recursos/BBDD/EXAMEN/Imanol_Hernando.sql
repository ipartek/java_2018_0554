

-- Listado departamentos ordenados por nombre ascendente
SELECT 
	d.id AS 'id_departamento',
    d.nombre AS 'nombre_departamento'
FROM departamento AS d
ORDER BY nombre ASC
LIMIT 500;



-- Listado empresas ordenados por nombre descendente
SELECT 
	e.id AS 'id_empresa',
    e.nombre AS 'nombre_empresa'
FROM empresa AS e
ORDER BY nombre DESC
LIMIT 500;



-- Listado puesto de trabajo ordenados por identificador descendente
SELECT 
	p.id AS 'id_puesto',
    p.nombre AS 'nombre_puesto'
FROM puesto AS p
ORDER BY p.id DESC
LIMIT 500;



-- Total de contratos
SELECT 
	COUNT(*) AS 'total_contratos'
FROM contratos;



-- Listado contratos del año 2018 

SELECT 

	c.fecha_inicio AS 'fecha_inicio',
    c.fecha_fin AS 'fecha_fin',	
    e.nombre AS 'nombre_empleado',
    p.nombre AS 'nombre_puesto',
    d.nombre AS 'nombre_departamento',
    e.sueldo AS 'sueldo_empleado',
    em.nombre AS 'nombre_empresa',
    e.id AS 'id_empleado',
    em.id AS 'id_empresa',
	d.id AS 'id_departamento',
    p.id AS 'id_puesto'
   
FROM 
	contratos AS c,
    empleado AS e,
    empresa AS em,
    puesto AS p,
    departamento AS d
WHERE 
	c.id_empleado= e.id
	AND c.id_empresa = em.id
    AND e.id_puesto=p.id
    AND e.id_departamento = d.id
	AND YEAR(fecha_inicio) = 2018
ORDER BY fecha_inicio ASC
LIMIT 500;



-- Listado contratos del año 2018 con detalle del empleado y la empresa
SELECT 
	c.fecha_inicio AS 'fecha_inicio',
    c.fecha_fin AS 'fecha_fin',
    e.nombre AS 'nombre_empleado',
    p.nombre AS 'nombre_puesto',
    d.nombre AS 'nombre_departamento',
    e.sueldo AS 'sueldo_empleado',
    em.nombre AS 'nombre_empresa',
    e.id AS 'id_empleado',
    em.id AS 'id_empresa',
	d.id AS 'id_departamento',
    p.id AS 'id_puesto'
FROM 
	contratos AS c,
    empleado AS e,
    empresa AS em,
    puesto AS p,
    departamento AS d
WHERE 
	c.id_empleado= e.id
	AND c.id_empresa = em.id
    AND e.id_puesto=p.id
    AND e.id_departamento = d.id
	AND YEAR(fecha_inicio) = 2018
ORDER BY fecha_inicio ASC
LIMIT 500;


-- Listado contratos empleado con identificador 22
SELECT 
	c.fecha_inicio AS 'fecha_inicio',
    c.fecha_fin AS 'fecha_fin',
    e.nombre AS 'nombre_empleado',
    p.nombre AS 'nombre_puesto',
    d.nombre AS 'nombre_departamento',
    e.sueldo AS 'sueldo_empleado',
    em.nombre AS 'nombre_empresa',
    e.id AS 'id_empleado',
    em.id AS 'id_empresa',
	d.id AS 'id_departamento',
    p.id AS 'id_puesto'
FROM 
	contratos AS c,
    empleado AS e,
    empresa AS em,
    puesto AS p,
    departamento AS d
WHERE 
	c.id_empleado= e.id
	AND c.id_empresa = em.id
    AND e.id_puesto=p.id
    AND e.id_departamento = d.id
	AND e.id=22
ORDER BY fecha_inicio ASC
LIMIT 500;


-- Total de contratos por empresa
SELECT 
	c.id_empresa AS 'id_empresa',
    e.nombre AS 'nombre_empresa',
	COUNT(*) AS 'total_contratos_empresa'
FROM 
	empresa AS e,
	contratos AS c
WHERE
	e.id = c.id_empresa
GROUP BY id_empresa;


-- Total sueldos de todos los empleados, también queremos el máximo sueldo, mínimo y la media
SELECT
	ROUND(SUM(sueldo),2) AS 'total_sueldo_empleados',
    ROUND(MAX(sueldo),2) AS 'maximo_sueldo_empleados',
	ROUND(MIN(sueldo),2) AS 'minimo_sueldo_empleados',
    ROUND(AVG(sueldo),2) AS 'media_sueldo_empleados'
FROM empleado;


-- Lo mismo que lo anterior pero ordenado por departamento
SELECT
    d.nombre AS 'nombre_departamento',
	ROUND(SUM(sueldo),2) AS 'total_sueldo_empleados',
    ROUND(MAX(sueldo),2) AS 'maximo_sueldo_empleados',
	ROUND(MIN(sueldo),2) AS 'minimo_sueldo_empleados',
    ROUND(AVG(sueldo),2) AS 'media_sueldo_empleados',
	id_departamento AS 'id_departamento'
FROM 
	empleado AS e,
	departamento AS d
WHERE 
	e.id_departamento = d.id
GROUP BY id_departamento
ORDER BY d.nombre
LIMIT 100;