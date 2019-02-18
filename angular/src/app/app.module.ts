import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

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
    CardFrutaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule   // para poder usar doble binding
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
