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

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'parametro/:repeticiones', component: ParametroComponent },
  { path: 'juego', component: JuegoComponent },
  { path: 'saludo/:nombre/:apellido', component: SaludoComponent },
  { path: 'error404', component: Error404Component },
  { path: 'pagina-directiva', component: PaginaDirectivaComponent },
  { path: 'flujo', component: FlujoComponent },
  { path: 'pagina-pipe', component: PaginaPipeComponent },
  { path: '**', pathMatch: 'full', redirectTo: 'error404' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
