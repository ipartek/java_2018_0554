SELECT 	p.id AS 'id_persona',  p.nombre AS 'nombre_persona', r.id AS 'id_rol', r.nombre AS 'nombre_rol' FROM persona AS p INNER JOIN persona_has_rol AS pr ON p.id = pr.id_persona INNER JOIN rol AS r ON r.id = pr.id_rol ORDER BY p.id DESC LIMIT 1000;

SELECT p.id as 'id_persona', p.nombre as 'nombre_persona', r.id as 'id_rol', r.nombre as 'nombre_rol', p.dni AS 'dni_persona', p.telefono AS 'telefono_persona' FROM persona as p, persona_has_rol as pr, rol as r WHERE p.id = pr.id_persona AND pr.id_rol = r.id ORDER BY p.id DESC LIMIT 1000;

SELECT v.id AS 'id_vehiculo', v.numero_bastidor AS 'bastidor', v.matricula AS 'matricula', c.nombre AS 'combustible',  m.nombre AS 'modelo' FROM vehiculo AS v, combustible AS c, modelo AS m WHERE v.id_combustible = c.id AND v.id_modelo = m.id AND v.id_propietario =  7;

SELECT id, nombre FROM combustible ORDER BY id DESC;

DELETE FROM combustile WHERE id = 6 ;

SELECT 
	p.id  as 'id_cliente',
    pe.id as 'id_mecanico',
    r.id as 'id_reparacion',
    m.id as 'id_modelo',
    c.id as 'id_combustible',
	p.nombre as 'cliente',
    p.apellidos,
    v.matricula,
    m.nombre as 'modelo',
    c.nombre as 'combustible',
    r.precio,
    r.fecha,
    r.descripcion, 
    pe.nombre as'mecanico'
    FROM 
	persona as p,
    vehiculo as v,
    modelo as m,
    combustible as c,
    reparaciones as r, 
    persona as pe
    WHERE 
    p.id = v.id_propietario AND 
    v.id_modelo = m.id AND
    v.id = r.id_vehiculo AND
    pe.id = r.id_mecanico AND
    v.id_combustible = c.id AND
	p.id = 7;  
