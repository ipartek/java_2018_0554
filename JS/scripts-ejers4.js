/*
1) A continuación de cada abreviatura que nos encontremos en la página, mostrar su significado

var abreviaturas = document.getElementsByTagName('abbr');
for (var i=0; i<abreviaturas.length; i++){
	var titulo = abreviaturas[i].title;
	var texto = abreviaturas[i].textContent;
	
	abreviaturas[i].textContent = texto + ' (' + titulo + ')';
}


var abreviaturas = document.getElementsByTagName('abbr');
for (var i=0; i<abreviaturas.length; i++){
	var titulo = abreviaturas[i].title;
	
	var significado = document.createElement('span');
	var significadoTexto = document.createTextNode(' (' + titulo + ')');
	significado.appendChild(significadoTexto);
	
	//inserto el span después del abbr
	abreviaturas[i].parentNode.insertBefore(significado, abreviaturas[i].nextSibling);
}
*/



/*
2) Mover el strong que se encuentra en el primer párrafo al principio del segundo párrafo.

parrafos = document.getElementsByTagName('p');

aviso = document.getElementById('aviso');
parrafos[1].insertBefore(aviso,parrafos[1].firstChild);
*/





/*
3) Clonar el menú de idiomas y ubicarlo en el footer de la página.

var idiomas = document.getElementById("menu-idiomas");
var idiomasClon = idiomas.cloneNode(true);
idiomasClon.removeAttribute('id');

var pie = document.getElementById("page-pie");
pie.appendChild(idiomasClon);
*/






/*
4) Reemplazar el texto del segundo párrafo por otro párrafo que prefieras.
*/




/* 
5) Mover (no clonar) los li del menú de idiomas al menú principal y después, eliminar el menú de idiomas
En el menú principal nos quedarán los li que ya había antes y los dos li con los idiomas.
*/






/*
6) Usar el texto alternativo de las fotos de la galería y sacarlo por pantalla como pie de foto.
*/





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



/*
8) en la sección de Biografía, cambiar los datos del personaje ficticio con tus datos.
Después, crea una imagen y añádela a la sección, para que la información quede completa.
*/