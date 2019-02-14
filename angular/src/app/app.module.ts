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

//Directives
import { Directiva1Directive } from './directives/directiva1.directive';
import { CountdownDirective } from './directives/countdown.directive';

//Pipes
import { MonedaPipe } from './pipes/moneda.pipe';

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
    MonedaPipe
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
