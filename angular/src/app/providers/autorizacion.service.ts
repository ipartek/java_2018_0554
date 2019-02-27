import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AutorizacionService {

  private isLogged: boolean;

  constructor() { 
    console.trace('AutorizacionService constructor');
    this.isLogged = false;
  }



  /**
   * Nos dice si el usuario ha hecho login o no
   * @returns <b>True</b> si ha hecho login, <b>False</b> si no.
   */
  estaLogueado(): boolean{
    return this.isLogged;
  }

  /**
   * Método para llamar al Servicio REST del Backoffice
   * @param usuario 
   * @param password 
   * @returns any. TODO return Agente
   */
  public login(usuario: string, password: string): any{
    //TODO llamar de verdad
    if(usuario === 'admin' && password === 'admin'){
      this.isLogged = true;
    }else{
      this.isLogged = false;
    }
  }

  /**
   * Cierra la sesión del usuario llamando al Backoffice
   */
  logout(){
    //TODO llamar Servicio REST
    this.isLogged = false;
  }

}
