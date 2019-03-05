import { Component, OnInit } from '@angular/core';
import { MultaService } from 'src/app/providers/multa.service';
import { Multa } from 'src/app/model/multa';
import { AutorizacionService } from 'src/app/providers/autorizacion.service';
import { Alert } from 'src/app/model/alert';


@Component({
  selector: 'app-lista-multas-anuladas',
  templateUrl: './lista-multas-anuladas.component.html',
  styleUrls: ['./lista-multas-anuladas.component.sass']
})
export class ListaMultasAnuladasComponent implements OnInit {
 
  
    multas : Multa[];
    alert:Alert;
    multaSeleccionada:Multa;

    // parametros de los inputs
    agente: any;
    
    constructor( private autorizacionService: AutorizacionService, public multaService:MultaService ) {
        console.log('frutasComponent constructor');
        this.multas = [];
      }
  
  
    ngOnInit() {
        console.log('TodosComponent ngOnInit');
        this.getAgenteInfo();
        this.getMultasAnuladas(this.agente);
      
    
      }
      //ngOnInit
  
    getAgenteInfo(){
        this.agente = this.autorizacionService.getAgente();
      }
  
    
    getMultasAnuladas(id:number){
        console.log('TodosComponent getAllByUser');
        this.multas = [];
        this.multaService.getMultasAnuladas(this.agente.id).subscribe(resultado => {
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

     activar(idMulta: number, op:number){
        console.trace('click editar %o', idMulta);
        
        this.multaService.anularMulta(idMulta, op).subscribe(
          resultado => {
          console.debug(`Multa anulada`);
          this.getMultasAnuladas(this.agente.id);   // Volver a listar.  la multa ya se ha anulado pero hay que volver a listar para que desaparezca
          
        }, error => {
          this.alert = new Alert(`Error inesperado. Código de error: ${error.status}`);
          console.warn('peticion incorrecta %o', error);
        });
    }


      seleccionar(multa: Multa){
        this.multaSeleccionada = multa;
      }
  }