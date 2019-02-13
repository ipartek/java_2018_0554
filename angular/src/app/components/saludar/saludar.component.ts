import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-saludar',
  templateUrl: './saludar.component.html',
  styleUrls: ['./saludar.component.scss']
})
export class SaludarComponent implements OnInit {

  nombre:string;
  apellido:string;

  constructor(private route: ActivatedRoute) { 
    console.trace('SaludarComponent constructor');
    this.nombre="";
    this.apellido="";
  }

  ngOnInit() {
    console.trace('SaludarComponent ngOnInit');
    this.route.paramMap.subscribe((params)=>{
      this.nombre=params.get('nombre');
      this.apellido=params.get('apellido');
    });
  }

}
