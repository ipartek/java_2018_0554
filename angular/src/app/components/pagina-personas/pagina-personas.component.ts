import { Component, OnInit } from '@angular/core';
import { RandomuserService } from 'src/app/providers/randomuser.service';
import { Persona } from 'src/app/model/persona';

@Component({
  selector: 'app-pagina-personas',
  templateUrl: './pagina-personas.component.html',
  styleUrls: ['./pagina-personas.component.scss']
})
export class PaginaPersonasComponent implements OnInit {

  personas: Persona[];
  numeroPersonas: number;

  constructor(private randomuserService: RandomuserService) { 
    this.personas = [];
    this.numeroPersonas = 10;
  }

  ngOnInit() {

    this.refrescarListado();
   
  }// ngOnInit

  refrescarListado(){

    this.personas = [];

    this.randomuserService.getAll( this.numeroPersonas ).subscribe( (json:any) => {

      // let info = json.info; 
      let personasJson = json.results; 

      //map de personasJson a Persona
      console.debug('personas %o' , personasJson );
      this.personas = personasJson.map( p => {
         let nombre = p.name.first;
         let apellido = p.name.last;
         let email = p.email;         
         let imagen = p.picture.large;
         return new Persona(nombre, apellido,email, imagen); 
      });
   });

  }

}
