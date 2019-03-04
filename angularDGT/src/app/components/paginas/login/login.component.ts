import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AutorizacionService } from 'src/app/services/autorizacion.service';
import { Router } from '@angular/router';
import { Alert } from 'src/app/model/alert';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  formulario: FormGroup;  
  alert: Alert;

  constructor(
    private autorizacionService: AutorizacionService,
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
      placa: [
                '',                                                                         
                [Validators.required, Validators.minLength(3), Validators.maxLength(150)]   
              ],
      password : [
              '',
              [Validators.required, Validators.minLength(3), Validators.maxLength(16)]
      ]  
    });  
      
  }// crearFormulario


  comprobar(){
    console.trace('click boton submit');
    let placa = this.formulario.controls.placa.value;
    let password = this.formulario.controls.password.value;
    console.debug('placa: %s password: %s',placa , password);
    this.autorizacionService.loggin(placa, password).subscribe(
      data =>{
        console.debug('Json Agente %o', data);
        this.autorizacionService.setLogged(true);
        this.autorizacionService.saveAgente(data);
        this.router.navigate(['/index']);
      },
      error=>{
        console.warn('error login %o', error);
        this.autorizacionService.setLogged(false);
        this.alert = new Alert('No tienes permisos');
      }
    );
  }
}