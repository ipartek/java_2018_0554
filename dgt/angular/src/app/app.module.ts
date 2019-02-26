import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './paginas/login/login.component';
import { NavComponent } from './components/nav/nav.component';
import { HomeComponent } from './paginas/home/home.component';
import { CajaEstadisticasComponent } from './components/caja-estadisticas/caja-estadisticas.component';
import { MonedaPipe } from './pipes/moneda.pipe';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavComponent,
    HomeComponent,
    CajaEstadisticasComponent,
    MonedaPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
