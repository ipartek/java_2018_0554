import { Component, OnInit } from '@angular/core';

const TIEMPO_JUEGO: number = 10;

@Component({
  selector: 'app-juego',
  templateUrl: './juego.component.html',
  styleUrls: ['./juego.component.scss']
})
export class JuegoComponent implements OnInit {

  contador: number;
  tiempo: number;
  intervalo;

  constructor() {
    console.trace('JuegoComponent constructor');

    this.contador = 0;
    this.tiempo = TIEMPO_JUEGO;
   }

  ngOnInit() {
    console.trace('JuegoComponent ngOnInit');
  }

  start(){
    console.trace('click start');

    let that = this;
    let interval = setInterval(function(){
      console.debug('restar');
      if(that.tiempo > 0){
        that.tiempo--;
      } else{
        console.debug('parar');
        this.clearInterval(interval);
      }
    }, 1000);
  }

  restart(){
    this.tiempo = TIEMPO_JUEGO;
    this.contador = 0;
  }

  sumar(){
    console.debug('volver a empezar');
    console.trace('click boton sumar');
    this.contador++;
  }

}
