import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AutorizacionService } from 'src/app/providers/autorizacion.service';
import { Router } from '@angular/router';
import { Alert } from 'src/app/model/alert';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  formulario: FormGroup;  
  alert: Alert;
  isModificado: boolean;  // comprobar si hay algun cambio en el formulario para la guarda

  constructor(
    private autorizacionService: AutorizacionService,
    private formBuilder: FormBuilder,
    private router: Router
  ) { 
    console.trace('LoginComponent constructor');
    this.crearFormulario();
    this.alert = new Alert('');
    this.isModificado = false;
  }

  ngOnInit() {
    console.trace('LoginComponent ngOnInit');
  }

  crearFormulario(){
    console.trace('LoginComponent crearFormulario');
    this.formulario = this.formBuilder.group({
      nombre: [
                '',                                                                         
                [Validators.required, Validators.minLength(3), Validators.maxLength(150)]   
              ],
      pass : [
              '',
              [Validators.required, Validators.minLength(3), Validators.maxLength(16)]
      ]  
    });  
      
  }// crearFormulario

  public puedoSalir(): Observable<boolean> | boolean {
    console.debug('LoginComponent puedoSalir');
    if( this.formulario.dirty ){    // comprobar si el usuario a interactuado con el form
      const mensaje = '¿ Esta seguro que quieres salir sin logearte ?';
      return window.confirm(mensaje);
    }
    return true;  
}	

  comprobar(){
    console.trace('click boton submit');
    let nombre = this.formulario.controls.nombre.value;
    let pass = this.formulario.controls.pass.value;
    console.debug('nombre: %s password: %s',nombre , pass);

    // llamar servicio Rest, realizar logica dentro de subscripcion
    // Cuidado es una llamada Asincrona
    this.autorizacionService.loggin(nombre, pass).subscribe(
      data =>{
        console.debug('Json Agente %o', data);
        this.autorizacionService.setLogged(true);
        this.autorizacionService.saveAgente(data);
        this.router.navigate(['/backoffice']);
      },
      error=>{
        console.warn('error login %o', error);
        this.autorizacionService.setLogged(false);
        this.alert = new Alert('No tienes permisos');
      }
    );

    // *** Cuidado no intentar usar datos de la respuesta aqui ***
       


  }// comprobar

}
