import { Component, OnInit, Input, Output } from '@angular/core';
import { EventEmitter } from '@angular/core';

@Component({
  selector: 'app-traductor',
  templateUrl: './traductor.component.html',
  styleUrls: ['./traductor.component.scss']
})
export class TraductorComponent implements OnInit {

  @Input('idioma') idioma: string;
  @Input('texto') texto: string;
  //Evento de salida, este nombre 'llamarPadre' se debe capturar en componente Padre
  @Output() llamarPadre = new EventEmitter();
  constructor() {
    console.trace('TraductorComponent constructor');
   }

  ngOnInit() {
    console.trace('TraductorComponent ngOnInit');
  }

    /**
     *  Al realizar click sobre el boton, temos que emitr un evneto para avisar al padre
     * usando el nombre del @Output llamarPadre: EventEmitter
     * @param event los datos que se le envia al padre son objetos, json es un objeto en javascript, o como se define
     */
    clickBoton(event){
      let datosEnviar={
        'idioma': this.idioma,
        'texto': this.texto
      };

      //llamarPadre => @Output hay que usar la funcion "EMIT"
      this.llamarPadre.emit(datosEnviar);
    }

}
