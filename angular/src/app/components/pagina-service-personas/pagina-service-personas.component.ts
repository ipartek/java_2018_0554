import { Component, OnInit } from '@angular/core';
import { Persona } from 'src/app/model/persona';
import { PersonaService } from 'src/app/providers/persona.service';

@Component({
  selector: 'app-pagina-service-personas',
  templateUrl: './pagina-service-personas.component.html',
  styleUrls: ['./pagina-service-personas.component.scss']
})
export class PaginaServicePersonasComponent implements OnInit {

  personas: Persona[];
  nPersonas: number;

  constructor( private personaService: PersonaService ) { 
    console.trace('PaginaServicePersonasComponent constructor');
    this.personas=[];
    this.nPersonas = 10;
  }

  ngOnInit() {
    console.trace('PaginaServicePersonasComponent ngOnInit');

    this.refrescarLista();
  }

  refrescarLista(){
    if(this.nPersonas < 0){
      this.nPersonas = 1;
    }
    
    this.personaService.getAll(this.nPersonas).subscribe( json => {
      console.debug("Recibimos datos del JSON: %o", json);
      //TODO mapear
      let personasJson = json.results;

      this.personas = personasJson.map( p => {
        return new Persona(p.name.first, p.name.last, p.email, p.picture.large);
      });
    });
  }
}
