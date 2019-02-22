import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { GLOBAL } from '../GLOBAL';
import { HttpClient, HttpHeaders } from '@angular/common/http';
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

  post(fruta:Fruta): Observable<any> {
    let url = GLOBAL.endpoint + '/fruta/';

    let body = {
      // "id": todo.id,
      "nombre": fruta.nombre,
      "precio": fruta.precio,
      "oferta": fruta.oferta,
      "descuento": fruta.descuento,
      "imagen": fruta.imagen
      //TODO colores
    }
    
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };

    return this.http.post( url, body , httpOptions );

  }

  put(fruta: Fruta): Observable<any>{
    let url = GLOBAL.endpoint + `/fruta/${fruta.id}`;

    let body = {
      "nombre": fruta.nombre,
      "precio": fruta.precio,                    
      "oferta": fruta.oferta,
      "descuento": fruta.descuento    
    }

    return this.http.put( url, body );  
  }

  patch(fruta: Fruta): Observable<any>{
    let url = GLOBAL.endpoint + `/fruta/${fruta.id}`;

    let body = {                    
      "oferta": !fruta.oferta,
      "descuento": fruta.descuento    
    } 
  
    return this.http.patch( url, body );  
  }

}
