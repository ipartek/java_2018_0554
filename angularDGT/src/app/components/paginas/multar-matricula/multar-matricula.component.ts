import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Alert } from 'src/app/model/alert';
import { MultasService } from 'src/app/services/multas.service';

@Component({
  selector: 'app-multar-matricula',
  templateUrl: './multar-matricula.component.html',
  styleUrls: ['./multar-matricula.component.scss']
})
export class MultarMatriculaComponent implements OnInit {

  formulario: FormGroup;  
  alert: Alert;

  constructor(
    private multasService: MultasService,
    private formBuilder: FormBuilder,
    private router: Router
  ) { 
    console.trace('LoginComponent constructor');
    this.crearFormulario();
    this.alert = new Alert('');
  }

  ngOnInit() {
  }

  crearFormulario(){
    console.trace('LoginComponent crearFormulario');
    this.formulario = this.formBuilder.group({
      matriculaenv: [
                '',                                                                         
                [Validators.required, Validators.minLength(7), Validators.maxLength(8)]   
              ]
    });  
  }// crearFormulario

  enviarMatricula(){
    console.trace('click boton submit');
    let matriculaenv = this.formulario.controls.matriculaenv.value;
    console.debug('placa: %s password: %s',matriculaenv);

    // llamar servicio Rest, realizar logica dentro de subscripcion
    // Cuidado es una llamada Asincrona
    this.multasService.existeMatricula(matriculaenv).subscribe(
      data =>{
        console.debug('Json Agente %o', data);
        this.multasService.existeMatricula(data);
        this.router.navigate(['/multar']);
      },
      error=>{
        console.warn('error login %o', error);
        this.alert = new Alert('No existe esa matrícula');
      }
    );
    // *** Cuidado no intentar usar datos de la respuesta aqui ***
  }// comprobar
}