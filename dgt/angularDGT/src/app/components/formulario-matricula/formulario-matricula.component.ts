import { Component, OnInit } from '@angular/core';
import { MultaService } from 'src/app/providers/multa.service';
import { Router } from '@angular/router';
import { Alert } from 'src/app/model/alert';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Coche } from 'src/app/model/coche';
@Component({
  selector: 'app-formulario-matricula',
  templateUrl: './formulario-matricula.component.html',
  styleUrls: ['./formulario-matricula.component.sass']
})
export class FormularioMatriculaComponent implements OnInit {
  
  cocheMulta : Coche ;

  formulario: FormGroup;  
  alert: Alert;

  constructor(
    private multaService: MultaService,
    private formBuilder: FormBuilder,
    private router: Router
  ) { 
    console.trace('LoginComponent constructor');
    this.crearFormulario();
    this.alert = new Alert('');
  }

  ngOnInit() {
    console.trace('LoginComponent ngOnInit');
  }

  crearFormulario(){
    console.trace('LoginComponent crearFormulario');
    this.formulario = this.formBuilder.group({
      matricula: [
                '',                                                                         
                [Validators.required, Validators.minLength(7), Validators.maxLength(8)]   
              ],
     
    });  
      
  }// crearFormulario


 comprobarMatricula() {
    console.trace('click boton submit');
    let matricula = this.formulario.controls.matricula.value;

    console.debug('matricula: %s , matricula');

    //llamar servicio TODO retornar Observable
    // llamar servicio Rest, realizar logica dentro de subscripcion
    // Cuidado es una llamada Asincrona
    this.multaService.buscarMatricula(matricula).subscribe(
      data => {
        console.debug('Json Vehiculo %o', data);
        this.router.navigate(['/multar']);
      },
      error => {
        console.warn('error vehiculo %o', error);
        this.alert = new Alert('Matrícula no encontrada');
      }
    );

  }
}