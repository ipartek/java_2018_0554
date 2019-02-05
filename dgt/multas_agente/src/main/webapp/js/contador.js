/* contador text area*/ 
console.log('funcionando');
let label;
let concepto; // textarea

const MAX_CARACTERES = 255; // TODO cambiar por 250 despues de las pruebas
const MIN_CARACTERES = 10;

window.addEventListener('load', function() {

	console.log('el DOM cargado y listo');
	label = document.querySelector('#contadorLabel');
	if (document.querySelector('#concepto') != null) {
		concepto = document.querySelector('#concepto');
	}

	let caracteres = concepto.value.length;
	let mensaje = "";
	label.textContent = `(${caracteres}/${MAX_CARACTERES})`;
	concepto.maxLength = `${MAX_CARACTERES}`;
	
	if (caracteres <= MIN_CARACTERES) {
		label.style.color = 'red';
		label.textContent = `(${caracteres}/${MAX_CARACTERES}) Minimo ${MIN_CARACTERES} caracteres`;
	} else if (caracteres >= MIN_CARACTERES) {
		label.style.color = 'green';
		label.textContent = `(${caracteres}/${MAX_CARACTERES}) Correcto`;
	}

	if (caracteres >= (MAX_CARACTERES / 1.25)) {
		label.textContent = `(${caracteres}/${MAX_CARACTERES}) Estas cerca del limite`;
	}
	if (caracteres >= MAX_CARACTERES) {
		label.textContent = `(${caracteres}/${MAX_CARACTERES}) Llegaste al limite`;
	}

	concepto.addEventListener("keyup", function() {
		let caracteres = concepto.value.length;
		// console.log('keypress ' + caracteres);
		label.textContent = `(${caracteres}/${MAX_CARACTERES})`;

		if (caracteres <= MIN_CARACTERES) {
			label.style.color = 'red';
			label.textContent = `(${caracteres}/${MAX_CARACTERES}) Minimo ${MIN_CARACTERES} caracteres`;
		} else if (caracteres >= MIN_CARACTERES) {
			label.style.color = 'green';
			label.textContent = `(${caracteres}/${MAX_CARACTERES}) Correcto`;
		}

		if (caracteres >= (MAX_CARACTERES / 1.25)) {
			label.textContent = `(${caracteres}/${MAX_CARACTERES}) Estas cerca del limite`;
		}
		if (caracteres >= MAX_CARACTERES) {
			label.textContent = `(${caracteres}/${MAX_CARACTERES}) Llegaste al limite`;
		}

	});

});

jQuery(document).ready(function(){
    jQuery(".preloader").delay(500).fadeOut("slow").delay(500, function(){
      jQuery(this).remove();
    });
});