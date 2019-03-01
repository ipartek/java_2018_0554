import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AutorizacionService {

  //private _isLogged: boolean;
  private storage = window.sessionStorage;

  
  public get isLogged(): boolean {
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


  constructor(private httpClient: HttpClient) { 
    console.trace('AutorizacionService canActivate');
    
  }


  /**
   * Nos dice si el usuario ha hecho login o no
   */
  estaLogeado(): boolean{
    return this.isLogged;
  }

  /**
   * metodo para llamar al servicio rest del backoffice
   * @param placa 
   * @param password 
   */
  loggin(placa: string, password: string): Observable<any>{

    console.trace('AutorizacionService loggin');
     /* if ( placa === '123456' && password === '123456'){
        this.isLogged = true;
      }else{
        this.isLogged = false;
      }*/


      // llamar Servicio Rest
      let uri = `http://localhost:8080/wsrest/api/agente/login/${placa}/${password}`;
      console.trace('AutorizacionService loggin uri: '+ uri);

      return this.httpClient.get(uri);

  }

  

  /**
   * Cierra la session del usuario llamando al backoffice
   */
  logout(){
    
    this.storage.clear();

    
  }


}