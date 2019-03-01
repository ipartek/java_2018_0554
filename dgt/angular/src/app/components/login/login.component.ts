import { Component, OnInit } from "@angular/core";
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from "@angular/router";
import { Alert } from "src/app/model/alert";
import { AutorizacionService } from "src/app/providers/autorizacion.service";

@Component({
  selector: "app-login",
  templateUrl: "./login.component.html",
  styleUrls: ["./login.component.scss"]
})
export class LoginComponent implements OnInit {
  formulario: FormGroup;
  alert: Alert;

  constructor(
    private autorizacionService: AutorizacionService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {
    console.trace("LoginComponent constructor");
    this.crearFormulario();
    this.alert = new Alert('');
  }

  ngOnInit() {
    console.trace("LoginComponent ngOnInit");
  }

  crearFormulario() {
    console.trace("LoginComponent crearFormulario");
    this.formulario = this.formBuilder.group({
      placa: [
        '',
        [
          Validators.required,
          Validators.minLength(3),
          Validators.maxLength(150)
        ]
      ],
      password: [
        '',
        [Validators.required, Validators.minLength(3), Validators.maxLength(16)]
      ]
    });
  } // crearFormulario

  comprobar() {
    console.trace("click boton submit");
    let placa = this.formulario.controls.placa.value;
    let password = this.formulario.controls.password.value;
    console.debug("placa: %s password: %s", placa, password);


    // llamar servicio Rest, realizar logica dentro de subscripcion
    // Cuidado es una llamada Asincrona
    this.autorizacionService.loggin(placa, password).subscribe(
      data =>{
        console.debug('Json Agente %o', data);
        this.autorizacionService.isLogged = true;
        this.router.navigate(['/backoffice']);
      },
      error=>{
        console.warn('error login %o', error);
        this.autorizacionService.isLogged = false;
        this.alert = new Alert('No tienes permisos');
      }
    );

    

    
  } // comprobar


}
