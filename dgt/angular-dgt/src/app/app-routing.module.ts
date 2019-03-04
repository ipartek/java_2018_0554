import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

//COMPONENTES
import { LoginComponent } from './components/login/login.component';
import { MenuPpalComponent } from './components/menu-ppal/menu-ppal.component';
import { LoginGuGuard } from './guards/login-gu.guard';
import { ListarMultasComponent } from './components/listar-multas/listar-multas.component';
import { MandarMatriculaComponent } from './components/mandar-matricula/mandar-matricula.component';
import { CrearMultaComponent } from './components/crear-multa/crear-multa.component';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'login', component: LoginComponent},
  {path: 'menu-ppal', component: MenuPpalComponent, canActivate: [LoginGuGuard]},
  {path: 'listar-multas', component: ListarMultasComponent, canActivate: [LoginGuGuard]},
  {path: 'mandarMatricula', component: MandarMatriculaComponent, canActivate: [LoginGuGuard]},
  {path: 'crearMulta', component: CrearMultaComponent, canActivate: [LoginGuGuard]}
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
