import { Component, OnInit } from '@angular/core';
import { Fruta } from 'src/app/model/fruta';
import { FrutaService } from 'src/app/providers/fruta.service';
import { FormBuilder, FormGroup, Validators, FormArray } from '@angular/forms';
import { Alert } from 'src/app/model/alert';
import { Color } from 'src/app/model/color';


@Component({
  selector: 'app-pagina-frutas',
  templateUrl: './pagina-frutas.component.html',
  styleUrls: ['./pagina-frutas.component.scss']
})
export class PaginaFrutasComponent implements OnInit {

  frutas: Fruta[];
  frutaSeleccionada: Fruta;
  alert: Alert;
  formulario: FormGroup;  // Agrupacion de FormControls == Input
 
  constructor( private frutaService: FrutaService, private formBuilder: FormBuilder ) { 
    console.trace('PaginaFrutasComponent constructor');
    this.frutas = [];
    this.frutaSeleccionada = new Fruta('',0);
    this.alert = new Alert('Ongi etorri', Alert.SUCCESS);
    this.crearFormulario(); 
  }

  ngOnInit() {
    console.trace('PaginaFrutasComponent ngOnInit');
    this.cargarFrutas();
  }


  crearFormulario(){
     console.trace('PaginaFrutasComponent crearFormulario');
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
                ],
        oferta: false,
        descuento: [ 0
                     // [Validators.min(1), Validators.max(99)]
                  ],        
        imagen: [ 
                  Fruta.IMAGEN_DEFAULT , 
                  [Validators.required, Validators.pattern('(http:|https:){1,1}.*\.(jpe?g|png|gif)$')]
                ],
        colores: this.formBuilder.array( 
                                        [ this.crearColoresFormGroup( new Color('','') )  ], 
                                        Validators.minLength(1) 
                                    ) // minimo un color
      });

      // subscribirnos al evento cada vez que cambia la "oferta" para validar el descuento
      this.formulario.get('oferta').valueChanges.subscribe(
        oferta=>{
          console.log('valueChanges %o', oferta);
          let descuentoFormControl = this.formulario.get('descuento');
          if (oferta){
            //Validar decuento            
            descuentoFormControl.setValidators([Validators.min(1), Validators.max(100)]);
          }else{
            //eliminar validaciones
            descuentoFormControl.setValidators([]);
          }
          //actualizar value y validaciones
          descuentoFormControl.updateValueAndValidity();
        }
      );

  }
 
  crearColoresFormGroup(color: Color): FormGroup{
   return this.formBuilder.group({
      nombre: [
                  color.nombre, 
                  [Validators.required, Validators.minLength(2)]
              ],
      codigo: [
                color.codigo, 
                [Validators.required, Validators.minLength(4),Validators.maxLength(7)] 
              ]
    });
  }

  cargarFrutas(){
    console.trace('PaginaFrutasComponent cargarFrutas');
    this.frutaService.getAll().subscribe(
      data=>{
        console.debug('datos en json %o', data);        
        this.frutas = data.map( jsonFruta => this.mapperJsonFruta(jsonFruta) );
      },
      error => {
        console.error(error);
        this.alert = new Alert('Lo sentimos pero no hay conexion con el servidor'); 
      }
    );
  }// cargarFrutas

  /**
   * Mappear de un Json al modelo Fruta
   * @param jsonFruta Json que recibimos del servicio Rest
   */
  mapperJsonFruta(jsonFruta: any){
    let fruta = new Fruta( jsonFruta.nombre, jsonFruta.precio );    
    fruta.id = jsonFruta.id;
    fruta.imagen = jsonFruta.imagen;
    fruta.oferta = jsonFruta.oferta;
    fruta.descuento = jsonFruta.descuento;
    if ( jsonFruta.colores ){
      fruta.colores = jsonFruta.colores.map( c => new Color(c.nombre,c.codigo) );
    }else{
      fruta.colores = [];
    }  
    return fruta;
  }

  /**
   * Mapea los datos de una Fruta al Formulario para poder editarlos
   * @param fruta: Fruta seleccionada
   */
  editar( fruta: Fruta) {
    console.trace('click editar %o', fruta); 
    this.frutaSeleccionada = fruta;

    this.formulario.controls['nombre'].setValue(fruta.nombre);
    this.formulario.controls['precio'].setValue(fruta.precio);
    this.formulario.controls['oferta'].setValue(fruta.oferta);
    this.formulario.controls['descuento'].setValue(fruta.descuento);
    this.formulario.controls['imagen'].setValue(fruta.imagen);

    // /////////////////////////////////////////////////
    // Mappear colores de la Fruta => FormArray
    // /////////////////////////////////////////////////

    // inicializar a vacio FormArray
    let coloresFormArray = this.formBuilder.array( [] ,  Validators.minLength(1) );  
    
    if (fruta.colores ) {
      for( let color of fruta.colores ) {        
        coloresFormArray.push( this.crearColoresFormGroup(color) );
      }  
    }else{   // no hay colores
      coloresFormArray.push( this.crearColoresFormGroup(new Color('','')) );
    }  
    this.formulario.controls['colores'] = coloresFormArray;
    
  }


  nuevoColor(){
    console.trace(' click nuevo color');
    this.formulario.controls['colores'].push( this.crearColoresFormGroup(new Color('','')) );
  }

  eliminarColor(index: number){
    console.trace(' click eliminar color posicion:' + index);
    this.formulario.controls['colores'].removeAt(index);
  }


  eliminar(fruta: Fruta){
    console.trace('PaginaFrutasComponent click eliminar %o', fruta);    
    if ( confirm('¿ Estas seguro que quieres eliminar ?') ){
      this.frutaService.delete( fruta.id ).subscribe(
        data=>{
          console.debug('datos en json %o', data);
          this.cargarFrutas();          
          this.alert = new Alert(`ELIMINADA ${fruta.nombre}`, Alert.SUCCESS);
        },
        error=>{
          console.error(error);
          this.alert = new Alert(`No se ha podido ELIMINAR ${fruta.nombre}`);
        }
      );// frutaService
    }// confirm
  }// eliminar

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
    // mapear FormArray a array colores para fruta
    let coloresFormArray = this.formulario.controls['colores'];
    let colores: Color[] = coloresFormArray.value.map( c => new Color(c.nombre, c.codigo));
    fruta.colores = colores;

    // llamar servicio                      
    this.frutaService.guardar(fruta).subscribe(
      data=>{
        console.debug('datos en json %o', data);
        this.frutaSeleccionada = new Fruta('',0);  // id => -1
        this.crearFormulario();    
        this.cargarFrutas();
        this.alert = new Alert(`Fruta guardada con Exito`, Alert.PRIMARY);
      },error=>{
        console.error(error);
        this.alert = new Alert(`No se ha podido GUARDAR`, Alert.WARNING);
      }
    );
       
  }// nueva


  

}
