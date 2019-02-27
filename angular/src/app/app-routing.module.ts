import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { PruebaComponent } from './components/prueba/prueba.component';
import { Error404Component } from './components/error404/error404.component';
import { PaginaDirectivaComponent } from './components/pagina-directiva/pagina-directiva.component';
import { FlujoComponent } from './components/flujo/flujo.component';
import { PaginaPipeComponent } from './components/pagina-pipe/pagina-pipe.component';
import { PaginaArrayComponent } from './components/pagina-array/pagina-array.component';
import { PaginaComparadorComponent } from './components/pagina-comparador/pagina-comparador.component';
import { PaginaServiceComponent } from './components/pagina-service/pagina-service.component';
import { PaginaTodosComponent } from './components/pagina-todos/pagina-todos.component';
import { PaginaFrutasComponent } from './components/pagina-frutas/pagina-frutas.component';
import { PaginaPersonasComponent } from './components/pagina-personas/pagina-personas.component';
import { BackofficeComponent } from './components/backoffice/backoffice.component';

// guards
import { PermisosGuard } from './guards/permisos.guard';


const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'about/:repeticiones', component: AboutComponent },  
  { path: 'juego', component: PruebaComponent },  
  { path: '404', component: Error404Component }, 
  { path: 'flujo', component: FlujoComponent }, 
  { path: 'pipe', component: PaginaPipeComponent }, 
  { path: 'arrays', component: PaginaArrayComponent }, 
  { path: 'comparador', component: PaginaComparadorComponent }, 
  { path: 'directiva', component: PaginaDirectivaComponent },
  { path: 'service', component: PaginaServiceComponent }, 
  { path: 'pesonas', component: PaginaPersonasComponent }, 
  { path: 'frutas', component: PaginaFrutasComponent }, 
  { path: 'todos', component: PaginaTodosComponent }, 
  { path: 'backoffice', component: BackofficeComponent, canActivate: [PermisosGuard] }, 
  { path: '**', pathMatch:'full', redirectTo : '404'  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
