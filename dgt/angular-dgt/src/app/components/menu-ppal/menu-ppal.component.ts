import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu-ppal',
  templateUrl: './menu-ppal.component.html',
  styleUrls: ['./menu-ppal.component.scss']
})
export class MenuPpalComponent implements OnInit {

  constructor(private router: Router) {
    console.trace('MenuPpalComponent constructor');
   }

  ngOnInit() {
    console.trace('MenuPpalComponent ngOnInit');
  }

}
