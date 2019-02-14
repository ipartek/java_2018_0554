import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'moneda'
})
export class MonedaPipe implements PipeTransform {

  //la interrogacion significa que el paramentro es opcional

  /**
   * transforma un numero añadiendo al final el simbolo de la moneda el
   * @param numero : numero a transformar
   * @param locale : string, por defecto 'es' , cambiamos 'es' por '€' y 'en' por $;
   * @return numero con su simbolo
   */
  transform(numero: number, locale: string): string {
    let simbolo='€';
    //triple igual compara el valor y el tipo  1==='1' => FALSE
    //con el doble solo compara el valor  1=='1' => TRUE

     if(locale==='en'){ simbolo = '$';}
   
    return numero + ' ' + simbolo;
  }

}
