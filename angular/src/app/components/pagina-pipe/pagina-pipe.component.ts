import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pagina-pipe',
  templateUrl: './pagina-pipe.component.html',
  styleUrls: ['./pagina-pipe.component.scss']
})
export class PaginaPipeComponent implements OnInit {
  
  nombre:string;
  numero:number;
  cadena: string;
  constructor() { 
    console.trace('PaginaPipeComponent constructor');
    this.nombre= 'Manolito Gafotas';
    this.numero = 3.14151678;
    this.cadena = '  Hola    Que     Axé      '; 
  }

  ngOnInit() {
    console.trace('PaginaPipeComponent ngOnInit');
  }

}
