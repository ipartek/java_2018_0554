import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-fruta',
  templateUrl: './fruta.component.html',
  styleUrls: ['./fruta.component.scss']
})
export class FrutaComponent implements OnInit {
fruta:any;
  constructor() {
    this.fruta = 
      {'nombre': 'pomelo',
      'oferta': false,
      'precio': 7.43,
      'descuento': 7,
      'imagen': 'http://frutasfercas.com/wp-content/uploads/2018/03/pomelo-1.jpg',
      'colores': [
        {'nombre': 'rojo', 'codigo': '#F00'},
        {'nombre': 'naranja', 'codigo': '#FFA500'},
      ]
      };
  }
  calcularDescuento(fruta:any):number{
    return (fruta.precio - (fruta.precio)*fruta.descuento/100);
 }
  ngOnInit() {
  }

}
