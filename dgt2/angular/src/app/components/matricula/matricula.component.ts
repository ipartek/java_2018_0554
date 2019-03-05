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
        if (this.cocheBuscado.id != -1) {
          console.debug('Coche obtenido %o', this.cocheBuscado);
          this.multaService.guardarCoche(this.cocheBuscado);
        }
        this.router.navigate(["redactar-multa"]);
      },
      error => {
        console.warn('No tienes permisos');
        if (error.status == 404) {
          this.alerta = new Alerta(`El vehiculo no existe. Error ${error.status}`,
            Alerta.TIPO_WARNING);
          console.error('Ha ocurrido un error: ' + error.status);
        } else {
          this.alerta = new Alerta(`Ha ocurrido un error inesperado`);
          console.error(error.status);
        }

      }
    );

  }

}
