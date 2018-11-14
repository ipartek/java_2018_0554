/*
1) Crear un párrafo en la página que contenga un texto loremipsum.
*/
var parrafo = document.createElement('p');

var textoParrafo = document.createTextNode('loremipsum');
parrafo.appendChild(textoParrafo);	

//parrafo.innerHTML = 'loremipsum';


document.body.appendChild(parrafo);

/*
2) Crear un enlace en la página con el texto "enlace con javascript" que enlace con la web "http://www.w3.org".
*/

var enlace = document.createElement('a');
var textoEnlace = document.createTextNode('enlace con javascript');
enlace.href = 'http://www.w3.org';
enlace.title='enlace externo';
enlace.className='enlace-info';
enlace.id = 'enlace1';

enlace.appendChild(textoEnlace);	
document.body.appendChild(enlace);


var imagen = document.createElement('img');
imagen.src='logo.jpg';
imagen.alt='Logotipo';
document.body.appendChild(imagen);




/*
3) Indicar el nº de enlaces que existen en la página.
*/
var enlaces = document.getElementsByTagName('a');
var numEnlaces = enlaces.length;

document.write('<br>En la página existen: ' + numEnlaces + ' enlaces.<br>');



/*
4) Indicar la url a la que enlaza el segundo enlace que existe en la página, y el segundo enlace si empezamos por el final.
*/

document.write('<br>El segundo enlace empezando por el inicio enlaza a: ' + enlaces[1].href + '<br>');
document.write('<br>El segundo enlace empezando por el final enlaza a: ' + enlaces[numEnlaces-2].href + '<br>');


/*
5) Indicar el nº de enlaces que tienen la clase "enlace-externo".
*/
//si utilizo document.getElementsByClassName('enlace-externo'), selecciono todos los elementos (sean enlace o no) que tengan la clase 'enlace-externo'.
// si esa clase se utilizara también en otros elementos (input, p.e.) en el array tendríamos tanto enlaces como esos input.

var contadorEnlacesExternos = 0;

for (var i=0; i<numEnlaces; i++){
	var clase = enlaces[i].className;
	if (clase == 'enlace-externo'){
		contadorEnlacesExternos++;
	}
}

document.write('<br>En la página existen: ' + contadorEnlacesExternos + ' enlaces externos.<br>');


/*
6) Indicar el nº de elementos strong que existen en el tercer párrafo de la página
*/

var parrafos = document.getElementsByTagName('p');
var parrafo3 = parrafos[2];

var strongs = parrafos[2].getElementsByTagName('strong');

var strongs = parrafo3.getElementsByTagName('strong');
document.write('<br>En el tercer párrafo existen: ' + strongs.length + ' elementos strong.<br>');


//Mismo código, pero sin la variable intermedia
var parrafos = document.getElementsByTagName('p');
var strongs = parrafos[2].getElementsByTagName('strong');
document.write('<br>En el tercer párrafo existen: ' + strongs.length + ' elementos strong.<br>');




/*
7) listado de 15 li, en cada li haya una img diferente
*/

document.getElementbyID('titulo1') //ID
document.querySelector('#titulo1')

document.getElementsbyTagName('p') //elemento
document.querySelectorAll('p');


document.getElementsbyTagName('p') //elemento
document.getElementsbyTagName('p a') //elemento


var parrafos = getElementsbyTagName('p');
var contadorA = 0;
for (var i=0; i< parrafos.length; i++){
	enlaces = parrafos[i].getElementsbyTagName('a');
	contadorA = contadorA + enlaces.length;
}

var enlacesRapidos = document.querySelectorAll('p a');
var contadorEnlacesRapidos = enlacesRapidos.length;



document.getElementsbyClassName('enlace-externo') //clase
document.querySelectorAll('.enlace-externo');







document.querySelector()
document.querySelectorAll('#seccion-noticias .noticia-resumen a');






//Función para crear una imagen en base a los parámetros de src y alt, la imagen se añade a un li que también se crea, y la función devolverá ese elemento li, que contiene la imagen.
function crearItemListaImg(src,alt){
	//Creo la imagen con sus atributos
	var imagen = document.createElement('img');
	imagen.src = src;
	imagen.alt = alt;
	
	//Creo el li y le añado la imagen
	var item = document.createElement('li');
	item.appendChild(imagen);
	
	//devuelvo el li
	return item;
}

//Creamos la lista y le añadimos un id
var listaFotos = document.createElement('ul');
listaFotos.id = 'lista-fotos';

//Llamamos 15 veces a la función para crear el li con la imagen, y se los vamos añadiendo al listado
for (var i=1; i<16; i++){
	
	var rutaImagen = 'https://picsum.photos/400/300?image=' + i;
	var altImagen = 'Foto ' + i;
	listaFotos.appendChild( crearItemListaImg(rutaImagen,altImagen) );
	
	/*
	listaFotos.appendChild( crearItemListaImg('https://picsum.photos/400/300?image=' + i,'Foto ' + i) );
	*/
}

listaFotos.appendChild( crearItemListaImg('http://www.panaderiapepe.com/logo.png','Logo Panadería Pepe') );
listaFotos.appendChild( crearItemListaImg('http://www.panaderiapepe.com/pan.png','Barra de pan') );
listaFotos.appendChild( crearItemListaImg('http://www.panaderiapepe.com/pastel.png','Pastel') );



//Añadimos la lista a la página
document.body.appendChild(listaFotos);








