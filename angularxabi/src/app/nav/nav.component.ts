import { Component, OnInit } from '@angular/core';
import { AutorizacionService } from '../providers/autorizacion.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.scss']
})
export class NavComponent implements OnInit {

  constructor(private autorizacionService: AutorizacionService, private router: Router) { }

  ngOnInit() {
  }
  logout(){
    this.autorizacionService.logout();
    this.router.navigate(['/']);
  }
}
