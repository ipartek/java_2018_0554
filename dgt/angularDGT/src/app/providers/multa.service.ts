import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class MultaService {
  post(multas: import("../model/multa").Multa): any {
    throw new Error("Method not implemented.");
  }

  endpoint = 'http://localhost:8080/wsrest/api/Agente/';
 

  constructor( private httpClient: HttpClient ) { 
    console.trace('MultaService constructor');
  }

   getAllByUser(id:number):Observable<any>{
    console.trace('getAllByUser ' + this.endpoint + id);
    return this.httpClient.get( this.endpoint + id );
  }




}