import { Component, OnInit } from '@angular/core';
import { Fruta } from 'src/app/model/fruta';
import { FrutaService } from 'src/app/providers/fruta.service';

@Component({
  selector: 'app-pagina-frutas',
  templateUrl: './pagina-frutas.component.html',
  styleUrls: ['./pagina-frutas.component.scss']
})
export class PaginaFrutasComponent implements OnInit {

  frutas: Fruta[];
  frutaNueva: Fruta;
  mensaje: string;

  constructor( private frutaService: FrutaService) { 
    console.trace('PaginaFrutasComponent constructor');
    this.frutas = [];
    this.frutaNueva = new Fruta('',0);
    this.mensaje = '';
  }

  ngOnInit() {
    console.trace('PaginaFrutasComponent ngOnInit');
    this.cargarFrutas();
  }


  cargarFrutas(){
    console.trace('PaginaFrutasComponent cargarFrutas');
    this.frutaService.getAll().subscribe(
      data=>{
        console.debug('datos en json %o', data);
        //TODO mappear bien
        this.frutas = data;
      },
      error => {
        console.error(error);
        this.mensaje = 'Lo sentimos pero no hay conexion con el servidor';
      }
    );
  }// cargarFrutas

  eliminar(fruta: Fruta){
    console.trace('PaginaFrutasComponent click eliminar %o', fruta);    
    if ( confirm('¿ Estas seguro que quieres eliminar ?') ){
      this.frutaService.delete( fruta.id ).subscribe(
        data=>{
          console.debug('datos en json %o', data);
          this.cargarFrutas();
          this.mensaje = `ELIMINADA ${fruta.nombre}`;
        },
        error=>{
          console.error(error);
          this.mensaje = `No se ha podido ELIMINAR ${fruta.nombre}`;
        }
      );// frutaService
    }// confirm
  }// eliminar

  nueva(){
    console.trace('click crear nueva fruta %o', this.frutaNueva);
    this.frutaService.crear(this.frutaNueva).subscribe(
      data=>{
        console.debug('datos en json %o', data);
        this.cargarFrutas();
        this.mensaje = `Fruta creada con Exito`;
      },error=>{
        console.error(error);
        this.mensaje = `No se ha podido CREAR`;
      }
    );   
  }


}
