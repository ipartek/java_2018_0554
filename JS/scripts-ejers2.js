/* 
Ejercicios a realizar 

1- Pedir al usuario que introduzca el tamaño del lado de un cuadrado. Mostrar por pantalla el tamaño del perímetro de ese cuadrado 
(El perímetro es la suma de los 4 lados. Como en este caso es un cuadrado, los 4 lados tendrán el mismo tamaño)

2- Pedir el precio de un producto y la cantidad que se va a comprar de ese producto. Mostrar el precio total de la compra.
  
3- Pedir una contraseña y solicitar que se repita la contraseña. Si las dos contraseñas son iguales, mostrar un mensaje de éxito. Si no lo son, mostrar un mensaje de error.

4- Pedir al usuario el día, mes y año de una fecha (3 datos numéricos individuales) y comprobar si la fecha introducida se corresponde con el 31 de diciembre de 2018.

5- Pedir las notas de 3 exámenes de un alumno. Hacer la media de las tres notas. 
(La nota media se calcula sumando las tres notas y dividiendo el resultado entre 3)
	Si la media es menor que 5, mostrar el mensaje de "No aprobado"
	Si la media es mayor o igual que 5 y menor que 6, mostrar el mensaje "Aprobado"
	Si la media es mayor o igual que 6 y menor que 7, mostrar le mensaje "Bien"
	Si la media es mayor o igual que 7 y menor que 9, mostrar le mensaje "Notable"
	Si la media es mayor o igual que 9 y menor que 10, mostrar le mensaje "Sobresaliente"
	Si la media es igual que 10, mostrar le mensaje "Matrícula de Honor"
	
6- Nos van a informar del sueldo de Pepe el panadero y sus años de antigüedad. Queremos ofrecerle un aumento de sueldo en base a las siguientes condiciones:
	a) Si su sueldo es inferior a 600 y su antigüedad es igual o superior a 10 años, otorgarle un aumento del 25 %, mostrar el sueldo a pagar.
	b) Si el sueldo es inferior a 600 pero su antigüedad es menor a 10 años, otorgarle un aumento del 10%.
	c) Si el sueldo es mayor o igual a 600, otorgarle un aumento del 2%.
	
7- Pedir al usuario un número del 1 al 5. En función del número que haya elegido indicarle el premio que le ha tocado:
	a) si elige el 1, le ha tocado un perrito piloto
	b) si elige el 2, le ha tocado una lavadora
	c) si elige el 3, le ha tocado un apartamento en Marina Dor
	d) si elige el 4, le ha tocado un lote de productos ibéricos
	e) si elige el 5, le han tocado dos velas negras
	
8- Mostrar los múltiplos de 7 hasta el valor 350. Debe aparecer en pantalla 7, 14, 21, etc. 	
	a) realizarlo primero con una estructura for
	b) realizarlo después con una estructura while
	c) volverlo a realizar con la estructura que se prefiera (for o while), pero sacar por pantalla los múltiplos en una lista html.

9- Pedir al usuario su dirección de mail y determinar si ese email contiene el carácter @ una sola vez. 
	
10- Determinar si un número es capicúa (se lee igual en ambos sentidos. P.e. el número 2332 es capicúa)

11- Pedir una frase y realizar las siguientes operaciones::
	a) Imprimir la primera mitad de los caracteres de la cadena.
	b) Imprimir el último carácter.
	c) Imprimirlo en forma inversa.
	d) imprimir cada caracter en una línea.

12- Determinar si una frase es palíndroma (se lee igual en ambos sentidos. P.e. "Dábale arroz a la zorra el abad" . No se tienen en cuenta ni los espacios, ni los caracteres con tildes ni se diferencia entre mayúscuas y minúsculas) 
)más ejemplos: https://es.wikiquote.org/wiki/Palíndromo#Frases)
*/


/*

.....RESUMEN FUNCIONES ÚTILES.....

* Mostrar dato:
	alert('Hola -por pantalla');
	console.log('Hola -por consola');
	document.write('estoy escribiendo un texto en el html');
	document.write('h1>Esto escribiendo texto con html</h1>');
		
		
* uso de Prompt:
El dato recogido con Prompt siempre se trata como si fuera una cadena de texto.	
	var dato = prompt("Escribe algo");

	
* Si pedimos un número, asegurarnos de que es un número y no una letra u otro caracter:
	var dato = prompt("Escribe algo");
	dato = parseInt(dato);		

Para ello, transformar el dato recogido por pantalla (con prompt) en formato numérico para poder operar con él:	
	numero = parseInt(numero);	 //para números enteros
	numero = parseFloat(numero); //para números con decimales	

	
* Saber si un dato no es numérico:
	isNaN(variable) -> devuelve true si no es un número (Not a Number) 

	
* número aleatorio:
	Math.random(); -> devuelve un valor entre 0 y 1
	
	
	
* otras funciones útiles de Math:
https://developer.mozilla.org/es/docs/Web/JavaScript/Guide/Numbers_and_dates#Objeto_Math	
	
	

var texto = 'Esto es una frase';
console.log(texto);

var tamano = texto.length;
console.log(tamano);

var pos1 = texto.substr(0,1); --> primer caracter de una cadena de texto
console.log(pos1);

var pos1Mayusculas = pos1.toUpperCase();  --> pasamos a mayúsculas el primer caracter
console.log(pos1Mayusculas);

if (pos1==pos1Mayusculas){
	console.log('es mayúsculas');
}else{
	console.log('es minusculas');
}


texto = texto.toLowerCase();   --> pasamos todo el texto a minúsculas
console.log(texto);	


* Convertir una cadena de texto a un array:
	var arrayFrase = frase.split('');
	
*/




