import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-traductor',
  templateUrl: './traductor.component.html',
  styleUrls: ['./traductor.component.scss']
})
export class TraductorComponent implements OnInit {
  
  @Input('idioma') idioma: string;
  @Input('texto') texto: string;

  constructor() { 
    console.trace('TraductorComponent constructor');
  }

  ngOnInit() {
    console.trace('TraductorComponent ngOnInit');
  }

}
