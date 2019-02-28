import { Component, OnInit, Input } from '@angular/core';
import { Alerta } from 'src/app/model/alerta';

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.scss']
})
export class AlertComponent implements OnInit {

  @Input() alerta: Alerta;

  constructor() { 
    this.alerta = new Alerta('');
  }

  ngOnInit() {
  }

}
