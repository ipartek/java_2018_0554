import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  endpoint = 'https://randomuser.me/api/?inc=email,name,picture&nat=es&results=';


  //  inyectar httpClient @angular/common/http';
  constructor(private httpClient: HttpClient) {
    console.trace('PersonaService constructor');
  }

  public getAll(numPersonas = 10 ):  Observable<any > {
    console.trace('getAll ' + this.endpoint + numPersonas);
    return this.httpClient.get( this.endpoint + numPersonas);
  }

}
