import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

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

  constructor(private httpClient: HttpClient) {
    console.trace('AutorizacionService canActivate');
    this._isLogged = false;

  }


  /**
   * muestra si ha hecho login o no
   */
  estaLogeado(): boolean {
    return this.isLogged;
  }

  /**
   * llamar al servicio rest del backoffice
   * @param placa 
   * @param password 
   */
  loggin(placa: string, password: string): Observable<any> {
/* if ( placa === '123456' && password === '123456'){
       this.isLogged = true;
     }else{
       this.isLogged = false;
     }*/
    console.trace('AutorizacionService loggin');
    


    // llamar Servicio Rest
    let uri = `http://localhost:8080/wsrest/api/agente/login/${placa}/${password}`;
    console.trace('AutorizacionService loggin uri: ' + uri);

    return this.httpClient.get(uri);
  }



  /**
   * Cierra la session del usuario llamando al backoffice
   */
  logout() {
    //TODO llamar Servicio Rest

    this._isLogged = false;


  }


}