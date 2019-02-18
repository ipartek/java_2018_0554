import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pagina-comparador-coche',
  templateUrl: './pagina-comparador-coche.component.html',
  styleUrls: ['./pagina-comparador-coche.component.scss']
})
export class PaginaComparadorCocheComponent implements OnInit {
  coches:any[];
  cocheSeleccionado:any;
  searchText: string;

  constructor() { 
    console.log('PaginaComparadorCocheComponent constructor ');
    this.coches=[
      {
        "nombre": "Seat Leon TSI",
        "precio": 15000,
        "imagen": "https://static.auto-online.ch/car_pictures/41/2952941/SEAT-Leon-CONNECT-1-4TSI-125PS-NAVI-LED-SITZHZG-ALU-2-2952941-3-1.jpg",
        "colores": [
          {"nombre": "rojo","codigo":"#FF0000"},
          {"nombre": "verde","codigo": "#0f0"},
          {"nombre": "negro","codigo": "#000"}
        ]
      },
      {
        "nombre": "Nissan S15",
        "precio": 18000,
        "imagen": "http://www.neweraimports.com/Nebusis/pictures/cars/1303196632329//pic1303197475898.jpg",
        "colores": [
          {"nombre": "rojo","codigo":"#FF0000"},
          {"nombre": "gris","codigo": "#9C9C9C"},
          {"nombre": "negro","codigo": "#000"}
        ]
      },
      {
        "nombre": "Opel Astra",
        "precio": 4000,
        "imagen": "https://es.autodata24.com/i/opel/astra/astra-f/large/38225217930f661261660e0c31a218c6.jpg",
        "colores": [
          {"nombre": "negro","codigo": "#000"}
        ]
      }
    ];
    this.cocheSeleccionado= this.coches[0];
    this.searchText="";
  }

  ngOnInit() {
    console.log('PaginaComparadorCocheComponent ngOnInit ');
  }

  cambiarCoche(i:number){
    console.log('Se ha cambiado de coche');
    this.cocheSeleccionado = this.coches[i];
  }
}
