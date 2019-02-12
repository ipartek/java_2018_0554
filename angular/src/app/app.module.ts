import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PruebaComponent } from './prueba/prueba.component';
import { OtromasComponent } from './otromas/otromas.component';

@NgModule({
  declarations: [
    AppComponent,
    PruebaComponent,
    OtromasComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
