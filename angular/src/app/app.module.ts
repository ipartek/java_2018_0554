import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

// components
import { PruebaComponent } from './components/prueba/prueba.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { Error404Component } from './components/error404/error404.component';
import { PaginaDirectivaComponent } from './components/pagina-directiva/pagina-directiva.component';
import { PaginaComparadorComponent } from './components/pagina-comparador/pagina-comparador.component';
import { CardFrutaComponent } from './components/card-fruta/card-fruta.component';


// directives
import { Directiva1Directive } from './directives/directiva1.directive';
import { CountdownDirective } from './directives/countdown.directive';
import { FlujoComponent } from './components/flujo/flujo.component';
import { PaginaPipeComponent } from './components/pagina-pipe/pagina-pipe.component';

// pipes
import { MonedaPipe } from './pipes/moneda.pipe';
import { TrimarPipe } from './pipes/trimar.pipe';
import { PaginaArrayComponent } from './components/pagina-array/pagina-array.component';
import { FiltroOfertaPipe } from './pipes/filtro-oferta.pipe';
import { NavComponent } from './nav/nav.component';
import { TraductorComponent } from './components/traductor/traductor.component';
import { PaginaServiceComponent } from './components/pagina-service/pagina-service.component';
import { PaginaFrutasComponent } from './components/pagina-frutas/pagina-frutas.component';
import { PaginaPersonasComponent } from './components/pagina-personas/pagina-personas.component';
import { PaginaTodosComponent } from './components/pagina-todos/pagina-todos.component';
import { AlertComponent } from './components/alert/alert.component';
import { BackofficeComponent } from './components/backoffice/backoffice.component';


@NgModule({
  declarations: [
    AppComponent,
    PruebaComponent,
    HomeComponent,
    AboutComponent,
    Error404Component,
    PaginaDirectivaComponent,
    Directiva1Directive,
    CountdownDirective,
    FlujoComponent,
    PaginaPipeComponent,
    MonedaPipe,
    TrimarPipe,
    PaginaArrayComponent,
    FiltroOfertaPipe,
    PaginaComparadorComponent,
    CardFrutaComponent,
    NavComponent,
    TraductorComponent,
    PaginaServiceComponent,
    PaginaFrutasComponent,
    PaginaPersonasComponent,
    PaginaTodosComponent,
    AlertComponent,
    BackofficeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,  // para usarlo con los Services
    FormsModule,   // para poder usar doble binding
    ReactiveFormsModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
