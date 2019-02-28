import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AutorizacionServiceService {
private isLogged: boolean;
  constructor() {


    this.isLogged=false;
   }


/**
 * 
 * nos dice si el usuario ha hecho login o no
 * 
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
//TODO: lamar de verdad

//hardcodeo
 if(usuario === 'admin' && password==='admin'){
this.isLogged=true;
//y se le pasara la llamada para que se suscriba
 }else{
   this.isLogged=false;
 }
 }

 /**
  * Cierra la sesion del usuario llamando al backoffice
  */
logout(){


  //TODO: llamar al servicio rest
  this.isLogged=false;
}

}



  
