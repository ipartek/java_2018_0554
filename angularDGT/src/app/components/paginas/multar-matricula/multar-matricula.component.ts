import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Alert } from 'src/app/model/alert';
import { MultasService } from 'src/app/services/multas.service';
import { AutorizacionService } from 'src/app/services/autorizacion.service';

@Component({
  selector: 'app-multar-matricula',
  templateUrl: './multar-matricula.component.html',
  styleUrls: ['./multar-matricula.component.scss']
})
export class MultarMatriculaComponent implements OnInit {

  formulario: FormGroup;  
  alert: Alert;
  agente: any;

  constructor(
    private multasService: MultasService,
    private formBuilder: FormBuilder,
    private router: Router,
    private autorizacionService: AutorizacionService
  ) { 
    console.trace('MultarMatriculaComponent constructor');
    this.crearFormulario();
    this.alert = new Alert('');
  }

  ngOnInit() {
    console.trace('MultarMatriculaComponent ngOnInit');
    this.getAgenteInfo();
  }

  crearFormulario(){
    console.trace('MultarMatriculaComponent crearFormulario');
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
    console.debug('matricula: %s',matriculaenv);

    // llamar servicio Rest, realizar logica dentro de subscripcion
    // Cuidado es una llamada Asincrona
    this.multasService.existeMatricul(matriculaenv).subscribe(
      data =>{
        console.debug('Json Agente %o', data);
        this.multasService.existeMatricul(data);
        this.router.navigate(['/multar']);
      },
      error=>{
        console.warn('error login %o', error);
        this.alert = new Alert('No existe esa matrícula');
      }
    );
    // *** Cuidado no intentar usar datos de la respuesta aqui ***
  }// comprobar

  getAgenteInfo(){
    this.agente = this.autorizacionService.getAgente();
  }
}