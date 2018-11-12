/* 
Ejercicios a realizar 

1) Crear dos variables, cada una de ellas contendrá un número. Mostrar por pantalla y en consola, el resultado de sumar, restar, multiplicar y dividir  las dos variables. También mostrar el resto de la división.

2) Pedir al usuario su nombre (mediante prompt) y mostrar por pantalla el mensaje: "Hola [nombreUsuario]".

3) Realizar la misma función que en el punto 1, pero en este caso, será el usuario quien introduzca el valor de las variables (mediante un prompt).

4) Pedir dos números y decir cuál de los dos es mayor.

5) Pedir tres números y decir cuál de los tres es mayor.

6) Pedir un número y decir si es par o impar.

7) Pedir un año y decir si es bisiesto o no.

8) Pedir un número y decir si es primo (no es divisible por ninguno otro número que no sea él mismo o la unidad. P.e. 7 es un número primo porque solo es divisible entre él mismo (el 7) y el 1).

9) Pedir la temperatura en grados Celsius y mostrar la temperatura en grados Fahrenheit.
https://es.wikipedia.org/wiki/Grado_Fahrenheit#Conversi.C3.B3n_a_otras_unidades


10) Pedir los tres ángulos internos de un triángulo y determinar:
	10a) si el triángulo es válido o no.
	(la suma de los 3 ángulos debe ser de 180 grados: https://es.wikipedia.org/wiki/Tri%C3%A1ngulo)

	10b) si el triángulo es Equilátero, Isósceles o Escaleno.
	Equilatero: Tres lados iguales.
	Isosceles: Dos lados iguales.
	Escaleno: Tres lados diferentes. 
	
11) Pedir una frase y decir:
	11a) cuántos caracteres tiene.
	11b) cuántas vocales tiene.
	11c) cuantas veces aparece la letra a.
	11d) si empieza con un número o con una letra.
	11e) si empieza con mayúscula o no.	

12) Adivinar número:
	12a) Elegir un número al azar entre el 1 y el 10. 
	12b) Pedir al usuario que introduzca un número.
	12c) Comprobar que el valor que ha introducido el usuario es un número del 1 al 10.
	12d) Si el usuario ha adivinado el número, sacar un mensaje. Si no lo ha adivinado, sacar otro mensaje.

13) Pedir un número al usuario y escribir en pantalla los divisores de dicho número
	
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




