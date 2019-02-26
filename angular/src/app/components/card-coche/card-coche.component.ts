import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-card-coche',
  templateUrl: './card-coche.component.html',
  styleUrls: ['./card-coche.component.scss']
})
export class CardCocheComponent implements OnInit {
  @Input('coche') coche: any;
  @Output('cocheSeleccionado') eventCocheSeleccionado = new EventEmitter();
  
  //@Output() llamarCoche = new EventEmitter();
  

  constructor() { 
    
  }

  ngOnInit() {
  }

 /* clickBotton(event){

    let datosEnviar = this.coche

    // llamarPadre => @Output hay que usar la funcion "EMIT"
    this.llamarCoche.emit( datosEnviar );
  }*/
  emitirEvento(){
    this.eventCocheSeleccionado.emit(this.coche);
  }
  /*addCoche(event){
    this.listados.push(this.cocheLista);
  }*/
}
