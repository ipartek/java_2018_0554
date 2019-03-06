import { Component, OnInit } from '@angular/core';
import { Multa } from 'src/app/model/multa';
import { AgenteService } from 'src/app/providers/agente.service';
import { Alerta } from 'src/app/model/alerta';
import { MultaService } from 'src/app/providers/multa.service';

@Component({
  selector: 'app-listado-multas',
  templateUrl: './listado-multas.component.html',
  styleUrls: ['./listado-multas.component.scss']
})
export class ListadoMultasComponent implements OnInit {

  multas: Multa[];
  multasAnuladas: Multa[];
  alerta: Alerta;
  multaSeleccionada: Multa;

  constructor(
    private agenteService: AgenteService,
    private multaService: MultaService
    ) {
    console.trace("ListadoMultasComponent constructor");
    this.multas = [];
    this.multasAnuladas = [];
    this.alerta = new Alerta('');
    this.multaSeleccionada = new Multa;
   }

  ngOnInit() {
    console.trace("ListadoMultasComponent ngOnInit");
    this.cargarMultas();
  }

  cargarMultas() {
    console.log('ListadoMultasComponent cargarMultas');
    this.multas = [];
    this.multasAnuladas = [];
    this.agenteService.getMultas( this.agenteService.getAgente().id ).subscribe(resultado => {
      console.debug('Resultado %o', resultado);
      this.mapper(resultado);
      this.multas.sort(function (a, b) {
        return (b.id - a.id);
      });
    }, error => {
      this.alerta = new Alerta(`Error inesperado. Código de error: ${error.status}`);
      console.warn('peticion incorrecta %o', error);
    });
  }

  cargarMultasAnuladas() {
    console.log('ListadoMultasComponent cargarMultasAnuladas');
    this.multas = [];
    this.multasAnuladas = [];
    this.agenteService.getMultasAnuladas( this.agenteService.getAgente().id ).subscribe(resultado => {
      console.debug('Resultado %o', resultado);
      this.mapperAnuladas(resultado);
      this.multasAnuladas.sort(function (a, b) {
        return (b.id - a.id);
      });
    }, error => {
      this.alerta = new Alerta(`Error inesperado. Código de error: ${error.status}`);
      console.warn('peticion incorrecta %o', error);
    });
    console.debug('Ordenando multas anuladas');
    this.multasAnuladas.sort();
  }

  anularMulta(idMulta: number) {
    console.log('ListadoMultasComponent anularMulta ID: ' + idMulta);

    this.multaService.patchMulta( idMulta, 'baja' ).subscribe(resultado => {
      console.debug(`Multa con ID: ${idMulta} dada de baja`);
      this.alerta = new Alerta(`Multa con ID: ${idMulta} dada de baja`, Alerta.TIPO_SUCCESS);
      this.cargarMultas();
    }, error => {
      this.alerta = new Alerta(`Error inesperado. Código de error: ${error.status}`);
      console.warn('peticion incorrecta %o', error);
    });
  }

  reactivarMulta(idMulta: number) {
    console.log('ListadoMultasComponent reactivarMulta ID: ' + idMulta);

    this.multaService.patchMulta( idMulta, 'alta' ).subscribe(resultado => {
      console.debug(`Multa con ID: ${idMulta} dada de alta`);
      this.alerta = new Alerta(`Multa con ID: ${idMulta} reactivada`, Alerta.TIPO_SUCCESS);
      this.cargarMultasAnuladas();
    }, error => {
      this.alerta = new Alerta(`Error inesperado. Código de error: ${error.status}`);
      console.warn('peticion incorrecta %o', error);
    });
  }

  seleccionar(multa: Multa){
    this.multaSeleccionada = multa;
  }

  //TODO cambiar forEach por map()
  mapper( result: any ){
    let multa: Multa;
    result.forEach(el => {
      multa = new Multa(el.id, el.importe, el.concepto, el.fecha);
      this.multas.push(multa);
    });
  }

  mapperAnuladas( result: any ){
    let multa: Multa;
    result.forEach(el => {
      multa = new Multa(el.id, el.importe, el.concepto, el.fecha, el.fecha_baja);
      this.multasAnuladas.push(multa);
    });
  }

}
