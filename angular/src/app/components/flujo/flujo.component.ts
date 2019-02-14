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
  nombre: string;
  claseInput: string;

  constructor() { 
    console.trace("Constructor FlujoComponent");
    //Las inicializamos en el constructor
    this.expresion="Soy una variable inicializada en el Modelo";
    this.isHidden = true;
    this.claseModelo = "text-primary";
    this.claseInput = "form-control";
    this.nombre="Todavía no me lo has dicho";
  }

  ngOnInit() {
    console.trace("ngOnInit FlujoComponent");
  }

  cambioColor(clase: string){
    console.trace("cambioColor FlujoComponent");
    this.claseModelo = clase;
    }

    borrar(){
      this.nombre = '';
      this.claseInput="form-control";
    }

    comprobarNombre(){
      if(this.nombre.length >= 3){
        this.claseInput="form-control is-valid";
      }else{
        this.claseInput="form-control is-invalid";
      }
    }

  }


