import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { AutorizacionService } from './autorizacion.service';
import { Coche } from '../model/coche';

@Injectable({
  providedIn: 'root'
})
export class MultasService {

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

  public saveCoche( coche: any ){
    this.storage.setItem('coche',  JSON.stringify(coche)); 
  }

  public getCoche(): any{
    let cocheString = this.storage.getItem('coche');
    if( cocheString ){    
      return JSON.parse(cocheString);
    }else{
      return undefined;
    }  
  }
  constructor(
    private httpClient: HttpClient ) { }
  /*
    public getCocheSession(): Coche {
      console.debug('coche_A_Multar: %o', this.storage.getItem('coche_A_Multar'));
      if(this.storage.getItem('coche_A_Multar')){
        return JSON.parse(this.storage.getItem('coche_A_Multar'));
      }else{
        return undefined;
      }
     }
  */
    listarMultas(id: number): Observable<any>{
      let uri = `http://localhost:8080/wsrest/api/agente/${id}/multas`;
  
        console.trace('MultaService listarMultas uri: '+ uri);
  
        return this.httpClient.get(uri);
  
    }
  
    listarMultasAnuladas(id: number): Observable<any>{
      let uri = `http://localhost:8080/wsrest/api/agente/${id}/multasbaja`;
  
        console.trace('MultaService listarMultasAnuladas uri: '+ uri);
  
        return this.httpClient.get(uri);
  
    }
  

  
  /**
   * metodo para llamar al servicio rest del backoffice
   * @param placa 
   * @param password 
   */
  existeMatricul(matricula: string): Observable<any>{
    let uri = `http://localhost:8080/wsrest/api/agente/${matricula}`;
    console.trace('AutorizacionService loggin uri: ' + uri);
    return this.httpClient.get(uri);    
  }

/*
    existeMatricula(matricula: string): Observable<any>{
      let uri = `http://localhost:8080/wsrest/api/agente/${matricula}`;
  
      console.trace('MultaService existeMatricula uri: '+ uri);
  
      return this.httpClient.get(uri);
    }
  
    public saveCoche( coche: any ){
      this.storage.setItem('coche',  JSON.stringify(coche)); 
    }
  
    public getCoche(): any{
  
      let cocheString = this.storage.getItem('coche');
      if( cocheString ){    
        return JSON.parse(cocheString);
      }else{
        return undefined;
      }  
  
    }
  */
    public multar (importe: string, concepto: string, agente: AutorizacionService, coche: Coche): Observable<any> {
      let url = `http://localhost:8080/wsrest/api/multa/`;
      console.trace('MultaService multar uri:  '+ url);
      
      let body = {
        "importe": importe,
       "concepto": concepto,
        "idAgente": agente.getAgente().id,
        "idCoche": coche.id,
          
      };
      return this.httpClient.post(url, body);
    } 
  
}