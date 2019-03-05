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
import { environment } from './../../../environments/environment';
console.debug( 'Estamos leyendo el valor de la variable environment.texto: ' + environment.texto );
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
        Validators.minLength(5),
        Validators.maxLength(45)
        ]
      ],
      pass: [
        '',
        [Validators.required,
        Validators.minLength(5),
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
    this.agenteService.login(placa, pass).subscribe(
      data => {
        this.agenteService.setLogged(true);
        this.agenteService.guardarAgente(data);
        if (this.agenteService.getAgente().id != -1) {
          console.debug('Agente obtenido %o', this.agenteService.getAgente());
        }
        console.info('isLogged: ' + this.agenteService.isLogged)
        console.info('Login correcto, tenemos permisos JSON: %o', data);
        this.router.navigate(['principal']);
      }, // data
      error => {
        this.agenteService.setLogged(false);
        console.warn('No tienes permisos');
        if (error.status == 403) {
          this.alerta = new Alerta(`Credenciales incorrectas, acceso denegado. Código de error: ${error.status}`,
            Alerta.TIPO_WARNING);
          console.error('Error esperado: ' + error.status);
        } else {
          this.alerta = new Alerta(`Ha ocurrido un error inesperado`);
          console.error(error.status);
        }

      } // error
    ); // subscribe

  } // comprobar

}
