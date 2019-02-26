import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavComponent } from './nav/nav.component';
import { PaginaLoginComponent } from './components/pagina-login/pagina-login.component';
import { PrincipalComponent } from './components/principal/principal.component';
import { FormularioMatriculaComponent } from './components/formulario-matricula/formulario-matricula.component';
import { FormularioMultarComponent } from './components/formulario-multar/formulario-multar.component';
import { ListaMultasComponent } from './components/lista-multas/lista-multas.component';

@NgModule({
  declarations: [
    AppComponent,
    NavComponent,
    PaginaLoginComponent,
    PrincipalComponent,
    FormularioMatriculaComponent,
    FormularioMultarComponent,
    ListaMultasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
