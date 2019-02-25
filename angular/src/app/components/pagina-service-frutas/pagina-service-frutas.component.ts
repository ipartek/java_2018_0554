import { Component, OnInit } from '@angular/core';
import { Fruta } from 'src/app/model/fruta';
import { FrutaService } from 'src/app/providers/fruta.service';
import { Mensaje } from 'src/app/model/mensaje';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-pagina-service-frutas',
  templateUrl: './pagina-service-frutas.component.html',
  styleUrls: ['./pagina-service-frutas.component.scss']
})
export class PaginaServiceFrutasComponent implements OnInit {
  frutas: Fruta[];
  frutaSeleccionada: Fruta;
  mensajeMostrar: Mensaje;
  formulario: FormGroup; //agrupacion de FormControls ==Input

  constructor(private frutaService: FrutaService, private formBuilder: FormBuilder) {
    console.trace('PaginaServiceFrutasComponent constructor');
    this.frutas = [];

    this.mensajeMostrar = new Mensaje('', '');
    this.frutaSeleccionada = new Fruta('', 0);
    this.crearFormulario();

  }

  ngOnInit() {
    console.trace('PaginaServiceFrutasComponent ngOnInit');
    this.getAllFrutas();

  }
  getAllFrutas() {
    this.frutaService.getAll().subscribe(jsonData => {
      console.debug('Se ha recibido el listado de frutas %o', jsonData);
      this.frutas = jsonData.map(v => {
        return this.rowMapper(v);
      });
    },
      error => {
        console.log("Se ha cometido un error al cargar todas las frutas %o", error);
        this.mensajeMostrar = new Mensaje('Lo siento pero no se ha podido realizar la consulta', Mensaje.DANGER);
      });
  }

  delete(fruta: Fruta) {
    console.trace('PaginaServiceFrutasComponent delete');
    if (confirm('¿Estas seguro que quieres eliinar?')) {
      this.frutaService.delete(fruta.id).subscribe(result => {
        this.getAllFrutas();
        this.mensajeMostrar = new Mensaje(`ELIMINADA ${fruta.nombre}`);
      },
        error => {
          console.log(error);
          this.mensajeMostrar = new Mensaje(`No se ha podido ELIMINAR ${fruta.nombre}`, Mensaje.WARNING);
        });
    }

  }

  /**
   * Metodo que inserta una nueva fruta
   * solamente añade el nombre que le ha dado el usuario,
   * los demas datos, POR AHORA, están hardcodeados
   */
  insert() {
    console.trace('Crear nueva fruta insert %o', this.formulario.value);
    this.frutaService.post(this.frutaSeleccionada).subscribe(r => {
      this.getAllFrutas();
      this.mensajeMostrar = new Mensaje(`CREADO ${this.frutaSeleccionada.nombre}`, Mensaje.SUCCESS);
      this.limpiarFormulario();
    },
      error => {
        console.log("Se ha cometido un error al crear la fruta nueva %o", error);
        this.mensajeMostrar = new Mensaje(`No se ha podido CREAR ${this.frutaSeleccionada.nombre}`, Mensaje.WARNING);

      });
  }

  seleccionar() {
    this.frutaSeleccionada = this.rowMapper(this.formulario.value);
    if (this.frutaSeleccionada.id === -1) {
      this.insert();
    } else {
      this.update();
    }
  }
  update() {
    console.trace('Modificar fruta update %o', this.formulario.value);
    this.frutaService.patch(this.frutaSeleccionada).subscribe(r => {
      this.getAllFrutas();
      this.mensajeMostrar = new Mensaje(`MODIFICAR ${this.frutaSeleccionada.nombre}`, Mensaje.SUCCESS);
      this.limpiarFormulario();
    },
      error => {
        console.log("Se ha cometido un error al crear la fruta nueva %o", error);
        this.mensajeMostrar = new Mensaje(`No se ha podido MODIFICAR ${this.frutaSeleccionada.nombre}`, Mensaje.WARNING);
      })
  }

  /**
   * Metodo que introduce los datos de la fruta seleccionada al formulario para editar dicha fruta
   * @param fruta  fruta que se ha seleccionado para modificar
   */
  seleccionaFrutaEditar(fruta: Fruta) {
    console.trace('click editar %o', fruta);
    this.formulario.controls['nombre'].setValue(fruta.nombre);
    this.formulario.controls['precio'].setValue(fruta.precio);
    this.formulario.controls['id'].setValue(fruta.id);
    this.formulario.controls['oferta'].setValue(fruta.oferta);
    this.formulario.controls['descuento'].setValue(fruta.descuento);
    this.formulario.controls['imagen'].setValue(fruta.imagen);
  }

  /** 
   * Se le envia una fruta en json y se transforma Fruta
   * @param value --> es el parametro donde estan los datos de la fruta a transformar
   * @returns Fruta completa
   */
  rowMapper(value: any): Fruta {
    return new Fruta(
      value.nombre,
      value.precio,
      value.id,
      value.oferta,
      value.descuento,
      value.imagen,
    )
  }

  limpiarFormulario() {
    console.trace('click limpiarFormulario ');
    this.formulario.controls['nombre'].setValue("");
    this.formulario.controls['precio'].setValue(0);
    this.formulario.controls['id'].setValue(-1);
    this.formulario.controls['oferta'].setValue(false);
    this.formulario.controls['descuento'].setValue(0);
    this.formulario.controls['imagen'].setValue(Fruta.IMAGEN_DEFAULT);
  }
  seleccionarFruta(f: Fruta) {
    this.frutaSeleccionada = f;
  }

  crearFormulario() {
    // inicializamos el formulario
    this.formulario = this.formBuilder.group({
      //Aqui se definen los formControll
      //FormControll --> nombre
      nombre: [
        'Fruta Nueva',//value
        [Validators.required, Validators.minLength(3), Validators.maxLength(150)]//validaciones
      ],
      //end control --> nombre
      precio: [
        0.99,
        [Validators.required, Validators.min(0), Validators.max(100)]
      ],
      id: [
        -1,
        [Validators.required]
      ],
      oferta: [
        false,
        [Validators.required]
      ],
      descuento: [
        0,
        //[Validators.required, Validators.min(0), Validators.max(100)]
      ],
      imagen: [
        Fruta.IMAGEN_DEFAULT,
        //TODO patter para comprobar que empieze por http y que acabe con extensión .jp[e]g ç
        //'(https?\:\/\/)?(www\.)?([a-z0-9]+\.)+([a-z]{2,})(\/[a-zA-Z0-9\-_]+)+(\.)+(jpg|png|bmp|jpeg){1}'
        //'(http:|https:){1,1}.*\.(jpe?g|png|gif)$'
        [Validators.required, Validators.pattern('(http:|https:){1,1}.*\.(jpe?g|png|gif)$')]
      ],
      colores:this.formBuilder.array(
                                      [this.crearColoresFormGroup()],
                                      [Validators.minLength(1)]
                                    )//minimo un color
    });
    // subscribirnos al evento cada vez que cambia la "oferta" para validar el descuento
    this.formulario.get('oferta').valueChanges.subscribe(
      oferta => {
        console.log('valueChanges %o', oferta);
        let descuentoFormControl = this.formulario.get('descuento');
        if (oferta) {
          //Validar decuento            
          descuentoFormControl.setValidators([Validators.min(1), Validators.max(100)]);
        } else {
          //eliminar validaciones
          descuentoFormControl.setValidators([]);
        }
        //actualizar value y validaciones
        descuentoFormControl.updateValueAndValidity();
      }
    );
  }
  crearColoresFormGroup():FormGroup{
    return  this.formBuilder.group({
        nombre:[
          'blaco',
          [Validators.required,Validators.minLength(2)]],
        codigo:[
          '#FFFFFF',
          [Validators.required,Validators.minLength(4),Validators.maxLength(7)]
        ]
      })
  }
  /**
   * Metodo que hace el calculo de su precio final con el porcentaje de descuento
   * @param fruta 
   */
  calcularDescuento(fruta: any): number {
    return fruta.precio - ((fruta.precio * fruta.descuento) / 100);
  }
}
