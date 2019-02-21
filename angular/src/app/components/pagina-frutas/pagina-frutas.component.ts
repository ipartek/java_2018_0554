import { Component, OnInit } from '@angular/core';
import { PaginaFrutasService } from 'src/app/providers/pagina-frutas.service';
import { Fruta } from 'src/app/model/fruta';

@Component({
  selector: 'app-pagina-frutas',
  templateUrl: './pagina-frutas.component.html',
  styleUrls: ['./pagina-frutas.component.scss']
})
export class PaginaFrutasComponent implements OnInit {

  frutas: Fruta[];

  constructor(public paginaFrutasService:PaginaFrutasService) {
    console.log('PaginaFrutasComponent constructor');
    this.frutas = [];
   }

  ngOnInit() {
    console.log('PaginaFrutasComponent ngOnInit');
    this.cargarFrutas();
  }

  cargarFrutas(){
    console.log('PaginaFrutasComponent cargarFrutas');
    this.paginaFrutasService.getFrutas().subscribe( resultado => {
     // console.debug('peticion correcta %o', resultado);
      this.frutas = resultado;
    },error=>{
      console.warn('peticion incorrecta %o', error);
    });
  }

}
