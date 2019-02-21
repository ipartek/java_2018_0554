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
  nombreFrutaNueva:string;

  constructor(private frutaService: FrutaService) {
    console.trace("constructor PaginaServicioFrutaComponent ");
    this.frutas = [];
    this.nuevaFruta ="base fruta";
    this.nombreFrutaNueva ="fruiljkiuovbiutopia";
  }

  ngOnInit() {
    console.trace('PaginaServicioFrutaComponent ngOnInit');
    this.cargarLista();
  }

  cargarLista(){
    this.frutaService.getAll().subscribe( json => {
      console.debug("recibimos datos json: %o", json);      
      this.frutas = json.map( f => {
        return new Fruta( f.nombre, f.precio, f.id, f.oferta, f.descuento, f.imagen, 1);
      });
    });
  }


  new(){
    console.log('PaginaServicioFrutaComponent new ');
    let fruta = this.nombreFrutaNueva;
    this.frutaService.post(new Fruta(fruta)).subscribe(
      result=>{
        console.log('PaginaServicioFrutaComponent new %o', result);
        this.cargarLista();
      },
      error=>{
        alert('No de pudo Crear Fruta');
        console.error(error);
      }
    );
  }



  delete(fruta: Fruta){
    console.log('PaginaServicioFrutaComponent delete %o', fruta );

    this.frutaService.delete(fruta.id).subscribe(
      result=>{
        this.cargarLista();
      },
      error=>{
        alert('No se pudo elimiar Fruta');
      }
    );
    }

    change(fruta :Fruta){
      console.log('PaginaServicioFrutaComponent change %o', fruta );
      this.frutaService.patch(fruta).subscribe(     
          result=>{
            console.log('Fruta modificada con exito %o', result);
            this.cargarLista();
          },
          error=>{
            alert('No de pudo Modificar la Tarea');
          }      
      );
        }

}
