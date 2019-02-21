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
  numPersonas: number;

  constructor(private personaService: PersonaService) {
    console.trace('RandomuserPaginaComponent constructor');
    this.personas = [];
    this.numPersonas = 10;

  }
  cambiarCantidad() {
   
    console.warn('RandomuserPaginaComponent this.numPersonas' + this.numPersonas);
    this.personas = [];
    this.personaService.getAll(this.numPersonas).subscribe( json => {
      const info = json['info'];
      const personasJson = json['results'];
      console.debug('%o', personasJson);
      personasJson.map(p => {
        const nombre = p['name']['first'];
        const apellido = p.name.last;
        const email = p['email'];
        const imagen = p.picture.large;
        this.personas.push(new Randomuser(nombre, apellido, email, imagen ));
      });

    });
  }


  ngOnInit() {
    console.trace('PaginaServiceComponent ngOnInit');
    this.cambiarCantidad() ;

  }

}
