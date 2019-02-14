import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'moneda'
})
export class MonedaPipe implements PipeTransform {

  /**
   * transforma un número añadiendo al final el símbolo de la moneda
   * @param numero: number, número a transformar
   * @param locale: string, por defecto 'es'. cambiamos:
   *          <ol>
   *            <li>es -> '€'</li>
   *            <li>en -> '$'</li>
   *          </ol>
   */
  transform(numero: number, locale: string = 'es'): string {
    let simbolo = '€';

    if (locale == 'us'){
      simbolo = '$';
    }
    return numero + '' + simbolo;
  }

}
