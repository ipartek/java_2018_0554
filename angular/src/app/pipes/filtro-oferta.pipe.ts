import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filtroOferta'
})
export class FiltroOfertaPipe implements PipeTransform {

  /**
   * Filtro para frutas
   * @param frutas [] array con todas las frutas a filtrar 
   * @param isOferta boolean si true mostrar solo frutas en oferta
   * @param searchText string cadena texto a buscar en el nombre de las frutas, 
   *                   caseInsesitive y cualquier coincidencia
   */
  transform( frutas: any[] , isOferta: boolean, searchText?: string): any[] {
    
    console.trace('FiltroOfertaPipe isOferta= %s searchText=%s', isOferta, searchText);

    if ( isOferta ){   
      return frutas.filter( f => f.oferta );
    }else{
      return frutas;
    }  
  }

}
