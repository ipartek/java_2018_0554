import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pagina-pipe',
  templateUrl: './pagina-pipe.component.html',
  styleUrls: ['./pagina-pipe.component.scss']
})
export class PaginaPipeComponent implements OnInit {

  nombre: string;
  numero: number;
  texto: string;

  constructor() {
    console.trace("PaginaPipeComponent constructor");
    this.nombre='MaNoLiTO gaFOTas';
    this.numero=3.14567890;
    this.texto='    texto Con Espacios       ';
   }

  ngOnInit() {
    console.trace("PaginaPipeComponent ngOnInit");
  }

}
