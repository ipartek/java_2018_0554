# DGT Multapp

## Introduccion

App para la gestion de multas para uso de Agente de tráfico.

### Funciones:
* Listado de Multas.
* Busqueda por matrícula
* Inserción, anulación y modificación de un registro


## Desarollo
En esta app se ha desarollado en un proyecto **Maven 3.1** con la tecnología de **Java Enterprise Edition 1.8** empleado tanto para definir los controladores que manejarán las acciones del usuario como la vista mediante ficheros **JSP** para mostrar los resultados con un formato correcto.

### Bases de Datos

Multapp trabaja con Bases de Datos diseñadas en **MySQL InnoBD** con el fin de asegurar la integridad de los registros.

**dgt.sql**: Se encuentra en la carpeta *SQL* en la rama del proyecto. Contiene el script que genera la base de datos y su contenido.

**database.properties**: archivo con los datos necesarios para la conexion con la BBDD. Están hubicados en la carpeta *resources* del proyecto.


El siguiente esquema representa la BBDD:

<img src="https://github.com/andonishiraiwa/dgt/blob/master/SQL/multas.png"></img>



## Diseño 
La app cuenta con un diseño responsive que se adapta a todos los dispositivos móviles en lo referente a dimensión de pantalla:
 
  A continuación mostramos unos ejemplos de la vista:
  
 ### Página Principal
 <img src="https://github.com/andonishiraiwa/dgt/blob/master/src/main/webapp/images/readme/index.png" width="250" height="500">
  
 ### Listado y gestión de Multas
 
<table>
<tr>
<td width="20%"><img src="https://github.com/andonishiraiwa/dgt/blob/master/src/main/webapp/images/readme/buscar.png"></td>
<td width="20%"><img src="https://github.com/andonishiraiwa/dgt/blob/master/src/main/webapp/images/readme/redactar.png"></td>
<td width="20%"><img src="https://github.com/andonishiraiwa/dgt/blob/master/src/main/webapp/images/readme/lista.png"></td>

 </tr>
 
 </table>
 

## Desarrolladores
App desarollada por **andonishiraiwa** y **Xabage**
