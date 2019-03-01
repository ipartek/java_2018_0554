import { Component, OnInit } from '@angular/core';
import { Multa } from 'src/app/model/multa';
import { AgenteService } from 'src/app/providers/agente.service';
import { Alerta } from 'src/app/model/alerta';

@Component({
  selector: 'app-listado-multas',
  templateUrl: './listado-multas.component.html',
  styleUrls: ['./listado-multas.component.scss']
})
export class ListadoMultasComponent implements OnInit {

  multas: Multa[];
  alerta: Alerta;

  constructor(private agenteService: AgenteService ) {
    console.trace("ListadoMultasComponent constructor");
    this.multas = [];
    this.alerta = new Alerta('');
   }

  ngOnInit() {
    console.trace("ListadoMultasComponent ngOnInit");
    //this.multas = [new Multa(1, 23, 'Concepto', '24/04/2019'), new Multa(2, 40, 'Concepto II', '14/04/2019')];
    this.cargarMultas();
  }

  cargarMultas() {
    console.log('ListadoMultasComponent cargarMultas');
    this.multas = [];
    this.agenteService.getMultas( this.agenteService.getAgente().id ).subscribe(resultado => {
      console.debug('Resultado %o', resultado);
      this.mapper(resultado);
    }, error => {
      this.alerta = new Alerta(`Error inesperado. Código de error: ${error.status}`);
      console.warn('peticion incorrecta %o', error);
    });
  }

  //TODO cambiar forEach por map()
  mapper( result: any ){
    let multa: Multa;
    result.forEach(el => {
      multa = new Multa(el.id, el.importe, el.concepto, el.fecha);
      this.multas.push(multa);
    });
  }

}
