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
  { path: '**', pathMatch:'full', redirectTo : '404'  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
