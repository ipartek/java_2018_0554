import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';


@Component({
  selector: 'app-traductor',
  templateUrl: './traductor.component.html',
  styleUrls: ['./traductor.component.scss']
})
export class TraductorComponent implements OnInit {

  @Input('idioma') idioma: string;

  @Input('texto') texto: string;

  //Evento de salida, este nombre 'llamarPadre' se debe capturar en el componente padre
  @Output() llamarPadre = new EventEmitter();

  constructor() { 
    console.trace("Constructor TraductorComponent");
  }

  ngOnInit() {
    console.trace("ngOnInit TraductorComponent");
  }

  /**
   * Al realizar click sobre el botón, tenemos que emitir un evento para avisar al padre
   * usando el nombre del @Output llamarPadre: EventEmitter
   * @param event 
   */
  clickBoton(event){

    let datosEnviar = {
      'idioma': this.idioma,
      'texto': this.texto
    };
    // llamarPadre => @Output hay que usar la función "EMIT"
    this.llamarPadre.emit( datosEnviar );
  }

}
