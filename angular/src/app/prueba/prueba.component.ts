import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-prueba',
  templateUrl: './prueba.component.html',
  styleUrls: ['./prueba.component.scss']
})
export class PruebaComponent implements OnInit {
  //variable tipo number
  contador:number;
  tiempo:number;

  constructor() { 
    console.trace('PruebaComponent constructor');
    //inicilizar las variables en el constructor
    this.contador=0;
    this.tiempo=10;

  }

  ngOnInit() {
    console.trace('PruebaComponent ngOnInit');
  }

  sumar(){
    console.trace('botonSumar++');
    this.contador++;
  }

}
