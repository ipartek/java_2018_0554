import {
  Component,
  OnInit
} from '@angular/core';
import {
  FormBuilder,
  FormGroup,
  Validators
} from '@angular/forms';
import {
  Router
} from '@angular/router';
import {
  AutorizacionService
} from 'src/app/providers/autorizacion.service';
import { Alerta } from 'src/app/model/alerta';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  formulario: FormGroup;
  alerta: Alerta;

  constructor(
    private autorizacionService: AutorizacionService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {
    console.trace('LoginComponent constructor');
    this.crearFormulario();
    this.alerta = new Alerta('');
  }

  ngOnInit() {
    console.trace('LoginComponent ngOnInit');
  }

  crearFormulario() {
    console.trace('LoginComponent crearFormulario');
    this.formulario = this.formBuilder.group({
      placa: [
        '',
        [Validators.required,
        Validators.min(0),
        Validators.max(99999),
        Validators.minLength(4),
        Validators.maxLength(45)
        ]
      ],
      pass: [
        '',
        [Validators.required,
        Validators.minLength(8),
        Validators.maxLength(50)
        ]
      ]
    });

  } // crearFormulario

  comprobar() {
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
      }, // data
      error => {
        this.autorizacionService.isLogged = false;
        console.warn('No tienes permisos');
        if (error.status == 403) {
          this.alerta = new Alerta(`Credenciales incorrectas, acceso denegado. Código de error: ${error.status}`,
            Alerta.TIPO_WARNING);
          console.error('Error esperado: ' + error.status);
        } else {
          this.alerta = new Alerta(`Error inesperado. Código de error: ${error.status}`);
          console.error(error.status);
        }

      } // error
    ); // subscribe

  } // comprobar

}
