import { Component, OnInit } from '@angular/core';
import { AutorizacionService } from 'src/app/providers/autorizacion.service';
import { Router } from '@angular/router';
import { Alert } from 'src/app/model/alert';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {


  formulario: FormGroup;  
  propiedadAlert: Alert;  // creo alert para ENVIAR A INPUTS MEDIANTE PROPIEDAD y les doy valor en la logica

  constructor(
    private autorizacionService: AutorizacionService,
    private formBuilder: FormBuilder,
    private router: Router  // tiene router porque lo usamos para redireccionar a principal en metodo comprobar
  ) { 
    console.trace('LoginComponent constructor');
    this.crearFormulario();
    this.propiedadAlert = new Alert('');
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


  comprobar() {	
	
    console.trace('click boton submit');
    let placa = this.formulario.controls.placa.value;
    let password = this.formulario.controls.password.value;
    console.debug('placa: %s password: %s', placa, password);
    
  
    //no hay SUBSCRIBE porque no hay SERVICIO REST
    this.autorizacionService.loggin(placa, password);  // llama a login y si coincide pone variable isLogged a true a la que (en autorizacion.service) se llama mediante el metodo estaLogeado()

    if (this.autorizacionService.estaLogeado()) {      
    console.info('Login correcto, tenemos permisos');
    this.router.navigate(['/principal']);  // mediante router de RouteComponent redireccionamos a principal
    
  
    } else {
    console.warn('No tienes permisos');
    this.propiedadAlert = new Alert('Login incorrecto');
    }
    
  
    }// comprobar
  
// -------------------------------------------PARA REST ----------------------------------------------

  /*
  comprobar(){
    console.trace('click boton submit');
    let placa = this.formulario.controls.placa.value;
    let password = this.formulario.controls.password.value;
    console.debug('nombre: %s password: %s',placa , password);

    // llamar servicio Rest, realizar logica dentro de subscripcion 
    // Cuidado es una llamada Asincrona NO OLVIDAR OBSERVABLE EN SERVICIO REST
    this.autorizacionService.loggin(placa, password).subscribe(
      data =>{
        console.debug('Json Agente %o', data);
        this.autorizacionService.setLogged(true);
        this.autorizacionService.saveAgente(data);
        this.router.navigate(['/principal']);
        this.alert = new Alert('loggeado');
      },
      error=>{
        console.warn('error login %o', error);
        this.autorizacionService.setLogged(false);
        this.alert = new Alert('No tienes permisos');
      }
    );

    // *** Cuidado no intentar usar datos de la respuesta aqui ***
       


  }// comprobar
*/
}