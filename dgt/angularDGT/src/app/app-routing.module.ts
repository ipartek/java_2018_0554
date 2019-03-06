import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PaginaLoginComponent } from './components/pagina-login/pagina-login.component';
import { PrincipalComponent } from './components/principal/principal.component';
import { FormularioMatriculaComponent } from './components/formulario-matricula/formulario-matricula.component';
import { FormularioMultarComponent } from './components/formulario-multar/formulario-multar.component';
import { ListaMultasComponent } from './components/lista-multas/lista-multas.component';
import { Error404Component } from './components/error404/error404.component';

// guards
import { PermisosGuard } from './guards/permisos.guard';
import { EstadisticasComponent } from './components/estadisticas/estadisticas.component';

const routes: Routes = [
  { path: '', component: PaginaLoginComponent },
  { path: 'login', component: PaginaLoginComponent },
  { path: 'principal', component: PrincipalComponent, canActivate: [PermisosGuard] },
  { path: 'matricula', component: FormularioMatriculaComponent },
  { path: 'multar', component: FormularioMultarComponent },
  { path: 'vermultas', component: ListaMultasComponent },
  { path: 'estadisticas', component: EstadisticasComponent },
  { path: '404', component: Error404Component },
  { path: '**', pathMatch:'full', redirectTo : '404'  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

 }
