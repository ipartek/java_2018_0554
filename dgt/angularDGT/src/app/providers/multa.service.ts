import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MultaService {

  

  constructor(private httpClient: HttpClient) {
    console.trace('MultaService constructor');
   }

  listarMultas(id: number): Observable<any>{
    let uri = `http://localhost:8080/wsrest/api/agente/${id}/multas`;

      console.trace('MultaService listarMultas uri: '+ uri);

      return this.httpClient.get(uri);

  }

  buscarMatricula(matricula: string): Observable<any>{
    let uri = `http://localhost:8080/wsrest/api/agente/${matricula}`;

    console.trace('MultaService buscarMatricula uri: '+ uri);

    return this.httpClient.get(uri);
  }
}
