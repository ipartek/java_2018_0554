import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'moneda'
})
export class MonedaPipe implements PipeTransform {

  // ? significa opcional, puede que ese parametro sea opcional o no
  //   transform(value: number, args?: string): string --> lo ultimo despues de ":" es lo que devuelve
  /**
   * Transforma un número añadiendo el final el simbolo de la moneda
   * @param numero numero a transformar
   * @param _locale de tipo string, por defecto 'es', 
   * <ol>
   *    <li>es => '€' </li>
   *    <li>en => '$'</li>
   * </ol>
   */
  transform(numero: number, _locale: string = 'es'): string {
    let simbolo='€';
    switch (_locale) {
      case 'es':
          return numero + simbolo;
        break;

      case 'en':
          simbolo='$';
          return numero + simbolo;
        break;
    
      default:
        return numero + simbolo;
        break;
    }
    return null;
  }

}
