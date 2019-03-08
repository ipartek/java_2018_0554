import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class AutorizacionService {

  private storage = window.sessionStorage;
  private isLogged: boolean;

  constructor() { 
    console.trace('AutorizacionService canActivate');
    this.isLogged = false;
  }


  /**
   * Nos dice si el usuario ha hecho login o no
   */
  estaLogeado(): boolean{
    return this.isLogged;
  }

  /**
   * metodo para llamar al servicio rest del backoffice
   * @param usuario 
   * @param password 
   */
  loggin(usuario: string, password: string): any{

      //TODO llamar Servicio Rest
      if ( usuario === 'admin' && password === 'admin'){
        this.isLogged = true;
      }else{
        this.isLogged = false;
      }
  }

   /**
   * Cierra la session del usuario llamando al backoffice
   */
  logout(){
    
    this.storage.clear();

    
  }

}
