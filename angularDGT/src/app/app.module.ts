import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/paginas/login/login.component';
import { IndexComponent } from './components/paginas/index/index.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { AlertComponent } from './components/componentes/alert/alert.component';
import { HttpClientModule } from '@angular/common/http';
import { MultasComponent } from './components/paginas/multas/multas.component';
import { MultarMatriculaComponent } from './components/paginas/multar-matricula/multar-matricula.component';
import { MultarComponent } from './components/paginas/multar/multar.component';
import { MultasBajaComponent } from './components/paginas/multas-baja/multas-baja.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    IndexComponent,
    AlertComponent,
    MultasComponent,
    MultarMatriculaComponent,
    MultarComponent,
    MultasBajaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
