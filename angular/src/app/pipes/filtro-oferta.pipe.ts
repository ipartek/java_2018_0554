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
    
    console.trace('FiltroOfertaPipe isOferta= %s searchText=%s', isOferta, searchText);
    searchText = searchText.toLowerCase();

    // conseguimos el mismo array pero sin que apunte a la misma posicion de memoria
    // no usar aResul = frutas;
    let aResul = frutas.map(f=>f);

    // 1º filtrar por Oferta
    if ( isOferta ){   
      aResul = aResul.filter( f => f.oferta );
    }

    //2º filtrar por searchText, si esta definido y diferente vacio
    if ( searchText && searchText !== '' ){
      aResul = aResul.filter( f => {
        let aColores = f.colores.map( c => c.nombre); // conseguir array con nombres colores
        let colores = aColores.join(''); // conseguir un string concatenando todos los colores del array
        let busqueda = f.nombre + colores; 
        return busqueda.toLowerCase().includes(searchText);
       });
    }

    return aResul;

  }
}


