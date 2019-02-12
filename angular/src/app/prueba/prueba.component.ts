import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-prueba',
  templateUrl: './prueba.component.html',
  styleUrls: ['./prueba.component.scss']
})
export class PruebaComponent implements OnInit {

  // variable tipo numerica
  contador: number;
  tiempo: number;

  constructor() {
    console.trace('PruebaComponent constructor');

    //inicializar las variables
    this.contador = 0;
    this.tiempo = 10; //seg
  }

  ngOnInit() {
    console.trace('PruebaComponent ngOnInit');
  }

  start(){
    console.trace('click start');
    let that = this;
    
    setInterval(function() {      
      console.debug('restar');
      if( that.tiempo > 0 ){
        that.tiempo = that.tiempo - 1;
      }  
  }, 1000);
    
  }

  sumar(){
    console.trace('click botton sumar');
    if ( this.tiempo > 0 ){
      this.contador++;
    }  
  }

}
