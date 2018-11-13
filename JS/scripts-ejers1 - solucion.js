/* 
Ejercicios a realizar 

1) Crear dos variables, cada una de ellas contendrá un número. Mostrar por pantalla y en consola, el resultado de sumar, restar, multiplicar y dividir  las dos variables. También mostrar el resto de la división.
*/
/*
var num1 = 8;
var num2 = 5;

var rdoSuma = num1 + num2;
var rdoResta = num1 - num2;
var rdoMultiplica = num1 * num2;
var rdoDivide = num1 / num2;
var rdoResto = num1 % num2;

console.log(num1 + ' + ' + num2 + ' = ' + rdoSuma);
console.log(num1 + ' - ' + num2 + ' = ' + rdoResta);
console.log(num1 + ' * ' + num2 + ' = ' + rdoMultiplica);
console.log(num1 + ' / ' + num2 + ' = ' + rdoDivide);
console.log(num1 + ' % ' + num2 + ' = ' + rdoResto);

alert(num1 + ' + ' + num2 + ' = ' + rdoSuma);
alert(num1 + ' - ' + num2 + ' = ' + rdoResta);
alert(num1 + ' * ' + num2 + ' = ' + rdoMultiplica);
alert(num1 + ' / ' + num2 + ' = ' + rdoDivide);
alert(num1 + ' % ' + num2 + ' = ' + rdoResto);

document.write(num1 + ' + ' + num2 + ' = ' + rdoSuma + '<br>');
document.write(num1 + ' - ' + num2 + ' = ' + rdoResta + '<br>');
document.write(num1 + ' * ' + num2 + ' = ' + rdoMultiplica + '<br>');
document.write(num1 + ' / ' + num2 + ' = ' + rdoDivide + '<br>');
document.write(num1 + ' % ' + num2 + ' = ' + rdoResto + '<br>');
*/



/*
2) Pedir al usuario su nombre (mediante prompt) y mostrar por pantalla el mensaje: "Hola [nombreUsuario]".
*/
/*
var saludo = prompt('Hola usuario, ¿cuál es tu nombre?');
document.write('Hola ' + saludo);
*/



/*
3) Realizar la misma función que en el punto 1, pero en este caso, será el usuario quien introduzca el valor de las variables (mediante un prompt).
*/
/*
var num1 = prompt('introduce el primer número: ');
var num2 = prompt('introduce el segundo número: ');

num1 = parseInt(num1);
num2 = parseInt(num2);

var rdoSuma = num1 + num2;
var rdoResta = num1 - num2;
var rdoMultiplica = num1 * num2;
var rdoDivide = num1 / num2;
var rdoResto = num1 % num2;

document.write(num1 + ' + ' + num2 + ' = ' + rdoSuma + '<br>');
document.write(num1 + ' - ' + num2 + ' = ' + rdoResta + '<br>');
document.write(num1 + ' * ' + num2 + ' = ' + rdoMultiplica + '<br>');
document.write(num1 + ' / ' + num2 + ' = ' + rdoDivide + '<br>');
document.write(num1 + ' % ' + num2 + ' = ' + rdoResto + '<br>');
*/




/*
4) Pedir dos números y decir cuál de los dos es mayor.
*/
/*
var num1 = prompt('introduce el primer número: ');
var num2 = prompt('introduce el segundo número: ');

num1 = parseInt(num1);
num2 = parseInt(num2);
	
if (num1 > num2){
	document.write('El primer número es el mayor');
}else if (num1 < num2){
	document.write('El primer número es el menor');
}else{
	document.write('Los dos números son iguales');
}
*/


	
/*
5) Pedir tres números y decir cuál de los tres es mayor.
*/
/*
var num1 = prompt('introduce el primer número: ');
var num2 = prompt('introduce el segundo número: ');
var num3 = prompt('introduce el tercer número: ');

num1 = parseInt(num1);
num2 = parseInt(num2);
num3 = parseInt(num3);

if ( (num1 > num2) && (num1 > num3) ){
	document.write('El primer número es el mayor');
}else if (num2 > num3){
	document.write('El segundo número es el mayor');
}else{
	document.write('El tercer número es el mayor');
}
*/



/*
6) Pedir un número y decir si es par o impar.
*/
/*
var num1 = prompt('introduce un número: ');

num1 = parseInt(num1);
resto = num1 % 2;
	
if (resto == 0){
	document.write('El número es par');
}else{
	document.write('El número es impar');
}
*/



/*
7) Pedir un año y decir si es bisiesto o no.
https://es.wikipedia.org/wiki/A%C3%B1o_bisiesto
*/
/*
var anyo = prompt('introduce un año: ');

anyo = parseInt(anyo);
resto1 = anyo % 4;
resto2 = anyo % 100;
resto3 = anyo % 400;

if ( ( anyo % 100 != 0) && ((anyo % 4 == 0) || (anyo % 400 == 0)) ) {
	document.write('El año es bisiesto');
}else{
	document.write('El año no es bisiesto');
}
*/



/*
8) Pedir un número y decir si es primo ((no es divisible por ninguno otro número que no sea él mismo o la unidad. P.e. 7 es un número primo porque solo es divisible entre él mismo (el 7) y el 1).
*/
/*
var num1 = prompt('introduce un número: ');
num1 = parseInt(num1);
errores = 0;

for (var i=2; i < num1; i++){
	if (num1 % i == 0){ //es divisible
		errores++;
	}
}

if (errores == 0 ){
	document.write('El número ' + num1 + ' es primo');
}else{
	document.write('El número ' + num1 + ' no es primo');
}
*/


/* otras forma más óptima de hacerlo, con for */
/*
var num1 = prompt('introduce un número: ');
num1 = parseInt(num1);
errores = 0;

for (var i=2; i < num1; i++){
	if (num1 % i == 0){ //es divisible
		errores++;
		break; //en cuanto encontramos un error, paramos la ejecución del for y salimos.
	}
}

if (errores == 0 ){
	document.write('El número ' + num1 + ' es primo');
}else{
	document.write('El número ' + num1 + ' no es primo');
}
*/


/* otras forma más óptima de hacerlo, con while */
/*
var num1 = prompt('introduce un número: ');
num1 = parseInt(num1);
errores = 0;
var i = 2; 

while ( (i < num1) && (errores == 0) ){
	if (num1 % i == 0){ //es divisible
		errores++;
	}
	i++;
}

if (errores == 0 ){
	document.write('El número ' + num1 + ' es primo');
}else{
	document.write('El número ' + num1 + ' no es primo');
}
*/

/*
9) Pedir la temperatura en grados Celsius y mostrar la temperatura en grados Fahrenheit.
https://es.wikipedia.org/wiki/Grado_Fahrenheit#Conversi.C3.B3n_a_otras_unidades
*/
/*
var celsius = prompt('introduce la temperatura en grados Celsius: ');
celsius = parseInt(celsius);

var fahrenheit = (1.8 * celsius) + 32;

document.write('La temperatura en grados Celsius es ' + celsius + ' y en grados Fahrenheit es: ' + fahrenheit);
*/



/*
10) Pedir los tres ángulos internos de un triángulo y determinar:
	10a) si el triángulo es válido o no.
	(la suma de los 3 ángulos debe ser de 180 grados: https://es.wikipedia.org/wiki/Tri%C3%A1ngulo)

	10b) si el triángulo es Equilátero, Isósceles o Escaleno.
	Equilatero: Tres lados iguales.
	Isosceles: Dos lados iguales.
	Escaleno: Tres lados diferentes. 
*/
/*
var angulo1 = prompt('introduce el primer número: ');
var angulo2 = prompt('introduce el segundo número: ');
var angulo3 = prompt('introduce el tercer número: ');

angulo1 = parseInt(angulo1);
angulo2 = parseInt(angulo2);
angulo3 = parseInt(angulo3);

if ( (angulo1 + angulo2 + angulo3) == 180 ){
	document.write('El triángulo es válido<br>');
	
	if ( (angulo1==angulo2) && (angulo1==angulo3) ){ //Todos los lados iguales
		document.write('El triángulo es Equilatero<br>');
	}else if( (angulo1!=angulo2) && (angulo1!=angulo3) && (angulo2!=angulo3) ){ //Todos los lados diferentes
		document.write('El triángulo es Escaleno<br>');
	}else{ //habrá dos lados iguales (da igual cuál de ellos sea)
		document.write('El triángulo es Isosceles<br>');
	}
	
}else{
	document.write('El triángulo no es válido<br>');
}
*/




/*	
11) Pedir una frase y decir:
	11a) cuántos caracteres tiene.
	11b) cuántas vocales tiene.
	11c) cuantas veces aparece la letra a.
	11d) si empieza con un número o con una letra.
	11e) si empieza con mayúscula o no.	
*/
/*
var frase = prompt('Escriba una frase:');
var numCaracteres = frase.length;

document.write('La frase: ' + frase + ':<br>');
document.write('Tiene ' + numCaracteres + ' caracteres<br>');

var contadorA = 0;
var contadorVocales = 0;

for (var i=0; i< numCaracteres; i++){
	if ( (frase.charAt(i)== 'a') || (frase.charAt(i)== 'e') || (frase.charAt(i)== 'i') || (frase.charAt(i)== 'o') || (frase.charAt(i)== 'u')){
		contadorVocales++;
		if ( frase.charAt(i)== 'a'){
			contadorA++;
		}
	}
}

document.write('Tiene ' + contadorVocales + ' vocales<br>');
document.write('Tiene ' + contadorA + ' a<br>');

var primeraLetra = frase.charAt(0);
if ( isNaN(primeraLetra) ){
	document.write('Empieza con una letra<br>');
	
	// La comprobación de si la frase empieza con mayúsculas o no, la hacemos cuando sabemos que el primer caracter es una letra. Los números no tienen mayúsculas/minúsculas
	var primeraLetraClon = frase.charAt(0);
	primeraLetraClon = primeraLetraClon.toUpperCase();
	
	if (primeraLetraClon == primeraLetra){
		document.write('La primera letra es mayúsculas<br>');
	}else{
		document.write('La primera no letra es mayúsculas<br>');
	}
	
}else{
	document.write('Empieza con un número<br>');
}
*/




/*
12) Adivinar número:
	12a) Elegir un número al azar entre el 1 y el 10. 
	12b) Pedir al usuario que introduzca un número.
	12c) Comprobar que el valor que ha introducido el usuario es un número del 1 al 10.
	12d) Si el usuario ha adivinado el número, sacar un mensaje. Si no lo ha adivinado, sacar otro mensaje.
	
*/
/*
aleatorio = Math.trunc(Math.random() * 10);
//aleatorio = 7; //para probar con un número fijo y ver si funciona el if/else
var num = prompt('Dime un número al azar entre 1 y 10:');
num = parseInt(num);

if ( !isNaN(num) && (num > 0) && (num<11) ){
	
	if ( num == aleatorio){
		document.write('Felicidades, has adivinado el número');
	}else{
		document.write('Lo siento, no has adivinado el número<br>');
	}
}
*/




/*
13) Pedir un número al usuario y escribir en pantalla los divisores de dicho número
*/
/*
var n1 = prompt("Escribe un número");
var i;
for (i=2;i < n1/2; i++) {
	if (n1 % i === 0) {
		document.write(i,", ");
	}
}
*/




/*

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
	
*/



