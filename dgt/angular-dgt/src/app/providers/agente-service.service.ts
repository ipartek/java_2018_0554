import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AgenteServiceService {

  constructor(private httpClient: HttpClient) {
    console.trace('AgenteServiceService constructor');

   }

   listarMultasAg(idAgente: number): Observable<any>{
    let uri = `http://192.168.0.12:8080/wsrest-endika/api/multa/${idAgente}`;
    console.trace('AgenteService loggin uri: ' + uri);
    return this.httpClient.get(uri);    
   }
}
