import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.scss']
})
export class AboutComponent implements OnInit {

  repeticiones: number;

  constructor(
    private route: ActivatedRoute
  ) { 
    console.trace("constructor ABOUT COMPONENT");
    this.repeticiones = 0;
  }

  ngOnInit() {
    console.trace("ngOnInit ABOUT COMPONENT");

    this.route.paramMap.subscribe( params =>{
      this.repeticiones = +params.get('repeticiones'); 
    });

    // Usamos + para hacer parseInt, cuidado que si no es número, retorna NaN (Not a Number)
    //this.repeticiones = +this.route.snapshot.params.repeticiones;
  }

}
