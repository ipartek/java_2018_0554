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

  constructor(private randomuserService: RandomuserService) { 
    this.personas = [];
  }

  

  ngOnInit() {

    this.randomuserService.getAll().subscribe( (json:any) => {

      // let info = json.info; 
      let personasJson = json.results; 

      //map de personasJson a Persona
      console.debug('personas %o' , personasJson );
      this.personas = personasJson.map( p => {
         let nombre = p.name.first;
         let email = p.email;
         let apellido = p.name.last;
         let imagen = p.picture.large;
         return new Persona(nombre, email, apellido, imagen); 
      });
   });
   
  }// ngOnInit

}
