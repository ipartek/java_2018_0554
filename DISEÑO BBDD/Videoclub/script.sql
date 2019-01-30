
-- peliculas alquiladas
--  1      sombras de grey     29/01/2019     Mari Mari
--  2      sombras de grey     28/01/2019     Pepe 
--  5      Rambo               17/01/2018     Pepe

SELECT 
	ca.id AS 'id_stock',
	p.nombre AS 'nombre_pelicula',
    DATE_FORMAT(ca.fecha_alquiler,'%d/%m/%Y')AS ' fecha_alquiler',
	CONCAT(c.nombre," ",c.apellidos) AS 'nombre_apellido'
    
FROM
	pelicula AS p,
	cliente AS c,
	cliente_alquila_stock AS ca
WHERE p.id = ca.pelicula_id
AND c.id = ca.cliente_id
ORDER BY ca.fecha_alquiler DESC
LIMIT 500;



--  clientes que no hayn alquila pelicula en el año actual CASI
SELECT 
	 *
FROM
	cliente AS c LEFT JOIN cliente_alquila_stock AS ca ON c.id = ca.cliente_id
group by c.nombre
HAVING
	MAX(YEAR(ca.fecha_alquiler) )< YEAR(now())
OR ca.cliente_id is null
;
    
--  clientes que no hayn alquila pelicula en el año actual OK

SELECT  
	  c.nombre AS 'nombre',
      c.apellidos AS 'apellidos',
      c.dni AS 'DNI',
      c.telefono AS 'telefono',
      MAX( ca.fecha_alquiler ) AS 'ultimo_alquiler'
FROM
	cliente AS c LEFT JOIN cliente_alquila_stock AS ca ON c.id = ca.cliente_id
WHERE c.id IN ( 
				SELECT c.id 
				FROM
					cliente AS c LEFT JOIN cliente_alquila_stock AS ca ON c.id = ca.cliente_id
				group by c.nombre
				HAVING
					MAX(YEAR(ca.fecha_alquiler) )< YEAR(now())
				OR ca.cliente_id is null
				)
GROUP BY c.nombre
ORDER BY c.nombre ASC
LIMIT 100;

    
-- peliculas en Stock  detalle
-- id_stock  id_pelicula     nombre
-- 1           1           sombras de grey 
-- 2           1           sombras de grey 
-- 3           1           sombras de grey 
-- 4           2           Jurasic Park
-- 5           3           Rambo 
-- 6           2           Jurasic Park

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
-- id_pelicula  total   nombre
-- 1             3       sombras de grey 
-- 2             2       Jurasic Park
-- 3             1       Rambo 

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
SELECT 
	COUNT(s.pelicula_id) AS 'total',
	p.nombre AS 'nombre_pelicula'
	
FROM 
	stock AS s,
    pelicula AS p
WHERE
	p.id = s.pelicula_id
GROUP BY
	s.pelicula_id
ORDER BY total DESC
LIMIT 100;

-- Peliculas nunca alquiladas

SELECT 
	p.nombre AS 'nombre_pelicula',
    d.nombre AS ' director',
    c.nombre AS 'categoria'
FROM 
	categoria AS c INNER JOIN pelicula AS p ON c.id = p.categoria_id 
    INNER JOIN director AS d ON d.id = p.director_id
    LEFT  JOIN cliente_alquila_stock As ca ON p.id =  ca.pelicula_id
WHERE ca.pelicula_id is null
ORDER BY nombre_pelicula ASC
LIMIT 100;
    



-- detalle pelicula con Director y Actores

-- Jango  Tarantino  Jimi fox
-- Jango  Tarantino  jensel guasinton
-- Jango  Tarantino  riki martin
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
    
    
-- detalle pelicula con Director y Actores
-- Jango  Tarantino  "Jimi fox, jensel guasinton, riki martin"
SELECT
	p.nombre AS 'nombre_pelicula',
    d.nombre AS 'director',
    GROUP_CONCAT(a.nombre) AS 'nombre_actor'
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
GROUP BY p.nombre
LIMIT 500;




