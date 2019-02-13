import { Component, OnInit } from '@angular/core';

const TIEMPO_JUEGO: number = 10;
const RESET_CONTADOR: number = 0;

@Component({
  selector: 'app-juego-click',
  templateUrl: './juego-click.component.html',
  styleUrls: ['./juego-click.component.scss']
})
export class JuegoClickComponent implements OnInit {

  //Variables
  contador : number;
  tiempo : number;

  constructor() { 
    console.trace('Prueba component constructor');

    this.contador = RESET_CONTADOR;
    this.tiempo = TIEMPO_JUEGO;
  }

  ngOnInit() {
    console.trace('Prueba component ngOnInit');
  }

  start(){
    let that = this;
    let interval = setInterval(function(){
      that.tiempo--;

      if(that.tiempo === 0){
       document.getElementById("click").setAttribute("disabled", "disabled");
        this.clearInterval(interval);
      }

    }, 1000);
  }

  sumar(){
    console.trace('Prueba component click sumar');

    this.contador++;
  }

  restart(){
    this.contador=RESET_CONTADOR;
    this.tiempo=TIEMPO_JUEGO;
    document.getElementById("click").removeAttribute("disabled");
  }

}
