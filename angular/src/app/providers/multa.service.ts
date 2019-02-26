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

  endpoint = 'http://localhost:8080/dgt/api/agente/{id}';
 

  constructor( private httpClient: HttpClient ) { 
    console.trace('MultaService constructor');
  }

  public getAllByUser():Observable<any>{
    console.trace('getAllByUser ' + this.endpoint);
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

  

}