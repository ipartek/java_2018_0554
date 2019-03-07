import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PrincipalComponent } from './components/principal/principal.component';

//components
import { LoginComponent } from './components/login/login.component';
import { FrutaComponent } from './components/fruta/fruta.component';

// guards
import { PermisosGuard } from './guards/permisos.guard';
import { Error404Component } from './components/error404/error404.component';


const routes: Routes = [

  { path: '', component: LoginComponent },  // componente que carga primero
  { path: 'login', component: LoginComponent },
  { path: 'fruta', component: FrutaComponent },
  { path: 'principal', component: PrincipalComponent, canActivate: [PermisosGuard] },
  { path: '404', component: Error404Component },
  { path: '**', pathMatch:'full', redirectTo : '404'  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

 }