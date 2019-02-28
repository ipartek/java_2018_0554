import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { AgenteService } from '../providers/agente.service';


@Injectable({
  providedIn: 'root'
})
export class PermisosGuard implements CanActivate {

  constructor(
    private agenteService: AgenteService,
    private router: Router
  ){
    console.trace('PermisosGuard constructor');
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
      console.trace('PermisosGuard canActivate');
      if(this.agenteService.isLogged){
        console.debug('Login correcto');
        return true;
      }else{
        console.warn('Login incorrecto');
        this.router.navigate(['login']);
        return false;
      }
      
  }
  
}
