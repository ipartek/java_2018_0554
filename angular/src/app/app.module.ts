import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';

//Components
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { ParametroComponent } from './components/parametro/parametro.component';
import { JuegoComponent } from './components/juego/juego.component';
import { Error404Component } from './components/error404/error404.component';
import { SaludoComponent } from './components/saludo/saludo.component';
import { PaginaDirectivaComponent } from './components/pagina-directiva/pagina-directiva.component';
import { FlujoComponent } from './components/flujo/flujo.component';
import { PaginaPipeComponent } from './components/pagina-pipe/pagina-pipe.component';
import { AboutComponent } from './components/about/about.component';
import { PaginaArrayComponent } from './components/pagina-array/pagina-array.component';
import { PaginaComparadorComponent } from './components/pagina-comparador/pagina-comparador.component';
import { FrutaComponent } from './components/pagina-comparador/fruta/fruta.component';
import { PaginaConcesionarioComponent } from './components/pagina-concesionario/pagina-concesionario.component';
import { CocheComponent } from './components/pagina-concesionario/coche/coche.component';
import { TraductorComponent } from './components/traductor/traductor.component';

//Directives
import { Directiva1Directive } from './directives/directiva1.directive';
import { CountdownDirective } from './directives/countdown.directive';

//Pipes
import { MonedaPipe } from './pipes/moneda.pipe';
import { FiltroOfertaPipe } from './pipes/filtro-oferta.pipe';
import { TrimarPipe } from './pipes/trimar.pipe';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ParametroComponent,
    JuegoComponent,
    Error404Component,
    SaludoComponent,
    PaginaDirectivaComponent,
    Directiva1Directive,
    CountdownDirective,
    FlujoComponent,
    PaginaPipeComponent,
    MonedaPipe,
    AboutComponent,
    PaginaArrayComponent,
    FiltroOfertaPipe,
    TrimarPipe,
    PaginaComparadorComponent,
    FrutaComponent,
    PaginaConcesionarioComponent,
    CocheComponent,
    TraductorComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
