import { Component, OnInit } from '@angular/core';
import { Fruta } from 'src/app/model/fruta';
import { FrutaService } from 'src/app/providers/fruta.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-pagina-frutas',
  templateUrl: './pagina-frutas.component.html',
  styleUrls: ['./pagina-frutas.component.scss']
})
export class PaginaFrutasComponent implements OnInit {

  frutas: Fruta[];
  frutaNueva: Fruta;
  mensaje: string;
  formulario: FormGroup;  // Agrupacion de FormControls == Input

  constructor( private frutaService: FrutaService, private formBuilder: FormBuilder ) { 
    console.trace('PaginaFrutasComponent constructor');
    this.frutas = [];
    this.frutaNueva = new Fruta('',0);
    this.mensaje = '';

    // inicializamos el formulario
    this.formulario = this.formBuilder.group({

        // FormControl nombre
        nombre: [
                  '',                                                                         // value
                  [Validators.required, Validators.minLength(3), Validators.maxLength(150)]   // Validaciones
                ],
        // end FormControl nombre       

        precio: [
                  0.99,
                  [Validators.required, Validators.min(0.99), Validators.max(9999)]
                ]  
    });
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
    console.trace('submit formulario %o', 
              this.formulario.value);
    // mappear de formulario a Fruta
    let fruta = new Fruta(
                            this.formulario.value.nombre,
                            this.formulario.value.precio
                          );
    // llamar servicio                      
    this.frutaService.crear(fruta).subscribe(
      data=>{
        console.debug('datos en json %o', data);
        this.cargarFrutas();
        this.mensaje = `Fruta creada con Exito`;
      },error=>{
        console.error(error);
        this.mensaje = `No se ha podido CREAR`;
      }
    );
       
  }// nueva


}
