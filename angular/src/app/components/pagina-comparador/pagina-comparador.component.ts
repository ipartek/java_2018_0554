import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pagina-comparador',
  templateUrl: './pagina-comparador.component.html',
  styleUrls: ['./pagina-comparador.component.scss']
})
export class PaginaComparadorComponent implements OnInit {
  frutas: any;
  frutaSelec1: any;
  frutaSelec2: any;
  frutaCarrito:any;
  totalFrutaCarrito: number;

  constructor() {
    this.totalFrutaCarrito=0;
    this.frutaCarrito = [];
    this.frutas = [
      {
        'nombre': 'fresa',
        'oferta': true,
        'precio': 3.59,
        'descuento': 5,
        'imagen': 'https://media.mercola.com/assets/images/foodfacts/strawberry-nutrition-facts.jpg',
        'colores': [
          { 'nombre': 'rojo' , 'codigo': '#F00'}
        ]
      },
      {
        'nombre': 'pomelo',
        'oferta': false,
        'precio': 7.43,
        'descuento': 7,
        'imagen': 'http://frutasfercas.com/wp-content/uploads/2018/03/pomelo-1.jpg',
        'colores': [
          {'nombre': 'rojo', 'codigo': '#F00'},
          {'nombre': 'naranja', 'codigo': '#FFA500'},
        ]
      },
      {
        'nombre': 'chirimoya',
        'oferta': false,
        'precio': 10,
        'descuento': 0,
        'imagen': 'https://media.mercola.com/assets/images/foodfacts/cherimoya-nutrition-facts.jpg',
        'colores': [
          {'nombre': 'verde', 'codigo': '#0F0'}
        ]
      },
      {
        'nombre': 'manzana',
        'oferta': true,
        'precio': 5.59,
        'descuento': 3.5,
        'imagen': 'https://www.comenaranjas.com/images/stories/virtuemart/product/manzana-royal.jpg',
        'colores': [
          {'nombre': 'verde', 'codigo': '#0F0'},
          {'nombre': 'rojo', 'codigo': '#F00'},
          {'nombre': 'amarillo', 'codigo': '#FF0'}
        ]
      },
      {
        'nombre': 'tamarindo',
        'oferta': true,
        'precio': 13.70,
        'descuento': 3,
        'imagen': 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTuiEhT2_yFMqcz3TlSGzmwVqrOXJnO1gdlEd5ErYl4ynfte4J',
        'colores': [
          {'nombre': 'negro', 'codigo': '#000'},
          {'nombre': 'verde', 'codigo': '#0F0'}
        ]
      }
    ];

    this.frutaSelec1 = this.frutas[0];
    this.frutaSelec2 = this.frutas[1];

   
  }

  ngOnInit() {
  }
  cambiarFruta(i:number){
    console.log('click cambiarFruta %o', i);
    this.frutaSelec2 = this.frutaSelec1;
    this.frutaSelec1 = this.frutas[i];
  }

  escucho(event){
    
    this.frutaCarrito.push(event);
    this.totalFrutaCarrito = this.frutaCarrito.map( f => f.precio).reduce((p, c) => { return p + c }, 0);
    
  }

}
