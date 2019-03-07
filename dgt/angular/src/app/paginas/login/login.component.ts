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
  AgenteService
} from 'src/app/providers/agente.service';
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
    private agenteService: AgenteService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {
    console.trace('LoginComponent constructor');
    this.crearFormulario();
    this.alerta = new Alerta('');
  }

  /**
   * Crea el formulario del login
   */
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
        Validators.max(999999),
        Validators.minLength(4),
        Validators.maxLength(45)
        ]
      ],
      pass: [
        '',
        [Validators.required,
        Validators.minLength(6),
        Validators.maxLength(50)
        ]
      ]
    });

  } // crearFormulario

  /**
   * Comprueba que los datos introducidos en el formulario
   * (Nº de Placa y Password) están relacionados con un
   * agente de la DB.
   * Si las credenciales existen, se obtienen los datos
   * del agente registrados en la DB y se construye con
   * ellos un objeto Agente [agenteLogueado], cambiando
   * también el estado de la variable 'isLogged' a true.
   * En caso de que no exista dicho agente en la DB, se
   * notificará al usuario mediante un mensaje por pantalla
   */
  comprobar() {
    console.trace('click boton submit');
    let placa = this.formulario.controls.placa.value;
    let pass = this.formulario.controls.pass.value;
    console.debug('nombre: %s password: %s', placa, pass);

    //llamar servicio TODO retornar Observable
    this.agenteService.login(placa, pass).subscribe(
      data => {
        this.agenteService.setLogged(true);
        this.agenteService.saveAgente(data);
        if(this.agenteService.getAgente().id != -1) {
          console.debug('Agente obtenido %o', this.agenteService.getAgente());
        }
        console.info('isLogged: ' + this.agenteService.isLogged)
        console.info('Login correcto, tenemos permisos JSON: %o', data);
        this.router.navigate(['home']);
      }, // data
      error => {
        this.agenteService.setLogged(false);
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
