import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
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
    console.trace('PermisosGuard constructor');
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
      console.trace('PermisosGuard canActivate');
      if(this.autorizacionService.isLogged){
        console.debug('Login correcto');
        return true;
      }else{
        console.warn('Login incorrecto');
        this.router.navigate(['login']);
        return false;
      }
      
  }
  
}
