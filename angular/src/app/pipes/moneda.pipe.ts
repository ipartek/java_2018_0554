import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'moneda'
})
export class MonedaPipe implements PipeTransform {

  transform(value: any, args?: any): any { // ? Significa que el parámetro es opcional (Puede que venga o puede que no)
    return null;
  }

}
