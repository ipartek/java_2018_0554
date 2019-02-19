import { Component, OnInit, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-traductor',
  templateUrl: './traductor.component.html',
  styleUrls: ['./traductor.component.scss']
})
export class TraductorComponent implements OnInit {
  @Input ('idioma') idioma:string;
  @Input ('texto') texto:string;
  //se debe capturar llamar padre en el componente padre
  @Output() llamarPadre = new EventEmitter();
  constructor() { 
    console.trace("TraductorComponent constructor");
  }

  ngOnInit() {
    console.trace("TraductorComponent ngOnInit");
  }
    /**
    * al realizar click sobre el boton tenemos que emitir un evento para avisar al padre usando el nombre de output
    */
    enviarEventoPadre(event){
      let datosEnviar ={
        'idioma':this.idioma,
        'texto':this.texto
      }
      this.llamarPadre.emit(datosEnviar);
    }
}

