import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-flujo',
  templateUrl: './flujo.component.html',
  styleUrls: ['./flujo.component.scss']
})
export class FlujoComponent implements OnInit {

  // Declaramos dentro de la clase
  expresion: string;
  isHidden:boolean;
  claseModelo: string;
  nombre: string;

  constructor() { 
    console.trace('FlujoComponent constructor');
    // Las inicializamos en el constructor
    this.expresion= "Soy una variable inicializada en el modelo";
    this.isHidden=true;
    this.claseModelo='text-primary';
    this.nombre='Todavía no me lo has dicho';
  }

  ngOnInit() {
    console.trace('FlujoComponent ngOnInit');
  }

  cambiocolor(color:string){
    console.trace('Color:' + color);
    this.claseModelo = color;
  }

  borrar(){
    this.nombre="";
  }
}
