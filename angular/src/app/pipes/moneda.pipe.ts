import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'moneda'
})
export class MonedaPipe implements PipeTransform {

  /**
   * Transforma un número, añadiendo al final el símbolo de la moneda
   * @param numero : number => Número a transformar
   * @param locale : string => Por defecto 'es', cambiamos: 
   *           <ol>
   *              <li> es => '€' </li>
   *              <li> en => '$' </li>
   *           </ol>
   */
  transform(numero: number, locale: string = 'es'): string { // ? Significa que el parámetro es opcional (Puede que venga o puede que no)
    let simbolo;
    switch (locale) {
      case 'es':
        simbolo='€';
        break;
      case 'eu':
      simbolo='$';
        break;
      default:
      simbolo='€';
        break;
    }

    return numero + ' ' + simbolo;
  }

}
