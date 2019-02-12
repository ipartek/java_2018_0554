import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-prueba',
  templateUrl: './prueba.component.html',
  styleUrls: ['./prueba.component.scss']
})
export class PruebaComponent implements OnInit {

  //varibale tipo numerica
  contador: number;
  tiempo:number;

  constructor() { 
    console.trace('PruebaComponent constructor');

    //inicializar variable
    this.contador=0;
    this.tiempo=10;
  }

  ngOnInit() {
    console.trace('PruebaComponent  ngOnInit');
  }

  sumar(){
    console.log('click boton sumar');
    this.contador++;
  }

  startContador(){
    setInterval(()=>{
      this.tiempo--;
    },10000)
  }
}
