import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  endpoint = 'https://randomuser.me/api/';

  constructor(private http:HttpClient) { 
    console.trace('PersonaService constructor');
  }

  public getAllByNumberResults(results:number):Observable<any>{
    let numeroPersonas=results;
    let url=this.endpoint+'?results='+numeroPersonas;
    console.trace('getAllByNumberResults: ' + url);
    return this.http.get(url);
  }
}
