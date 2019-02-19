import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/model/persona';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  manolo:Persona;
  anonimo:Persona;

  idiomas: string[];
  idiomaSeleccionado:string;
  textoTraducir:string;

  constructor() { 
    this.manolo = new Persona('Manolo');
    this.anonimo = new Persona();
    this.idiomas=['es','eu','en'];
    this.idiomaSeleccionado=this.idiomas[0];
    this.textoTraducir="";
    }

  ngOnInit() {
  }
  cambiarIdioma(idioma:string){
    this.idiomaSeleccionado = idioma;
  }

  escucho(event){
    alert('Acabo de recibir el evento del hijo. Idioma = ' + event.idioma + ' y texto= ' + event.texto);
  }
}
