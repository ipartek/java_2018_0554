import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginServiceService } from '../providers/login-service.service';

@Injectable({
  providedIn: 'root'
})
export class LoginGuGuard implements CanActivate {

  constructor(private router: Router,
    private loginS: LoginServiceService){
      console.trace('LoginGuGuard constructor');

  }
  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

    console.trace('LoginGuGuard canActivate');

    if ( this.loginS.isLogged ){
      console.debug(' estamos autorizados');
      console.debug('El agente en sessionStorage %o' , this.loginS.getAgente() );
      return true;

    }else{        
      console.warn(' NO estamos autorizados');
      this.router.navigate(['/login']);
      return false;
    }    

}

  
  
}
