import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fruta } from '../model/fruta';

@Injectable({
  providedIn: 'root'
})
export class FrutaService {

  endpoint = 'http://localhost:3000/fruta/';

  constructor( private httpClient: HttpClient ) { 
    console.trace('FrutaService constructor');
  }

  public getAll():Observable<any>{
    console.trace('getAll ' + this.endpoint);
    return this.httpClient.get( this.endpoint );
  }

  public getById(id: number):Observable<any>{
    let url = this.endpoint + id;
    console.trace('getById ' + url);
    return this.httpClient.get( url );
  };

  public delete(id: number):Observable<any>{
    let url = this.endpoint + id;
    console.trace('delete ' + url);
    return this.httpClient.delete( url );
  }  

  public guardar(fruta: Fruta):Observable<any>{
    let url = this.endpoint;
   

    if ( fruta.id == -1 ){
      let body = {
        "nombre": fruta.nombre,
        "oferta": fruta.oferta,
        "precio": fruta.precio,
        "descuento": fruta.descuento,
        "imagen": fruta.imagen      
      };
      console.trace('crear ' + url);
      return this.httpClient.post(url, body);

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
      return this.httpClient.put(url + fruta.id , body);
    }

    
  } 


}
