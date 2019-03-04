import { Component, OnInit } from '@angular/core';
import { Alert } from 'src/app/model/alert';
import { Multa } from 'src/app/model/multa';
import { MultaService } from 'src/app/providers/multa.service';
import { AutorizacionService } from 'src/app/providers/autorizacion.service';

@Component({
  selector: 'app-lista-multas',
  templateUrl: './lista-multas.component.html',
  styleUrls: ['./lista-multas.component.sass']
})
export class ListaMultasComponent implements OnInit {

  multas: Multa[];
  agente: any;
  alert: Alert;
  multasAnuladas: Multa[];
  isActiva: boolean;
  

  constructor( private autorizacionService: AutorizacionService, public multaService:MultaService) {
    console.log('ListaMultasComponent constructor');
    this.multas = [];
    this.alert = new Alert('');
    this.multasAnuladas = [];
    this.isActiva = false;

  }



  ngOnInit() {
    console.log('ListaMultasComponent ngOnInit');
    
    this.getAgenteInfo();
    this.getMultas(this.agente);
    this.getMultasAnuladas(this.agente);

  }
  //ngOnInit

  getAgenteInfo(){
    this.agente = this.autorizacionService.getAgente();

  }

  getMultas(id: number) {
    console.log('TodosComponent getAllByUser');
    this.multas = [];
    this.multasAnuladas = [];
    this.multaService.listarMultas(this.agente.id).subscribe(resultado => {
      console.debug('peticion correcta %o', resultado);
      // this.mapeo(resultado);
      // this.todos = resultado.filter( todo => !todo.completed );
      this.isActiva = true;
      this.multas = resultado;
    },
      error => {
        console.warn('peticion incorrecta %o', error);
      }
    );//subscribe   
  }//getMultas

  getMultasAnuladas(id: number) {
    console.log('ListadoMultasComponent getMultasAnuladas');
    this.multas = [];
    this.multasAnuladas = [];
    this.multaService.listarMultasAnuladas(this.agente.id).subscribe(resultado => {
      console.debug('Resultado %o', resultado);
      this.isActiva = true;
      this.multasAnuladas = resultado;
    },  error => {
      console.warn('peticion incorrecta %o', error);
    
    });
  }

  cambiarTabla( value: boolean){    
    this.isActiva = value;
    console.debug('click cambiarOferta ' + this.isActiva);
  }
}
