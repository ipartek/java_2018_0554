import { Component, OnInit, Input } from '@angular/core';
import { Alert } from 'src/app/model/alert';

@Component({
  selector: 'app-alert',
  templateUrl: './alert.component.html',
  styleUrls: ['./alert.component.scss']
})
export class AlertComponent implements OnInit {

  @Input() alert: Alert;

  constructor() { 
    this.alert = new Alert('');
  }

  ngOnInit() {
  }

}