import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from 'selenium-webdriver/http';

@Injectable({
  providedIn: 'root'
})
export class MultaService {

  constructor(private httpClient: HttpClient) {

    console.trace('MultaService constructor');
   }

   //listarMultas(id: number): Observable<any>{
    //let uri = `http://localhost:8080/wsrest/api/agente/${id}/multas`;

    //  console.trace('MultaService listarMultas uri: '+ uri);

    //  return this.httpClient.get(uri);
  // }
}
