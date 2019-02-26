import { Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-pagina-concesionario',
  templateUrl: './pagina-concesionario.component.html',
  styleUrls: ['./pagina-concesionario.component.scss']
})
export class PaginaConcesionarioComponent implements OnInit {
  
  
  coches: any[];
  cocheSelec1: any[];
  carrito: any[];
  totalCarro: number;
  constructor() {
    this.coches = [
      {
        "marca": "Lamborghini",
        "modelo": "Urus",
        "imagen": "https://www.motor.es/fotos-ficha/lamborghini/grande-version/lamborghini-urus-37455_1.jpg",
        "precio": 171429,

      },
      {
        "marca": "Audi",
        "modelo": "Q8",
        "imagen": "https://static.hoy.es/www/multimedia/201810/12/media/cortadas/AUDI_Q8-kQtB-U601227667413EgD-624x385@RC.jpg",
        "precio": 84840,
      },
      {
        "marca": "Porsche",
        "modelo": "Cayenne",
        "imagen": "https://cdn77.motor.es/fotos-ficha/porsche/medianas/porsche-cayenne-turbo-7154_1.jpg",
        "precio": 87579,
      },
      {
        "marca": "Ferrari",
        "modelo": "FUV",
        "imagen": "https://static1.squarespace.com/static/5a55226f51a584f83427df20/t/5b314e150e2e72326c3c395d/1529957946877/image1.jpeg",
        "precio": 250000,
      },
      {
        "marca": "Mercedes",
        "modelo": "GLA",
        "imagen": "https://www.mercedes-benz.es/passengercars/mercedes-benz-cars/models/gla/gla-suv/explore/vehicle-highlights/_jcr_content/highlightcontainer/image.MQ6.0.20180115103444.jpeg",
        "precio": 61820,
      },
      {
        "marca": "BMW",
        "modelo": "X6",
        "imagen": "https://www.autobild.es/sites/autobild.es/public/styles/main_element/public/dc/fotos/BMW_X6M_002.jpg?itok=tvpeoR9m",
        "precio": 81950,
      },
      {
        "marca": "CITRÖEN",
        "modelo": "DS5 Crossback",
        "imagen": "http://i.i-sgcm.com/news/article_news/2016/15137_p1_s_1.jpg",
        "precio": 34080,
      },
      {
        "marca": "TESLA",
        "modelo": "Model X",
        "imagen": "https://www.diariomotor.com/imagenes/picscache/375x250c/tesla-model-x-3_375x250c.jpg",
        "precio": 116780,
      }
    ];

    this.cocheSelec1 = this.coches[0];
  }

  ngOnInit() {
  }

  cambiarCoche(i:number){
    console.log('click cambiarCoche %o', i);
    this.cocheSelec1 = this.coches[i];
  }



  addCarrito(event){
    this.carrito.push(event);

    //calcular totales
    this.totalCarro = this.carrito.map( f=> f.precio ).reduce( (p,c)=>{ return p+c }, 0);
  }
  /*eliminarCarro( cocheSelec1: any ): void{
    console.trace('click eliminar %o', cocheSelec1 );
    this.carrito = this.carrito.filter( c=> {return c.marca !== cocheSelec1.marca});

     //calcular totales
    this.totalCarro = this.carrito.map( c=> c.precio ).reduce( (p,c)=>{ return p+c }, 0);
  }*/
 
}
