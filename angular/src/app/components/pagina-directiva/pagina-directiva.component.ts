import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-pagina-directiva',
  templateUrl: './pagina-directiva.component.html',
  styleUrls: ['./pagina-directiva.component.scss']
})
export class PaginaDirectivaComponent implements OnInit {

  tiempo : number;

  constructor() { 
    this.tiempo = 10;
  }

  ngOnInit() {
  }

  start(){
    let that = this;
    let interval = setInterval(function(){
      that.tiempo--;

      if(that.tiempo === 0){
       
        this.clearInterval(interval);
      }

    }, 1000);
  }

}
