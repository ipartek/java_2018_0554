-- listado vehiculos un liente
SELECT 
	CONCAT(p.nombre," ",p.apellidos) AS 'cliente',
	v.matricula,
	m.nombre AS vehiculo
 FROM
	persona AS p,
	vehiculo AS v,
    modelo AS m
WHERE
 p.id = v.id_propietario
 AND v.id_modelo = m.id
 AND p.id=7;
 
 
 
 -- listado vehiculos con sus reparacuones para un cliente
 SELECT 
	CONCAT(p.nombre," ",p.apellidos) AS 'cliente',
	v.matricula,
	m.nombre AS vehiculo,
    r.precio,
    r.fecha,
    r.descripcion
 FROM
	persona AS p,
	vehiculo AS v,
    modelo AS m,
    reparaciones AS r
WHERE
 p.id = v.id_propietario
 AND v.id_modelo = m.id
 AND r.id_vehiculo = v.id
 AND p.id=7;



-- dinero ingresado por año
SELECT YEAR(r.fecha) AS anio,
ROUND(SUM(precio),2) AS total
FROM reparaciones as r
GROUP BY YEAR(r.fecha)
ORDER BY YEAR(r.fecha) DESC;

-- dinero por cliente 
SELECT 
	p.id,
    p.nombre,
    ROUND(SUM(r.precio),2) AS total
FROM 
	persona AS p,
	vehiculo AS v,
	reparaciones AS r
WHERE p.id = v.id_propietario
AND v.id = r.id_vehiculo
GROUP BY p.id
ORDER BY total DESC;



-- dinero por cliente y año
SELECT 
	YEAR(r.fecha) AS anio,
    p.nombre,
    ROUND(SUM(r.precio),2) AS total
FROM 
	persona AS p,
	vehiculo AS v,
	reparaciones AS r
WHERE p.id = v.id_propietario
AND v.id = r.id_vehiculo
GROUP BY YEAR(r.fecha), p.id
ORDER BY YEAR(r.fecha) DESC, total DESC;



-- Historico reparaciones
SELECT 
	r.id AS 'id_reparacion',
	DATE_FORMAT(r.fecha,'%d/%m/%Y') AS fecha,
    CONCAT(pe.nombre," ",pe.apellidos) AS 'cliente',
	CONCAT(m.nombre,": ",c.nombre) AS 'vehiculo_cliente',
	v.numero_bastidor AS 'bastidor_vehiculo',
    r.precio AS 'precio',
    r.descripcion AS 'observaciones',
    CONCAT(p.nombre," ",p.apellidos," - ",t.nombre) AS 'trabajador'
   
FROM	
    reparaciones AS r,
    persona AS p,
    rol AS t,
    vehiculo AS v,
    modelo AS m, 
    persona AS pe,
    combustible AS c,
    persona_has_rol AS pr
WHERE p.id = r.id_mecanico
	AND v.id = r.id_vehiculo
	AND p.id = pr.id_persona
    AND pr.id_rol = t.id
	AND v.id_modelo = m.id
	AND pe.id = v.id_propietario
    AND v.id_combustible = c.id
ORDER BY r.fecha DESC
LIMIT 500;



-- listado de plantilla
SELECT 
	p.id AS 'id_cliente',
    p.dni AS 'dni',
    CONCAT(p.nombre," ",p.apellidos) AS 'nombre',
    telefono,
    r.nombre
FROM
	persona AS p, 
    rol AS r ,
    persona_has_rol AS pr
WHERE 
	p.id = pr.id_persona
    ANd pr.id_rol = r.id 

ORDER BY r.id
LIMIT 100;


-- listado de plantilla
SELECT 
	p.id AS 'id_cliente',
    p.dni AS 'dni',
    CONCAT(p.nombre," ",p.apellidos) AS 'nombre',
    telefono,
    r.nombre
FROM
	(persona AS p LEFT JOIN persona_has_rol AS pr ON p.id = pr.id_persona )
   INNER JOIN rol AS r  ON pr.id_rol = r.id
ORDER BY r.id
LIMIT 100;

-- dinero ingresado por rol

SELECT 
	SUM(r.precio) AS ingresos,
	t.nombre
FROM	
    reparaciones AS r,
    persona AS p,
    rol AS t,
    vehiculo AS v,
    persona_has_rol AS pr
WHERE p.id = r.id_mecanico
	AND v.id = r.id_vehiculo
	AND p.id = pr.id_persona
    AND pr.id_rol = t.id
GROUP BY t.nombre
ORDER BY ingresos DESC
LIMIT 500;

-- por combustibel cuanto dienro se gastan