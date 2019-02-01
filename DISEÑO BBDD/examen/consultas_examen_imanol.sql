-- listado de reparaciones este año, plantilla del taller, etc



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
	r.id,
	DATE_FORMAT(r.fecha,'%d/%m/%Y') AS fecha,
    CONCAT(pe.nombre," ",pe.apellidos) AS 'cliente',
    r.precio,
    r.observaciones,
    CONCAT(p.nombre," ",p.apellidos," ",t.nombre) AS 'trabajador'
FROM	
    reparacion AS r,
    persona AS p,
    tipo AS t,
    vehiculo AS v,
    modelo AS m, 
    persona AS pe
WHERE p.id = r.trabajador_persona_id
	AND v.id = r.vehiculo_id
	AND p.tipo_id = t.id
	AND v.modelo_id = m.id
	AND pe.id = v.persona_id
ORDER BY r.fecha DESC
LIMIT 500;








