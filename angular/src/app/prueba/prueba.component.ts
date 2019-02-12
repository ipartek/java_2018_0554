import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-prueba',
  templateUrl: './prueba.component.html',
  styleUrls: ['./prueba.component.scss']
})
export class PruebaComponent implements OnInit {

  // Variable tipo numérica
  contador : number; //Nombre y tipo

  constructor() {
    console.trace('Prueba component constructor');
    
    //Inicializar las variables
    this.contador = 0;


   }

  ngOnInit() {
    console.trace('Prueba component ngOnInit');
  }

  sumar(){
    console.trace('Click boton sumar');
    this.contador++;
  }

}
