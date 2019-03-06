import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { GLOBAL } from 'src/global';
import { Coche } from '../model/coche';
import { Agente } from '../model/agente';
import { Multa } from '../model/multa';

@Injectable({
  providedIn: 'root'
})
export class MultaService {

  private storage = window.sessionStorage;

  constructor(
    private http: HttpClient
  ) {
    console.log('MultaService constructor');

  }

  public saveCoche(coche: Coche) {
    this.storage.setItem('coche_A_Multar', JSON.stringify(coche));
  }

  public getCocheSession(): Coche {
    console.debug('coche_A_Multar: %o', this.storage.getItem('coche_A_Multar'));
    if (this.storage.getItem('coche_A_Multar')) {
      return JSON.parse(this.storage.getItem('coche_A_Multar'));
    } else {
      return undefined;
    }
  }

  public saveMulta(multa: Multa) {
    this.storage.setItem('multa_detalle', multa.toString() );
  }

  public getMultaSession(): Multa {
    console.debug('multa_detalle: %o', this.storage.getItem('multa_detalle'));
    if (this.storage.getItem('multa_detalle')) {
      return JSON.parse(this.storage.getItem('multa_detalle'));
    } else {
      return undefined;
    }
  }

  getCoche(matricula: string): Observable<any> {
    console.debug('matricula: %s', matricula);

    const url = GLOBAL.endpoint + `/vehiculo/${matricula}`;
    console.log(`MultaService login ${url}`);
    return this.http.get(url);
  } // getCoche

  getMulta(id: number): Observable<any> {
    console.debug('matricula: %s', id);

    const url = GLOBAL.endpoint + `/multa/${id}`;
    console.log(`MultaService login ${url}`);
    return this.http.get(url);
  } // getCoche

  postMulta(importe: string, concepto: string, agente: Agente, coche: Coche): Observable<any> {
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
        'Content-Type': 'application/json'
      })
    };

    return this.http.post(url, body, httpOptions);
  }

  patchMulta(idMulta: number, accion: string) {

    if (accion.localeCompare('baja') || accion.localeCompare('alta')) {
      let url = GLOBAL.endpoint + `/multa/${idMulta}/${accion}`;

      let body = {}

      return this.http.patch(url, body);
    }

  }
}
