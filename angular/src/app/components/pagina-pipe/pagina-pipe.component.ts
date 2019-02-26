import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pagina-pipe',
  templateUrl: './pagina-pipe.component.html',
  styleUrls: ['./pagina-pipe.component.scss']
})
export class PaginaPipeComponent implements OnInit {

  nombre: string;
  numero: number;

  constructor() {
    console.trace('PaginaPipeComponent constructor');
    this.nombre = 'MasaLSOASDdsa';
    this.numero = 3.145465454564;

   }

  ngOnInit() {
    console.trace('PaginaPipeComponent ngOnIt');
  }

}
