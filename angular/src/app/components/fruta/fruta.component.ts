import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';

@Component({
  selector: 'app-fruta',
  templateUrl: './fruta.component.html',
  styleUrls: ['./fruta.component.scss']
})
export class FrutaComponent implements OnInit {

  @Input('fruta') fruta: any;
  @Input('frutaComparar') frutaComparar: any;

  @Output() enviarCarrito = new EventEmitter();

  constructor() {
    

   }

  ngOnInit() {
  }

  anadirCarrito(event){
    // llamarPadre => @Output hay que usar la función "EMIT"
    
    this.enviarCarrito.emit( this.fruta );
  }

}
