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
    let uri = `http://192.168.0.12:8080/wsrest-xabi/api/agente/${id}/multas`;

      console.trace('MultaService listarMultas uri: '+ uri);

      return this.httpClient.get(uri);

  }

  listarMultasAnuladas(id: number): Observable<any>{
    let uri = `http://192.168.0.12:8080/wsrest-xabi/api/agente/${id}/multasbaja`;

      console.trace('MultaService listarMultasAnuladas uri: '+ uri);

      return this.httpClient.get(uri);

  }

  buscarMatricula(matricula: string): Observable<any>{
    let uri = `http://192.168.0.12:8080/wsrest-xabi/api/agente/${matricula}`;

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

  

  public multar (multa: Multa): Observable<any> {
    let url = `http://192.168.0.12:8080/wsrest-xabi/api/multa/`;
    console.trace('MultaService multar uri:  '+ url);
    
    let body = {
      "importe": multa.importe,
     "concepto": multa.concepto,
      "id_agente": this.autorizacionService.getAgente().id,
      "id_coche": this.getVehiculo().id,
        
    };
    return this.httpClient.post(url, body);
  } 


  public anularMulta(idMulta: number): Observable<any> {    
    let url = `http://192.168.0.12:8080/wsrest-xabi/api/multa/anular/${idMulta}`;
    console.trace('MultaService anularMulta uri:  '+ url);

    let body = {
      
    };

    console.debug('modificar url: %s body: %o', url, body);
    return this.httpClient.patch(url, body);
  }


  public desAnularMulta(idMulta: number): Observable<any> {    
    let url = `http://192.168.0.12:8080/wsrest-xabi/api/multa/desanular/${idMulta}`;
    console.trace('MultaService desAnularMulta uri:  '+ url);

    let body = {
      
    };

    console.debug('modificar url: %s body: %o', url, body);
    return this.httpClient.patch(url, body);
  }

}
