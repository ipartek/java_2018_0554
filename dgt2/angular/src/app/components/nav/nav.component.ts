import { Component, OnInit } from '@angular/core';
import { Agente } from 'src/app/model/agente';
import { AgenteService } from 'src/app/providers/agente.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {

  agenteLogueado: Agente;

  constructor( 
    private agenteService: AgenteService,
    private route: Router
     ) { 
    this.agenteLogueado = agenteService.getAgente();
  }

  ngOnInit() {
  }

  clickCerrarSesion(){
    this.agenteService.logout();
    this.route.navigate(['login']);
  }

}
