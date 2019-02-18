import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

//nuestros componentes
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { PruebaComponent } from './components/prueba/prueba.component';
import { Error404Component } from './components/error404/error404.component';
import { SaludarComponent } from './components/saludar/saludar.component';
import { PaginaDirectivaComponent } from './components/pagina-directiva/pagina-directiva.component';
import { FlujoComponent } from './components/flujo/flujo.component';
import { PaginaPipeComponent } from './components/pagina-pipe/pagina-pipe.component';
import { ArrayComponent } from './components/array/array.component';
import { PaginaComparadorComponent } from './components/pagina-comparador/pagina-comparador.component';
import { PaginaComparadorCocheComponent } from './components/pagina-comparador-coche/pagina-comparador-coche.component';

const routes: Routes = [
  {path:'home',component:HomeComponent},
  {path:'game',component:PruebaComponent},
  {path:'about/:repeticiones',component:AboutComponent},
  {path:'saludar/:nombre/:apellido',component:SaludarComponent},
  {path:'directiva',component:PaginaDirectivaComponent},
  {path:'pipe',component:PaginaPipeComponent},
  {path:'array',component:ArrayComponent},
  {path:'comparador',component:PaginaComparadorComponent},
  {path:'coche',component:PaginaComparadorCocheComponent},
  {path:'flujo',component:FlujoComponent},
  {path:'404',component:Error404Component},
  {path:'**',pathMatch:'full',redirectTo:'404'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
