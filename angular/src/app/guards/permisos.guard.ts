import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AutorizacionService } from '../providers/autorizacion.service';

@Injectable({
  providedIn: 'root'
})
export class PermisosGuard implements CanActivate {

  constructor( private autorizacionService: AutorizacionService, private router: Router ){
    console.trace('GuardPermisosGuard constructor');
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
    console.trace('GuardPermisosGuard canActivate');

    if(this.autorizacionService.estaLogueado){
      console.debug('Estamos autorizados');
      return true;

    } else{
      console.warn('NO estamos autorizados');
      this.router.navigate(['/login']);
      return false;
    }
  }
  
}
