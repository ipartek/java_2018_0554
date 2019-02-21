import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpClient, HttpParams } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  endpoint = 'https://randomuser.me/api/';

  constructor(private http:HttpClient) { 
    console.trace('PersonaService constructor');
  }

  public getAllByNumberResults(results:number):Observable<any>{
    //añades una variable params para añadirle la cantidad de usuarios que quieres ver
    let cantidadusuarios=""+results;
    let params = new HttpParams().set('results', cantidadusuarios);
  //  let numeroPersonas=results;
   // let url=this.endpoint+'?results='+numeroPersonas;
    console.trace('getAllByNumberResults: ' + this.endpoint);
    return this.http.get(this.endpoint, { params: params })
  }
}
