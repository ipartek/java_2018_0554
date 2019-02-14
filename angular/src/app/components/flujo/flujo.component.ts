import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-flujo',
  templateUrl: './flujo.component.html',
  styleUrls: ['./flujo.component.scss']
})
export class FlujoComponent implements OnInit {
  //declaramos dentro de la clase
  expresion: string;
  ocultar :boolean;
  claseModelo :string;
  nombre:string;
 

  constructor() {
    console.trace('FlujoComponent constructor');
    //inicializamos en el constructor
    this.expresion= "Variable inicilizada en el Modelo";
    this.ocultar=true;
    this.claseModelo="text-primary";
    this.nombre="";
  }
  
 
  cambiarClase(claseSeleccionada:string) {
    console.trace("CLICK RADIO "+claseSeleccionada);
    this.claseModelo=claseSeleccionada;
    
  }
  borrar(){
    this.nombre = '';
  }
  ngOnInit() {
  }

}
