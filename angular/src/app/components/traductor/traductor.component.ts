import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';


@Component({
  selector: 'app-traductor',
  templateUrl: './traductor.component.html',
  styleUrls: ['./traductor.component.scss']
})
export class TraductorComponent implements OnInit {
  @Input('idioma') idioma: string;
  @Input('texto') texto: string;

  //evento de salida, este nombre 'llamarPadre' se debe capturar en componentePadre
  @Output() llamarPadre = new EventEmitter();

  constructor() { 
    console.trace('TraductorComponent constructor');
  }

  ngOnInit() {
    console.trace('TraductorComponent ngOnInit');
  }
/**
   * Al realizar click sobre el boton, tenemos que emitir un evento para avisar al padre
   * usando la nombre del @Output llamarPadre: EventEmitter
   * @param event 
   */
  clickBotton(event){

    let datosEnviar = {
        'idioma': this.idioma,
        'texto': this.texto
    };

    // llamarPadre => @Output hay que usar la funcion "EMIT"
    this.llamarPadre.emit( datosEnviar );
  }
}
