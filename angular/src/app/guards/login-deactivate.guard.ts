import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, RouterStateSnapshot, CanDeactivate } from '@angular/router';
import { Observable } from 'rxjs';
import { LoginComponent } from '../components/login/login.component';

@Injectable({
  providedIn: 'root'
})

export class CanDeactivateGuard implements CanDeactivate<LoginComponent> {
   
  canDeactivate(
    component: LoginComponent,
    currentRoute: ActivatedRouteSnapshot,
    currentState: RouterStateSnapshot,
    nextState: RouterStateSnapshot
  ): Observable<boolean>|boolean {

    console.trace('CanDeactivateGuard ');
    return component.puedoSalir();
  }
}
