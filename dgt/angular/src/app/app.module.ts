import { HttpClientModule } from "@angular/common/http";
import { BrowserModule } from "@angular/platform-browser";
import { NgModule } from "@angular/core";

import { AppRoutingModule } from "./app-routing.module";
import { AppComponent } from "./app.component";
import { PrincipalComponent } from "./components/principal/principal.component";
import { LoginComponent } from "./components/login/login.component";
import { BackofficeComponent } from "./components/backoffice/backoffice.component";
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { AlertComponent } from "./components/alert/alert.component";
import { FormsMatriculaComponent } from './components/forms-matricula/forms-matricula.component';
import { PaginaMultasComponent } from './components/pagina-multas/pagina-multas.component';
import { MonedaPipe } from './pipe/moneda.pipe';

@NgModule({
  declarations: [
    AppComponent,
    PrincipalComponent,
    LoginComponent,
    BackofficeComponent,
    AlertComponent,
    FormsMatriculaComponent,
    PaginaMultasComponent,
    MonedaPipe
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, // modulo obligatorio para utilizar BananaInBox
    HttpClientModule, // modulo obligatorio Para usarlo con los services
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {}
