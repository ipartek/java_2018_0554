import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { PruebaComponent } from './components/prueba/prueba.component';
import { Error404Component } from './components/error404/error404.component';
import { PaginaDirectivaComponent } from './components/pagina-directiva/pagina-directiva.component';
import { FlujoComponent } from './components/flujo/flujo.component';
import { PaginaPipeComponent } from './components/pagina-pipe/pagina-pipe.component';
import { ArrayComponent } from './components/array/array.component';
import { PaginaComparadorComponent } from './components/pagina-comparador/pagina-comparador.component';
import { PaginaConcesionarioComponent } from './components/pagina-concesionario/pagina-concesionario.component';
import { TraductorComponent } from './components/traductor/traductor.component';
import { PaginaServiceComponent } from './components/pagina-service/pagina-service.component';
import { PaginaPersonasComponent } from './components/pagina-personas/pagina-personas.component';
import { PaginaFrutasComponent } from './components/pagina-frutas/pagina-frutas.component';
import { PaginaTodosComponent } from './components/pagina-todos/pagina-todos.component';


const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'about/:repeticiones', component: AboutComponent },  
  { path: 'juego', component: PruebaComponent },  
  { path: '404', component: Error404Component }, 
  { path: 'directiva', component: PaginaDirectivaComponent },
  { path: 'flujo', component: FlujoComponent },
  { path: 'pipe', component: PaginaPipeComponent },
  {path: 'array', component: ArrayComponent},
  {path: 'comparador', component: PaginaComparadorComponent},
  {path: 'concesionario', component: PaginaConcesionarioComponent},
  {path: 'traductor', component: TraductorComponent},
  { path: 'service', component: PaginaServiceComponent }, 
  { path: 'personas', component: PaginaPersonasComponent },
  { path: 'frutas', component: PaginaFrutasComponent }, 
  { path: 'todos', component: PaginaTodosComponent },
  { path: '**', pathMatch:'full', redirectTo : '404'  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
