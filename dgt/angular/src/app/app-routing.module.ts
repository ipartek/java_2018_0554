import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './paginas/home/home.component';
import { LoginComponent } from './paginas/login/login.component';
import { ListadoMultasComponent } from './paginas/listado-multas/listado-multas.component';
import { PermisosGuard } from './guards/permisos.guard';

const routes: Routes = [
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
    data: { title: 'Listado-multas' }
  },
  { path: '**', pathMatch:'full', redirectTo : 'login'  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
