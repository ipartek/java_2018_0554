import { Component, OnInit } from '@angular/core';
import { MultaService } from 'src/app/providers/multa.service';
import { Multa } from 'src/app/model/multa';
import { AutorizacionService } from 'src/app/providers/autorizacion.service';
import { Alert } from 'src/app/model/alert';



@Component({
  selector: 'app-lista-multas',
  templateUrl: './lista-multas.component.html',
  styleUrls: ['./lista-multas.component.sass']
})
export class ListaMultasComponent implements OnInit {

  multas : Multa[];
  agente: any;
  alert:Alert;
  multaSeleccionada:Multa;
   
  constructor( private autorizacionService: AutorizacionService, public multaService:MultaService ) {
    console.log('frutasComponent constructor');
    this.multas = [];
    this.alert = new Alert('');
    this.multaSeleccionada = new Multa(-1,0,'','',-1,-1);
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

  anular(idMulta: number, op:number){
    console.trace('click editar %o', idMulta);
    
    this.multaService.anularMulta(idMulta,op).subscribe(
      resultado => {
      console.debug(`Multa anulada`);
      this.getMultas(this.agente.id);   // Volver a listar.  la multa ya se ha anulado pero hay que volver a listar para que desaparezca
      
    }, error => {
      this.alert = new Alert(`Error inesperado. Código de error: ${error.status}`);
      console.warn('peticion incorrecta %o', error);
    });

  }

  seleccionar(multa: Multa){
    this.multaSeleccionada = multa;
  }

}