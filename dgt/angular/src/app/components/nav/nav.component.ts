import { Component, OnInit } from '@angular/core';
import { Agente } from 'src/app/model/agente';
import { AgenteService } from 'src/app/providers/agente.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {

  agenteLogueado: Agente;

  constructor( agenteService: AgenteService ) { 
    this.agenteLogueado = agenteService.agenteLogueado;
  }

  ngOnInit() {
  }

}
