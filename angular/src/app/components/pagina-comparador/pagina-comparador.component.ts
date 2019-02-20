import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pagina-comparador',
  templateUrl: './pagina-comparador.component.html',
  styleUrls: ['./pagina-comparador.component.scss']
})
export class PaginaComparadorComponent implements OnInit {
  frutas: any[];
  frutaSelec1: any;
  frutaSelec2: any;
  carritoCompra: any[];
  precioTotalCompra: number;

  constructor() {
    this.frutas = [
      {
        "nombre": "Fresa",
        "oferta": true,
        "precio": 3.59,
        "descuento": 5,
        "imagen": "https://media.mercola.com/assets/images/foodfacts/strawberry-nutrition-facts.jpg",
        "colores": [{
          "nombre": "rojo", "codigo": "#FF0000"
        }]
      },
      {
        "nombre": "pomelo",
        "oferta": false,
        "precio": 7.43,
        "descuento": 7,
        "imagen": "http://frutasfercas.com/wp-content/uploads/2018/03/pomelo-1.jpg",
        "colores": [
          { "nombre": "rojo", "codigo": "#F00" },
          { "nombre": "naranja", "codigo": "#FF9800" }
        ]
      },
      {
        "nombre": "chirimoya",
        "oferta": true,
        "precio": 10,
        "descuento": 0,
        "imagen": "https://media.mercola.com/assets/images/foodfacts/cherimoya-nutrition-facts.jpg",
        "colores": [
          { "nombre": "verde", "codigo": "#0F0" }]
      },
      {
        "nombre": "manzana",
        "oferta": true,
        "precio": 5.59,
        "descuento": 3.5,
        "imagen": "https://www.comenaranjas.com/images/stories/virtuemart/product/manzana-royal.jpg",
        "colores": [
          { "nombre": "verde", "codigo": "#0f0" },
          { "nombre": "roja", "codigo": "#f00" },
          { "nombre": "amarillo", "codigo": "#ff0" }
        ]
      },
      {
        "nombre": "tamarindo",
        "oferta": true,
        "precio": 13.70,
        "descuento": 3,
        "imagen": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTuiEhT2_yFMqcz3TlSGzmwVqrOXJnO1gdlEd5ErYl4ynfte4J",
        "colores": [
          { "nombre": "verde", "codigo": "#0f0" },
          { "nombre": "negro", "codigo": "#000" }
        ]
      }
    ];
    this.frutaSelec1 = this.frutas[0];
    this.frutaSelec2 = this.frutas[1];
    this.carritoCompra = [];
    this.precioTotalCompra = 0;
  }

  ngOnInit() {
  }

  cambiarFruta(i: number) {
    console.log("cambiarFruta: index " + i + " fruta seleccionada");
    this.frutaSelec2 = this.frutaSelec1;
    this.frutaSelec1 = this.frutas[i];
  }
  /**
   * Metodo que esta escuchando al Output del hijo y que añade frutas al carrito de la compra
   * @param event en el evento se le manda la fruta que se ha seleccionado para introducirla al carrito
   */
  anadirACarrito(event) {
    let frutaAnadir = event;
    //Cada vez que se añade una fruta se actualiza el precio total de la compra
    //this.precioTotalCompra = this.precioTotalCompra + event.precio;
    this.precioTotalCompra = this.carritoCompra.map(f=>f.precio).reduce((p,c)=>{return p+c},0);

    this.carritoCompra.push(frutaAnadir);
  }
  elimarFrutaCarrito(f: any) {
    //TODO falta restar del precio total cuando se elimina la fruta
      //esto resta su precio, de la fruta eliminada, al preciototal
      //this.precioTotalCompra = this.precioTotalCompra - f.precio;
    this.precioTotalCompra = this.carritoCompra.map(f=>f.precio).reduce((p,c)=>{return p+c},0);
    this.carritoCompra = this.carritoCompra.filter(fruta =>{return fruta.nombre !== f.nombre});
  }
}
