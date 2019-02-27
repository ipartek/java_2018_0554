import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PaginaLoginComponent } from './components/pagina-login/pagina-login.component';
import { PrincipalComponent } from './components/principal/principal.component';
import { FormularioMatriculaComponent } from './components/formulario-matricula/formulario-matricula.component';
import { FormularioMultarComponent } from './components/formulario-multar/formulario-multar.component';
import { ListaMultasComponent } from './components/lista-multas/lista-multas.component';

// guards
import { PermisosGuard } from './guards/permisos.guard';

const routes: Routes = [

  { path: 'login', component: PaginaLoginComponent },
  { path: 'principal', component: PrincipalComponent, canActivate: [PermisosGuard] },
  { path: 'matricula', component: FormularioMatriculaComponent },
  { path: 'multar', component: FormularioMultarComponent },
  { path: 'vermultas', component: ListaMultasComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {

 }
