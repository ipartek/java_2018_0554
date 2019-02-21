import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fruta } from '../model/fruta';

@Injectable({
  providedIn: 'root'
})
export class FrutaService {

  endpoint ='http://localhost:3000/fruta/';

  constructor(private http: HttpClient) { 
    console.trace('FrutaService constructor');
  }

  public getAll():Observable<any>{
    console.trace("getAll"+ this.endpoint);
    return this.http.get(this.endpoint);
  }

  post(fruta:Fruta):Observable<any>{
    let url = this.endpoint;
    console.log(`FrutaService put ${url}`);

    let body = {
                  
                  "nombre": fruta.nombre
                } 
              
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type':  'application/json'
      })
    };

    return this.http.post( url, body , httpOptions );
  }

  patch(fruta: Fruta):Observable<any>{
    let url = this.endpoint + `${fruta.id}`;
    console.log(`FrutaService patch ${url}`);

    let body = {                    
                  "nombre": fruta.nombre   
                } 
              
    
    return this.http.patch( url, body );
  }


  delete(id:number){
    let url = this.endpoint + id;
    console.log(`FrutaService delete ${url}` );
    return this.http.delete(url);
  }

  public getById(id:number):Observable<any>{
    let url = this.endpoint + id;
    console.trace("getById" + url);
    return this.http.get(this.endpoint);
  }
}
