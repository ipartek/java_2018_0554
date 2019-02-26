import { Component, OnInit } from '@angular/core';
import { Multa } from 'src/app/model/multa';
import { MultaService } from 'src/app/providers/multa.service';

@Component({
  selector: 'app-listado-multas',
  templateUrl: './listado-multas.component.html',
  styleUrls: ['./listado-multas.component.scss']
})
export class ListadoMultasComponent implements OnInit {

  multas: Multa[];

  constructor(public multaService: MultaService ) {
    console.trace("ListadoMultasComponent constructor");
    this.multas = [];
   }

  ngOnInit() {
    console.trace("ListadoMultasComponent ngOnInit");
    //this.multas = [new Multa(1, 23, 'Concepto', '24/04/2019'), new Multa(2, 40, 'Concepto II', '14/04/2019')];
    this.cargarMultas();
  }

  cargarMultas() {
    console.log('ListadoMultasComponent cargarMultas');
    this.multas = [];
    this.multaService.getMultas().subscribe(resultado => {
      console.debug('Resultado %o', resultado);
      this.mapper(resultado);
    }, error => {
      // TODO NOTIFICAR AL USUARIO
      console.warn('peticion incorrecta %o', error);
    });
  }

  mapper( result: any ){
    let multa: Multa;
    result.forEach(el => {
      multa = new Multa(el.id, el.importe, el.concepto, el.fecha);
    });
  }

}
