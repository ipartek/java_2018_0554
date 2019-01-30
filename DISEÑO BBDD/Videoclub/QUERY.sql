
-- peliculas alquiladas
SELECT 
	ca.id AS 'id_stock',
	p.nombre AS 'nombre_pelicula',
	ca.fecha_alquiler AS ' fecha_alquiler',
	c.nombre AS 'nombre_cliente',
	c.apellidos AS 'apellido_cliente'
FROM
	pelicula AS p,
	cliente AS c,
	cliente_alquila_stock AS ca
WHERE p.id = ca.pelicula_id
AND c.id = ca.cliente_id
ORDER BY ca.fecha_alquiler
LIMIT 500;


--  clientes que no hayn alquila pelicula en el año actual

SELECT 
	c.nombre AS 'nombre_cliente'
FROM
	cliente AS c,
	cliente_alquila_stock AS ca
WHERE c.id = ca.cliente_id
AND YEAR(ca.fecha_alquiler) < YEAR(now());


SELECT 
	c.nombre AS 'nombre_cliente'
FROM
	cliente AS c LEFT JOIN cliente_alquila_stock AS ca ON c.id = ca.cliente_id;
    
    
    
-- peliculas en Stock  detalle

SELECT 
	s.id AS 'id_stock',
	p.id AS 'id_pelicula',
    p.nombre AS 'nombre_pelicula'
FROM
	pelicula AS p,
	stock AS s
WHERE p.id = s.pelicula_id
ORDER BY s.id LIMIT 500;


-- Resumen Peliculas en Stock

SELECT 
	p.id AS 'id_pelicula',
	COUNT(s.id) AS 'total',
    p.nombre AS 'nombre_pelicula'
FROM
	pelicula AS p,
	stock AS s
WHERE p.id = s.pelicula_id
GROUP BY p.id
ORDER BY s.id LIMIT 500;


-- Peliculas mas alquiladas 

-- Peliculas nunca alquiladas

SELECT * 
FROM 
	pelicula AS p LEFT  JOIN cliente_alquila_stock As ca 
    ON p.id =  ca.pelicula_id
WHERE ca.pelicula_id is null;
    



-- detalle pelicula con Director y Actores
SELECT
	p.nombre AS 'nombre_pelicula',
    d.nombre AS 'director',
    a.nombre AS 'nombre_actor'
    
FROM
	pelicula AS p,
    director AS d,
    pelicula_has_actor AS pa,
    actor as a
WHERE
	p.director_id = d.id
AND
    p.id = pa.pelicula_id
AND
    pa.actor_id = a.id
LIMIT 500;
    
    






