import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Casa } from 'src/app/model/casa';
import { CasaService } from 'src/app/providers/casa.service';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.sass']
})
export class FormularioComponent implements OnInit {

  formulario: FormGroup;
  casa: Casa[];

  constructor(private casaService: CasaService, private formBuilder: FormBuilder) { }

  ngOnInit() {
    this.crearFormulario();
  }

  crearFormulario() {
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
      alquiler: false,
      direccion: ['',                                                                         // value
        [Validators.required, Validators.minLength(3), Validators.maxLength(500)]

      ],
      foto: [
        '',
        [Validators.required, Validators.pattern('(http:|https:){1,1}.*\.(jpe?g|png|gif)$')]
      ],
      habitacion: [1,
        [Validators.required, Validators.min(1), Validators.max(300)]

      ],


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

  nueva() {
    console.trace('submit formulario %o',
      this.formulario.value);



    // mappear de formulario a Fruta
    let casa = new Casa(-1,
      this.formulario.value.nombre,
      this.formulario.value.precio,
      this.formulario.value.alquiler,
      this.formulario.value.foto,
      this.formulario.value.habitacion,
      this.formulario.value.direccion,
      0
    );
    ;


    // llamar servicio                      
    this.casaService.guardar(casa).subscribe(
      data => {
        console.debug('datos en json %o', data);

        this.crearFormulario();
        

      }, error => {
        console.error(error);

      }
    );

  }// nueva

}
