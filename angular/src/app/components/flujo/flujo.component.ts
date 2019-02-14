import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-flujo',
  templateUrl: './flujo.component.html',
  styleUrls: ['./flujo.component.scss']
})
export class FlujoComponent implements OnInit {

  //Declaramos dentro de la class
  expresion: string;
  isHidden: boolean;
  claseModelo: string;

  constructor() { 
    console.trace("Constructor FlujoComponent");
    //Las inicializamos en el constructor
    this.expresion="Soy una variable inicializada en el Modelo";
    this.isHidden = true;
    this.claseModelo = "text-primary";
  }

  ngOnInit() {
    console.trace("ngOnInit FlujoComponent");
  }

  cambioColor(clase: string){
    console.trace("cambioColor FlujoComponent");
    this.claseModelo = clase;
    }
    
  }


