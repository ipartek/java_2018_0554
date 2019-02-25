import { Component, OnInit, Input } from '@angular/core';
import { Mensaje } from 'src/app/model/mensaje';

@Component({
  selector: 'app-alerta',
  templateUrl: './alerta.component.html',
  styleUrls: ['./alerta.component.scss']
})

export class AlertaComponent implements OnInit {

  
  @Input() mensaje: Mensaje;

  constructor() { 
    this.mensaje = new Mensaje('');
  }

  ngOnInit() {
  }

}
