import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-saludo',
  templateUrl: './saludo.component.html',
  styleUrls: ['./saludo.component.scss']
})
export class SaludoComponent implements OnInit {

  nombre: string;
  apellido: string;

  constructor(
    private route: ActivatedRoute
  ) {
    console.trace('ParametroComponent constructor');
    this.nombre = "";
    this.apellido = "";
   }

  ngOnInit() {
    console.trace('ParametroComponent constructor');
    /* Forma 1
    this.route.paramMap.subscribe( params =>{
      this.repeticiones = params.get('repeticiones');
    });
    */
  
    //Forma 2 (el + lo convierte en int)
    this.nombre = this.route.snapshot.params.nombre;
    this.apellido = this.route.snapshot.params.apellido;
  }

}
