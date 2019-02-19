import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pagina-concesionario',
  templateUrl: './pagina-concesionario.component.html',
  styleUrls: ['./pagina-concesionario.component.scss']
})
export class PaginaConcesionarioComponent implements OnInit {

  coches: any[];

  constructor() { 
    this.coches =
    [
      {
        "modelo": "PEUGEOT 207",
        "combustible": "Diésel",
        "precio": 4800,
        "km": 195000,
        "imagen": "https://a.ccdn.es/cnet/2019/01/12/36862042/168966887_g.jpg"
      },
      {
        "modelo": "FIAT 500L",
        "combustible": "Diésel",
        "precio": 12990,
        "km": 7000,
        "imagen": "https://a.ccdn.es/cnet/2019/02/18/37438914/173356643_g.jpg"
      }
    ];
  }

  ngOnInit() {
  }

}
