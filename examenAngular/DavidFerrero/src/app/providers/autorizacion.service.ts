import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AutorizacionService {

  private storage = window.sessionStorage;
  private isLogged: boolean;



  constructor( private httpClient: HttpClient ) { 
    console.trace('AutorizacionService canActivate');    
  }

  /**	    console.trace('AutorizacionService canActivate');
   * Nos dice si el usuario ha hecho login o no	    this._isLogged = false;
   */	
estaLogeado(): boolean{	
    return this.isLogged;	
  }

/**	
	* metodo para llamar al servicio rest del backoffice
	* @param placa 
	* @param password 
	*/
	loggin(placa: string, password: string): any{
	

    //TODO llamar Servicio Rest
    if ( placa === '123456' && password === '123456'){
      this.isLogged = true;
    }else{
      this.isLogged = false;
      }
    }
    
  
    /**
    * Cierra la session del usuario llamando al backoffice
    */
    logout(){
    //TODO llamar Servicio Rest
    this.isLogged = false;
    }
    

/*

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



  /**
   * metodo para llamar al servicio rest del backoffice
   * @param usuario 
   * @param password 
   */
  /*
   loggin(usuario: string, password: string): Observable<any>{
        
    let uri = `http://localhost:8080/wsrest/api/agente/login/${usuario}/${password}`;
    console.trace('AutorizacionService loggin uri: ' + uri);
    return this.httpClient.get(uri);    
  }

 
  logout(){
  this.storage.clear()
  };
*/




}