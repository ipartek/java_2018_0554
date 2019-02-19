import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-fruta-card',
  templateUrl: './fruta-card.component.html',
  styleUrls: ['./fruta-card.component.scss']
})
export class FrutaCardComponent implements OnInit {

  
  isOferta:boolean;
  @Input() fruta:any;
  @Input() frutaComparar:any;

  @Output()frutaAnadir= new EventEmitter();

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

  /**Al hacer click, se activa el evento que avisa al padre y hace lo siguiente.
   * Metodo que envia la fruta seleccionada previamente, para añadirla al carrito del padre
   * @param event 
   */
  anadirFruta(event){
    this.frutaAnadir.emit(this.fruta);
  }
}
