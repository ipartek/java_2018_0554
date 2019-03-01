import { Component } from '@angular/core';
import { AutorizacionService } from './services/autorizacion.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'angularDGT';

  constructor(
    private autorizacionService: AutorizacionService,
    private router: Router
  ) {}

  logout(){
    console.trace('nav logout');
    this.autorizacionService.logout();
    this.router.navigate(['/login']);
  }
}
