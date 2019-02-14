import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-flujo',
  templateUrl: './flujo.component.html',
  styleUrls: ['./flujo.component.scss']
})
export class FlujoComponent implements OnInit {

  // declaramos dentro de la class
  expresion: string;
  ocultar: boolean;
  claseModelo: string;
  nombre: string;
  valido: string;
  //tamano: nombre.length;
  //tamano = ;

  constructor() { 
    console.trace('FlujoComponent constructor');
    // las inicializamos aqui
    this.expresion = 'Soy una Variable inicializada en el Modelo';
    this.ocultar = true;
    this.claseModelo = 'text-primary';
    this.nombre = 'Todavia no me lo has dicho';

  }

  ngOnInit() {
    console.trace('FlujoComponent ngOnInit');
  }
  
  changeClass( claseSeleccionada: string){
    console.trace('click ratiobutton');
    this.claseModelo = claseSeleccionada;
  }

  borrar(){
    this.nombre = '';
  }
/*
  if ( tamano <= 2 ) {
    this.valido = 'is-invalid';
  } else{
    this.valido = 'is-valid';
  }*/
}