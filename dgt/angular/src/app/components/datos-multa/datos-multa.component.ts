import { Component, OnInit } from '@angular/core';
import { Coche } from 'src/app/model/coche';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-datos-multa',
  templateUrl: './datos-multa.component.html',
  styleUrls: ['./datos-multa.component.scss']
})
export class DatosMultaComponent implements OnInit {

  coche: Coche;

  constructor(
    private route: ActivatedRoute
  ) { 
    this.coche = new Coche();
  }

  ngOnInit() {
    this.route.paramMap.subscribe( params =>{
      //this.coche = +params.get('coche'); 
      params.get('coche');
    });
  }

}
