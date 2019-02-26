import { Component, OnInit } from '@angular/core';
import { PersonasService } from 'src/app/providers/personas.service';
import { ListaPersona } from 'src/app/model/lista-persona';

@Component({
  selector: 'app-pagina-personas',
  templateUrl: './pagina-personas.component.html',
  styleUrls: ['./pagina-personas.component.scss']
})
export class PaginaPersonasComponent implements OnInit {

  personas: ListaPersona[];
  numeroPersonas: number;

  constructor(private personasService: PersonasService) {
    console.trace('PaginaPersonasComponent constructor');
    this.personas=[];
    this.numeroPersonas = 10;
    /*this.personas = [
      {"name":{"title":"mr","first":"eeli","last":"wiitala"},"email":"eeli.wiitala@example.com","picture":{"large":"https://randomuser.me/api/portraits/men/35.jpg","medium":"https://randomuser.me/api/portraits/med/men/35.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/men/35.jpg"}},{"name":{"title":"mr","first":"justin","last":"johnson"},"email":"justin.johnson@example.com","picture":{"large":"https://randomuser.me/api/portraits/men/14.jpg","medium":"https://randomuser.me/api/portraits/med/men/14.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/men/14.jpg"}},{"name":{"title":"mrs","first":"katie","last":"duncan"},"email":"katie.duncan@example.com","picture":{"large":"https://randomuser.me/api/portraits/women/30.jpg","medium":"https://randomuser.me/api/portraits/med/women/30.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/women/30.jpg"}},{"name":{"title":"mr","first":"christian","last":"christiansen"},"email":"christian.christiansen@example.com","picture":{"large":"https://randomuser.me/api/portraits/men/47.jpg","medium":"https://randomuser.me/api/portraits/med/men/47.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/men/47.jpg"}},{"name":{"title":"mr","first":"andre","last":"hamilton"},"email":"andre.hamilton@example.com","picture":{"large":"https://randomuser.me/api/portraits/men/44.jpg","medium":"https://randomuser.me/api/portraits/med/men/44.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/men/44.jpg"}},{"name":{"title":"mrs","first":"anni","last":"toivonen"},"email":"anni.toivonen@example.com","picture":{"large":"https://randomuser.me/api/portraits/women/41.jpg","medium":"https://randomuser.me/api/portraits/med/women/41.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/women/41.jpg"}},{"name":{"title":"miss","first":"lea","last":"christiansen"},"email":"lea.christiansen@example.com","picture":{"large":"https://randomuser.me/api/portraits/women/25.jpg","medium":"https://randomuser.me/api/portraits/med/women/25.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/women/25.jpg"}},{"name":{"title":"mr","first":"sacha","last":"leclerc"},"email":"sacha.leclerc@example.com","picture":{"large":"https://randomuser.me/api/portraits/men/88.jpg","medium":"https://randomuser.me/api/portraits/med/men/88.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/men/88.jpg"}},{"name":{"title":"mrs","first":"maria","last":"møller"},"email":"maria.møller@example.com","picture":{"large":"https://randomuser.me/api/portraits/women/16.jpg","medium":"https://randomuser.me/api/portraits/med/women/16.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/women/16.jpg"}},{"name":{"title":"miss","first":"lori","last":"willis"},"email":"lori.willis@example.com","picture":{"large":"https://randomuser.me/api/portraits/women/43.jpg","medium":"https://randomuser.me/api/portraits/med/women/43.jpg","thumbnail":"https://randomuser.me/api/portraits/thumb/women/43.jpg"}}

      
    ]*/

   }

  ngOnInit() {

    this.refrescarListado();
    
  }//ngOnInit

  refrescarListado(){

    this.personasService.getAll(this.numeroPersonas ).subscribe( (json: any) =>{
      
      let personasJson = json.results; ;
      console.debug("recibimos datos json: %o", personasJson);
      this.personas= personasJson.map(p =>{
        let nombre = p.name.first;
        let apellido = p.name.last;
        let email = p.email;
        let imagen = p.picture.medium;
        return new ListaPersona (nombre, apellido, email, imagen);
      });
    });
  }

}
