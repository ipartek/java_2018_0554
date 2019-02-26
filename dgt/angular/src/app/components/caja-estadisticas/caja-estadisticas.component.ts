import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-caja-estadisticas',
  templateUrl: './caja-estadisticas.component.html',
  styleUrls: ['./caja-estadisticas.component.scss']
})
export class CajaEstadisticasComponent implements OnInit {

  @Input() tipo: string;

  constructor() {
    console.trace('Constructor CajaEstadisticasComponent');
    this.tipo='success';
   }

  ngOnInit() {
    console.trace('ngOnInit CajaEstadisticasComponent');
    console.debug('Valor de tipo ' + this.tipo);
  }

}
