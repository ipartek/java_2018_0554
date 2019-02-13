import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-nombre',
  templateUrl: './nombre.component.html',
  styleUrls: ['./nombre.component.scss']
})
export class NombreComponent implements OnInit {

  nombre: String;
  apellido: String;

  constructor(
    private route: ActivatedRoute
  ) {
    this.nombre = ""; 
    this.apellido = "";
  }

  ngOnInit() {
    this.route.paramMap.subscribe( params =>{
      this.nombre = params.get('nombre'); 
    });

    this.route.paramMap.subscribe( params =>{
      this.apellido = params.get('apellido'); 
    });
  }

}
