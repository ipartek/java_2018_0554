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

  endpoint = 'http://localhost:8080/wsrest/api/agente/';
 

  constructor( private httpClient: HttpClient ) { 
    console.trace('MultaService constructor');
  }

   getAllByUser(id:number):Observable<any>{
    
    let uri = this.endpoint + id + '/multas';
    console.trace('multa service getAllByUser multas' + uri );
    return this.httpClient.get( uri );
  }




}