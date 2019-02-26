import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-listado-multas',
  templateUrl: './listado-multas.component.html',
  styleUrls: ['./listado-multas.component.scss']
})
export class ListadoMultasComponent implements OnInit {

  multas: string[];

  constructor() {
    console.trace("ListadoMultasComponent constructor");
    this.multas = [];
   }

  ngOnInit() {
    console.trace("ListadoMultasComponent ngOnInit");
    this.multas = ['Primera', 'Segunda', 'Tercera', 'Cuarta', 'Quinta'];
  }

}
