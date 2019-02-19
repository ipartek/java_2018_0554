import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/model/persona';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  manolo: Persona;

  idiomas: string[];

  idiomaSeleccionado: string;

  constructor() { 

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
