import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http'

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

// nuestros components
import { PruebaComponent } from './components/prueba/prueba.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { Error404Component } from './components/error404/error404.component';
import { PaginaDirectivaComponent } from './components/pagina-directiva/pagina-directiva.component';
import { FlujoComponent } from './components/flujo/flujo.component';
import { PaginaComparadorComponent } from './components/pagina-comparador/pagina-comparador.component';
import { FrutaComponent } from './components/fruta/fruta.component';
import { PaginaPipeComponent } from './components/pagina-pipe/pagina-pipe.component';
import { ArrayComponent } from './components/array/array.component';
import { PaginaConcesionarioComponent } from './components/pagina-concesionario/pagina-concesionario.component';
import { CardCocheComponent } from './components/card-coche/card-coche.component';
import { TraductorComponent } from './components/traductor/traductor.component';
import { PaginaServiceComponent } from './components/pagina-service/pagina-service.component';
import { PersonaComponent } from './components/persona/persona.component';
import { PaginaPersonasComponent } from './components/pagina-personas/pagina-personas.component';
import { PaginaFrutasComponent } from './components/pagina-frutas/pagina-frutas.component';
import { PaginaTodosComponent } from './components/pagina-todos/pagina-todos.component';
import { NavComponent } from './nav/nav.component';

//directivas
import { Directiva1Directive } from './directives/directiva1.directive';
import { PruebaDirective } from './directives/prueba.directive';

//pipes
import { MonedaPipe } from './pipes/moneda.pipe';
import { TrimarPipe } from './pipes/trimar.pipe';
import { FiltroOfertaPipe } from './pipes/filtro-oferta.pipe';
import { AlertComponent } from './components/alert/alert.component';




@NgModule({
  declarations: [
    AppComponent,
    PruebaComponent,
    HomeComponent,
    AboutComponent,
    Error404Component,
    PaginaDirectivaComponent,
    Directiva1Directive,
    PruebaDirective,
    FlujoComponent,
    PaginaPipeComponent,
    MonedaPipe,
    TrimarPipe,
    ArrayComponent,
    FiltroOfertaPipe,
    PaginaComparadorComponent,
    FrutaComponent,
    PaginaConcesionarioComponent,
    CardCocheComponent,
    TraductorComponent,
    PaginaServiceComponent,
    PersonaComponent,
    PaginaPersonasComponent,
    PaginaFrutasComponent,
    PaginaTodosComponent,
    NavComponent,
    AlertComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule, //para poder usar doble binding
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
