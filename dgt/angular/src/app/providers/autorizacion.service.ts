import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AutorizacionService {

  private isLogged: boolean;

  constructor() {
    console.trace('AutorizacionService constructor');
    this.isLogged = false;
  } // Constructor

  /**
   * Nos indica si el usuario ha hecho login o no
   * @returns True si ha hecho login, False si no
   */
  estaLogueado() {
    console.trace('AutorizacionService estaLogueado()');
    return this.isLogged;
  } //estaLogueado

  /**
   * Llama a la API REST y comprueba que el usuario y la contraseña existan en la DB
   * @param placa Nº de placa del Agente
   * @param pass Contraseña del Agente
   */
  login(placa: string, pass: string): any {
    if (placa === 'admin' && pass === 'admin') {
      this.isLogged = true;
    } else {
      this.isLogged = false;
    }
  } // Login

  /**
  * Cierra la session del usuario llamando al backoffice
  */
  logout() {
    //TODO llamar Servicio Rest
    this.isLogged = false;
  }
}
