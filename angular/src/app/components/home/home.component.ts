import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/model/persona';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
manolo:Persona;
  constructor() {
    this.manolo = new Persona;
    console.debug("manoloc sin inicializar %o", this.manolo);
    this.manolo.nombre ='man';
    console.debug("dame tu nombre" +this.manolo.nombre);
   }

  ngOnInit() {
  }

}
