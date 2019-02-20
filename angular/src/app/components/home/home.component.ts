import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/model/persona';
import { Fruta } from 'src/app/model/fruta';

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

  
  frutaConstructor:Fruta;
  frutaConstructorDescuento:Fruta;
  frutaConstructorCompleto:Fruta;

  constructor() { 

    //Fruta
    this.frutaConstructor=new Fruta('Fresa',3.45);
    this.frutaConstructorDescuento = new Fruta('Tamarindo',25.78,undefined,true,25,undefined,5);
    this.frutaConstructorCompleto = new Fruta('Naranja',5.13,3,true,5,'https://naranjaspilarin.com/wp-content/uploads/2017/12/naranja-2.jpg',20);

    console.debug('frutaConstructor: %o',this.frutaConstructor);
    console.debug('frutaConstructorDescuento: %o',this.frutaConstructorDescuento);
    console.debug('frutaConstructorDescuento: %o',this.frutaConstructorDescuento);

    //Pruebas con objeto Persona
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
