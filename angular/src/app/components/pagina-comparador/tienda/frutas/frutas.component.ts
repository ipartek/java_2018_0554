import { Component, OnInit, Input, Output } from '@angular/core';

@Component({
  selector: 'app-frutas',
  templateUrl: './frutas.component.html',
  styleUrls: ['./frutas.component.scss']
})
export class FrutasComponent implements OnInit {

  @Input('frutas') frutas: any;
  @Input('frutasComparar') frutasComparar: any;
  @Output('frutaSeleccionada') eventFrutaSeleccionada = new EventEmitter();

  constructor() { 
  }

  ngOnInit() {
  }

  emitirEvento(){
    this.eventFrutaSeleccionada.emit(this.frutas);
  }

}
