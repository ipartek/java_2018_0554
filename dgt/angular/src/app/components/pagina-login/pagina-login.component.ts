import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pagina-login',
  templateUrl: './pagina-login.component.html',
  styleUrls: ['./pagina-login.component.sass']
})
export class PaginaLoginComponent implements OnInit {

  placa: string;
  password:string;

  constructor() {
    this.placa = '';
    this.password = '';
   }

  ngOnInit() {
  }

  
}
