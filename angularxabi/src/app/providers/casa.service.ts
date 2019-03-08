import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Casa } from '../model/casa';

@Injectable({
  providedIn: 'root'
})
export class CasaService {

  endpoint = 'http://localhost:3000/casas/';

  constructor(private httpClient: HttpClient) {
    console.trace('CasaService constructor');
   }

   public getAll():Observable<any>{
    console.trace('getAll ' + this.endpoint);
    return this.httpClient.get( this.endpoint );
  }

  public guardar(casa: Casa):Observable<any>{
    let url = this.endpoint;
   

   

      let body = {
        "nombre": casa.nombre,
        "alquiler": casa.alquiler,
        "precio": casa.precio,
        "direccion": casa.direccion,
        "foto": casa.foto,
        "habitaciones": casa.habitaciones     
      };
      console.debug('crear url: %s body: %o', url, body);
      return this.httpClient.post(url, body);

    }

    
  } 

  /*public getAlquiler():Observable<any>{
    console.trace('getAlquiler ' + this.endpoint);
    return this.httpClient.get( this.endpoint );
  }

  public getVenta():Observable<any>{
    console.trace('getVenta ' + this.endpoint);
    return this.httpClient.get( this.endpoint );
  }*/

