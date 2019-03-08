import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'moneda'
})
export class MonedaPipe implements PipeTransform {

  /**
   * transforma un numero añadiendo al final el simbolo de la moneda
   * @param numero: number numero a transformar  
   * @param locale: string por defecto 'es', cambiamos:
   *         <ol> 
   *            <li> es => '€'</li>
   *            <li> en => '$'</li>   
   *         <ol>
   */
  transform(numero: number, locale: string = 'es' ): string {
    let simbolo = '€';
    if ( locale === 'en'){
      simbolo = '$';
    }
    return numero + ' ' + simbolo;
  }

}
