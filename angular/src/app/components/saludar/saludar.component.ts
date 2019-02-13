import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-saludar',
  templateUrl: './saludar.component.html',
  styleUrls: ['./saludar.component.scss']
})
export class SaludarComponent implements OnInit {
  nombre:string;
  constructor(
    private route: ActivatedRoute
  ) {
    console.trace('AboutComponent constructor');
    this.nombre = '';
  }

  ngOnInit() {
    console.trace('AboutComponent ngOnInit');
    this.route.paramMap.subscribe( params =>{
      this.nombre = params.get('nombre'); 
    });



  }

}