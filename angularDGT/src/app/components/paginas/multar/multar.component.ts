import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Alert } from 'src/app/model/alert';
import { AutorizacionService } from 'src/app/services/autorizacion.service';
import { MultasService } from 'src/app/services/multas.service';
import { Router } from '@angular/router';
import { Multa } from 'src/app/model/multa';

@Component({
  selector: 'app-multar',
  templateUrl: './multar.component.html',
  styleUrls: ['./multar.component.scss']
})
export class MultarComponent implements OnInit {

  agente: any;
  coche: any;
  formulario: FormGroup;
  alert: Alert;
  
  constructor(
    private autorizacionService: AutorizacionService,
    private multaService: MultasService,
    private formBuilder: FormBuilder,
    private router: Router
  ) {
    this.crearFormulario();
    this.alert = new Alert('');
   }

  ngOnInit() {
    this.getAgenteInfo();
    this.getCocheInfo();
  }

  getAgenteInfo() {
    this.agente = this.autorizacionService.getAgente();

  }

  getCocheInfo() {
    this.coche = this.multaService.getCoche();
  }

  crearFormulario() {
    console.trace('PaginaLoginComponent crearFormulario');
    this.formulario = this.formBuilder.group({
      importe: [
        '',
        [Validators.required]
      ],
      concepto: [
        '',
        [Validators.required, Validators.minLength(10), Validators.maxLength(250)]
      ]
    });

  }

  

  nueva() {
    console.trace('click boton submit');
    let importe = this.formulario.controls.importe.value;
    let concepto = this.formulario.controls.concepto.value;
    let agente = this.autorizacionService.getAgente();
    let coche = this.multaService.getCoche();
    let multa = new Multa(
      -1,
      this.formulario.value.importe,
      this.formulario.value.concepto,
      '',
      this.agente.id,
      this.coche.id,
      '',
      ''
      
    );

    this.multaService.multar(importe, concepto, agente, coche).subscribe(
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