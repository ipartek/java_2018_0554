import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pagina-concesionario',
  templateUrl: './pagina-concesionario.component.html',
  styleUrls: ['./pagina-concesionario.component.scss']
})
export class PaginaConcesionarioComponent implements OnInit {

  coches: any[];
  cocheSelec: any;
  carrito: any[];

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
      },
      {
        "modelo": "VOLKSWAGEN Golf",
        "combustible": "Diésel",
        "precio": 5600,
        "km": 195000,
        "imagen": "https://a.ccdn.es/cnet/2019/01/29/37125069/171072492_g.jpg"
      },
      {
        "modelo": "MERCEDES-BENZ Clase C",
        "combustible": "Diésel",
        "precio": 32850,
        "km": 75581,
        "imagen": "https://a.ccdn.es/cnet/2019/01/31/37157312/171375846_g.jpg"
      }
    ];
    this.cocheSelec = this.coches[0];
  }

  ngOnInit() {
  }

  cambiarCoche(i:number){
    this.cocheSelec = this.coches[i];
  }

}
