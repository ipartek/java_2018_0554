import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';

@Component({
  selector: 'app-principal',
  templateUrl: './principal.component.html',
  styleUrls: ['./principal.component.scss']
})
export class PrincipalComponent implements OnInit {

  //variable dependiente del entorno
  texto:string=environment.texto;


  
  constructor() { }

  ngOnInit() {
  }

}
