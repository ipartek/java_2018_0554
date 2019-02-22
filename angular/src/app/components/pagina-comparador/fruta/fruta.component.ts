import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';


@Component({
  selector: 'app-fruta',
  templateUrl: './fruta.component.html',
  styleUrls: ['./fruta.component.scss']
})
export class FrutaComponent implements OnInit {

 
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