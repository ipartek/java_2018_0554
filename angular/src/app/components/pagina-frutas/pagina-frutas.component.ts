import { Component, OnInit } from '@angular/core';
import { PaginaFrutasService } from 'src/app/providers/pagina-frutas.service';
import { Fruta } from 'src/app/model/fruta';
import { Mensaje } from 'src/app/model/mensaje';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-pagina-frutas',
  templateUrl: './pagina-frutas.component.html',
  styleUrls: ['./pagina-frutas.component.scss']
})
export class PaginaFrutasComponent implements OnInit {

  frutas: Fruta[];
  frutaNueva: Fruta;
  frutaSeleccionada: Fruta;
  mensaje: Mensaje;
  mensajeSuccess: string;
  mensajeError: string;
  formulario: FormGroup;

  constructor(public paginaFrutasService: PaginaFrutasService, private formBuilder: FormBuilder) {
    console.log('PaginaFrutasComponent constructor');
    this.frutas = [];
    this.frutaNueva = new Fruta("", 0);
    this.mensajeSuccess="";
    this.mensajeError="";
    this.mensaje = new Mensaje("");
    //Inicializamos el formulario
    this.formulario = this.formBuilder.group({
      //FormControl nombre
      nombre : [
        '',                                                                        // value
        [Validators.required, Validators.minLength(3), Validators.maxLength(150)] // Validación
      ],
      //End FormControl nombre
      precio: [
        undefined,
        [Validators.required, Validators.min(0.1), Validators.max(999)]
      ],
      oferta: false, 
      descuento: [
        undefined,
        [Validators.min(0), Validators.max(70)]
      ]
    });
  }

  ngOnInit() {
    console.log('PaginaFrutasComponent ngOnInit');
    this.cargarFrutas();
  }

  accion(){
    if(this.frutaNueva.id === -1){
      this.create();
    }else{
      this.modificar(this.frutaNueva);
    }
  }

  cargarFrutas() {
    console.log('PaginaFrutasComponent cargarFrutas');
    this.frutas = [];
    this.paginaFrutasService.getFrutas().subscribe(resultado => {
      // console.debug('peticion correcta %o', resultado);
      this.mapeo(resultado);
    }, error => {
      this.mensaje = new Mensaje("No se pueden obtener las frutas de la DB", Mensaje.MENSAJE_ERROR);
      console.warn('peticion incorrecta %o', error);
    });
  }

  delete(fruta: Fruta){

    if( confirm('¿Estás seguro de que quieres eliminar?') ){
    this.paginaFrutasService.delete(fruta.id).subscribe( result => {
      this.mensaje = new Mensaje(`Se ha eliminado la fruta ${fruta.id} ${fruta.nombre}`, Mensaje.MENSAJE_SUCCESS);
      //this.mensajeSuccess = `Se ha eliminado la fruta ${fruta.id} ${fruta.nombre}`;
      this.cargarFrutas();
      this.limpiar();
    },
    error => {
      //this.mensajeError = `No se pudo eliminar la Fruta ${fruta.id} ${fruta.nombre}`;
      this.mensaje = new Mensaje(`No se pudo eliminar la Fruta ${fruta.id} ${fruta.nombre}`, Mensaje.MENSAJE_ERROR)
    })
  }
}

  create(){
    console.trace('Submit formulario: %o', this.formulario.value);

    this.frutaNueva = new Fruta(this.formulario.value.nombre, this.formulario.value.precio);

     if(this.frutaNueva.descuento > 0){
       this.frutaNueva.oferta = true;
     }
     //TODO mapear this.formulario.value a Fruta()
     this.paginaFrutasService.post(this.frutaNueva).subscribe( result => {
       this.mensajeSuccess = `Creada nueva fruta ${this.frutaNueva.nombre}`;
       this.mensaje = new Mensaje(`Creada nueva fruta ${this.frutaNueva.nombre}`, Mensaje.MENSAJE_SUCCESS);
       this.limpiar();
       this.cargarFrutas();
     }, error => {
       console.error(error);
       this.mensajeError = 'No se pudo Crear la Nueva Fruta';
       this.mensaje = new Mensaje('No se pudo Crear la Nueva Fruta', Mensaje.MENSAJE_ERROR);
     });
  }

  editar(fruta: Fruta){
    this.frutaNueva = fruta;
    this.formulario.controls.nombre.setValue(fruta.nombre);
    this.formulario.controls.precio.setValue(fruta.precio);
    this.formulario.controls.oferta.setValue(fruta.oferta);
    this.formulario.controls.descuento.setValue(fruta.descuento);
  }

  modificar(fruta: Fruta){
    this.paginaFrutasService.put(fruta).subscribe( result => {
      this.mensaje = new Mensaje(`Fruta ${fruta.nombre} modificada`, Mensaje.MENSAJE_SUCCESS);
      this.cargarFrutas();
    }, error => {
      console.error(error);
      this.mensaje = new Mensaje(`No se ha podido modificar la Fruta ${fruta.id} ${fruta.nombre}`, Mensaje.MENSAJE_ERROR);
    });
  }

  changeOferta(fruta: Fruta){
    //fruta.oferta = true;
    let texto = `Se ha puesto en oferta la fruta ${fruta.nombre}`;
    let tipo = Mensaje.MENSAJE_SUCCESS;
    if(!fruta.oferta){
      if(this.frutaNueva.descuento <= 0){
        fruta.descuento = 5;
      }else{
        fruta.descuento = this.frutaNueva.descuento;
      }  
    }else{
      tipo = Mensaje.MENSAJE_INFO;
      texto = `Se ha retirado la oferta de la fruta ${fruta.nombre}`;
      fruta.descuento = 0;
    }
    this.paginaFrutasService.patch(fruta).subscribe( result => {
      //this.mensajeSuccess = texto;
      this.mensaje = new Mensaje(texto, tipo);
      this.cargarFrutas();
    }, error => {
      console.error(error);
      //this.mensajeError = `No se ha podido poner en oferta la Fruta ${fruta.id} ${fruta.nombre}`;
      this.mensaje = new Mensaje(`No se ha podido poner en oferta la Fruta ${fruta.id} ${fruta.nombre}`, Mensaje.MENSAJE_ERROR);
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
    this.frutaNueva.nombre = fruta.nombre;
    this.frutaNueva.precio = fruta.precio;
    this.frutaNueva.descuento = fruta.descuento;
    // this.nuevaFrutaImagen = fruta.imagen;
  }

  /**
   * Limpia únicamente el input de nombre
   */
  limpiarNombre(){
    this.frutaNueva.nombre = "";
  }

  /**
   * Limpia únicamente el input de precio
   */
  limpiarPrecio(){
    this.frutaNueva.precio = null;
  }

  /**
   * Limpia únicamente el input de descuento
   */
  limpiarDescuento(){
    this.frutaNueva.descuento = null;
  }

  limpiarOferta(){
    this.frutaNueva.oferta = false;
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
    this.formulario.controls.nombre.setValue("");
    this.formulario.controls.precio.setValue(undefined);
    this.formulario.controls.oferta.setValue(false);
    this.formulario.controls.descuento.setValue(undefined);
    this.frutaNueva = new Fruta("", 0);
    // this.limpiarImagen();
  }

}
