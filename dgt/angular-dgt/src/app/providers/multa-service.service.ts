import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Multa } from '../model/multa';
import { LoginServiceService } from './login-service.service';

@Injectable({
  providedIn: 'root'
})
export class MultaServiceService {

  constructor(private httpClient: HttpClient,
    private loginS : LoginServiceService) { }

  busquedaMatricula(matricula: string): Observable<any>{
        
    let uri = `http://192.168.0.12:8080/wsrest-endika/api/multa/matricula/${matricula}`;
    console.trace('LoginService loggin uri: ' + uri);
    return this.httpClient.get(uri);    
  }
  insertarMulta(multa:Multa){
    let uri = `http://192.168.0.12:8080/wsrest-endika/api/multa/`;
    console.trace('MultaService loggin uri: ' + uri);
    const req = this.httpClient.post(uri, {
      "agente": {
        "id": this.loginS.getAgente().id
    },
      "coche": {
        "matricula": multa.matricula
      },
      "concepto": multa.concepto,
      "importe": multa.importe
    })
      .subscribe(
        res => {
          console.debug(res);
        },
        err => {
          console.log("Error occured");
        }
      );
  }
  
  darBaja(id: number){
    let uri = `http://192.168.0.12:8080/wsrest-endika/api/multa/baja/`;
    console.trace('MultaService loggin uri: ' + uri);
    const req = this.httpClient.patch(uri, {
        "id": id
    })
      .subscribe(
        res => {
          console.debug(res);
        },
        err => {
          console.log("Error occured");
        }
      );
  }

  darAlta(id: number){
    let uri = `http://192.168.0.12:8080/wsrest-endika/api/multa/alta/`;
    console.trace('MultaService loggin uri: ' + uri);
    const req = this.httpClient.patch(uri, {
        "id": id
    })
      .subscribe(
        res => {
          console.debug(res);
        },
        err => {
          console.log("Error occured");
        }
      );
  }
 
}
