import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PruebaComponent } from './components/prueba/prueba.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { Error404Component } from './components/error404/error404.component';
import { SaludarComponent } from './components/saludar/saludar.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent  },
  { path: 'about/:repeticiones', component: AboutComponent  },
  { path: 'juego', component: PruebaComponent  },
  { path: '404', component: Error404Component }, 
  { path: 'saludar/:nombre', component: SaludarComponent }, 
  { path: '**', pathMatch:'full', redirectTo : '404'  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }







