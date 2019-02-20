import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { ParametroComponent } from './components/parametro/parametro.component';
import { JuegoComponent } from './components/juego/juego.component';
import { Error404Component } from './components/error404/error404.component';
import { SaludoComponent } from './components/saludo/saludo.component';
import { PaginaDirectivaComponent } from './components/pagina-directiva/pagina-directiva.component';
import { FlujoComponent } from './components/flujo/flujo.component';
import { PaginaPipeComponent } from './components/pagina-pipe/pagina-pipe.component';
import { AboutComponent } from './components/about/about.component';
import { PaginaArrayComponent } from './components/pagina-array/pagina-array.component';
import { PaginaComparadorComponent } from './components/pagina-comparador/pagina-comparador.component';
import { PaginaConcesionarioComponent } from './components/pagina-concesionario/pagina-concesionario.component';
import { PaginaServiceComponent } from './components/pagina-comparador/pagina-service/pagina-service.component';
import { TiendaComponent } from './components/pagina-comparador/tienda/tienda.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'parametro/:repeticiones', component: ParametroComponent },
  { path: 'juego', component: JuegoComponent },
  { path: 'saludo/:nombre/:apellido', component: SaludoComponent },
  { path: 'error404', component: Error404Component },
  { path: 'pagina-directiva', component: PaginaDirectivaComponent },
  { path: 'flujo', component: FlujoComponent },
  { path: 'pagina-pipe', component: PaginaPipeComponent },
  { path: 'about', component: AboutComponent },
  { path: 'pagina-array', component: PaginaArrayComponent },
  { path: 'pagina-comparador', component: PaginaComparadorComponent },
  { path: 'pagina-concesionario', component: PaginaConcesionarioComponent },
  { path: 'pagina-service', component: PaginaServiceComponent },
  { path: 'tienda', component: TiendaComponent },
  { path: '**', pathMatch: 'full', redirectTo: 'error404' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
