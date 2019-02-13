import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PruebaComponent } from './components/prueba/prueba.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent  },
  { path: 'about', component: AboutComponent  },
  { path: 'juego', component: PruebaComponent  },
  { path: '', redirectTo: 'home', pathMatch: 'full' },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
