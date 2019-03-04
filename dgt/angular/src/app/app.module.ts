import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './paginas/login/login.component';
import { NavComponent } from './components/nav/nav.component';
import { HomeComponent } from './paginas/home/home.component';
import { CajaEstadisticasComponent } from './components/caja-estadisticas/caja-estadisticas.component';
import { MonedaPipe } from './pipes/moneda.pipe';
import { ListadoMultasComponent } from './paginas/listado-multas/listado-multas.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AlertComponent } from './components/alert/alert.component';
import { Error404Component } from './components/error404/error404.component';
import { MatriculaComponent } from './components/matricula/matricula.component';
import { DatosMultaComponent } from './components/datos-multa/datos-multa.component';
import { DetalleMultaComponent } from './components/detalle-multa/detalle-multa.component';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavComponent,
    HomeComponent,
    CajaEstadisticasComponent,
    MonedaPipe,
    ListadoMultasComponent,
    AlertComponent,
    Error404Component,
    MatriculaComponent,
    DatosMultaComponent,
    DetalleMultaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
