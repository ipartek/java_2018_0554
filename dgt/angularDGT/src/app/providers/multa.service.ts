import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Multa } from '../model/multa';
import { Vehiculo } from '../model/vehiculo';
import { AutorizacionService } from './autorizacion.service';

@Injectable({
  providedIn: 'root'
})
export class MultaService {

  private storage = window.sessionStorage;
  

  constructor(private httpClient: HttpClient, private autorizacionService: AutorizacionService) {
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

  public multar (multa: Multa): Observable<any> {
    let url = `http://localhost:8080/wsrest/api/multa/`;
    console.trace('MultaService multar uri:  '+ url);
    
    let body = {
      "importe": multa.importe,
      "concepto": multa.concepto,
      "id_coche": this.getVehiculo().id,
      "id_agente": this.autorizacionService.getAgente().id     
    };
    return this.httpClient.post(url, body);
  } 

}
