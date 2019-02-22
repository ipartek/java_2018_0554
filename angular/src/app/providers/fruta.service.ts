import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Fruta } from '../model/fruta';


//Definimos la cabecera de la peticion, diciendo que mandamos un json
const HTTP_OPTIONS = {
  headers: new HttpHeaders(
    { 'Content-Type': 'application/json' }
  )
};

@Injectable({
  providedIn: 'root'
})
export class FrutaService {
  //se guarda en services/provider

  endpoint = 'http://localhost:3000/frutas/';

  constructor(private http: HttpClient) {
    console.trace('FrutaService constructor');
  }

  public getAll(): Observable<any> {
    console.trace('getAll ' + this.endpoint);
    return this.http.get(this.endpoint);
  }

  public getById(id: number): Observable<any> {
    let url = this.endpoint + id
    console.trace('getById ' + url);
    return this.http.get(url);
  }

  /**
   * metodo que elimina una fruta de la bd
   * @param id el id de la fruta a eliminar
   */
  delete(id: number) {
    let url = this.endpoint + id;
    console.trace('delete ' + url);
    return this.http.delete(url);
  }

  post(fruta: Fruta): Observable<any> {
    let url = this.endpoint;
    console.trace('post ' + url);

    //Se define el cuerpo de la fruta que se va a crear para enviarla mediante post
    let body = {
      "id": fruta.id,
      "nombre": fruta.nombre,
      "oferta": fruta.oferta,
      "precio": fruta.precio,
      "descuento": fruta.descuento,
      "imagen": fruta.imagen
    }
    return this.http.post(url,body,HTTP_OPTIONS);
  }

  /**
   * Metodo que sirve para actualizar el nombre de la fruta
   * @param fruta fruta a modificar
   */
  patch(fruta: Fruta): Observable<any> {
    let url = this.endpoint + fruta.id;
    console.trace('put ' + url);

    //Se define el cuerpo de la fruta que se va a modificar para enviarla mediante put
    let body = {
      "id": fruta.id,
      "nombre": fruta.nombre,
      "oferta": fruta.oferta,
      "precio": fruta.precio,
      "descuento": fruta.descuento,
      "imagen": fruta.imagen
    }

    return this.http.put(url,body,HTTP_OPTIONS);
  }
}
