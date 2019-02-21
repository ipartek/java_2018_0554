import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  endpoint = 'https://randomuser.me/api/?results=';

  constructor( private httpClient: HttpClient ) { 
    console.trace('PersonaService constructor');
  }

  public getAll(nPersonas: number = 10):Observable<any>{
    console.trace('getAll ' + this.endpoint);
    return this.httpClient.get( this.endpoint + nPersonas);
  }

}
