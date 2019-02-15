import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filtroOferta'
})
export class FiltroOfertaPipe implements PipeTransform {

  transform(frutas: any[], isOferta: boolean): any[] {
    console.debug('isOferta %o frutas%o', isOferta,frutas);
    
    if(isOferta){
      return frutas.filter(f=>f.oferta);
    }
    return frutas;
    
  }

}
