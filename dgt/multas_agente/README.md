# Aplicación para la creación y consulta de multas.
Ander y Daniel

App realizada para los agentes del ayuntamiento. Permite la creación y consulta de las multas registradas en la base de datos asociada. 
La aplicación tiene diseño resposive, para permitir su uso en los dispositivos móviles de los agentes, ya que se entiende que será desde donde se use esta aplicación. 

## Listado de Tecnologías utilizadas: 
- Java
- Bootstrap 4
- JQuery
- DataTable
- HTML 5
- Maven
- CSS3
- MySQL

## Guía de instalación: 
### Instalación de la Base de datos
Debemos seguir los siguientes pasos: 
1. Ir a la carpeta 'SQL'.
2. Copiar script 'dgt.sql'.
3. Pegar contenido del script en nuestro SGBD (Sistema Gestor de Base de Datos).
4. Comprobar que los datos de configuración de la BD corresponden con los indicados en el archivo 'resources < database.properties'.
## Esquema Entidad-Relación de la Base de Datos DGT
![Alt Esquema del E-R de la BD](https://github.com/dZallo/appMultas/blob/master/screnshoots/e-r_DGT.png)

## TESTING
### Usuarios registrados
| Nº Placa | Password | Nombre_Agente |
|----------|----------|---------------|
| 1234     | 12345678 | Majonei       |
| 4321     | 12345678 | Jonny Walker  |
| 7890     | 12345678 | Monk          |
| 0987     | 12345678 | Takelberry    |
| 5678     | 12345678 | Tontini       |

### Vehículos registrados
| ID | Matrícula | Modelo        |
|----|-----------|---------------|
| 1  | 3548MKZ   | toyota yaris  |
| 3  | 9605EFH   | Fiat Multipla |
| 4  | 5674MBD   | GRT           |
| 6  | BI0020AZ  | flagoneta     |

## Pantallas principales de la aplicación

![Alt Página principal de la aplicación](https://github.com/dZallo/appMultas/blob/master/screnshoots/principal.PNG)
![Alt Listado de las multas registradas](https://github.com/dZallo/appMultas/blob/master/screnshoots/listado.PNG)


![Alt Pantalla para buscar la matrícula del coche a multar](https://github.com/dZallo/appMultas/blob/master/screnshoots/matricula.PNG)
![Alt Pantalla para dar de alta una multa](https://github.com/dZallo/appMultas/blob/master/screnshoots/generarMulta.PNG)


