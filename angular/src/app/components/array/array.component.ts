import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-array',
  templateUrl: './array.component.html',
  styleUrls: ['./array.component.scss']
})
export class ArrayComponent implements OnInit {

  frutas: any;
  f_nombres: any[];
  f_precios: any[];

  constructor() {
    console.trace("ArrayComponent constructor")
    this.frutas = [
      {
        "nombre": "fresa",
        "oferta": true,
        "precio": 3.59,
        "descuento": 5,
        "imagen": "https://media.mercola.com/assets/images/foodfacts/strawberry-nutrition-facts.jpg",
        "colores": [
          { "nombre": "rojo" , "codigo": "#F00"}
        ]
      },
      {
        "nombre": "pomelo",
        "oferta": false,
        "precio": 7.43,
        "descuento": 7,
        "imagen": "http://frutasfercas.com/wp-content/uploads/2018/03/pomelo-1.jpg",
        "colores": [
          {"nombre": "rojo", "codigo":"#F00"},
          {"nombre": "naranja", "codigo":"#FFA500"},
        ]
      },
      {
        "nombre": "chirimoya",
        "oferta": true,
        "precio": 10,
        "descuento": 0,
        "imagen": "https://media.mercola.com/assets/images/foodfacts/cherimoya-nutrition-facts.jpg",
        "colores": [
          {"nombre": "verde", "codigo":"#0F0"}
        ]
      },
      {
        "nombre": "manzana",
        "oferta": true,
        "precio": 5.59,
        "descuento": 3.5,
        "imagen": "https://www.comenaranjas.com/images/stories/virtuemart/product/manzana-royal.jpg",
        "colores": [
          {"nombre": "verde", "codigo":"#0F0"},
          {"nombre": "rojo", "codigo":"#F00"},
          {"nombre": "amarillo", "codigo":"#FF0"}
        ]
      },
      {
        "nombre": "tamarindo",
        "oferta": true,
        "precio": 13.70,
        "descuento": 3,
        "imagen": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTuiEhT2_yFMqcz3TlSGzmwVqrOXJnO1gdlEd5ErYl4ynfte4J",
        "colores": [
          {"nombre": "negro", "codigo":"#000"},
          {"nombre": "verde", "codigo":"#0F0"}
        ]
      }      
    ];

    console.trace("Comenzamos a mapear");
    this.f_nombres = this.frutas.map( (value, index, array) => {
      console.debug('Value: ' + value);
      console.debug('Index: ' + index);
      console.debug('Array: ', array);
      return value.nombre;
    } );

    this.f_precios = this.frutas.map( fruta => {return fruta.precio} );
   }

  ngOnInit() {
    console.trace("ArrayComponent ngOnInit")
  }

}
