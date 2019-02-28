import {
  Injectable
} from '@angular/core';
import {
  GLOBAL
} from '../GLOBAL';
import {
  HttpClient
} from '@angular/common/http';
import {
  Observable
} from 'rxjs';
import { Agente } from '../model/agente';

@Injectable({
  providedIn: 'root'
})
export class AgenteService {

  private _isLogged: boolean;
  private _agenteLogueado: Agente;

  public get isLogged(): boolean {
    return this._isLogged;
  }
  public set isLogged(value: boolean) {
    this._isLogged = value;
  }

  public get agenteLogueado(): Agente {
    console.trace('Get AgenteLogueado');
    return this._agenteLogueado;
  }
  public set agenteLogueado(agente: Agente) {
    console.trace('set AgenteLogueado');
    this._agenteLogueado = agente;
  }

  constructor(public http: HttpClient) {
    console.trace('AgenteService constructor');
    this._isLogged = false;
    this._agenteLogueado = new Agente();
  } // Constructor

  /**
   * Llama a la API REST y comprueba que el usuario y la contraseña existan en la DB
   * @param placa Nº de placa del Agente
   * @param pass Contraseña del Agente
   */
  login(placa: string, pass: string): Observable < any > {
    console.debug('Placa: %s Pass: %s', placa, pass);

    const url = GLOBAL.endpoint + 'login/' + placa + '/' + pass;
    console.log(`AgenteService login ${url}`);
    return this.http.get(url);
  } // Login

  /**
   * Cierra la sesión del usuario llamando al backoffice
   */
  logout() {
    //TODO llamar Servicio Rest
    this.isLogged = false;
  }
}
