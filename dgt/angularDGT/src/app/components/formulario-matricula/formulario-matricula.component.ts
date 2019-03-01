import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Alert } from 'src/app/model/alert';
import { MultaService } from 'src/app/providers/multa.service';
import { Router, NavigationExtras } from '@angular/router';


@Component({
  selector: 'app-formulario-matricula',
  templateUrl: './formulario-matricula.component.html',
  styleUrls: ['./formulario-matricula.component.sass']
})
export class FormularioMatriculaComponent implements OnInit {
  formularioMat: FormGroup;
  alert: Alert;

  constructor(private multaService: MultaService,
    private formBuilder: FormBuilder,
    private router: Router) {

    console.trace('FormularioMatriculaComponent constructor');
    this.crearFormulario();
    this.alert = new Alert('');
  }

  ngOnInit() {
    console.trace('FormularioMatriculaComponent ngOnInit');
  }
  crearFormulario() {
    console.trace('PaginaLoginComponent crearFormulario');
    this.formularioMat = this.formBuilder.group({
      matricula: [
        '',
        [Validators.required, Validators.minLength(5), Validators.maxLength(10)]
      ]
    });

  }// crearFormulario

  comprobar() {
    console.trace('click boton submit');
    let matricula = this.formularioMat.controls.matricula.value;

    console.debug('matricula: %s , matricula');

    //llamar servicio TODO retornar Observable
    // llamar servicio Rest, realizar logica dentro de subscripcion
    // Cuidado es una llamada Asincrona
    this.multaService.buscarMatricula(matricula).subscribe(
      data => {
        console.debug('Json Vehiculo %o', data);
        this.multaService.saveVehiculo(data);
        this.router.navigate(['/multar']);
      },
      error => {
        console.warn('error vehiculo %o', error);
        this.alert = new Alert('Matrícula no encontrada');
      }
    );

  }

}
