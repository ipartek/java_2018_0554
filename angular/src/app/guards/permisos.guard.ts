import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AutorizacionService } from '../providers/autorizacion.service';

@Injectable({
  providedIn: 'root'
})
export class PermisosGuard implements CanActivate {

  constructor(
    private autorizacionService: AutorizacionService,
    private router: Router
  ){
    console.trace('GuardPermisosGuard constructor');
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

    console.trace('GuardPermisosGuard canActivate');

    if ( this.autorizacionService.estaLogeado() ){
      console.debug(' estamos autorizados');
      return true;

    }else{        
      console.warn(' NO estamos autorizados');
      this.router.navigate(['/login']);
      return false;
    }    

  }
}
