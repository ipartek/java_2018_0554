import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class FrutaService {

  endpoint = 'http://localhost:3000/fruta/';

  constructor( private httpClient: HttpClient ) { 
    console.trace('FrutaService constructor');
  }

  getAll():Observable<any>{
    console.trace('getAll ' + this.endpoint);
    return this.httpClient.get( this.endpoint );
  }

  getById( id: number ):Observable<any>{
    let url = this.endpoint + id;
    console.trace('getById ' + url);
    return this.httpClient.get( url );
  }

}
