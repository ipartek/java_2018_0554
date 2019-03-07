import { Component, OnInit, Input } from '@angular/core';
import { Alert } from 'src/app/model/alert';

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.scss']
})
export class AlertComponent implements OnInit {

  @Input() propiedadAlert: Alert;  // creo input en lugar de variable porque el mensaje y el tipo LO RECIBO  de los componentes

  constructor() { 
    this.propiedadAlert = new Alert('');
  }

  ngOnInit() {
  }

}