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

@NgModule({
  declarations: [
    AppComponent,
    PrincipalComponent,
    LoginComponent,
    BackofficeComponent,
    AlertComponent
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
