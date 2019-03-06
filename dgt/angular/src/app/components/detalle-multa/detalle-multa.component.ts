import { Component, OnInit } from '@angular/core';
import { Multa } from 'src/app/model/multa';
import { MultaService } from 'src/app/providers/multa.service';
import { Alerta } from 'src/app/model/alerta';

@Component({
  selector: 'app-detalle-multa',
  templateUrl: './detalle-multa.component.html',
  styleUrls: ['./detalle-multa.component.scss']
})
export class DetalleMultaComponent implements OnInit {

  multa: Multa;
  alerta: Alerta;

  constructor( private multaService: MultaService ) {
    this.multa = multaService.getMultaSession();
    this.alerta = new Alerta('');
  }

  ngOnInit() {
    this.multa = this.multaService.getMultaSession();
  }

  anularMulta(idMulta: number) {
    console.log('ListadoMultasComponent anularMulta ID: ' + idMulta);

    this.multaService.patchMulta( idMulta, 'baja' ).subscribe(resultado => {
      console.debug(`Multa con ID: ${idMulta} dada de baja`);
      this.alerta = new Alerta(`Multa con ID: ${idMulta} dada de baja`, Alerta.TIPO_SUCCESS);
      this.multaService.getMulta(idMulta).subscribe(data =>{
      this.multaService.saveMulta(data);
      this.multa = this.multaService.getMultaSession();
      }, error =>{
        this.alerta = new Alerta(`Error inesperado. Código de error: ${error.status}`);
      console.warn('peticion incorrecta %o', error);
      });
    }, error => {
      this.alerta = new Alerta(`Error inesperado. Código de error: ${error.status}`);
      console.warn('peticion incorrecta %o', error);
    });
  }

  reactivarMulta(idMulta: number) {
    console.log('ListadoMultasComponent reactivarMulta ID: ' + idMulta);

    this.multaService.patchMulta( idMulta, 'alta' ).subscribe(resultado => {
      console.debug(`Multa con ID: ${idMulta} dada de alta`);
      this.alerta = new Alerta(`Multa con ID: ${idMulta} reactivada`, Alerta.TIPO_SUCCESS);
      this.multaService.getMulta(idMulta).subscribe(data =>{
        let m = new Multa(data.id, data.importe, data.concepto, data.fecha, data.fecha_baja);
        this.multaService.saveMulta(m);
        this.multa = this.multaService.getMultaSession();
        }, error =>{
          this.alerta = new Alerta(`Error inesperado. Código de error: ${error.status}`);
        console.warn('peticion incorrecta %o', error);
        });
    }, error => {
      this.alerta = new Alerta(`Error inesperado. Código de error: ${error.status}`);
      console.warn('peticion incorrecta %o', error);
    });
  }

}
