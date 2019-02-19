import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pagina-array',
  templateUrl: './pagina-array.component.html',
  styleUrls: ['./pagina-array.component.scss']
})
export class PaginaArrayComponent implements OnInit {

  isOferta: boolean;
  searchText: string;
  frutas: any[];

  //arrays para filtrar, reduce, map, etc..
  f_nombres: any[];
  f_precios: any[];
  f_precios_nombre: any[];
  f_oferta: any[];
  f_no_oferta: any[];
  total_frutas: number;
  total_frutas_oferta: number;

  constructor() {
    console.trace('PaginaArrayComponent constructor');
    this.isOferta = false;
    this.searchText = '';    
    this.frutas = [{
      "nombre": "fresa",
      "oferta": true,
      "precio": 3.59,
      "descuento": 5,
      "imagen": "https://libbys.es/wordpress/wp-content/uploads/2018/05/fresas.jpg",
      "colores":  [
        { "nombre": "rojo" , "codigo": "red"}
      ]
    },
    {
      "nombre": "pomelo",
      "oferta": false,
      "precio": 7.43,
      "descuento": 7,
      "imagen": "https://www.comenaranjas.com/images/stories/virtuemart/product/pomelo-star-ruby.jpg",
      "colores":  [
        {"nombre": "rojo", "codigo":"red"},
        {"nombre": "naranja", "codigo":"orange"},
      ]
    },
    {
      "nombre": "chirimoya",
      "oferta": true,
      "precio": 10,
      "descuento": 0,
      "imagen": "https://www.frutadelasarga.com/server/Portal_0008706/img/products/chirimoya_1258331.jpg",
      "colores": [
        { "nombre": "verde" , "codigo": "green"}
      ]
    },
    {
      "nombre": "manzana",
      "oferta": true,
      "precio": 5.59,
      "descuento": 3.5,
      "imagen": "https://t1.uc.ltmcdn.com/images/2/7/4/img_como_evitar_que_la_manzana_se_oxide_5472_600.jpg",
      "colores": [
        {"nombre": "verde", "codigo":"green"},
        {"nombre": "rojo", "codigo":"red"},
        {"nombre": "amarillo", "codigo":"yellow"},
      ]
    },
    {
      "nombre": "tamarindo",
      "oferta": true,
      "precio": 13.7,
      "descuento": 3,
      "imagen": "https://e.rpp-noticias.io/normal/2016/03/30/042804_108586.jpg",
      "colores": [
        {"nombre": "verde", "codigo":"green"},
        {"nombre": "negro", "codigo":"black"},
      ]
    }
  ];

  console.trace('comenzamos a mappear el array de frutas');
  this.f_nombres = this.frutas.map( 
    function ( value, index, array ) {       
      console.debug('value: ' + value);
      console.debug('index: ' + index);
      console.debug('array: ', array);
      return value.nombre;
    }
  );

  this.f_precios = this.frutas.map( fruta => { return fruta.precio });

  this.f_precios_nombre = this.frutas.map( fruta => { 
    return {
      "nombre" : fruta.nombre,
      "precio" : fruta.precio
    };
  });


  this.f_oferta = this.frutas.filter( f => f.oferta ).map( f => { return f.nombre });
  this.f_no_oferta = this.frutas.filter( f => !f.oferta ).map( f => { return f.nombre });

  this.total_frutas = this.frutas.map( f=>f.precio).reduce((p,c)=>{ return p + c }, 0);
  this.total_frutas_oferta = this.frutas.filter(f=>f.oferta).map( f=>f.precio).reduce((p,c)=>{ return p + c }, 0);
}

ngOnInit() {
  console.trace('PaginaArrayComponent ngOnInit');
}

calcularDescuento( fruta: any) : number {    
  return fruta.precio - ( fruta.precio * fruta.descuento / 100 );
}

cambiarOferta( value: boolean){    
  this.isOferta = value;
  console.debug('click cambiarOferta ' + this.isOferta);
}

}