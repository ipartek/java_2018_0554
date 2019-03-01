import { Component, OnInit } from '@angular/core';
import { MultasService } from 'src/app/services/multas.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-multas',
  templateUrl: './multas.component.html',
  styleUrls: ['./multas.component.scss']
})
export class MultasComponent implements OnInit {

  constructor(
    private multasService: MultasService,
    private router: Router) { }

  ngOnInit() {
  }

  listarMultas(){
    let idAgente;
    // llamar servicio Rest, realizar logica dentro de subscripcion
    // Cuidado es una llamada Asincrona
    this.multasService.obtenerMultas(idAgente).subscribe(
      data =>{
        this.multasService.obtenerMultas(idAgente);
      },
      error=>{
        console.warn('error login %o', error);
        this.router.navigate(['/index']);
      }
    );

    // *** Cuidado no intentar usar datos de la respuesta aqui ***
  }

}
