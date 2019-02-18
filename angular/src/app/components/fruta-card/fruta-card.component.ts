import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-fruta-card',
  templateUrl: './fruta-card.component.html',
  styleUrls: ['./fruta-card.component.scss']
})
export class FrutaCardComponent implements OnInit {

  frutas:any[];
  isOferta:boolean;
  

  constructor() {
    this.isOferta=false;
    this.frutas=[
      {
        "nombre": "Fresa",
        "oferta": true,
        "precio": 3.59,
        "descuento": 5,
        "imagen": "https://media.mercola.com/assets/images/foodfacts/strawberry-nutrition-facts.jpg",
        "colores": [{
          "nombre": "rojo","codigo":"#FF0000"
        }]
      },
      {
        "nombre": "pomelo",
        "oferta": false,
        "precio": 7.43,
        "descuento": 7,
        "imagen": "http://frutasfercas.com/wp-content/uploads/2018/03/pomelo-1.jpg",
        "colores": [
          {"nombre": "rojo","codigo":"#F00"},
          {"nombre": "naranja","codigo":"#FF9800"}
        ]
      }];
   }

  ngOnInit() {
  }

  calcularDescuento(fruta:any):number{
    return fruta.precio-((fruta.precio*fruta.descuento)/100);
  }
  cambiarOferta(value:boolean){
    this.isOferta = value;
    console.debug('cambiarOferta ' + this.isOferta);
  }
}
