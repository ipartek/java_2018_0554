import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FrutaService {
  //se guarda en services/provider

  endpoint = 'http://192.168.0.12:3000/frutas/';

  constructor(private http:HttpClient) { 
    console.trace('FrutaService constructor');
  }

  public getAll():Observable<any>{
    console.trace('getAll ' + this.endpoint);
    return this.http.get(this.endpoint);
  }
  public getById(id:number):Observable<any>{
    let url = this.endpoint + id
    console.trace('getById ' + url);
    return this.http.get(url);
  }
}
