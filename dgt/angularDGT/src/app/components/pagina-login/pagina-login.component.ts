import { Component, OnInit } from '@angular/core';
import { AutorizacionService } from 'src/app/providers/autorizacion.service';
import { Router } from '@angular/router';
import { Alert } from 'src/app/model/alert';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-pagina-login',
  templateUrl: './pagina-login.component.html',
  styleUrls: ['./pagina-login.component.sass']
})
export class PaginaLoginComponent implements OnInit {

  formulario: FormGroup;
  alert: Alert;

  constructor(private autorizacionService: AutorizacionService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {

    console.trace('PaginaLoginComponent constructor');
    this.crearFormulario();
    this.alert = new Alert('');
  }

  ngOnInit() {
    console.trace('PaginaLoginComponent ngOnInit');
  }

  crearFormulario() {
    console.trace('PaginaLoginComponent crearFormulario');
    this.formulario = this.formBuilder.group({
      placa: [
        '',
        [Validators.required, Validators.minLength(3), Validators.maxLength(150)]
      ],
      password: [
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

    //llamar servicio TODO retornar Observable
    this.autorizacionService.loggin(placa, password);

    if (this.autorizacionService.estaLogeado()) {
      console.info('Login correcto, tenemos permisos');
      this.router.navigate(['/principal']);

    } else {
      console.warn('No tienes permisos');
      this.alert = new Alert('No tienes permisos');
    }

  }// comprobar

}
