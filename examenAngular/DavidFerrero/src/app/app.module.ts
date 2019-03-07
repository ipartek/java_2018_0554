import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { Error404Component } from './components/error404/error404.component';
import { PrincipalComponent } from './components/principal/principal.component';
import { AlertComponent } from './components/alert/alert.component';
import { NavComponent } from './nav/nav/nav.component';
import { HttpClientModule } from '@angular/common/http';
import { FrutaComponent } from './components/fruta/fruta.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    Error404Component,
    PrincipalComponent,
    AlertComponent,
    NavComponent,
    FrutaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,   // para poder usar doble binding
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }