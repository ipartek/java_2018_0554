import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})

export class MultaService {
  
  // variable y getter and setter para comprobar si encuentra la matricula
  private _encontrada: boolean;
  
  public get encontrada(): boolean {
    return this._encontrada;
  }
  public set encontrada(value: boolean) {
    this._encontrada = value;
  }


  
  // no lo se
  post(multas: import("../model/multa").Multa): any {
    throw new Error("Method not implemented.");
  }

  //ENDPOINT
  endpoint = 'http://localhost:8080/wsrest/api/agente/';
 
// METODO CONSTRUCTOR CON HTTPCLIENT COMO PARAMETRO
  constructor( private httpClient: HttpClient ) { 
    console.trace('MultaService constructor');
    this._encontrada = false;
  }

  //METODO PARA LISTADO MULTAS
   getAllByUser(id:number):Observable<any>{
    
    let uri = this.endpoint + id + '/multas';
    console.trace('multa service getAllByUser multas' + uri );
    return this.httpClient.get( uri );
  }
  
  //METODO PARA ENCONTRAR MATRICULA
  getByMatricula(matricula:string):Observable<any>{
    
    let uri = this.endpoint + matricula ;
    console.trace('multa service getByMatricula matricula' + uri );
    return this.httpClient.get( uri );
  }






}