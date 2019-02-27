import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PermisosGuard implements CanActivate {

  constructor(private router: Router){
    console.trace('GuardPermisosGuard constructor');
  }

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

    console.trace('GuardPermisosGuard canActivate');

    // TODO llamar serviceAutorizacion

    // redirigir a Home
    this.router.navigate(['/home']);

    return false;

  }
}
