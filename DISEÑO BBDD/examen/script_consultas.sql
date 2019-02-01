
-- listado de todos los clientes
SELECT 
	p.id AS 'id_cliente',
    p.dni AS 'dni',
    CONCAT(p.nombre," ",p.apellidos) AS 'nombre',
    telefono
FROM
	persona AS p, 
    tipo AS t  
WHERE 
	p.tipo_id = t.id
AND p.tipo_id = 1
ORDER BY dni
LIMIT 500;



-- listado trabajadores
SELECT 
	p.id AS 'id_cliente',
    p.dni AS 'dni',
    CONCAT(p.nombre," ",p.apellidos) AS 'nombre',
    telefono,
    t.nombre
FROM
	persona AS p, 
    tipo AS t  
WHERE 
	p.tipo_id = t.id
AND p.tipo_id <> 1
ORDER BY t.id
LIMIT 100;
	


-- Historico reparaciones
SELECT 
	r.id AS 'id_reparacion',
	DATE_FORMAT(r.fecha,'%d/%m/%Y') AS fecha,
    CONCAT(pe.nombre," ",pe.apellidos) AS 'cliente',
	CONCAT(m.nombre,": ",c.nombre) AS 'vehiculo_cliente',
	v.numero_bastidor AS 'bastidor_vehiculo',
    r.precio AS 'precio',
    r.observaciones AS 'observaciones',
    CONCAT(p.nombre," ",p.apellidos," - ",t.nombre) AS 'trabajador'
   
FROM	
    reparacion AS r,
    persona AS p,
    tipo AS t,
    vehiculo AS v,
    modelo AS m, 
    persona AS pe,
    combustible AS c
WHERE p.id = r.trabajador_persona_id
	AND v.id = r.vehiculo_id
	AND p.tipo_id = t.id
	AND v.modelo_id = m.id
	AND pe.id = v.persona_id
    AND v.combustible_id = c.id
ORDER BY r.fecha DESC
LIMIT 500;




-- cuantas reparaciones por trabajador y año
SELECT 
	COUNT(r.trabajador_persona_id) AS 'total',
    YEAR(r.fecha) AS 'anio',
	CONCAT(p.nombre," ",p.apellidos) AS 'trabajador',
    t.nombre AS 'puesto'
    
FROM 
	reparacion AS r,
    persona AS p,
    tipo AS t
WHERE r.trabajador_persona_id = p.id
AND t.id = p.tipo_id
AND p.tipo_id <> 1
GROUP BY r.trabajador_persona_id, YEAR(r.fecha)
ORDER BY YEAR(r.fecha) DESC
LIMIT 100;


