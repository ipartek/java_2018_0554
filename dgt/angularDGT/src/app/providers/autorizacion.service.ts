import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AutorizacionService {

  private _isLogged: boolean;

  public get isLogged(): boolean {
    return this._isLogged;
  }
  public set isLogged(value: boolean) {
    this._isLogged = value;
  }

  constructor( private httpClient: HttpClient ) { 
    console.trace('AutorizacionService canActivate');
    this._isLogged = false;
  }


  /**
   * metodo para llamar al servicio rest del backoffice
   * @param usuario
   * @param password 
   */
  loggin(usuario: string, password: string): Observable<any>{
        
    let uri = `http://localhost:8080/wsrest/api/agente/login/${usuario}/${password}`;
    console.trace('AutorizacionService loggin uri: ' + uri);
    return this.httpClient.get(uri);    
  }

  /**
   * Cierra la session del usuario llamando al backoffice
   */
  logout(){
    //TODO llamar Servicio Rest
    this._isLogged = false;
  }


}