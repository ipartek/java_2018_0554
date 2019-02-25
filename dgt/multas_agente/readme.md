# Funciones Proyecto

Gestor de multas DGT, permite a un agente aplicar multas, anularlas y listarlas desde su telefono mòvil o tablet.
## Para iniciar

* Datos de conexion en el archivo database.properties en la carpeta resources del proyecto. ( cambiar para ajustar a tu base de datos)
* Acciones para LOG en el archivo log4j.properties en la carpeta resources del proyecto. (registra eventos y errores que puedan surgir)
* En la carpeta SQL del proyecto se encuentra el archivo dgt.sql con el script que crea la base de datos con los datos iniciales.(copiar y pegar el codigo en  Sistema de Gestion de Base de Datos de su preferencia, incluye creacion de la BDD, tablas y datos para comprobar funcionamiento)
* Datos de acceso de prueba:<br>
	Placa 987987<br>
	contraseña 987987<br>
	matricula multable: 9605EFH<br>
* La base de datos tiene la siguente estructura:

<img src="https://github.com/AjRoBSeYeR/PruebasIpartek/blob/master/dgt/src/main/resources/eer.png">

## Proyectos

* modelo: Aplicación Java (jar) para gestionar el modelo de datos
* multas_agente: Proyecto Java Web (war) para gestion de multas de un Agente
* backend: Proyecto Java web para gestionar toda la información como Administradores (CRUD: agentes, coches, etc.)
* WS_SOAP: Web Service (Proveedor - SOAP) para poder consultar información de un vehículo

## Previsualización

<table>
<tr>
	<td width="33%"><img src="https://github.com/AjRoBSeYeR/PruebasIpartek/blob/master/dgt/src/main/resources/dgt.png"></td>
	<td width="33%"><img src="https://github.com/AjRoBSeYeR/PruebasIpartek/blob/master/dgt/src/main/resources/dgt2.png"></td>
	<td width="33%"><img src="https://github.com/AjRoBSeYeR/PruebasIpartek/blob/master/dgt/src/main/resources/dgt3.png"></td>
</tr>
</table>




</div>

## Tecnología

* J2EE 1.8
* Maven 3.1
* MySQL InnoDB
* boostrap 4
	* Datatables
* javaScript
* JQuery

## Version

Beta 0.7

## Desarrolladores

* Hector Serrano
* Borja Reyes


## License

Freeware

