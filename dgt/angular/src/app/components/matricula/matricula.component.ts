import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Alerta } from 'src/app/model/alerta';
import { MultaService } from 'src/app/providers/multa.service';
import { Router } from '@angular/router';
import { Coche } from 'src/app/model/coche';

@Component({
  selector: 'app-matricula',
  templateUrl: './matricula.component.html',
  styleUrls: ['./matricula.component.scss']
})
export class MatriculaComponent implements OnInit {

  formulario: FormGroup;
  alerta: Alerta;
  cocheBuscado: Coche;

  constructor(
    private multaService: MultaService,
    private formBuilder: FormBuilder,
    private router: Router
  ) { 
    console.trace('MatriculaComponent constructor');
    this.crearFormulario();
    this.alerta = new Alerta('');
  }

  ngOnInit() {
  }

  crearFormulario() {
    console.trace('MatriculaComponent crearFormulario');
    this.formulario = this.formBuilder.group({
      matricula: [
        '',
        [Validators.required,
        Validators.min(0),
        Validators.max(9999),
        Validators.minLength(4),
        Validators.maxLength(10)
        ]
      ]
    });

  } // crearFormulario

  comprobar() {
    console.trace('click boton submit');
    let matricula = this.formulario.controls.matricula.value;
    
    console.debug('matricula: %s', matricula);
    
    //llamar servicio TODO retornar Observable
    this.multaService.getCoche(matricula).subscribe(
      data => {
        console.debug(data.JSON)
        this.cocheBuscado = data;
        if(this.cocheBuscado.id != -1) {
          console.debug('Coche obtenido %o', this.cocheBuscado);          
        }
        //this.router.navigate(['datosMulta/' + this.cocheBuscado]);
        let ruta = this.router.navigate(['datosMulta/' , this.cocheBuscado]);
        console.debug('ruta: %o', ruta);
      }, // data
      error => {
        console.warn('No tienes permisos');
        if (error.status == 404) {
          this.alerta = new Alerta(`El coche buscado no existe. Código de error: ${error.status}`,
            Alerta.TIPO_WARNING);
          console.error('Error esperado: ' + error.status);
        } else {
          this.alerta = new Alerta(`Error inesperado. Código de error: ${error.status}`);
          console.error(error.status);
        }

      } // error
    ); // subscribe

  } // comprobar

}
