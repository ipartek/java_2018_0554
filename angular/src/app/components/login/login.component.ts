import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AutorizacionService } from 'src/app/providers/autorizacion.service';
import { Router } from '@angular/router';
import { Mensaje } from 'src/app/model/mensaje';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  formulario: FormGroup;
  mensaje: Mensaje;

  constructor( 
    private autorizacionService: AutorizacionService, 
    private formBuilder: FormBuilder,
    private router: Router
    ) { 
      console.trace('LoginComponent constructor');
      this.crearFormulario();
      this.mensaje = new Mensaje('');
  }

  ngOnInit() {
    console.trace('LoginComponent ngOnInit');
  }

  crearFormulario(){
    console.trace('LoginComponent crearFormulario');

    this.formulario = this.formBuilder.group({
      //FormControl nombre
      nombre : [
        '',                                                                        
        [Validators.required, Validators.minLength(3), Validators.maxLength(150)] 
      ],
      pass: [
        '',
        [Validators.required, Validators.minLength(3), Validators.maxLength(16)]
      ]
    });
  } // crearFormulario

  comprobar(){
    console.trace('Click boton submit');
    let nombre = this.formulario.controls.nombre.value;
    let pass = this.formulario.controls.pass.value;
    console.debug('nombre: %s password: %s', nombre, pass);

    //Llamar servicio (y a su vez este llama al REST) TODO retornar Observable
    this.autorizacionService.login(nombre, pass);

    if( this.autorizacionService.estaLogueado() ){
      console.info('Login correcto, tenemos permisos');
      this.router.navigate(['backoffice']);
    }else{
      this.mensaje = new Mensaje('No tienes permisos');
    }

  } // comprobar

}
