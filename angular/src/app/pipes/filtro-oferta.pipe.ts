import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filtroOferta'
})
export class FiltroOfertaPipe implements PipeTransform {

  transform( frutas: any[] , isOferta: boolean ): any[] {

    if ( isOferta ){
      return frutas.filter( f => f.oferta );
    }else{
      return frutas;
    }
  }

}
