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

   public saveCoche( coche: Vehiculo){
    this.storage.setItem('coche_A_Multar', JSON.stringify(coche));
  }

  public getCocheSession(): Vehiculo {
    console.debug('coche_A_Multar: %o', this.storage.getItem('coche_A_Multar'));
    if(this.storage.getItem('coche_A_Multar')){
      return JSON.parse(this.storage.getItem('coche_A_Multar'));
    }else{
      return undefined;
    }
   }

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

  

  public multar (importe: string, concepto: string, agente: AutorizacionService, coche: Vehiculo): Observable<any> {
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
