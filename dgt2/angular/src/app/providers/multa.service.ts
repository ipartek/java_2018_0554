import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GLOBAL } from 'src/global';
import { AgenteService } from './agente.service';
import { Coche } from '../model/coche';
import { Agente } from '../model/agente';

@Injectable({
  providedIn: 'root'
})
export class MultaService {
  private storage = window.sessionStorage;
  constructor(  public http: HttpClient,
    private agenteService: AgenteService ) {
    console.log('MultaService constructor');

   }

   public getCocheGuardado(): Coche {
    console.debug('cocheMulta: %o', this.storage.getItem('cocheMulta'));
    if(this.storage.getItem('cocheMulta')){
      return JSON.parse(this.storage.getItem('cocheMulta'));
    }else{
      return undefined;
    }
   }

   public guardarCoche( coche: Coche){
    this.storage.setItem('cocheMulta', JSON.stringify(coche));
  }

   getCoche(matricula: string): Observable < any > {
    console.debug('matricula: %s', matricula);

    const url = GLOBAL.endpoint + `/vehiculo/${matricula}`;
    console.log(`MultaService login ${url}`);
    return this.http.get(url);
  }

  multaPost(importe: string, concepto: string, agente: Agente, coche: Coche): Observable < any > {
    let url = GLOBAL.endpoint + `/agente/${agente.id}/multa`;
      console.log(`multaService multaPost ${url}`);

      let body = {  
                    "idAgente": agente.id,
                    "idCoche": coche.id,
                    "concepto": concepto,
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
