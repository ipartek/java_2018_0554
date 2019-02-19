import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/model/persona';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  manolo: Persona; 
  constructor() { 
    this.manolo;
    console.debug("manolo sin inicializar %o", this.manolo);
    this.manolo.nombre = 'Manolo';
    console.debug("Dame tu nombre " + this.manolo.nombre);
  }

  ngOnInit() {
  }

}
