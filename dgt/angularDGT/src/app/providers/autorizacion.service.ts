import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AutorizacionService {

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

 
  logout(){
  this.storage.clear()
  };


}