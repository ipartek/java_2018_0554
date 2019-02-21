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
  nuevaFrutaNombre : string;
  nuevaFrutaPrecio : number;
  nuevaFrutaDescuento : number;
  nuevaFrutaImagen : string;

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
      this.limpiar();
    },
    error => {
      alert('No se pudo eliminar la Fruta ' + fruta.id);
    })
  }

  create(){
    let fruta = new Fruta(this.nuevaFrutaNombre, this.nuevaFrutaPrecio);

    this.paginaFrutasService.post(fruta).subscribe( result => {
      this.limpiar();
      this.cargarFrutas();
    }, error => {
      alert('No se pudo Crear la Nueva Fruta');
    });
  }

  changeOferta(fruta: Fruta){
    //fruta.oferta = true;
    if(!fruta.oferta){
      if(this.nuevaFrutaDescuento <= 0){
        fruta.descuento = 5;
      }else{
        fruta.descuento = this.nuevaFrutaDescuento;
      }
      
    }else{
      fruta.descuento = 0;
    }
    
    
    this.paginaFrutasService.patch(fruta).subscribe( result => {
      this.cargarFrutas();
    }, error => {
      alert("No se ha podido poner en oferta la Fruta");
    });

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

  rellenarDatos(fruta: Fruta){
    this.nuevaFrutaNombre = fruta.nombre;
    this.nuevaFrutaPrecio = fruta.precio;
    this.nuevaFrutaDescuento = fruta.descuento;
    // this.nuevaFrutaImagen = fruta.imagen;
  }

  /**
   * Limpia únicamente el input de nombre
   */
  limpiarNombre(){
    this.nuevaFrutaNombre = "";
  }

  /**
   * Limpia únicamente el input de precio
   */
  limpiarPrecio(){
    this.nuevaFrutaPrecio = null;
  }

  /**
   * Limpia únicamente el input de descuento
   */
  limpiarDescuento(){
    this.nuevaFrutaDescuento = null;
  }

  /**
   * Limpia únicamente el input de imagen
   */
  // limpiarImagen(){
  //   this.nuevaFrutaImagen = "";
  // }

  /**
   * Llama a las 3 funciones de limpieza de cada input, para limpiar todos
   */
  limpiar(){
    this.limpiarNombre();
    this.limpiarPrecio();
    this.limpiarDescuento();
    // this.limpiarImagen();
  }

}
