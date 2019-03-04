import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GLOBAL } from 'src/global';
import { Coche } from '../model/coche';
import { AgenteService } from './agente.service';
import { Agente } from '../model/agente';

@Injectable({
  providedIn: 'root'
})
export class MultaService {

  private storage = window.sessionStorage;

  constructor( 
    public http: HttpClient,
    private agenteService: AgenteService
    ) {
    console.log('MultaService constructor');

   }

   public saveCoche( coche: Coche){
    this.storage.setItem('coche_A_Multar', JSON.stringify(coche));
  }

  public getCocheSession(): Coche {
    console.debug('coche_A_Multar: %o', this.storage.getItem('coche_A_Multar'));
    if(this.storage.getItem('coche_A_Multar')){
      return JSON.parse(this.storage.getItem('coche_A_Multar'));
    }else{
      return undefined;
    }
   }

   getCoche(matricula: string): Observable < any > {
    console.debug('matricula: %s', matricula);

    const url = GLOBAL.endpoint + `/vehiculo/${matricula}`;
    console.log(`MultaService login ${url}`);
    return this.http.get(url);
  } // getCoche

  postMulta(importe: string, concepto: string, agente: Agente, coche: Coche): Observable < any > {
    let url = GLOBAL.endpoint + `/agente/${agente.id}/multa`;
      console.log(`multaService postMulta ${url}`);

      let body = {
                    "concepto": concepto,
                    "idAgente": agente.id,
                    "idCoche": coche.id,
                    "importe": importe
                } 
                
      const httpOptions = {
        headers: new HttpHeaders({
          'Content-Type':  'application/json'
        })
      };

      return this.http.post( url, body , httpOptions );
  }
}
