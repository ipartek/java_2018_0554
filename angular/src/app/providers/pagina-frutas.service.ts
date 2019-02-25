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

  public getById(id: number):Observable<any>{
    let url = GLOBAL.endpoint + id;
    console.trace('getById ' + url);
    return this.http.get( url );
  };

  /**
   * Eliminar fruta mediante su ID
   * @param id :number Identificador de la fruta a eliminar
   */
  delete(id: number){
    let url = GLOBAL.endpoint + '/fruta/'+id;
    return this.http.delete(url);
  }

  public guardar(fruta: Fruta):Observable<any>{
    let url = GLOBAL.endpoint + '/fruta/' ;
   
    if ( fruta.id == -1 ){
      let body = {
        "nombre": fruta.nombre,
        "oferta": fruta.oferta,
        "precio": fruta.precio,
        "descuento": fruta.descuento,
        "imagen": fruta.imagen      
      };
      console.trace('crear ' + url);
      return this.http.post(url, body);

    }else{
      let body = {
        "id": fruta.id,
        "nombre": fruta.nombre,
        "oferta": fruta.oferta,
        "precio": fruta.precio,
        "descuento": fruta.descuento,
        "imagen": fruta.imagen      
      };
      console.trace('modificar ' + url + fruta.id);
      return this.http.put(url + fruta.id , body);
    }
    
  } 

  
}
