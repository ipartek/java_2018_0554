import { Component, OnInit } from '@angular/core';
import { FrutaService } from 'src/app/providers/fruta.service';
import { Fruta } from 'src/app/model/fruta';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-lista-frutas',
  templateUrl: './lista-frutas.component.html',
  styleUrls: ['./lista-frutas.component.scss']
})
export class ListaFrutasComponent implements OnInit {

  frutas : Fruta[];
  formulario: FormGroup;
  mensaje: string;
/*
  nuevaFrutaNombre : string;
  nuevaFrutaPrecio: number;
  nuevaFrutaId: number;
  nuevaFrutaImg: string;
  nuevaFrutaOferta: boolean;
  nuevaFrutaDescuento: number;
  nuevaFrutaCantidad: number;
  nuevaFrutaCompleted: boolean;
*/
  constructor( public frutasService:FrutaService, private formBuilder: FormBuilder ) { 
    console.log('FrutasComponent constructor');
    this.frutas = [];
    this.mensaje = '';

    this.formulario = this.formBuilder.group({
      nombre: [
        '', //valor
        [ Validators.required, Validators.maxLength(150), Validators.minLength(3) ] //validaciones
      ],
      precio: [
        '', //valor
        [ Validators.required, Validators.max(9999), Validators.min(0.99) ] //validaciones
      ],
      imagen: [
        '', //valor
        [ Validators.minLength(10) ] //validaciones
      ]
    });
  }

  ngOnInit() {
    console.log('FrutasComponent ngOnInit');
    this.cargarFrutas();
  }

  cargarFrutas(){
    console.log('FrutasComponent cargarFrutas');
    this.frutas = [];
    this.frutasService.getAll().subscribe(
      resultado => {
        console.debug('peticion correcta %o', resultado);
         this.frutas = resultado;
      },
      error=>{
        console.warn('peticion incorrecta %o', error);
      }
    );
  }

  mapeo( result : any ){

    let fruta:Fruta;
    result.forEach(f => {
        fruta = new Fruta( f.nombre, f.precio);
        fruta.id = f.id;
        fruta.oferta = f.oferta;
        fruta.descuento = f.descuento;
        fruta.imagen = f.imagen;
        fruta.cantidad = f.cantidad;

        this.frutas.push(fruta);
    });
  }

  change(fruta:Fruta){
    console.log('FrutasComponent change %o', fruta );
    this.frutasService.patch(fruta).subscribe(     
        result=>{
          console.log('Fruta modificada con exito %o', result);
          this.cargarFrutas();
        },
        error=>{
          alert('No se pudo Modificar la Fruta');
        }      
    );
  }

  delete(fruta:Fruta){
    console.log('FrutasComponent delete %o', fruta );

    this.frutasService.delete(fruta.id).subscribe(
      result=>{
        this.cargarFrutas();
      },
      error=>{
        alert('No se pudo elimiar la Fruta');
      }
    );
  }

  new(){
    console.trace('submit formulario', this.formulario.value);

    let fruta = new Fruta(
      this.formulario.value.nombre,
      this.formulario.value.precio,
      this.formulario.value.imagen
    );

    this.frutasService.post(fruta).subscribe(
      data=>{
        console.log('FrutasComponent new %o', data);
        this.cargarFrutas();
        this.mensaje = 'Fruta creada con éxito';
      },
      error=>{
        console.error(error);
        this.mensaje = 'No se pudo Crear Nueva Fruta';
      }
    );

    /*
    console.log('FrutasComponent new ');
    let fruta = new Fruta(this.nuevaFrutaNombre, this.nuevaFrutaPrecio, this.nuevaFrutaId, this.nuevaFrutaOferta, this.nuevaFrutaDescuento, this.nuevaFrutaImg, this.nuevaFrutaCantidad, this.nuevaFrutaCompleted);
    this.frutasService.post(fruta).subscribe(
      result=>{
        console.log('FrutasComponent new %o', result);
        this.cargarFrutas();
      },
      error=>{
        alert('No se pudo Crear Nueva Fruta');
        //console.error(error);
      }
    );*/
  }
/*
  borrar(){
    this.nuevaFrutaNombre = '';
  }
*/
}
