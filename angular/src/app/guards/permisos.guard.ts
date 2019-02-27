import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PermisosGuard implements CanActivate {

  constructor( private router: Router ){
    console.trace('GuardPermisosGuard constructor');
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    
    console.trace('GuardPermisosGuard canActivate');

    //TODO llamar serviceLogin

    //Redirigir a home
    this.router.navigate(['/home']);

    return false;
  }
  
}
