

-- estadisticas del total empleados,  toal sueldos, total comosiones, min, max, avg => sueldos para todos los empleados
SELECT 
	COUNT(*) AS 'total_empleados',
	SUM(salario) AS 'total_sueldos',
	SUM(comision) AS 'total_cominiones',
	MIN(salario) AS 'minimo_salario',
	MAX(salario) AS 'maximo_salario',
	ROUND(AVG(salario),2) AS 'media_salario'
FROM empleado;

-- lo mismo agrupado por departamento
SELECT 
	id_departamento AS 'id_departamento',
    d.nombre AS 'nombre_departemento',
	COUNT(*) AS 'total_empleados',
	SUM(salario) AS 'total_sueldos',
	SUM(comision) AS 'total_cominiones',
	MIN(salario) AS 'minimo_salario',
	MAX(salario) AS 'maximo_salario',
	ROUND(AVG(salario),2) AS 'media_salario'
FROM 
	empleado AS e, 
	departamento AS d
WHERE 
	e.id_departamento = d.id
GROUP BY 
	id_departamento;

-- lo mismo agrupado por departamento, pero empleados con antiguedad > 3 años
SELECT 
	COUNT(*) AS 'total_empleados',
	SUM(salario) AS 'total_sueldos',
	SUM(comision) AS 'total_cominiones',
	MIN(salario) AS 'minimo_salario',
	MAX(salario) AS 'maximo_salario',
	ROUND(AVG(salario),2) AS 'media_salario'
FROM empleado;

-- lo mismo agrupado por departamento
SELECT 
	id_departamento AS 'id_departamento',
    d.nombre AS 'nombre_departemento',
	COUNT(*) AS 'total_empleados',
	SUM(salario) AS 'total_sueldos',
	SUM(comision) AS 'total_cominiones',
	MIN(salario) AS 'minimo_salario',
	MAX(salario) AS 'maximo_salario',
	ROUND(AVG(salario),2) AS 'media_salario'
FROM 
	empleado AS e, 
	departamento AS d
WHERE 
	e.id_departamento = d.id
AND 
	(YEAR(now())- YEAR(fecha_contrato)) > 3
GROUP BY 
	id_departamento;



-- contar numero empleados con salario minimo
SELECT COUNT(*) as total
FROM empleado AS e
WHERE salario = 900;


-- contar numero empleados con salario minimo por departamento
SELECT 
	id_departamento AS 'id_departamento',
	d.nombre AS 'nombre_departemento',
	COUNT(*) as total
FROM 
	empleado AS e, 
	departamento AS d
WHERE 
	e.id_departamento = d.id
AND 
	salario = 900
GROUP BY 
	id_departamento;




-- detalle empleados del departamento Oficina = 38 ordenados por puesto de trabajo
SELECT 
	e.id AS 'empleado_id', 
	e.id_puesto AS 'id_puesto',
    d.id AS 'id_departamento',
    e.nombre AS 'empleado_nombre',
    d.nombre AS 'departamento_nombre',
    j.nombre AS 'nombre_jefe',
    e.fecha_contrato AS 'fecha_contrato', 
    e.salario AS 'empleado_salario', 
    e.comision AS 'empleado_comision', 
    p.nombre  AS 'empleado_nombre'
    
FROM 
	empleado AS e,
    empleado AS j,
    departamento AS d,
    puesto AS p
WHERE e.id_departamento=d.id
AND e.id_puesto = p.id
AND j.id=e.id_jefe
AND e.id_departamento=38
ORDER BY e.id_puesto ASC;



-- detalle empleados del departamento Oficina = 38 ordenados por salario
SELECT 
	e.id AS 'empleado_id', 
	e.id_puesto AS 'id_puesto',
    d.id AS 'id_departamento',
    e.nombre AS 'empleado_nombre',
    d.nombre AS 'departamento_nombre',
    j.nombre AS 'nombre_jefe',
    e.fecha_contrato AS 'fecha_contrato', 
    e.salario AS 'empleado_salario', 
    e.comision AS 'empleado_comision', 
    p.nombre  AS 'empleado_nombre'
    
FROM 
	empleado AS e,
    empleado AS j,
    departamento AS d,
    puesto AS p
WHERE e.id_departamento=d.id
AND e.id_puesto = p.id
AND j.id=e.id_jefe
AND e.id_departamento=38
ORDER BY e.salario ASC;

-- detalle empleados del departamento Oficina = 38 ordenados por fecha contrato
SELECT 
	e.id AS 'empleado_id', 
	e.id_puesto AS 'id_puesto',
    d.id AS 'id_departamento',
    e.nombre AS 'empleado_nombre',
    d.nombre AS 'departamento_nombre',
    j.nombre AS 'nombre_jefe',
    e.fecha_contrato AS 'fecha_contrato', 
    e.salario AS 'empleado_salario', 
    e.comision AS 'empleado_comision', 
    p.nombre  AS 'empleado_nombre'
FROM 
	empleado AS e,
    empleado AS j,
    departamento AS d,
    puesto AS p
WHERE e.id_departamento=d.id
AND e.id_puesto = p.id
AND j.id=e.id_jefe
AND e.id_departamento=38
ORDER BY e.fecha_contrato DESC;
-- no se me ocuure mas, vosotros mismos

