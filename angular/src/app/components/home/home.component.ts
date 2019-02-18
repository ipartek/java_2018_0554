import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/model/persona';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  manolo:Persona;
  anonimo:Persona;
  constructor() { 
    this.manolo = new Persona('Manolo');
    this.anonimo = new Persona();
    }

  ngOnInit() {
  }

}
