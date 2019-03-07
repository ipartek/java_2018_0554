import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { LoginServiceService } from 'src/app/providers/login-service.service';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  formulario: FormGroup;  

  texto: string = environment.texto;

  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private loginS: LoginServiceService) { 
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
                [Validators.required, Validators.minLength(3), Validators.maxLength(150)]   
              ],
      password : [
              '',
              [Validators.required, Validators.minLength(3), Validators.maxLength(16)]
      ]  
    });  
  }

  comprobar(){
    console.trace('click boton submit');
    let placa = this.formulario.controls.placa.value;
    let password = this.formulario.controls.password.value;
    console.debug('placa: %s password: %s',placa , password);
    
    // llamar servicio Rest, realizar logica dentro de subscripcion
    // Cuidado es una llamada Asincrona
    this.loginS.loggin(placa, password).subscribe(
      data =>{
        console.debug('Json Agente %o', data);
        this.loginS.setLogged(true);
        this.loginS.saveAgente(data);
        this.router.navigate(['/menu-ppal']);
      },
      error=>{
        console.warn('error login %o', error);
        this.loginS.setLogged(false);
        alert('No existe el usuario');
      }
    );
// *** Cuidado no intentar usar datos de la respuesta aqui ***
  }

}
