import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GLOBAL } from 'src/global';
import { Multa } from '../model/multa';

@Injectable({
  providedIn: 'root'
})
export class MultaService {
  http: any;
  agenteService: any;
  private storage = window.sessionStorage;

  constructor(private httpClient: HttpClient) {
    console.trace('MultaService constructor');
   }

   buscarMatricula(matricula: string): Observable<any>{
    let uri = `http://localhost:8080/wsrest/api/agente/${matricula}`;

    console.trace('MultaService buscarMatricula uri: '+ uri);

    return this.httpClient.get(uri);
  }

  public guardarCoche( coche: any ){
    this.storage.setItem('coche',  JSON.stringify(coche)); 
  }

 public getCoche(): any {
    

    let cocheString = this.storage.getItem('coche');
    if( cocheString ){    
      return JSON.parse(cocheString);
    }else{
      return undefined;
    }  
  }


  public multar (multa: Multa): Observable<any> {
    let url = `http://localhost:8080/wsrest/api/multa/`;
    console.trace('MultaService multar uri:  '+ url);

    let body = {
      "importe": multa.importe,
      "concepto": multa.concepto,
      "idCoche": this.getCoche().id,
      "idAgente": this.agenteService.getAgente().id     
    };
    return this.httpClient.post(url, body);
  } 

 


  
}
