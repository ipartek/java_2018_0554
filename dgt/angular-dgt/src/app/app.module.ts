import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { MenuPpalComponent } from './components/menu-ppal/menu-ppal.component';
import { ListarMultasComponent } from './components/listar-multas/listar-multas.component';
import { MandarMatriculaComponent } from './components/mandar-matricula/mandar-matricula.component';
import { CrearMultaComponent } from './components/crear-multa/crear-multa.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MenuPpalComponent,
    ListarMultasComponent,
    MandarMatriculaComponent,
    CrearMultaComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, //para poder usar doble binding
    HttpClientModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
