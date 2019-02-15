import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'trimar'
})
export class TrimarPipe implements PipeTransform {
  
  transform(cadena: string): string {
    return cadena.replace(/ +(?= )/g,'').trim();  

  }

}
