import { Component, OnInit } from '@angular/core';
import { MultasService } from 'src/app/services/multas.service';
import { AutorizacionService } from 'src/app/services/autorizacion.service';
import { Multa } from 'src/app/model/multa';
import { Alert } from 'src/app/model/alert';

@Component({
  selector: 'app-multas-baja',
  templateUrl: './multas-baja.component.html',
  styleUrls: ['./multas-baja.component.scss']
})

export class MultasBajaComponent implements OnInit {

  multas: Multa[];
  alert: Alert;
  agente: any;
  multasAnuladas: Multa[];
  isActiva: boolean;

  constructor(
    public multasService: MultasService,
    private autorizacionService: AutorizacionService,
  ) { 
      this.multas = [];
      this.alert = new Alert('');
      this.multasAnuladas = [];
      this.isActiva = false;
    }

  ngOnInit() {
    this.getAgenteInfo();
    this.getMultasAnuladas(this.agente);
  }

  getAgenteInfo(){
    this.agente = this.autorizacionService.getAgente();
  }
  getMultas(id: number) {
    console.log('TodosComponent getAllByUser');
    this.multas = [];
    this.multasAnuladas = [];
    this.multasService.listarMultas(this.agente.id).subscribe(resultado => {
      console.debug('peticion correcta %o', resultado);
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
    this.multasService.listarMultasAnuladas(this.agente.id).subscribe(resultado => {
      console.debug('Resultado %o', resultado);
      this.isActiva = true;
      this.multasAnuladas = resultado;
    },  error => {
      console.warn('peticion incorrecta %o', error);
    
    });
  }
};