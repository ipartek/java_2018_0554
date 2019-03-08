import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { CasaService } from 'src/app/providers/casa.service';
import { Casa } from 'src/app/model/casa';

@Component({
  selector: 'app-card-casa',
  templateUrl: './card-casa.component.html',
  styleUrls: ['./card-casa.component.sass']
})
export class CardCasaComponent implements OnInit {
  @Input('casa') casa: any;
  @Output('casaSeleccionado') eventCasaSeleccionado = new EventEmitter();

  casas: Casa[];

  constructor(private casaService: CasaService) {

    this.casas = [];
    
   }

  ngOnInit() {

    this.cargarCasas();
  }

  /*emitirEvento(){
    this.eventCasaSeleccionado.emit(this.casa);
  }*/

  cargarCasas() {

    this.casas = [];
    console.trace('PrincipalComponent cargarCasas');

    this.casaService.getAll().subscribe((json: any) => {

      // let info = json.info; 
      let casasJson = json;

      //map 
      console.debug('casas %o', casasJson);
      this.casas = casasJson.map(ca => {
        let id = ca.id;
        let nombre = ca.nombre;
        let precio = ca.precio;
        let alquiler = ca.alquiler;
        let habitaciones = ca.habitaciones;
        let foto = ca.foto;
        let direccion = ca.direccion;
        let servicios = ca.servicios;
        return new Casa(id,nombre, precio, alquiler, habitaciones, foto, direccion, servicios);
      });
    });

    

  }


}
