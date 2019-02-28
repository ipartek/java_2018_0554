import { Component, OnInit } from '@angular/core';
import { MultaService } from 'src/app/providers/multa.service';
import { Router } from '@angular/router';
import { Alert } from 'src/app/model/alert';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-formulario-matricula',
  templateUrl: './formulario-matricula.component.html',
  styleUrls: ['./formulario-matricula.component.sass']
})
export class FormularioMatriculaComponent implements OnInit {


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


  comprobar(){
    console.trace('click boton submit');
    let matricula = this.formulario.controls.matricula.value;

    console.debug('placa: %s password: %s',matricula );

    // llamar servicio Rest, realizar logica dentro de subscripcion
    // Cuidado es una llamada Asincrona
    this.multaService.getByMatricula(matricula).subscribe(
      data =>{
        console.debug('Json Agente %o', data);
        this.multaService.encontrada = true;
        this.router.navigate(['/multar']);
      },
      error=>{
        console.warn('Json login %o', error);
        this.multaService.encontrada = false;
        this.alert = new Alert('Este vehiculo no está registrado');
      }
    );

    // *** Cuidado no intentar usar datos de la respuesta aqui ***
       


  }// comprobar
}