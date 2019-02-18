import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filtroOferta'
})
export class FiltroOfertaPipe implements PipeTransform {
/**
 * filtro para frutas
 * @param frutas frutas [] array con todas las frutas a filtrar
 * @param isOferta  isOferta boolean si true mostrar solo frutas en oferta
 * @param searchText searchText string cadena texto a buscar ene l jombre de las frutas ,case insensitive
 */ 
  transform( frutas: any[] , isOferta: boolean, searchText?: string): any[] {
      console.trace('FiltroOfertaPipe isOferta=%o searchText=%o',isOferta,searchText);
    if ( isOferta ){
      frutas = frutas.filter( f => f.oferta );
      if (searchText) {
        searchText = searchText.toLowerCase();
        return frutas.filter(function (el: any) {
            return el.nombre.toLowerCase().indexOf(searchText) > -1;
        });
    }
     return frutas
    }else{
      if (searchText) {
        searchText = searchText.toLowerCase();
        return frutas.filter(function (el: any) {
            return el.nombre.toLowerCase().indexOf(searchText) > -1;
        });
    }
      return frutas;

      
    }

    



  }

}
