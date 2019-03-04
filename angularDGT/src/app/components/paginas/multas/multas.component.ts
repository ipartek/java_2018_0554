import { Component, OnInit } from '@angular/core';
import { MultasService } from 'src/app/services/multas.service';
import { AutorizacionService } from 'src/app/services/autorizacion.service';
import { Router } from '@angular/router';
import { Multa } from 'src/app/model/multa';
import { Alert } from 'src/app/model/alert';

@Component({
  selector: 'app-multas',
  templateUrl: './multas.component.html',
  styleUrls: ['./multas.component.scss']
})

export class MultasComponent implements OnInit {

  multas: Multa[];
  alerta: Alert;

  constructor(
    private multasService: MultasService,
    private autorizacionService: AutorizacionService,
    private router: Router) { 
      this.multas = [];
      this.alerta = new Alert('');
    }

  ngOnInit() {
    this.listarMultas();
  }

  listarMultas() {
    console.log('ListadoMultasComponent listarMultas');
    this.multas = [];
    this.multasService.obtenerMultas( this.autorizacionService.getAgente().id ).subscribe(resultado => {
      console.debug('Resultado %o', resultado);
      this.mapper(resultado);
    }, error => {
      this.alerta = new Alert(`Error inesperado. Código de error: ${error.status}`);
      console.warn('peticion incorrecta %o', error);
    });
  }

  mapper( result: any ){
    let multa: Multa;
    result.forEach(el => {
      multa = new Multa(el.id, el.importe, el.concepto, el.fechaAlta, el.idAgente, el.idCoche, el.fechaModificacion, el.fechaBaja);
      this.multas.push(multa);
    });
  }

}
