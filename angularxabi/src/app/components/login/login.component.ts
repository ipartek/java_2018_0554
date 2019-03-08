import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AutorizacionService } from 'src/app/providers/autorizacion.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.sass']
})
export class LoginComponent implements OnInit {

  formulario: FormGroup;

  constructor(private autorizacionService: AutorizacionService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {

    console.trace('PaginaLoginComponent constructor');
    
    
  }

  ngOnInit() {
    console.trace('LoginComponent ngOnInit');
    this.crearFormulario();
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


  comprobar(){
    console.trace('click boton submit');
    let nombre = this.formulario.controls.nombre.value;
    let pass = this.formulario.controls.pass.value;
    console.debug('nombre: %s password: %s',nombre , pass);

    //llamar servicio TODO retornar Observable
    this.autorizacionService.loggin(nombre, pass);

    if ( this.autorizacionService.estaLogeado() ){
      console.info('Login correcto, tenemos permisos');
      this.router.navigate(['principal']);

    }else{
      console.warn('No tienes permisos');
      //this.alert = new Alert('No tienes permisos');
    }

  }// comprobar

}
