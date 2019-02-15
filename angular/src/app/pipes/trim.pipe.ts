import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'trim'
})
export class TrimPipe implements PipeTransform {
  /**
   * Trimar de derecha a izquierda y sustituir los múltiples espacios
   * entre las palabras 
   * @param texto : string a trimar
   * @returns resultado : string trimado
   */
  transform(texto: string): string {
    return texto.replace(/ +(?= )/g,'').trim();;
  }

}
