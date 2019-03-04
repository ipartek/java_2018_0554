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

  private storage = window.sessionStorage;

  public isLogged(): boolean {
    if(this.storage.getItem('isLogged') === "true"){
      return true;
    }else{
      return false;
    }
  }
  public setLogged(value: boolean) {
    console.debug('Hacemos setter de _isLogged y guardar en sessionStorage %o', this.storage);
    if(value === true){
      this.storage.setItem('isLogged', 'true');
    }else{
      this.storage.setItem('isLogged', 'false');
    }
  }

  public saveAgente( agente: Agente){
    this.storage.setItem('agenteLogueado', JSON.stringify(agente));
  }

  public getAgente(): Agente {
    console.debug('Agente logueado: %o', this.storage.getItem('agenteLogueado'));
    if(this.storage.getItem('agenteLogueado')){
      return JSON.parse(this.storage.getItem('agenteLogueado'));
    }else{
      return undefined;
    }
   }

  constructor(public http: HttpClient) {
    console.trace('AgenteService constructor');
    
  } // Constructor

  /**
   * Llamar a la API rest 
   * @param placa 
   * @param pass 
   */
  login(placa: string, pass: string): Observable < any > {
    console.debug('Placa: %s Pass: %s', placa, pass);

    const url = GLOBAL.endpoint + 'login/' + placa + '/' + pass;
    console.log(`AgenteService login ${url}`);
    return this.http.get(url);
  } // Login

  
  getMultas( id: number ): Observable<any> {
    const url = GLOBAL.endpoint + `/agente/${id}/multa`;
    return this.http.get(url);
  }

  getMultasAnuladas( id: number ): Observable<any> {
    const url = GLOBAL.endpoint + `/agente/${id}/anuladas`;
    return this.http.get(url);
  }


  logout() {
    
    
  }
}
