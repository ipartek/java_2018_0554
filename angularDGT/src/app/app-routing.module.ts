import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './components/paginas/login/login.component';
import { IndexComponent } from './components/paginas/index/index.component';
import { PermisosGuard } from './guards/permisos.guard';
import { MultasComponent } from './components/paginas/multas/multas.component';
import { MultarMatriculaComponent } from './components/paginas/multar-matricula/multar-matricula.component';
import { MultarComponent } from './components/paginas/multar/multar.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'index', component: IndexComponent, canActivate: [PermisosGuard] },
  { path: 'multas', component: MultasComponent, canActivate: [PermisosGuard] },
  { path: 'multar-matricula', component: MultarMatriculaComponent, canActivate: [PermisosGuard] },
  { path: 'multar', component: MultarComponent, canActivate: [PermisosGuard] }, 
  { path: '**', pathMatch: 'full', redirectTo: 'login' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
