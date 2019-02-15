import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-array',
  templateUrl: './array.component.html',
  styleUrls: ['./array.component.scss']
})
export class ArrayComponent implements OnInit {

  isOferta:boolean;
  frutas: any[];
  f_nombres:any[];
  f_precios:any[];
  f_precios_nombre:any[];
  f_oferta:any[];
  f_no_oferta:any[];
  f_oferta_pares:any[];
  total_frutas:any[];
  total_frutas_oferta:any[];
  fruta_color_verde:any[];

  constructor() { 
    console.log('ArrayComponent constructor ');
    this.isOferta=false;
    this.frutas=[
      {
        "nombre": "fresa",
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
      },
      {
        "nombre": "chirimoya",
        "oferta": true,
        "precio": 10,
        "descuento": 0,
        "imagen": "https://media.mercola.com/assets/images/foodfacts/cherimoya-nutrition-facts.jpg",
        "colores": [
          {"nombre": "verde","codigo":"#0F0"}]
      },
      {
        "nombre": "manzana",
        "oferta": true,
        "precio": 5.59,
        "descuento": 3.5,
        "imagen": "https://www.comenaranjas.com/images/stories/virtuemart/product/manzana-royal.jpg",
        "colores": [
          {"nombre": "verde","codigo": "#0f0"},
          {"nombre": "roja","codigo": "#f00"},
          {"nombre": "amarillo","codigo": "#ff0"}
        ]
      },
      {
        "nombre": "tamarindo",
        "oferta": true,
        "precio": 13.70,
        "descuento": 3,
        "imagen": "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQTuiEhT2_yFMqcz3TlSGzmwVqrOXJnO1gdlEd5ErYl4ynfte4J",
        "colores": [
          {"nombre": "verde","codigo": "#0f0"},
          {"nombre": "negro","codigo": "#000"}
        ]
      }
    ];

    console.trace('comenzamos a mapear el array de frutas');
    //this.f_nombres=this.frutas.map(fruta => {return fruta.nombre});
    this.f_nombres=this.frutas.map((value,index,array) => {
      console.debug('value: ' +value);
      console.debug('index: ' +index);
      console.debug('array: ' +array);
      return value.nombre;
    });
    this.f_precios_nombre=this.frutas.map((fruta)=>{
      let f;
      f={
      "nombre":fruta.nombre,
      "precio":fruta.precio
      }
        
      return f;
    });

    //MAP,FILTER,MAP
    //map(value,index,array)
    //filter(value,index,array)
    //map(actual,previous,index,array),valor de previous hay que inicializarlo => 0 ej:.reduce((p,c)=>{return p +c},0);
    this.f_precios=this.frutas.map(fruta => {return fruta.precio});

    this.f_oferta=this.frutas.filter(f =>f.oferta).map(f=>{return f.nombre});
    this.f_no_oferta=this.frutas.filter(f =>!f.oferta).map(f=>{return f.nombre});
    this.f_oferta_pares=this.frutas.filter((f,i)=>(f.oferta && (i%2==0))).map(f=>{return f.nombre});
    this.total_frutas = this.frutas.map(f=>{return f.precio}).reduce((p,c)=>{return p +c},0);
    this.total_frutas_oferta = this.frutas.filter(f=>f.oferta).map(f=>{return f.precio}).reduce((p,c)=>{return p +c},0);
    this.fruta_color_verde= this.frutas.find(el => el.colores.find(e=>e.nombre==="verde"));
  }

  ngOnInit() {
    console.log('ArrayComponent ngOnInit ');
  }

  calcularDescuento(fruta:any):number{
    return fruta.precio-((fruta.precio*fruta.descuento)/100);
  }
  cambiarOferta(value:boolean){
    this.isOferta = value;
    console.debug('cambiarOferta ' + this.isOferta);
  }
}
