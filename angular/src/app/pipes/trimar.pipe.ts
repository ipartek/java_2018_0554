import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'trimar'
})
export class TrimarPipe implements PipeTransform {

  /**
   * Trimar a derecha e izquierda, sustituir entre palabras los espacios en blanco
   * Ej: "Hola     que     tal" => "Hola que tal"
   * @param cadena 
   */
  transform(cadena: string): string {
    return cadena.replace(/ +(?= )/g,'');
  }

}
