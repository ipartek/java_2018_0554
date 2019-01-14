

CREATE DEFINER =`root`@`localhost` FUNCTION `hola`() RETURNS varchar(20) CHARSET utf8
READS SQL DATA deterministic
BEGIN
RETURN 'HolaMundo';
END



CREATE FUNCTION `holaMundo`(entrada VARCHAR(20)) RETURNS VARCHAR(20)
READS SQL DATA deterministic
BEGIN
  DECLARE salida VARCHAR(20) DEFAULT 'hola';
  SET salida ='HOLA MUNDO ';
  RETURN salida;
END


CREATE FUNCTION `saludo` ( nombre VARCHAR(25))
RETURNS VARCHAR(50)
READS SQL DATA deterministic

BEGIN
DECLARE salida VARCHAR(50) DEFAULT 'holita',
SET salida = CONCAT('Saludo ',nombre);
RETURN salida;
END



CREATE DEFINER=`root`@`localhost` FUNCTION `saludo`( nombre VARCHAR(25)) RETURNS varchar(50) CHARSET utf8
    READS SQL DATA
    DETERMINISTIC
BEGIN
DECLARE salida VARCHAR(50) DEFAULT 'holita';
SET salida = CONCAT('Saludo ',nombre);
RETURN salida;
END




CREATE FUNCTION `nombre_mes` ()
RETURNS VARCHAR(20)
READS SQL DATA deterministic
BEGIN
DECLARE mes VARCHAR(20) DEFAULT 'NO EXISTE';
CASE numeroMes
WHEN 1 THEN SET mes ='enero';
ELSE SET mes = CONCAT('numero_mes '+mes);
END CASE;
RETURN mes;
END