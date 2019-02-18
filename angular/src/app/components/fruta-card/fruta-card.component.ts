import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-fruta-card',
  templateUrl: './fruta-card.component.html',
  styleUrls: ['./fruta-card.component.scss']
})
export class FrutaCardComponent implements OnInit {

  
  isOferta:boolean;
  @Input() fruta:any;
  @Input() frutaComparar:any;

  constructor() {
    this.isOferta=false;
   
   }

  ngOnInit() {
  }

  calcularDescuento(fruta:any):number{
    return fruta.precio-((fruta.precio*fruta.descuento)/100);
  }
  cambiarOferta(value:boolean){
    this.isOferta = value;
    console.debug('cambiarOferta ' + this.isOferta);
  }
}
