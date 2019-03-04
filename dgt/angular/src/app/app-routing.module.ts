import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PrincipalComponent } from './components/principal/principal.component';
import { LoginComponent } from './components/login/login.component';
import { PaginaMultasComponent } from './components/pagina-multas/pagina-multas.component';
import { PermisosGuard } from './guards/permisos.guard';
import { Error404Component } from './components/error404/error404.component';
import { MatriculaComponent } from './components/matricula/matricula.component';
import { DatosMultaComponent } from './components/datos-multa/datos-multa.component';

const routes: Routes = [
  {
    path: '',
    component: LoginComponent,
    data: { title: 'login' }
  },
  {
    path: 'login',
    component: LoginComponent,
    data: { title: 'login' }
  },
  {
    path: 'principal',
    component: PrincipalComponent,
    canActivate: [PermisosGuard],
    data: { title: 'Principal' }
  },
  {
    path: 'multar',
    component: MatriculaComponent,
    canActivate: [PermisosGuard],
    data: { title: 'Buscar por Matrícula' }
  },
  {
    path: 'datos-multa:coche',
    component: DatosMultaComponent,
    canActivate: [PermisosGuard],
    data: { title: 'Datos Multa' }
  },
  {
    path: 'pagina-multas',
    component: PaginaMultasComponent,
    canActivate: [PermisosGuard],
    data: { title: 'Pagina Multas' }
  },
  {
    path: '404',
    component: Error404Component,
    data: { title: 'Error 404' }
  },
  { path: '**', pathMatch:'full', redirectTo : '/404'  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
