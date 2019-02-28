import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AutorizacionServiceService } from '../providers/autorizacion-service.service';

@Injectable({
  providedIn: 'root'
})
export class GuardPermisosGuard implements CanActivate {

  constructor(
    //parametros
    private autorizacionService: AutorizacionServiceService,
    private router: Router
  ) {
    console.trace('GuardPermisosGuard constructor');
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

    console.trace('GuardPermisosGuard canActivate');

    if ( this.autorizacionService.isLogged ){
      console.debug(' estamos autorizados');
      return true;

    }else{        
      console.warn(' NO estamos autorizados');
      this.router.navigate(['/login']);
      return false;
    }    

  }
}
