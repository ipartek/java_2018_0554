import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Alerta } from 'src/app/model/alerta';
import { MultaService } from 'src/app/providers/multa.service';
import { Router } from '@angular/router';
import { Coche } from 'src/app/model/coche';

@Component({
  selector: 'app-matricula',
  templateUrl: './matricula.component.html',
  styleUrls: ['./matricula.component.scss']
})
export class MatriculaComponent implements OnInit {

  formulario: FormGroup;
  alerta: Alerta;
  cocheBuscado: Coche;
  agente: any;
  agenteService: any;

  constructor(
    private multaService: MultaService,
    private formBuilder: FormBuilder,
    private router: Router
  ) { 
    console.trace('MatriculaComponent constructor');
    this.crearFormulario();
    this.alerta = new Alerta('');
  }

  ngOnInit() {
this.getDatosAgente();
  }

  crearFormulario() {
    console.trace('MatriculaComponent crearFormulario');
    this.formulario = this.formBuilder.group({
      matricula: [
        '',
        [Validators.required,
        Validators.minLength(7),
        Validators.maxLength(10)
        ]
      ]
    });

  } // crearFormulario

  comprobar() {
    console.trace('click boton submit');
    let matricula = this.formulario.controls.matricula.value;
    
    console.debug('matricula: %s', matricula);
    
    //llamar servicio TODO retornar Observable
    this.multaService.getCoche().subscribe(
      data => {
        console.debug('Json Coche %o',data)
        this.cocheBuscado = data;
        if(this.cocheBuscado.id != -1) {
          console.debug('Coche obtenido %o', this.cocheBuscado);          
        }
       
       
      }, 
      error => {
        console.warn('No tienes permisos');
        if (error.status == 404) {
          this.alerta = new Alerta(`El vehiculo no existe. Error ${error.status}`,
            Alerta.TIPO_WARNING);
          console.error(' Se ha encontrado el siguiente error: ' + error.status);
        } else {
          this.alerta = new Alerta(`Ha ocurrido un error inesperado`);
          console.error(error.status);
        }

      } 
    ); 

  } // comprobar
  getDatosAgente(){
    this.agente = this.agenteService.getAgente();

  }

  // TO METODO POST (uri: )
}
