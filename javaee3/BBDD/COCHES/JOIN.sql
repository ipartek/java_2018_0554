SELECT * FROM departamento;
SELECT * FROM empleado;

-- INNER JOIN
-- join explicita
SELECT * FROM empleado AS e INNER JOIN departamento AS d ON e.id_departamento=d.id;

-- INNER JOIN
-- join implicita
SELECT 
e.id AS 'id_empleado',
d.id AS 'id_departamento',
e.apellido  AS 'apellido_empleado',
nombre AS 'nombre_departamento'
FROM empleado AS e, departamento AS d 
WHERE e.id_departamento=d.id;

-- LEFT JOIN
-- LISTADO EMPLEADOS CON O SIN DEPARTAMENTO
SELECT * FROM empleado AS e LEFT  JOIN departamento AS d ON e.id_departamento=d.id;

-- RIGHT  JOIN
-- LISTADO DEPARTAMENTO CON O SIN empleados
SELECT * FROM empleado AS e RIGHT  JOIN departamento AS d ON e.id_departamento=d.id;
