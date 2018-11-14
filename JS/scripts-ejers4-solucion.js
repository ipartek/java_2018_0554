/*
1) A continuación de cada abreviatura que nos encontremos en la página, mostrar su significado



var abreviaturas = document.getElementsByTagName('abbr');

for (var i=0; i<abreviaturas.length; i++){
	
	var titulo = abreviaturas[i].title;
	
	var texto = abreviaturas[i].textContent;
	abreviaturas[i].textContent = texto + ' (' + titulo + ')';
	
	var texto = abreviaturas[i].innerHTML;
	abreviaturas[i].innerHTML = texto + ' (' + titulo + ')';
}

*/

var abreviaturas = document.getElementsByTagName('abbr');

for (var i=0; i<abreviaturas.length; i++){
	var titulo = abreviaturas[i].title;
	
	var significado = document.createElement('span');
	var significadoTexto = document.createTextNode(' -(' + titulo + ')-');
	significado.appendChild(significadoTexto);
	
	//inserto el span después del abbr
	abreviaturas[i].parentNode.insertBefore(significado, abreviaturas[i].nextSibling);
}




/*
2) Mover el strong que se encuentra en el primer párrafo al principio del segundo párrafo.
*/


parrafos = document.getElementsByTagName('p');

aviso = document.getElementById('aviso');
parrafos[1].insertBefore(aviso,parrafos[1].firstChild);



/*
var seccion = document.getElementById('sec-contenido');
var parrafos = document.querySelectorAll('#sec-contenido p');
var aviso = document.getElementById('aviso');

seccion.insertBefore(aviso, parrafos[0]);
//seccion.appendChild(aviso);


var pie = document.getElementById('page-pie');
var parrafoPie = document.querySelector('#page-pie .copyright');

pie.insertBefore(seccion, parrafoPie);
*/






/*
3) Clonar el menú de idiomas y ubicarlo en el footer de la página.
*/

var idiomas = document.getElementById("menu-idiomas");
var idiomasClon = idiomas.cloneNode(true);
//idiomasClon.id = 'idiomas2';
idiomasClon.removeAttribute('id');

var pie = document.getElementById("page-pie");
pie.appendChild(idiomasClon);







/*
4) Reemplazar el texto del segundo párrafo por otro párrafo que prefieras.
*/

var parrafos = document.getElementsByTagName('p'); 
parrafos[1].innerHTML = 'Este texto lo he cambiado desde javascript';

/* 
5) Mover (no clonar) los li del menú de idiomas al menú principal y después, eliminar el menú de idiomas
En el menú principal nos quedarán los li que ya había antes y los dos li con los idiomas.
*/

var idiomas = document.querySelectorAll('#menu-idiomas li');
var menu = document.querySelector('.page-nav .menu');

for (var i=0; i<idiomas.length; i++){
	menu.appendChild(idiomas[i]);
}

var menuIdiomas = document.getElementById('menu-idiomas');
var padre = menuIdiomas.parentNode;
padre.removeChild(menuIdiomas);

//menuIdiomas.parentNode.removeChild(menuIdiomas);




/*
6) Usar el texto alternativo de las fotos de la galería y sacarlo por pantalla como pie de foto.
*/
var imgsGaleria = document.querySelectorAll('.galeria-con-pie img');

for (var i=0; i<imgsGaleria.length; i++){
	var alt = imgsGaleria[i].alt;
	var pie = document.createElement('span');
	pie.innerHTML = alt;
	imgsGaleria[i].parentNode.appendChild(pie);	
}



/*
7) En la css, crear los siguientes estilos:
.anchura1{width:25%}
.anchura2{width:50%}
.anchura3{width:75%}
.anchura4{width:100%}

En la galería de imágenes, aplicar a cada li una de estas 4 clases que hemos creado, de manera aleatoria

por ejemplo, el código resultante podría quedar así...

<ul class="galeria galeria-con-pie">
	<li class="anchura3"><img src="..." alt="..."></li>
	<li class="anchura1"><img src="..." alt="..."></li>
	<li class="anchura4"><img src="..." alt="..."></li>
	<li class="anchura3"><img src="..." alt="..."></li>
	<li class="anchura2"><img src="..." alt="..."></li>
	<li class="anchura1"><img src="..." alt="..."></li>
</ul>
*/

var itemsGaleria = document.querySelectorAll('.galeria li');
var estilos = ['anchura1', 'anchura2', 'anchura3', 'anchura4'];

for (var i=0; i<itemsGaleria.length; i++){
	var random = Math.trunc(Math.random()*4);
	//console.log(random);
	itemsGaleria[i].className = estilos[random];
}

/*
8) en la sección de Biografía, cambiar los datos del personaje ficticio con tus datos.
Después, crea una imagen y añádela a la sección, para que la información quede completa.
*/

var bioNombre = document.getElementById('bio-nombre');
var bioCurso = document.getElementById('curso');
var bioDuracion = document.getElementById('duracion');

bioNombre.innerHTML = 'Pepe';
bioCurso.innerHTML = 'Páginas Web';
bioDuracion.innerHTML = 'el fin de los tiempos';


var bioImagen = document.createElement('img');
bioImagen.src = 'https://picsum.photos/300/200?image=5';
bioImagen.alt = 'mi foto de perfil';

var bio = document.getElementById('sec-biografía');
bio.appendChild(bioImagen);




















