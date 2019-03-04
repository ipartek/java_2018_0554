import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MultasService {

  endpoint: "http://localhost:8080/wsrest/api";
  http: any;
  constructor( private httpClient: HttpClient ) { }

  obtenerMultas( id: number ): Observable<any> {
    const url = this.endpoint + `/agente/${id}/multa`;
    return this.http.get(url);
  }

  existeMatricula(matricula: string): Observable<any>{
    let uri = `http://localhost:8080/wsrest/api/agente/login/${matricula}`;
    console.trace('AutorizacionService matricula uri: ' + uri);
    return this.httpClient.get(uri);    
  }
}