import { Component, OnInit } from '@angular/core';


const TIEMPO_JUEGO: number = 10;

@Component({
  selector: 'app-prueba',
  templateUrl: './prueba.component.html',
  styleUrls: ['./prueba.component.scss']
})
export class PruebaComponent implements OnInit {
 
  // variable tipo numerica
  contador: number;
  tiempo: number;
  intervalo;

  constructor() {
    //console.trace('PruebaComponent constructor');

    //inicializar las variables
    this.contador = 0;
    this.tiempo = TIEMPO_JUEGO; //seg
  }

  ngOnInit() {
    //console.trace('PruebaComponent ngOnInit');
  }

  restart(){
    console.trace('click restart');
    this.tiempo = TIEMPO_JUEGO;
    this.contador = 0;
  }

  start(){
    console.trace('click start');

    let that = this;    
    let interval = setInterval(function() {      
      console.debug('restar');  
      if ( that.tiempo > 0){   
        that.tiempo--;       
      }else{
        console.debug('parar');  
        this.clearInterval(interval);
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
