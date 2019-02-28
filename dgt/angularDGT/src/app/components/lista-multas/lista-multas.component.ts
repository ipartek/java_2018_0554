import { Component, OnInit } from '@angular/core';
import { MultaService } from 'src/app/providers/multa.service';
import { Multa } from 'src/app/model/multa';


@Component({
  selector: 'app-lista-multas',
  templateUrl: './lista-multas.component.html',
  styleUrls: ['./lista-multas.component.sass']
})
export class ListaMultasComponent implements OnInit {

  multas : Multa[];
  
  // parametros de los inputs
  id: number;
  importe: number;
  concepto: string;
  fecha_alta: any;
  id_coche: number;
  id_agente: number;
  

  
    constructor( public multaService:MultaService ) {
        console.log('frutasComponent constructor');
        this.multas = [];
    
 
    }


  
    ngOnInit() {
      console.log('TodosComponent ngOnInit');

      //
      this.id_agente= 4; // TODO no hardcor
      this.getMultas(this.id_agente);
  
    }
    //ngOnInit
  
    getMultas(id:number){
      console.log('TodosComponent getAllByUser');
      this.multas = [];
      this.multaService.getAllByUser(id).subscribe(resultado => {
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
/*
    delete(multas:Multa){
      console.log('frutas2Component delete %o', multas );
  
      this.multaService.delete(multas.id).subscribe(
        result=>{
          this.getAllByUser(this.id_agente);
        },
        error=>{
          alert('No de pudo elimiar fruta');
        }
      );
      }


    new(){
      console.log('FrutaComponent new ');
      let multas = new Multa(this.id,this.importe,this.concepto,this.fecha_alta,this.id_coche,this.id_agente);

      this.multaService.post(multas).subscribe(
        result=>{
          console.log('TodosComponent new %o', result);
          this.getAllByUser(this.id_agente);
        },
        error=>{
          alert('No se pudo Crear Nueva Tarea');
          console.error(error);
        }
      );
    }
  */
  }
  