import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AutorizacionService } from 'src/app/providers/autorizacion.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  formulario: FormGroup; 

  constructor(
    private autorizacionService: AutorizacionService,
    private formBuilder: FormBuilder,
    private router: Router
  ) { 
    console.trace('LoginComponent constructor');
    this.crearFormulario();
  }

  ngOnInit() {
    console.trace('LoginComponent ngOnInit');
  }

  crearFormulario(){
    console.trace('LoginComponent crearFormulario');
    this.formulario = this.formBuilder.group({
      placa: [
                '',                                                                         
                [Validators.required, Validators.min(0), Validators.max(99999), Validators.minLength(4), Validators.maxLength(45)]   
              ],
      pass : [
              '',
              [Validators.required, Validators.minLength(8), Validators.maxLength(50)]
      ]  
    });  
      
  }// crearFormulario

  comprobar(){
    console.trace('click boton submit');
    let placa = this.formulario.controls.placa.value;
    let pass = this.formulario.controls.pass.value;
    console.debug('nombre: %s password: %s', placa, pass);

    //llamar servicio TODO retornar Observable
    this.autorizacionService.login(placa, pass).subscribe(
      data => {
        this.autorizacionService.isLogged = true;
        console.info('isLogged: ' + this.autorizacionService.isLogged)
        console.info('Login correcto, tenemos permisos JSON: %o', data);
        this.router.navigate(['home']);
      },
      error=>{
        //TODO mensaje al usuario
        if(error.status == 403){
          console.error('Error esperado: ' + error.status);
        }else{
          console.error(error.status);
        }
        
        this.autorizacionService.isLogged = false;
        console.info('isLogged: ' + this.autorizacionService.isLogged)
        console.warn('No tienes permisos');
      }
    );



  }// comprobar

}
