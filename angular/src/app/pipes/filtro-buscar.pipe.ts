import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filtroBuscar'
})
export class FiltroBuscarPipe implements PipeTransform {

  transform(items: any[], searchText: string): any[] {
    if(!items) return [];
    if(!searchText) return items;
    searchText = searchText.toLowerCase();
   return items.filter( it => {
    return it.colores.find(el => el.nombre == searchText);
  });
 }


}
