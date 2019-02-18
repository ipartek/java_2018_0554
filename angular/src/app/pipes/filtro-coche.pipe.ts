import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filtroCoche'
})
export class FiltroCochePipe implements PipeTransform {

  transform(coches: any[], searchText?: string): any[] {
    console.trace('FiltroCochePipe  coches%o',  coches);

    let aResul = coches.map(c=>c);

    if(searchText && searchText !==''){
      aResul = aResul.filter(c =>{
        //let cColores = c.colores.map(colo => colo.nombre); //Obtengo todos los colores de cada coche
       // let colores = cColores.join(''); // quito los espacios
       // let busqueda = c.nombre + colores;
       let busqueda = c.nombre;
        return busqueda.toLowerCase().includes(searchText.toLowerCase());
      });
    }

    return aResul;
  }

}
