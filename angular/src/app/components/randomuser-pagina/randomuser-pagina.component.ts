import { Component, OnInit } from '@angular/core';

import { PersonaService } from 'src/app/providers/persona.service';
import { Randomuser } from 'src/app/model/randomuser';

@Component({
  selector: 'app-randomuser-pagina',
  templateUrl: './randomuser-pagina.component.html',
  styleUrls: ['./randomuser-pagina.component.scss']
})
export class RandomuserPaginaComponent implements OnInit {

  personas: Randomuser[];

  constructor(private personaService: PersonaService) { 
    console.trace('RandomuserPaginaComponent constructor');
    this.personas = []
  }

  ngOnInit() {
    console.trace('PaginaServiceComponent ngOnInit');
    this.personaService.getAll().subscribe( json => {
      let info = json['info'];
      let personasJson = json['results'];
      
      console.debug("%o",personasJson);

      personasJson.map(p =>{
        let nombre = p['name']['first'];
        let apellido =p.name.last;
        let imagen = p.picture.large;
      })

    });

    

  }

}
