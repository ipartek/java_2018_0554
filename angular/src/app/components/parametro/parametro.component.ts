import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-parametro',
  templateUrl: './parametro.component.html',
  styleUrls: ['./parametro.component.scss']
})
export class ParametroComponent implements OnInit {

  repeticiones: number;

  constructor(
    private route: ActivatedRoute
  ) {
    console.trace('ParametroComponent constructor');
    this.repeticiones = 0;
   }

  ngOnInit() {
    console.trace('ParametroComponent constructor');
    /* Forma 1
    this.route.paramMap.subscribe( params =>{
      this.repeticiones = params.get('repeticiones');
    });
    */
  
    //Forma 2 (el + lo convierte en int)
    this.repeticiones = +this.route.snapshot.params.repeticiones;
  }

}
