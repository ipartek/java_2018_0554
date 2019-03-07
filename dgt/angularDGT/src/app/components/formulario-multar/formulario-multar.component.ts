import { Component, OnInit } from '@angular/core';
import { AutorizacionService } from 'src/app/providers/autorizacion.service';
import { MultaService } from 'src/app/providers/multa.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Alert } from 'src/app/model/alert';
import { Multa } from 'src/app/model/multa';
import { Vehiculo } from 'src/app/model/vehiculo';

@Component({
  selector: 'app-formulario-multar',
  templateUrl: './formulario-multar.component.html',
  styleUrls: ['./formulario-multar.component.sass']
})
export class FormularioMultarComponent implements OnInit {

  agente: any;
  vehiculo: any;
  formulario: FormGroup;
  alert: Alert;

  constructor(private autorizacionService: AutorizacionService,
    private multaService: MultaService,
    private formBuilder: FormBuilder,
    private router: Router) {

    console.log('FormularioMultarComponent constructor');
    this.crearFormulario();
    this.alert = new Alert('');
  }

  ngOnInit() {
    console.log('FormularioMultarComponent ngOnInit');

    this.getAgenteInfo();
    this.getVehiculoInfo();
  }
  getAgenteInfo() {
    this.agente = this.autorizacionService.getAgente();

  }

  getVehiculoInfo() {
    this.vehiculo = this.multaService.getVehiculo();
  }

  crearFormulario() {
    console.trace('FormularioMultarComponent crearFormulario');
    this.formulario = this.formBuilder.group({
      importe: [
        '',
        [Validators.required, Validators.min(0.99), Validators.max(9999)]
      ],
      concepto: [
        '',
        [Validators.required, Validators.minLength(5), Validators.maxLength(250)]
      ]
    });

  }// crearFormulario

  

  nueva() {
    console.trace('click boton submit');
    let importe = this.formulario.controls.importe.value;
    let concepto = this.formulario.controls.concepto.value;
    

  
    console.debug('importe: %s concepto: %s', importe, concepto);

    // mappear de formulario a Multa
    let multa = new Multa(
      -1,
      this.formulario.value.importe,
      this.formulario.value.concepto,
      '',
      this.vehiculo.id,
      this.agente.id

      
    );

    //llamar servicio TODO retornar Observable
    // llamar servicio Rest, realizar logica dentro de subscripcion
    // Cuidado es una llamada Asincrona
    this.multaService.multar(multa).subscribe(
      data => {
        console.debug('Json Multa %o', data);
        this.crearFormulario();
        this.router.navigate(['/vermultas']);
      },
      error => {
        console.warn('error multa %o', error);
        this.alert = new Alert('No se ha podido crear la multa');
      }
    );

  }

}
