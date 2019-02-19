import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-fruta',
  templateUrl: './fruta.component.html',
  styleUrls: ['./fruta.component.scss']
})
export class FrutaComponent implements OnInit {

  @Input('fruta') fruta: any;
  @Input('frutaComparar') frutaComparar: any;

  constructor() { 
  }

  ngOnInit() {
  }

  calcularDescuento( fruta: any) : number {    
    return fruta.precio - ( fruta.precio * fruta.descuento / 100 );
  }

}
