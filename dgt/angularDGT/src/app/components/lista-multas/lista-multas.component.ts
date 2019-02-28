import { Component, OnInit } from '@angular/core';
import { Alert } from 'src/app/model/alert';
import { Multa } from 'src/app/model/multa';
import { MultaService } from 'src/app/providers/multa.service';

@Component({
  selector: 'app-lista-multas',
  templateUrl: './lista-multas.component.html',
  styleUrls: ['./lista-multas.component.sass']
})
export class ListaMultasComponent implements OnInit {

  multas: Multa[];
  id_agente: number;
  alert: Alert;

  constructor( public multaService:MultaService) {
    console.log('ListaMultasComponent constructor');
    this.alert = new Alert('');

  }



  ngOnInit() {
    console.log('ListaMultasComponent ngOnInit');

    //
    this.id_agente = 4; 
    this.getMultas(this.id_agente);

  }
  //ngOnInit

  getMultas(id: number) {
    console.log('TodosComponent getAllByUser');
    this.multas = [];
    this.multaService.listarMultas(id).subscribe(resultado => {
      console.debug('peticion correcta %o', resultado);
      // this.mapeo(resultado);
      // this.todos = resultado.filter( todo => !todo.completed );
      this.multas = resultado;
    },
      error => {
        console.warn('peticion incorrecta %o', error);
      }
    );//subscribe   
  }

}
