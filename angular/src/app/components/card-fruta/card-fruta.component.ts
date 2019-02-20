import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';


@Component({
  selector: 'app-card-fruta',
  templateUrl: './card-fruta.component.html',
  styleUrls: ['./card-fruta.component.scss']
})
export class CardFrutaComponent implements OnInit {

 
  @Input('fruta') fruta: any;
  @Input('frutaComparar') frutaComparar: any;
  @Output('frutaSeleccionada') eventFrutaSeleccionada = new EventEmitter();

  constructor() { 
  }

  ngOnInit() {
  }


  emitirEvento(){
    this.eventFrutaSeleccionada.emit(this.fruta);
  }

}
