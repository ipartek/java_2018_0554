import { Component, OnInit } from '@angular/core';
import { MultaService } from 'src/app/providers/multa.service';
import { Multa } from 'src/app/model/multa';
import { AutorizacionService } from 'src/app/providers/autorizacion.service';
import { Alert } from 'src/app/model/alert';



@Component({
  selector: 'app-lista-multas',
  templateUrl: './lista-multas.component.html',
  styleUrls: ['./lista-multas.component.scss']
})
export class ListaMultasComponent implements OnInit {

  multas : Multa[];
  agente: any;
  alert:Alert;
   
  constructor( private autorizacionService: AutorizacionService, public multaService:MultaService ) {
    console.log('frutasComponent constructor');
    this.multas = [];
    this.alert = new Alert('');
  }


  ngOnInit() {
    console.log('TodosComponent ngOnInit');
    this.getAgenteInfo();
    this.getMultas(this.agente);
  }

  getAgenteInfo(){
    this.agente = this.autorizacionService.getAgente();
  }
  
  getMultas(id:number){
    console.log('TodosComponent getMultas');
    this.multas = [];
    this.multaService.getMultas(this.agente.id).subscribe(resultado => {
      console.debug('peticion correcta %o', resultado);      
      this.multas = resultado;
    },
    error=>{
      console.warn('peticion incorrecta %o', error);
    }
    );//subscribe   
  }
}