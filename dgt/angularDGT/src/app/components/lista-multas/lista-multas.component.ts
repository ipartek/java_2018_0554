import { Component, OnInit } from '@angular/core';
import { MultaService } from 'src/app/providers/multa.service';
import { Multa } from 'src/app/model/multa';
import { AutorizacionService } from 'src/app/providers/autorizacion.service';


@Component({
  selector: 'app-lista-multas',
  templateUrl: './lista-multas.component.html',
  styleUrls: ['./lista-multas.component.scss']
})
export class ListaMultasComponent implements OnInit {

  multas : Multa[];
  
  // parametros de los inputs
 

  agente: any;
  

  
    constructor( private autorizacionService: AutorizacionService, public multaService:MultaService ) {
        console.log('frutasComponent constructor');
        this.multas = [];
    
 
    }


    ngOnInit() {
      console.log('TodosComponent ngOnInit');
      this.getAgenteInfo();
      this.getMultas(this.agente);
    
  
    }
    //ngOnInit

 getAgenteInfo(){
      this.agente = this.autorizacionService.getAgente();
    }

  
    getMultas(id:number){
      console.log('TodosComponent getAllByUser');
      this.multas = [];
      this.multaService.getAllByUser(this.agente.id).subscribe(resultado => {
          console.debug('peticion correcta %o', resultado);
         // this.mapeo(resultado);
        // this.todos = resultado.filter( todo => !todo.completed );
           this.multas = resultado;
        },
        error=>{
          console.warn('peticion incorrecta %o', error);
        }
      );//subscribe   
    }
  }