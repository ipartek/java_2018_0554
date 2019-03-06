# Web Service API Rest DGT

Servicio Rest con Spring 4.3.0.RELEASE

## endpoint

http://localhost:8080/wsrest/api

## recursos

* agente
* vehiculo
* multas

# DGT-MULTAS APP

## Introduccion

App para la gestion de multas para uso de Agente de tráfico.

### Funciones:
* Listado de Multas.
* Busqueda por matrícula
* Inserción, anulación y modificación de un registro
* Consultar estadísticas


## Desarollo
En esta app se ha desarrollado en un proyecto Web Service REST para el backend y Angular para el frontend.

### Bases de Datos

Esta app trabaja con Bases de Datos diseñadas en **MySQL InnoBD** con el fin de asegurar la integridad de los registros.

**dgt_xabi.sql**: Se encuentra en la carpeta *SQL* dentro de la carpeta *modelo* en la rama del proyecto. Contiene el script que genera la base de datos y su contenido.

**database.properties**: archivo con los datos necesarios para la conexion con la BBDD. Están hubicados en la carpeta *resources* del proyecto.


El siguiente esquema representa la BBDD:

<img src="https://github.com/ipartek/java_2018_0554/blob/xabiereguskiza/dgt/WS_REST/src/main/webapp/imagenes/esquema.png"></img>



## Diseño 
La app cuenta con un diseño responsive que se adapta a todos los dispositivos móviles en lo referente a dimensión de pantalla:
 
  A continuación mostramos unos ejemplos de la vista:
  
 ### Página de Login
 <img src="https://github.com/ipartek/java_2018_0554/blob/xabiereguskiza/dgt/WS_REST/src/main/webapp/imagenes/login.png" width="20%">
  
 ### Principal y gestión de Multas
 
<table>
<tr>
<td width="20%"><img src="https://github.com/ipartek/java_2018_0554/blob/xabiereguskiza/dgt/WS_REST/src/main/webapp/imagenes/principal.png"></td>
<td width="20%"><img src="https://github.com/ipartek/java_2018_0554/blob/xabiereguskiza/dgt/WS_REST/src/main/webapp/imagenes/buscar.png"></td>
<td width="20%"><img src="https://github.com/ipartek/java_2018_0554/blob/xabiereguskiza/dgt/WS_REST/src/main/webapp/imagenes/multar.png"></td>
<td width="20%"><img src="https://github.com/ipartek/java_2018_0554/blob/xabiereguskiza/dgt/WS_REST/src/main/webapp/imagenes/multas.png"></td>


 </tr>
 
 </table>
 

## Desarrollado por:
	Xabier Eguskiza