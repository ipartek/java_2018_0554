import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GLOBAL } from '../GLOBAL';
import { HttpClient } from '@angular/common/http';
import { Fruta } from '../model/fruta';

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

  /**
   * Eliminar fruta mediante su ID
   * @param id :number Identificador de la fruta a eliminar
   */
  delete(id: number){
    let url = GLOBAL.endpoint + '/fruta/'+id;
    return this.http.delete(url);
  }

}
