import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {
  
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
  
  constructor(private httpClient: HttpClient) {
    console.trace('AutorizacionService canActivate');

  }

  /**
   * metodo para llamar al servicio rest de DGT
   * @param placa 
   * @param password 
   */
  loggin(placa: number, password: string): Observable<any>{
        
    let uri = `http://localhost:8080/wsrest/api/agente/login/${placa}/${password}`;
    console.trace('LoginService loggin uri: ' + uri);
    return this.httpClient.get(uri);    
  }
}
