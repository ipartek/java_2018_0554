import { Component, OnInit } from '@angular/core';
import { PaginaFrutasService } from 'src/app/providers/pagina-frutas.service';
import { Fruta } from 'src/app/model/fruta';

@Component({
  selector: 'app-pagina-frutas',
  templateUrl: './pagina-frutas.component.html',
  styleUrls: ['./pagina-frutas.component.scss']
})
export class PaginaFrutasComponent implements OnInit {

  frutas: Fruta[];

  constructor(public paginaFrutasService: PaginaFrutasService) {
    console.log('PaginaFrutasComponent constructor');
    this.frutas = [];
  }

  ngOnInit() {
    console.log('PaginaFrutasComponent ngOnInit');
    this.cargarFrutas();
  }

  cargarFrutas() {
    console.log('PaginaFrutasComponent cargarFrutas');
    this.frutas = [];
    this.paginaFrutasService.getFrutas().subscribe(resultado => {
      // console.debug('peticion correcta %o', resultado);
      this.mapeo(resultado);
    }, error => {
      console.warn('peticion incorrecta %o', error);
    });
  }

  delete(fruta: Fruta){
    this.paginaFrutasService.delete(fruta.id).subscribe( result => {
      this.cargarFrutas();
    },
    error => {
      alert('No se pudo eliminar la Fruta ' + fruta.id);
    })
  }

  /**
   * Función que mapea las Frutas del JSON al objeto Fruta y los añade
   * al array de frutas
   * @param result JSON de la BD
   */
  mapeo(result: any) {
    let fruta: Fruta;
    result.forEach(el => {
      fruta = new Fruta(el.nombre, el.precio);
      fruta.id = el.id;
      fruta.oferta = el.oferta;
      fruta.descuento = el.descuento;
      fruta.imagen = el.imagen;

      this.frutas.push(fruta);
      //console.debug("Fruta mapeada: %o", el);
    });

  }

}
