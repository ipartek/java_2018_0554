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
  frutaSeleccionada: Fruta;
  mensaje: Mensaje;
  mensajeSuccess: string;
  mensajeError: string;
  formulario: FormGroup;

  constructor(public paginaFrutasService: PaginaFrutasService, private formBuilder: FormBuilder) {
    console.log('PaginaFrutasComponent constructor');
    this.frutas = [];
    this.frutaSeleccionada = new Fruta("", 0);
    this.mensaje = new Mensaje("");
    this.inicializarFormulario();
  }

  ngOnInit() {
    console.log('PaginaFrutasComponent ngOnInit');
    this.cargarFrutas();
  }

  inicializarFormulario(){
    this.frutaSeleccionada = new Fruta("", 0);
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
        0,
        [Validators.min(0), Validators.max(70)]
      ], 
      imagen: [ Fruta.IMAGEN_DEFAULT, [Validators.required]]
    });
  }

  cargarFrutas() {
    console.log('PaginaFrutasComponent cargarFrutas');
    this.frutas = [];
    this.paginaFrutasService.getFrutas().subscribe(resultado => {
      this.mapeo(resultado);
    }, error => {
      this.mensaje = new Mensaje("No se pueden obtener las frutas de la DB", Mensaje.MENSAJE_ERROR);
      console.warn('peticion incorrecta %o', error);
    });
  }

  editar(fruta: Fruta){
    this.frutaSeleccionada = fruta;

    this.formulario.controls['nombre'].setValue(fruta.nombre);
    this.formulario.controls['precio'].setValue(fruta.precio);
    this.formulario.controls['oferta'].setValue(fruta.oferta);
    this.formulario.controls['descuento'].setValue(fruta.descuento);
    this.formulario.controls['imagen'].setValue(fruta.imagen);
  }

  delete(fruta: Fruta){

    if( confirm('¿Estás seguro de que quieres eliminar?') ){
    this.paginaFrutasService.delete(fruta.id).subscribe( result => {
      this.mensaje = new Mensaje(`Se ha eliminado la fruta ${fruta.id} ${fruta.nombre}`, Mensaje.MENSAJE_SUCCESS);
      //this.mensajeSuccess = `Se ha eliminado la fruta ${fruta.id} ${fruta.nombre}`;
      this.cargarFrutas();
      this.inicializarFormulario();
    },
    error => {
      this.mensaje = new Mensaje(`No se pudo eliminar la Fruta ${fruta.id} ${fruta.nombre}`, Mensaje.MENSAJE_ERROR)
    })
  }
}

  nueva(){
    console.trace('submit formulario %o', 
              this.formulario.value);
    
    let id = this.frutaSeleccionada.id;        
    console.debug(`identificador fruta {id}`);

    // mappear de formulario a Fruta
    let fruta = new Fruta(
                            this.formulario.value.nombre,
                            this.formulario.value.precio,
                            id,
                            this.formulario.value.oferta,
                            this.formulario.value.descuento,
                            this.formulario.value.imagen,
                            0
                          );
    // llamar servicio                      
    this.paginaFrutasService.guardar(fruta).subscribe(
      data=>{
        console.debug('datos en json %o', data);
        this.frutaSeleccionada = new Fruta('',0);  // id => -1
        this.inicializarFormulario();    
        this.cargarFrutas();
        if(id === -1){
          this.mensaje = new Mensaje(`Creada nueva fruta ${fruta.nombre}`, Mensaje.MENSAJE_SUCCESS);
        }else{
          this.mensaje = new Mensaje(`Fruta ${fruta.nombre} modificada`, Mensaje.MENSAJE_SUCCESS);
        }
      },error=>{
        console.error(error);
        this.mensaje = new Mensaje('No se pudo Crear la Nueva Fruta', Mensaje.MENSAJE_ERROR);
      }
    );
       
  }// nueva

  /**
   * Función que mapea las Frutas del JSON al objeto Fruta y los añade
   * al array de frutas
   * @param result JSON de la BD
   */
  mapeo(result: any) {
    let fruta: Fruta;
    result.forEach(el => {
      fruta = new Fruta(el.nombre, el.precio, el.id, el.oferta, el.descuento, el.imagen);
      this.frutas.push(fruta);
      //console.debug("Fruta mapeada: %o", el);
    });
  }

}
