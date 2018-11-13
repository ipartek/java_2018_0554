/*
1) Enlaces externos. Sobre la lista de enlaces a buscadores, al hacer click en cada enlace con la clase identificativa de enlace externo, abrir el enlace en una nueva ventana
*/
var enlaces = document.querySelectorAll('#sec-buscadores .lista-buscadores a');

for (var i=0; i<enlaces.length; i++){
	if( enlaces[i].classList.contains('enlace-externo') ){
		enlaces[i].target = '_blank';
		enlaces[i].title = '(enlace externo)';
	}
}




/* 
2) Comprobar si se pulsa la tecla "Enter" o no
*/

function queTeclaPulsas(e) {
	var keyCode = e.keyCode;
	if(keyCode==13) {
		console.log("Has pulsado Enter.");
	}else{
		console.log("No has pulsado Enter");
	}
}

//Estamos alerta continuamente para ver si se dispara el evento "keydown".
//Si se dispara, entonces se ejecuta la función.	
document.addEventListener("keydown", queTeclaPulsas, false);	
	
	
	


	

/*
3) En el bloque de la noticia 1, cuando se haga click en cualquier zona de la noticia, que se ejecute el enlace.

*/






/*
4) En el bloque de la noticia 2, crear desde javascript un enlace de "leer más" que sea igual de funcional que el enlace que tiene en el título.

*/





	
/*
5) Implementar una función que muestre/oculte el menú (#menu) de la página cuando se haga click en el enlace "menú" (#gestionaMenu)


function muestraOculta(){ 
	
}

var enlace = document.getElementById('gestionaMenu');

 */	
	

	
	
	


/*
6) En el listado de colores, al hacer click sobre cada uno de ellos, cambiar el color de fondo de body por el color que indica en cada li

*/


