import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pagina-pipe',
  templateUrl: './pagina-pipe.component.html',
  styleUrls: ['./pagina-pipe.component.scss']
})
export class PaginaPipeComponent implements OnInit {
nombre:string;
numero:number;
  constructor() {
    console.trace("entrando constructor PaginaPipeComponent")
    this.nombre="Mi NoMbRe ComPleTo";
    this.numero=2.2551988;
  }

  ngOnInit() {
  }

}
