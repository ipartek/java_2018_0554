import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-coche',
  templateUrl: './coche.component.html',
  styleUrls: ['./coche.component.scss']
})
export class CocheComponent implements OnInit {

  @Input('coche') coche: any;

  constructor() { }

  ngOnInit() {
  }

  comprarCoche(event){

    let datosEnviar = {
        'coche': this.coche
    };
  }
}