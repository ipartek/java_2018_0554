import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GLOBAL } from '../GLOBAL';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PaginaFrutasService {

  constructor( public http: HttpClient ) { 
    console.log('PaginaFrutasService constructor');
  }

  /**
   * Obtener todas las frutas del JSON-Server
   */
  getFrutas(): Observable<any> {
    const url = GLOBAL.endpoint + '/fruta';
    return this.http.get(url);
  }

  

}
