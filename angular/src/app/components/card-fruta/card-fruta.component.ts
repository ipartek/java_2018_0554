import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-card-fruta',
  templateUrl: './card-fruta.component.html',
  styleUrls: ['./card-fruta.component.scss']
})
export class CardFrutaComponent implements OnInit {

 
  @Input('fruta') fruta: any;
  @Input('frutaComparar') frutaComparar: any;

  constructor() { 

    
  }

  ngOnInit() {
  }

}
