/* 
Ejercicios a realizar 



1- Pedir al usuario que introduzca el tamaño del lado de un cuadrado. Mostrar por pantalla el tamaño del perímetro de ese cuadrado 
(El perímetro es la suma de los 4 lados. Como en este caso es un cuadrado, los 4 lados tendrán el mismo tamaño)
*/
/*
var lado = prompt('Introduce el tamaño del lado de un cuadrado:');
lado = parseInt(lado);
var perimetro = lado * 4;

document.write('El perímetro de un cuadrado cuyo lado mide: ' + lado + ' es: ' + perimetro);
*/




/*
2- Pedir el precio de un producto y la cantidad que se va a comprar de ese producto. Mostrar el precio total de la compra.
*/
/*
var precio = parseInt(prompt('Introduce el precio del producto:'));
var cantidad = parseInt(prompt('Introduce la cantidad que has comprado del producto:'));

var precioTotal = precio * cantidad;

document.write('Factura:<br>');
document.write('Precio unitario: ' + precio + '€<br>');
document.write('Cantidad comprada: ' + cantidad + '<br>');
document.write('El precio total de tu compra es: ' + precioTotal + '€<br>');
*/




/*
3- Pedir una contraseña y solicitar que se repita la contraseña. Si las dos contraseñas son iguales, mostrar un mensaje de éxito. Si no lo son, mostrar un mensaje de error.
*/
/*
var clave1 = prompt('Introduce una contraseña: ');
var clave2 = prompt('Repita la contraseña: ');

if (clave1 == clave2){
	document.write('Las dos contraseñas son iguales');
}else{
	document.write('Las contraseñas no coinciden');
}
*/




/*
4- Pedir al usuario el día, mes y año de una fecha (3 datos numéricos individuales) y comprobar si la fecha introducida se corresponde con el 31 de diciembre de 2018.
*/
/*
var dia = parseInt(prompt('Introduzca el día:'));
var mes = parseInt(prompt('Introduzca el mes:'));
var anyo = parseInt(prompt('Introduzca el año:'));

if ( (dia==31) && (mes==12) && (anyo==2018) ){
	document.write('Fecha correcta');
}else{
	document.write('Fecha incorrecta');
}
*/

/* Habría que comprobar si el usuario está introduciendo números y son válidos, p.e. que no nos mete el 32 como día, el 13 como mes, etc... 

if ( (!isNaN(dia)) && (dia >0) && (dia<32) && (!isNaN(mes)) && (mes >0) && (mes<13) && (!isNaN(anyo)) ){
	// Día, Mes y Año son números y dentro de sus rangos
}

*/


/*
5- Pedir las notas de 3 exámenes de un alumno. Hacer la media de las tres notas. 
(La nota media se calcula sumando las tres notas y dividiendo el resultado entre 3)
	Si la media es menor que 5, mostrar el mensaje de "No aprobado"
	Si la media es mayor o igual que 5 y menor que 6, mostrar el mensaje "Aprobado"
	Si la media es mayor o igual que 6 y menor que 7, mostrar le mensaje "Bien"
	Si la media es mayor o igual que 7 y menor que 9, mostrar le mensaje "Notable"
	Si la media es mayor o igual que 9 y menor que 10, mostrar le mensaje "Sobresaliente"
	Si la media es igual que 10, mostrar le mensaje "Matrícula de Honor"
*/
/*
var nota1 = parseInt(prompt('Nota primer trimestre:'));
var nota2 = parseInt(prompt('Nota segundo trimestre:'));
var nota3 = parseInt(prompt('Nota tercer trimestre:'));

var media = (nota1 + nota2 + nota3) / 3;

if (media < 5){
	document.write('No aprobado');
}else if(media < 6) { 
	document.write('Aprobado');
}else if(media < 7) { 
	document.write('Bien');
}else if(media < 9) { 
	document.write('Notable');
}else if(media < 10) { 
	document.write('Sobresaliente');
}else{ 
	document.write('Matrícula de Honor');
}
*/



/*
6- Nos van a informar del sueldo de Pepe el panadero y sus años de antigüedad. Queremos ofrecerle un aumento de sueldo en base a las siguientes condiciones:
	a) Si su sueldo es inferior a 600 y su antigüedad es igual o superior a 10 años, otorgarle un aumento del 25 %, mostrar el sueldo a pagar.
	b) Si el sueldo es inferior a 600 pero su antigüedad es menor a 10 años, otorgarle un aumento del 10%.
	c) Si el sueldo es mayor o igual a 600, otorgarle un aumento del 2%.
*/
/*
var sueldo = parseInt( prompt('¿Cuál es el sueldo de Pepe?') );
var antiguedad = parseInt( prompt('¿Cuál es la antigüedad de Pepe?') );
var nuevosueldo = sueldo;
var aumento;

if ( (sueldo < 600) && (antiguedad >= 10) ){
	nuevoSueldo = sueldo + (sueldo * 0.25);
	aumento = ' Aumento del 25%';
}

if ( (sueldo < 600) && (antiguedad < 10) ){
	nuevoSueldo = sueldo + (sueldo * 0.1);
	aumento = ' Aumento del 10%';
}

if ( sueldo >= 600 ){
	nuevoSueldo = sueldo + (sueldo * 0.02);
	aumento = 'Aumento del 2%';
}

document.write('Pepe<br>Sueldo: ' + sueldo + '€<br>Antigüedad: ' + antiguedad + ' años<br>Nuevo sueldo: ' + nuevoSueldo + '€<br>' + aumento);
*/



/*
7- Pedir al usuario un número del 1 al 5. En función del número que haya elegido indicarle el premio que le ha tocado:
	a) si elige el 1, le ha tocado un perrito piloto
	b) si elige el 2, le ha tocado una lavadora
	c) si elige el 3, le ha tocado un apartamento en Marina Dor
	d) si elige el 4, le ha tocado un lote de productos ibéricos
	e) si elige el 5, le han tocado dos velas negras
*/
/*
var num = parseInt(prompt('Introduce un número del 1 al 5'));
if ( !isNaN(num) && (num >= 1) && (num <= 5) ){
	switch (num) {
	  case 1:
		document.write('Te ha tocado un perrito piloto');
		break;
	  case 2:
		document.write('Te ha tocado una lavadora');
		break;
	  case 3:
		document.write('Te ha tocado un apartamento en Marina Dor');
		break;
	  case 4:
		document.write('Te ha tocado un lote de productos ibéricos');
		break;
	  case 5:
		document.write('Te han tocado dos velas negras');
		break;
	  default: //En teoría no llegaríamos a este caso porque ya estamos haciendo un if para validar que el número está entre 1 y 5
		document.write('Lo sentimos, no has tenido suerte');
		break;
	}
}
*/	
	
/*
8- Mostrar los múltiplos de 7 hasta el valor 350. Debe aparecer en pantalla 7, 14, 21, etc. 	
	a) realizarlo primero con una estructura for
	b) realizarlo después con una estructura while
	c) volverlo a realizar con la estructura que se prefiera (for o while), pero sacar por pantalla los múltiplos en una lista html.
*/
/*
var multiploFor=0;
document.write('<ul>');
for (var i=1; multiploFor<350; i++){
	multiploFor = 7*i;
	document.write('<li>' + multiploFor + '</li>');
}
document.write('</ul>');


var multiploWhile=0;
var i=1;
document.write('<ul>');
while (multiploWhile<350){
	multiploWhile = 7*i;
	document.write('<li>' + multiploWhile + '</li>');
	i++;
}
document.write('</ul>');
*/




/*
9- Pedir al usuario su dirección de mail y determinar si ese email contiene el carácter @ una sola vez. 
*/
/*
var email = prompt('Introduce tu e-mail:');
numCaracteres = email.length;
var contadorArroba = 0;

for (var i=0; i< numCaracteres; i++){
	if (email.charAt(i)== '@'){
		contadorArroba++;
	}
}

if (contadorArroba == 1){
	document.write('Tu email: ' + email + ' es correcto. Solo contiene una @');
}else{
	document.write('Tu email: ' + email + ' es incorrecto. Contiene más de una @ o no contiene ninguna');
}
*/


/*
10- Determinar si un número es capicúa (se lee igual en ambos sentidos. P.e. el número 2332 es capicúa)
*/
/*
var num = prompt('Introduce un número:');
// En este caso no tenemos que hacer el parseInt porque queremos tratar el número como una cadena de texto.
var arrayNum = num.split('');
var numInvertido = '';

for (var i=arrayNum.length-1; i>=0; i--){
	numInvertido = numInvertido + arrayNum[i];
}

//document.write(num + ' / ' + numInvertido);

if (num == numInvertido){
	document.write ('El número es capicúa');
}else{
	document.write ('El número no es capicúa');
}
*/



/*
11- Pedir una frase y realizar las siguientes operaciones::
	a) Imprimir la primera mitad de los caracteres de la cadena.
	b) Imprimir el último carácter.
	c) Imprimirlo en forma inversa.
	d) imprimir cada caracter en una línea.

*/
/*
var frase = prompt('Introduzca una frase');
var numCaracteres = frase.length;
var mitad = Math.trunc(numCaracteres / 2); //Quitamos los decimales

for (var i=0; i <= mitad; i++){
	document.write( frase.charAt(i));
}

document.write('<br>El último caracter es: ' + frase.charAt(numCaracteres-1) + '<br>');

for (var i=numCaracteres-1; i >=0; i--){
	document.write( frase.charAt(i));
}

for (var i=0; i < numCaracteres; i++){
	document.write('<br>' + frase.charAt(i));
}

for (var i=numCaracteres-1; i >=0; i--){
	document.write('<br>' +  frase.charAt(i));
}
*/




/*
12- Determinar si una frase es palíndroma (se lee igual en ambos sentidos. P.e. "Dábale arroz a la zorra el abad" . No se tienen en cuenta ni los espacios, ni los caracteres con tildes ni se diferencia entre mayúscuas y minúsculas) 
)más ejemplos: https://es.wikiquote.org/wiki/Palíndromo#Frases)

Solución:
https://librosweb.es/libro/javascript/capitulo-11/ejercicio-10.html
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



