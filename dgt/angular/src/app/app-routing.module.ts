import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './paginas/home/home.component';
import { LoginComponent } from './paginas/login/login.component';
import { ListadoMultasComponent } from './paginas/listado-multas/listado-multas.component';
import { PermisosGuard } from './guards/permisos.guard';
import { Error404Component } from './components/error404/error404.component';

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
    path: 'home',
    component: HomeComponent,
    canActivate: [PermisosGuard],
    data: { title: 'Home' }
  },
  {
    path: 'listado-multas',
    component: ListadoMultasComponent,
    canActivate: [PermisosGuard],
    data: { title: 'Listado Multas' }
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
