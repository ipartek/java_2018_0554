import { Component, OnInit } from '@angular/core';

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

    this.contador = 0;
    this.tiempo = 10;
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

}
