import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/model/persona';
import { Fruta } from 'src/app/model/fruta';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  manolo: Persona;

  idiomas: string[];

  idiomaSeleccionado: string;

  frutaConstructor: Fruta;
  frutaConstructorDescuento: Fruta;
  frutaConstructorCompleto: Fruta;

  constructor() { 

    this.frutaConstructor = new Fruta( 'fresa', 3.45 );
    this.frutaConstructorDescuento = new Fruta('Tamarindo', 25.78, undefined, true, 25, undefined, undefined);
    this.frutaConstructorCompleto = new Fruta('Naranja', 5.13, 3, true, 5, 'https://comefruta.es/wp-content/uploads/naranjas-verano.jpg', 3);

    console.debug('frutaConstructor: %o', this.frutaConstructor);
    console.debug('frutaConstructorDescuento: %o', this.frutaConstructorDescuento);
    console.debug('frutaConstructorCompleto: %o', this.frutaConstructorCompleto);


    this.idiomas = ['eu', 'es', 'en'];
    this.idiomaSeleccionado = this.idiomas[0]; //eu

    this.manolo = new Persona();
    console.debug("manolo sin inicializar %o", this.manolo);

    this.manolo.nombre = 'Manolo';
    console.debug("Dame tu nombre " + this.manolo.nombre);
  }

  ngOnInit() {
  }

  cambiarIdioma(idioma: string){
    this.idiomaSeleccionado = idioma;
  }

  escucho(event){
    alert("He recibido un evento del Hijo idioma=" + event.idioma + " y texto = " + event.texto);
  }

}
