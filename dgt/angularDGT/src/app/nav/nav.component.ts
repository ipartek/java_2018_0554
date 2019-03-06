import { Component, OnInit } from '@angular/core';
import { AutorizacionService } from 'src/app/providers/autorizacion.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.sass']
})
export class NavComponent implements OnInit {
  agente: any;

  constructor(private autorizacionService: AutorizacionService, private router: Router) { 
    
  }

  ngOnInit() {

    this.getAgenteInfo();
  }

  getAgenteInfo(){
    this.agente = this.autorizacionService.getAgente();

  }

  logout(){
    this.autorizacionService.logout();
    this.router.navigate(['/login']);
  }
}
