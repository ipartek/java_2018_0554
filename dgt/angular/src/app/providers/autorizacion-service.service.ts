
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class AutorizacionServiceService {
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
   *
   * nos dice si el usuario ha hecho login o no
   *
   */
  estaLogeado(): boolean {
    return this.isLogged;
  }

  /**
   * metodo para llamar al servicio rest del backoffice
    *@param usuario
   * @param password
   */
  loggin(usuario: string, password: string): Observable<any> {




    // hardcodeo
    /*if (usuario === 'admin' && password === 'admin') {
   this.isLogged = true;
   // y se le pasara la llamada para que se suscriba
    } else {
      this.isLogged = false;
    }*/


    //con servicios Rest
    let uri = `http://localhost:8080/wsrest/api/agente/login/${usuario}/${password}`;
    console.trace('AutorizacionService loggin uri: ' + uri);
    return this.httpClient.get(uri);
  }


  /**
   * Cierra la sesion del usuario llamando al backoffice
   */
  logout() {


    // TODO: llamar al servicio rest
    this._isLogged = false;
  }

}




