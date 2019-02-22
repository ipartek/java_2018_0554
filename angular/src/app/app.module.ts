import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

//Componentes
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PruebaComponent } from './prueba/prueba.component';
import { JuegoClickComponent } from './juego-click/juego-click.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { Error404Component } from './components/error404/error404.component';
import { NombreComponent } from './components/nombre/nombre.component';
import { PaginaDirectivaComponent } from './components/pagina-directiva/pagina-directiva.component';
import { FlujoComponent } from './components/flujo/flujo.component';
import { PaginaPipeComponent } from './components/pagina-pipe/pagina-pipe.component';
import { PaginaComparadorComponent } from './components/pagina-comparador/pagina-comparador.component';
import { FrutaComponent } from './components/fruta/fruta.component';
import { TraductorComponent } from './components/traductor/traductor.component';
import { CarritoComponent } from './components/carrito/carrito.component';
import { PaginaServiceComponent } from './components/pagina-service/pagina-service.component';
import { ArrayComponent } from './components/array/array.component';

//Directivas
import { Directiva1Directive } from './directives/directiva1.directive';
import { CountdownDirective } from './directives/countdown.directive';

//Pipes
import { MonedaPipe } from './pipes/moneda.pipe';
import { TrimPipe } from './pipes/trim.pipe';
import { FiltroOfertaPipe } from './pipes/filtro-oferta.pipe';
import { PaginaServicePersonasComponent } from './components/pagina-service-personas/pagina-service-personas.component';
import { NavComponent } from './components/nav/nav.component';
import { PaginaTodosComponent } from './components/pagina-todos/pagina-todos.component';
import { PaginaFrutasComponent } from './components/pagina-frutas/pagina-frutas.component';
import { AlertaComponent } from './components/alerta/alerta.component';


@NgModule({
  declarations: [
    AppComponent,
    PruebaComponent,
    JuegoClickComponent,
    HomeComponent,
    AboutComponent,
    Error404Component,
    NombreComponent,
    PaginaDirectivaComponent,
    Directiva1Directive,
    CountdownDirective,
    FlujoComponent,
    PaginaPipeComponent,
    MonedaPipe,
    TrimPipe,
    ArrayComponent,
    FiltroOfertaPipe,
    PaginaComparadorComponent,
    FrutaComponent,
    TraductorComponent,
    CarritoComponent,
    PaginaServiceComponent,
    PaginaServicePersonasComponent,
    NavComponent,
    PaginaTodosComponent,
    PaginaFrutasComponent,
    AlertaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, //Para poder usar doble binding
    HttpClientModule, //Para usarlo con los services (Obligatorio)
    ReactiveFormsModule //Para formularios Reactivos
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
