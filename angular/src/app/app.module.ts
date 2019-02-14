import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';

// components
import { PruebaComponent } from './components/prueba/prueba.component';
import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { Error404Component } from './components/error404/error404.component';
import { PaginaDirectivaComponent } from './components/pagina-directiva/pagina-directiva.component';

// directives
import { Directiva1Directive } from './directives/directiva1.directive';
import { CountdownDirective } from './directives/countdown.directive';

@NgModule({
  declarations: [
    AppComponent,
    PruebaComponent,
    HomeComponent,
    AboutComponent,
    Error404Component,
    PaginaDirectivaComponent,
    Directiva1Directive,
    CountdownDirective
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
