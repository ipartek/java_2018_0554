import { Component, OnInit } from '@angular/core';

const TIEMPO_JUEGO: number = 10;

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
    this.tiempo=TIEMPO_JUEGO;
  }

  ngOnInit() {
    console.trace('PruebaComponent  ngOnInit');
  }

  sumar(){
    console.log('click boton sumar');
    if(this.tiempo>0){
      this.contador++;
    }
  }

  start(){
    let that = this;
    let intervalo=setInterval(()=>{
      console.debug('restar');
      if(that.tiempo>0){
        that.tiempo--;
      }else{
        console.debug('parar');
        clearInterval(intervalo);
      }
    },1000)
  }

  restart(){
    console.trace('Se ha reseteado la partida');
    this.tiempo=TIEMPO_JUEGO;
    this.contador=0;
  }
}
