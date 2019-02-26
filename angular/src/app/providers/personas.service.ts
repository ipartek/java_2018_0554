import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PersonasService {

 // endpoint = 'https://randomuser.me/api/?inc=picture,name,email&results='+numberOfPersons;
  
  constructor(private httpClient: HttpClient) {
    console.trace('PersonasService constructor');
   }

   public getAll(numberOfPersons = 10):Observable<any>{
    console.trace('getAll ');
    return this.httpClient.get( 'https://randomuser.me/api/?inc=picture,name,email&results='+numberOfPersons );
  }

  /*public getById(id: number):Observable<any>{
    let url = this.endpoint + id;
    console.trace('getById ' + url);
    return this.httpClient.get( url );
  };*/
}
