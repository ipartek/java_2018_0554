import { Component, OnInit } from '@angular/core';
import { CarritoComponent } from '../carrito/carrito.component';

@Component({
  selector: 'app-pagina-comparador',
  templateUrl: './pagina-comparador.component.html',
  styleUrls: ['./pagina-comparador.component.scss']
})
export class PaginaComparadorComponent implements OnInit {

  frutas: any[];
  frutaSelect1: any;
  frutaSelect2: any;
  carrito: any[];
  precioTotal: number;
  precioTotalDescuento: number;

  constructor() { 
    this.frutas = [
      {
        "nombre": "fresa",
        "oferta": true,
        "precio": 3.59,
        "descuento": 5,
        "imagen": "https://media.mercola.com/assets/images/foodfacts/strawberry-nutrition-facts.jpg",
        "colores": [
          { "nombre": "rojo", "codigo": "#F00" }
        ]
      },
      {
        "nombre": "pomelo",
        "oferta": false,
        "precio": 7.43,
        "descuento": 7,
        "imagen": "http://frutasfercas.com/wp-content/uploads/2018/03/pomelo-1.jpg",
        "colores": [
          { "nombre": "rojo", "codigo": "#F00" },
          { "nombre": "naranja", "codigo": "#FFA500" },
        ]
      },
      {
        "nombre": "chirimoya",
        "oferta": true,
        "precio": 10,
        "descuento": 0,
        "imagen": "https://media.mercola.com/assets/images/foodfacts/cherimoya-nutrition-facts.jpg",
        "colores": [
          { "nombre": "verde", "codigo": "#0F0" }
        ]
      },
      {
        "nombre": "manzana",
        "oferta": true,
        "precio": 5.59,
        "descuento": 3.5,
        "imagen": "https://www.comenaranjas.com/images/stories/virtuemart/product/manzana-royal.jpg",
        "colores": [
          { "nombre": "verde", "codigo": "#0F0" },
          { "nombre": "rojo", "codigo": "#F00" },
          { "nombre": "amarillo", "codigo": "#FF0" }
        ]
      },
      {
        "nombre": "tamarindo",
        "oferta": true,
        "precio": 13.70,
        "descuento": 3,
        "imagen": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTuiEhT2_yFMqcz3TlSGzmwVqrOXJnO1gdlEd5ErYl4ynfte4J",
        "colores": [
          { "nombre": "negro", "codigo": "#000" },
          { "nombre": "verde", "codigo": "#0F0" }
        ]
      }
    ];

    this.frutaSelect1 = this.frutas[0];
    this.frutaSelect2 = this.frutas[1];
    this.carrito=[];
    this.precioTotal = 0;
    this.precioTotalDescuento = 0;
  }

  ngOnInit() {
  }

  cambiarFruta(i: number){
    console.log("Hemos hecho click en cambiar fruta %o", i)
    this.frutaSelect2 = this.frutaSelect1;
    this.frutaSelect1 = this.frutas[i];
  }

  eliminarProducto(fruta:any){
    let cantidad:number = this.carrito.filter(f => f.nombre === fruta.nombre).length;
    this.carrito = this.carrito.filter(f => f.nombre !== fruta.nombre);
    this.precioTotal = (this.precioTotal - (fruta.precio * cantidad));
    this.precioTotalDescuento = (this.precioTotalDescuento - (fruta.precio - ((fruta.precio * fruta.descuento)/100)) * cantidad);
  }


  
  recibirCarrito(event){
    //alert("He recibido un evento del Hijo prueba=" + event.nombre);
    this.carrito.push(event);
    this.precioTotal += event.precio;
    //this.TotalCarro = this.carrito.map(f=> f.precio).reduce((p,c)=>{return p + c}, 0)
    this.precioTotalDescuento += (event.precio - ((event.precio * event.descuento) / 100))
  }
}
