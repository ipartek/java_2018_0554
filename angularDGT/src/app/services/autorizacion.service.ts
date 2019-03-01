import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AutorizacionService {

  /* Cuando recargas la pagina olvida el usuario 
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
  }*/

  //Cuando recargas la página sigue recordando el usuario, cuando cierras la pestaña ya no (sesion)
  private storage = window.sessionStorage;
  
  public isLogged(): boolean {    
    if ( this.storage.getItem('isLogged') === "true" ){
      return true;
    }else{
      return false;
    }
  }

  public setLogged(value: boolean) {
    console.debug('Hacemos setter de _isLogged y guardar en sessionStorage %o', this.storage);   
    this.storage.setItem('isLogged', 'true' ); 
  }

  public saveAgente( agente: any ){
    this.storage.setItem('agente',  JSON.stringify(agente)); 
  }

  public getAgente(): any{
    let agenteString = this.storage.getItem('agente');
    if( agenteString ){    
      return JSON.parse(agenteString);
    }else{
      return undefined;
    }  
  }

  constructor( private httpClient: HttpClient ) { 
    console.trace('AutorizacionService canActivate');
    
  }
  //FIN Cuando recargas pa página sigue recordando el usuario, cuando cierras la pestaña ya no (sesion)
  
  /**
   * metodo para llamar al servicio rest del backoffice
   * @param placa 
   * @param password 
   */
  loggin(placa: string, password: string): Observable<any>{
        
    let uri = `http://localhost:8080/wsrest/api/agente/login/${placa}/${password}`;
    console.trace('AutorizacionService loggin uri: ' + uri);
    return this.httpClient.get(uri);    
  }

  /**
   * Cierra la session del usuario llamando al backoffice
   */
  logout(){
    //(Parte del metodo 1)this._isLogged = false;
    //this.storage.clear();
    console.trace('logout service');
    this.storage.removeItem('isLogged');
  }

}