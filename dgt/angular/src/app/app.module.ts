import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { NavComponent } from './components/nav/nav.component';
import { PrincipalComponent } from './components/principal/principal.component';
import { MonedaPipe } from './pipes/moneda.pipe';
import { PaginaMultasComponent } from './components/pagina-multas/pagina-multas.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AlertComponent } from './components/alert/alert.component';
import { Error404Component } from './components/error404/error404.component';
import { MatriculaComponent } from './components/matricula/matricula.component';
import { RedactarMultaComponent } from './components/redactar-multa/redactar-multa.component';
import { EstadisticasComponent } from './components/estadisticas/estadisticas.component';
import { AnularMultaComponent } from './components/anular-multa/anular-multa.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavComponent,
    PrincipalComponent,
    MonedaPipe,
    PaginaMultasComponent,
    AlertComponent,
    Error404Component,
    MatriculaComponent,
    RedactarMultaComponent,
    EstadisticasComponent,
    AnularMultaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
