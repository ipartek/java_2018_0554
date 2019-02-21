import { Component, OnInit } from '@angular/core';
import { Fruta } from 'src/app/model/fruta';
import { FrutaService } from 'src/app/providers/fruta.service';
import { Persona } from 'src/app/model/persona';

@Component({
  selector: 'app-pagina-service-frutas',
  templateUrl: './pagina-service-frutas.component.html',
  styleUrls: ['./pagina-service-frutas.component.scss']
})
export class PaginaServiceFrutasComponent implements OnInit {
  frutas:Fruta[];
  constructor(private frutaService:FrutaService) { 
    console.trace('PaginaServiceFrutasComponent constructor');
    this.frutas=[];
  }

  ngOnInit() {
    console.trace('PaginaServiceFrutasComponent ngOnInit');
    this.getAllFrutas();

  }
  getAllFrutas(){
    this.frutaService.getAll().subscribe(jsonData=>{
      
      console.debug('Se ha recibido el listado de frutas %o',jsonData);
      this.frutas = jsonData.map(v=>{
        return this.rowMapper(v);
      });
    },
    error=>{
      console.log("Se ha cometido un error al cargar todas las frutas %o",error);
    });
  }
  
  delete(fruta:Fruta){
    this.frutaService.delete(fruta.id).subscribe(result=>{
      this.getAllFrutas();
    },
    error=>{
      console.log("Se ha cometido un error al eliminar la fruta seleccionada %o",error);
    });
  }

  /** 
   * Se le envia una fruta en json y se transforma Fruta
   * @param value --> es el parametro donde estan los datos de la fruta a transformar
   * @returns Fruta completa
   */
  rowMapper(value:any):Fruta{
   return new Fruta(
    value.nombre,
    value.precio,
    value.id,
    value.oferta,
    value.descuento,
    value.imagen,
      )
  }

  /**
   * Metodo que hace el calculo de su precio final con el porcentaje de descuento
   * @param fruta 
   */
  calcularDescuento(fruta:any):number{
    return fruta.precio-((fruta.precio*fruta.descuento)/100);
  }
}
