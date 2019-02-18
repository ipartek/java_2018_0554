import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-coche-card',
  templateUrl: './coche-card.component.html',
  styleUrls: ['./coche-card.component.scss']
})
export class CocheCardComponent implements OnInit {

  @Input()coche:any;
  constructor() { }

  ngOnInit() {
  }

}
