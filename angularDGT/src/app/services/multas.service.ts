import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MultasService {

  constructor( private httpClient: HttpClient ) { }

  obtenerMultas(idAgente: number): Observable<any>{
        
    let uri = `http://localhost:8080/wsrest/api/agente/login/${idAgente}/multas`;
    console.trace('AutorizacionService loggin uri: ' + uri);
    return this.httpClient.get(uri);    
  }
}
