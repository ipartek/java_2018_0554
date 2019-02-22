import { Component, OnInit } from '@angular/core';
import { FrutaService } from 'src/app/providers/fruta.service';
import { Fruta } from 'src/app/model/fruta';

@Component({
  selector: 'app-pagina-servicio-fruta',
  templateUrl: './pagina-servicio-fruta.component.html',
  styleUrls: ['./pagina-servicio-fruta.component.scss']
})
export class PaginaServicioFrutaComponent implements OnInit {

  frutas: any;
  nuevaFruta: string;
  nombreFrutaNueva: string;
  nuevaFrutaNombre2: string;
  mensaje :string;
  check:boolean[];
  checkSeleccionado:number;

  constructor(private frutaService: FrutaService) {
    console.trace('constructor PaginaServicioFrutaComponent ');
    this.frutas = [];
    this.nuevaFruta = 'base fruta';
    this.nombreFrutaNueva = 'fruitopia';
    this.nuevaFrutaNombre2 = 'Fruta';
    this.mensaje ="";
    this.check =[];
  }

  ngOnInit() {
    console.trace('PaginaServicioFrutaComponent ngOnInit');
    this.cargarLista();
  }

  cargarLista() {//get all devuelve un observable llamando a la url
    this.frutaService.getAll().subscribe( 
      json => {
      console.debug('recibimos datos json: %o', json);
      this.frutas = json.map( f => {
        return new Fruta( f.nombre, f.precio, f.id, f.oferta, f.descuento, f.imagen, 1);
      });
    },error =>{//se captura el error
      console.error(error);
      this.mensaje = 'Sin conexión';
    });
  }


  new() {
    console.log('PaginaServicioFrutaComponent new ');
    const fruta = this.nombreFrutaNueva;
    this.frutaService.post(new Fruta(fruta)).subscribe(
      result => {
        console.log('PaginaServicioFrutaComponent new %o', result);
        this.cargarLista();
        this.mensaje = 'Fruta creada' + this.nombreFrutaNueva;
      },
      error => {
        this.mensaje = 'No de pudo Crear Fruta';
        console.error(error);
      }
    );
  }



  delete(fruta: Fruta) {
    console.log('PaginaServicioFrutaComponent delete %o', fruta );
    if ( confirm('¿ Estas seguro que quieres eliminar ' + fruta.nombre) ){
    this.frutaService.delete(fruta.id).subscribe(
      result => {
        this.cargarLista();
        this.mensaje = 'Eliminada' + fruta.nombre;
      },
      error => {
        this.mensaje = 'No se pudo elimiar Fruta';
      }
    );
    }
    }

    change(fruta: Fruta) {
      console.log('PaginaServicioFrutaComponent change %o', fruta );
      this.frutaService.patch(fruta).subscribe(
          result => {
            console.log('Fruta modificada con exito %o', result);
            this.checkSeleccionado = -1;
            this.cargarLista();
            this.mensaje = 'Fruta modificada correctamente' + fruta.nombre;
          },
          error => {
            this.mensaje = 'No de pudo Modificar la Fruta';
          }
      );
        }

    selecionado(frutas:any, i:any){
      if(i==this.checkSeleccionado){
        this.checkSeleccionado = -1;
      }else{
        this.checkSeleccionado = i;
      }
      
     
    }


}
