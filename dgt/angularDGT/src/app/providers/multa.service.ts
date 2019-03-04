import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Multa } from '../model/multa';
import { AutorizacionService } from './autorizacion.service';


@Injectable({
  providedIn: 'root'
})

export class MultaService {
  
  // variable y getter and setter para comprobar si encuentra la matricula
  private _matriculaEncontrada: boolean;
  
  public get matriculaEncontrada(): boolean {
    return this._matriculaEncontrada;
  }
  public set matriculaEncontrada(value: boolean) {
    this._matriculaEncontrada = value;
  }
  
  // REcuperar parametros de la sesion
  private storage = window.sessionStorage;
  

  // no lo se
  post(multas: import("../model/multa").Multa): any {
    throw new Error("Method not implemented.");
  }

  //ENDPOINT
  endpoint = 'http://localhost:8080/wsrest/api/agente/';
 
// METODO CONSTRUCTOR CON HTTPCLIENT COMO PARAMETRO
  constructor( private httpClient: HttpClient, private autorizacionService: AutorizacionService) { 
    console.trace('MultaService constructor');
    this._matriculaEncontrada = false;
  }

  //METODO PARA LISTADO MULTAS
   getMultas(id:number):Observable<any>{
    
    let uri = this.endpoint + id + '/multas';
    console.trace('multa service getAllByUser multas' + uri );
    return this.httpClient.get( uri );
  }
    //METODO PARA LISTADO MULTAS Anuladas
    getMultasAnuladas(id:number):Observable<any>{
    
      let uri = this.endpoint + id + '/multasAnuladas';
      console.trace('multa service getAllByUser multas' + uri );
      return this.httpClient.get( uri );
    }
  
  //METODO PARA ENCONTRAR MATRICULA
  buscarMatricula(matricula:string):Observable<any>{
    
    let uri = this.endpoint + matricula ;
    console.trace('multa service getByMatricula matricula' + uri );
    return this.httpClient.get( uri );
  }


  // para MODIFICAR  datos SET
  public saveVehiculo( vehiculo: any ){
    this.storage.setItem('vehiculo',  JSON.stringify(vehiculo)); 
  }

  // para OBTENER datos vehiculo  GET
  public getVehiculo(): any{

    let vehiculoString = this.storage.getItem('vehiculo');
    if( vehiculoString ){    
      return JSON.parse(vehiculoString);
    }else{
      return undefined;
    }  
  }  

  public multar (multa: Multa): Observable<any> {
    let url = "http://localhost:8080/wsrest//api/vehiculo/multas";
    console.trace('MultaService multar uri:  '+ url);
    
    let body = {
      "importe": multa.importe,
      "concepto": multa.concepto,ç
      "idVehiculo": this.getVehiculo().id,
      "idAgente": this.autorizacionService.getAgente().id     
    };
    return this.httpClient.post(url, body);
  } 
}
