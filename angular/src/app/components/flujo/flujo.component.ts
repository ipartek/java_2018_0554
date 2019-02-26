import { Component, OnInit } from '@angular/core';
import { validateConfig } from '@angular/router/src/config';

@Component({
  selector: 'app-flujo',
  templateUrl: './flujo.component.html',
  styleUrls: ['./flujo.component.scss']
})
export class FlujoComponent implements OnInit {

  ocultar: boolean;
  expresion: string;
  claseModelo: string;
  nombre: string;
  valido: string;

  constructor() {
    console.trace('FlujoComponent constructor');
    this.expresion = 'Soy una Variable inicializada en el Modelo';
    this.ocultar = true;
    this.claseModelo = 'text-primary';
    this.nombre = 'Todavia no me lo has dicho';
    this.valido = '';
   
   }
  
  ngOnInit() {

    console.trace('FlujoComponent ngOnIt');
  }

  chageClass (claseSeleccionada: string){
    console.trace('click radiobutton');
    this.claseModelo = claseSeleccionada;

  }

  borrar(){
    this.nombre = '';
  }

  validar(){
    console.trace('FlujoComponent validar');
    let valido = 'is-invalid';
    if(this.nombre.length > 2){
      this.valido = 'is-valid';
    }
    
  }
}
