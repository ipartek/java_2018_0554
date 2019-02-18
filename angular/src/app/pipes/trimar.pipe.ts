import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'trimar'
})
export class TrimarPipe implements PipeTransform {

 /**
   * Trimar a derecha e izquierda, sustituir entre palabras los espacios en blanco por sol un espacio.<br>
   * Ej.:  "  hola    que      tal    " =>  "hola que tal"
   * @param cadena
   */
  transform(cadena: string): string {

    return cadena.replace(/ +(?= )/g,'').trim();

 }

}
