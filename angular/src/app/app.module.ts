import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PruebaComponent } from './components/prueba/prueba.component';
import { OtromasComponent } from './components/otromas/otromas.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { Error404Component } from './components/error404/error404.component';
import { SaludarComponent } from './components/saludar/saludar.component';
import { FlujoComponent } from './components/flujo/flujo.component';
import { PaginaPipeComponent } from './components/pagina-pipe/pagina-pipe.component';
import { ArrayComponent } from './components/array/array.component';
import { PaginaComparadorComponent } from './components/pagina-comparador/pagina-comparador.component';
import { FrutaCardComponent } from './components/fruta-card/fruta-card.component';
//directivas
import { PaginaDirectivaComponent } from './components/pagina-directiva/pagina-directiva.component';
import { Directiva1Directive } from './directives/directiva1.directive';
import { CountdownDirective } from './directives/countdown.directive';
//pipe
import { MonedaPipe } from './pipes/moneda.pipe';
import { TrimarPipe } from './pipes/trimar.pipe';
import { FiltroOfertaPipe } from './pipes/filtro-oferta.pipe';

@NgModule({
  declarations: [
    AppComponent,
    PruebaComponent,
    OtromasComponent,
    HomeComponent,
    AboutComponent,
    Error404Component,
    SaludarComponent,
    PaginaDirectivaComponent,
    Directiva1Directive,
    CountdownDirective,
    FlujoComponent,
    PaginaPipeComponent,
    MonedaPipe,
    TrimarPipe,
    ArrayComponent,
    FiltroOfertaPipe,
    PaginaComparadorComponent,
    FrutaCardComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule // para poder usar doble binding o banana in a box
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
