import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GLOBAL } from 'src/global';

@Injectable({
  providedIn: 'root'
})
export class MultaService {

  constructor( public http: HttpClient ) {
    console.log('MultaService constructor');

   }

   getCoche(matricula: string): Observable < any > {
    console.debug('matricula: %s', matricula);

    const url = GLOBAL.endpoint + `/vehiculo/${matricula}`;
    console.log(`MultaService login ${url}`);
    return this.http.get(url);
  }
}
