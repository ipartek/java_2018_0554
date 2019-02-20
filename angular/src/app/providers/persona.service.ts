import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs'

@Injectable({
  providedIn: 'root'
})
export class PersonaService {
  endpoint = 'https://randomuser.me/api/?inc=email,name,&results=5';


  //inyectar httpClient @angular/common/http';
  constructor(private httpClient: HttpClient) { 
    console.trace('PersonaService constructor');
  }

  public getAll():Observable<any>{
    console.trace('getAll ' + this.endpoint);
    return this.httpClient.get( this.endpoint );
  }

  
}
