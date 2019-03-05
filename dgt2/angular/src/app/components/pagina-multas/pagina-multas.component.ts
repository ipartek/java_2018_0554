import { Component, OnInit } from '@angular/core';
import { Multa } from 'src/app/model/multa';
import { AgenteService } from 'src/app/providers/agente.service';
import { Alerta } from 'src/app/model/alerta';
import { MultaService } from 'src/app/providers/multa.service';

@Component({
  selector: 'app-pagina-multas',
  templateUrl: './pagina-multas.component.html',
  styleUrls: ['./pagina-multas.component.scss']
})
export class PaginaMultasComponent implements OnInit {

  multas: Multa[];
  multasAnuladas: Multa[];
  alerta: Alerta;

  constructor(private agenteService: AgenteService, private multaService: MultaService ) {
    console.trace("PaginaMultasComponent constructor");
    this.multas = [];
    this.multasAnuladas = [];
    this.alerta = new Alerta('');
   }

  ngOnInit() {
    console.trace("PaginaMultasComponent ngOnInit");
   this.cargarMultas();
  }
 
  cargarMultas() {
    console.log('PaginaMultasComponent cargarMultas');
    this.multas = [];
    this.multasAnuladas = [];
    this.agenteService.getMultas( this.agenteService.getAgente().id ).subscribe(resultado => {
      console.debug('Resultado %o', resultado);
      this.mapper(resultado);
    }, error => {
      this.alerta = new Alerta(`Ha ocurrido un error inesperado`);
      console.warn('peticion incorrecta %o', error);
    });
  }

  cargarMultasAnuladas() {
    console.log('PaginaMultasComponent cargarMultasAnuladas');
    this.multas = [];
    this.multasAnuladas = [];
    this.agenteService.getMultasAnuladas( this.agenteService.getAgente().id ).subscribe(resultado => {
      console.debug('Resultado %o', resultado);
      this.mapperAnuladas(resultado);
    }, error => {
      this.alerta = new Alerta(`Ha ocurrido un error inesperado`);
      console.warn('peticion incorrecta %o', error);
    });
  }


  mapper( result: any ){
    let multa: Multa;
    result.forEach(el => {
      multa = new Multa(el.id, el.importe, el.concepto, el.fecha);
      this.multas.push(multa);
     // this.multas.sort(); // al no haber OrderByPipe | sort() --> ascendente => multas.sort((a,b) => 0 - (a > b ? -1 : 1));
    });
  }

  mapperAnuladas( result: any ){
    let multa: Multa;
    result.forEach(el => {
      multa = new Multa(el.id, el.importe, el.concepto, el.fecha, el.fechaBaja);
      this.multasAnuladas.push(multa);
   //   this.multasAnuladas.sort();
    });
  }

}
