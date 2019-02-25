import { Component, OnInit, Input } from '@angular/core';
import { Mensaje } from 'src/app/model/mensaje';

@Component({
  selector: 'app-mensaje',
  templateUrl: './mensaje.component.html',
  styleUrls: ['./mensaje.component.scss']
})
export class MensajeComponent implements OnInit {

  @Input() mensaje: Mensaje;

  constructor() { 
    console.trace('MensajeComponent constructor');
    this.mensaje=new Mensaje('');
    
  }

  ngOnInit() {
    console.trace('MensajeComponent ngOnInit');
  }

}
