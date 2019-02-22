import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
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

  patch(fruta: Fruta):Observable<any>{
    let url = this.endpoint + `${fruta.id}`;
    console.log(`FrutasService patch ${url}`);
    let body = {                    
      "completed": !fruta.completed    
    }                
    return this.httpClient.patch( url, body );
  }

  public delete(id:number):Observable<any>{
    let url = this.endpoint + id;
    console.log(`FrutasService delete ${url}`);
    return this.httpClient.delete(url);
  }

  public post(fruta:Fruta):Observable<any>{
    let url = this.endpoint;
    console.log(`FrutasService put (crear) ${url}`);

    let body = {
      
                  "nombre": fruta.nombre,
                  "precio": fruta.precio,
                  "oferta": fruta.oferta,
                  "descuento": fruta.descuento,
                  "imagen": fruta.imagen,
                  "cantidad": fruta.cantidad,
                  "completed": fruta.completed    
                } 
              

    return this.httpClient.post( url, body);
  }
}