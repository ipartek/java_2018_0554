import { Component, OnInit, Input, Output, EventEmitter} from '@angular/core';

@Component({
  selector: 'app-fruta',
  templateUrl: './fruta.component.html',
  styleUrls: ['./fruta.component.scss']
})
export class FrutaComponent implements OnInit {

@Input('fruta') fruta: any;
@Input('frutaComparar') frutaComparar: any;
@Output() llamarPadre = new EventEmitter();
constructor() { 

  
}

ngOnInit() {
}
calcularDescuento(fruta:any):number{
    return (fruta.precio - (fruta.precio)*fruta.descuento/100);
 }

 enviarEventoPadre(event){
  let datosEnviar =this.fruta;
  this.llamarPadre.emit(datosEnviar);
}
}
