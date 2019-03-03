import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class MultaService {

  private storage = window.sessionStorage;
  

  constructor(private httpClient: HttpClient) {
    console.trace('MultaService constructor');
   }

  listarMultas(id: number): Observable<any>{
    let uri = `http://localhost:8080/wsrest/api/agente/${id}/multas`;

      console.trace('MultaService listarMultas uri: '+ uri);

      return this.httpClient.get(uri);

  }

  buscarMatricula(matricula: string): Observable<any>{
    let uri = `http://localhost:8080/wsrest/api/agente/${matricula}`;

    console.trace('MultaService buscarMatricula uri: '+ uri);

    return this.httpClient.get(uri);
  }

  public saveVehiculo( vehiculo: any ){
    this.storage.setItem('vehiculo',  JSON.stringify(vehiculo)); 
  }

  public getVehiculo(): any{

    let vehiculoString = this.storage.getItem('vehiculo');
    if( vehiculoString ){    
      return JSON.parse(vehiculoString);
    }else{
      return undefined;
    }  

  }

  public listarMultasAnuladas( id: number ): Observable<any> {
    let uri = `http://localhost:8080/wsrest/api/agente/${id}/multas`;

      console.trace('MultaService listarMultasAnuladas uri: '+ uri);

    return this.httpClient.get(uri);
  }

}
