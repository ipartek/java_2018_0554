import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';


import { JuegoClickComponent } from './juego-click/juego-click.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { Error404Component } from './components/error404/error404.component';
import { NombreComponent } from './components/nombre/nombre.component';
import { PaginaDirectivaComponent } from './components/pagina-directiva/pagina-directiva.component';
import { FlujoComponent } from './components/flujo/flujo.component';

const routes: Routes = [
  {
  path: 'home',
  component: HomeComponent,
  data: { title: 'home' }
  },
  { path: 'about/:repeticiones',
  component: AboutComponent,
  data: { title: 'about' }
  },
  { path: 'juego',
  component: JuegoClickComponent,
  data: { title: 'juego' }
  },
  { path: 'nombre/:nombre/:apellido',
  component: NombreComponent,
  data: { title: 'nombre' }
  },
  { path: 'directiva',
  component: PaginaDirectivaComponent,
  data: { title: 'directiva' }
  },
  { path: 'flujo',
  component: FlujoComponent,
  data: { title: 'flujo' }
  },
  { path: '404',
  component: Error404Component,
  data: { title: '404' }
  },
  { path: '**', pathMatch: 'full', redirectTo: '404' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
