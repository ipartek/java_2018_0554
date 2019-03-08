import { Component, OnInit } from '@angular/core';
import { Casa } from 'src/app/model/casa';
import { CasaService } from 'src/app/providers/casa.service';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.sass']
})
export class PrincipalComponent implements OnInit {

  casas: Casa[];
  alquileres: Casa[];
  ventas: Casa[];
  isAlquiler: boolean;
  casaSelec:any;

  constructor(private casaService: CasaService) {
    this.casas = [];
    this.casaSelec = new Casa (-1,'',0,false,1,'','',[]);
    
  }

  ngOnInit() {

    this.cargarCasas();
  }

  

  cargarCasas() {

    this.casas = [];
    console.trace('PrincipalComponent cargarCasas');

    this.casaService.getAll().subscribe((json: any) => {

      // let info = json.info; 
      let casasJson = json;

      //map 
      console.debug('casas %o', casasJson);
      this.casas = casasJson.map(c => {
        let id = c.id;
        let nombre = c.nombre;
        let precio = c.precio;
        let alquiler = c.alquiler;
        let habitaciones = c.habitaciones;
        let foto = c.foto;
        let direccion = c.direccion;
        let servicios = c.servicios;
        return new Casa(id,nombre, precio, alquiler, habitaciones, foto, direccion, servicios );
      });
    });

    

  }


  /*argarAlquiler() {

    this.alquileres = [];
    console.trace('PrincipalComponent cargarAlquiler');
    this.isAlquiler = true;
    this.casaService.getAll().subscribe((json: any) => {

      // let info = json.info; 
      let alquileresJson = json;

      //map 
      console.debug('alquileres %o', alquileresJson);
      this.alquileres = alquileresJson.map(a => {
        let nombre = a.nombre;
        let precio = a.precio;
        let alquiler = (a.alquiler)? a.alquiler :true;
        let habitaciones = a.habitaciones;
        let foto = a.foto;
        let direccion = a.direccion;
        return new Casa(nombre, precio, alquiler, habitaciones, foto, direccion);
      });
    });

    
    

  }

  cargarVenta() {

    this.ventas = [];
    console.trace('PrincipalComponent cargarVenta');
    this.isAlquiler = false;
    this.casaService.getAll().subscribe((json: any) => {

      // let info = json.info; 
      let ventasJson = json;

      //map 
      console.debug('ventas %o', ventasJson);
      this.ventas = ventasJson.map(v => {
        let nombre = v.nombre;
        let precio = v.precio;
        let alquiler = (v.alquiler)? v.alquiler :false;
        let habitaciones = v.habitaciones;
        let foto = v.foto;
        let direccion = v.direccion;
        return new Casa(nombre, precio, alquiler, habitaciones, foto, direccion);
      });
    });

    
    

  }*/

  cambiarTabla( value: boolean){    
    this.isAlquiler = value;
    console.debug('click cambiarTabla ' + this.isAlquiler);
  }

  cambiarCasa(i:number){
    console.log('click cambiarCasa %o', i);
    this.casaSelec = this.casas[i];
  }

}
