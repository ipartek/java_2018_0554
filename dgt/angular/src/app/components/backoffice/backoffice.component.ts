import { Component, OnInit } from '@angular/core';
import { AutorizacionService } from 'src/app/providers/autorizacion.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-backoffice',
  templateUrl: './backoffice.component.html',
  styleUrls: ['./backoffice.component.scss']
})
export class BackofficeComponent implements OnInit {


  constructor( private autorizacionService: AutorizacionService, private router: Router) {




   }

  ngOnInit() {
  }
  cerrar(){
    console.trace('click boton cerrar session');
    //this.autorizacionService.isLogged = false;
    this.router.navigate(['/login']);
    //redirigir a login
  }
}
