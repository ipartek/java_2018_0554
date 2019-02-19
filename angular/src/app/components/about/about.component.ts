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
    console.trace('AboutComponent constructor');
    this.repeticiones = 0;
  }

  ngOnInit() {
    console.trace('AboutComponent ngOnInit');
    //recibir parametro 'repeticiones'

    
    this.route.paramMap.subscribe( params =>{
      this.repeticiones = +params.get('repeticiones'); 
    });
   // usamos + para hacer parseInt, cuidado que si no es numero retorna NaN ( Not a Number )
   // this.repeticiones = +this.route.snapshot.params.repeticiones;
  }
}