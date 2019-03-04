import { AgenteService } from '../../providers/agente.service';
import { Component, OnInit } from '@angular/core';
import { Alerta } from 'src/app/model/alerta';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MultaService } from 'src/app/providers/multa.service';
import { Router } from '@angular/router';
import { Agente } from 'src/app/model/agente';
import { Multa } from 'src/app/model/multa';


@Component({
  selector: 'app-redactar-multa',
  templateUrl: './redactar-multa.component.html',
  styleUrls: ['./redactar-multa.component.scss']
})
export class RedactarMultaComponent implements OnInit {
  formulario: FormGroup;
  alerta: Alerta;
  coche: any; //DAO en funcionamiento, TODO: arreglar fallo al importar el coche desde la base de datos medieante angular
  agente: any;
  vehiculo: any;



  //almacenar los datos recopilados por el formulario , metodo post + que liste los nuevos registros (deberia hacerse automaticamente)


  constructor(private agenteService: AgenteService,
    private multaService: MultaService,
    private formBuilder: FormBuilder,
    private router: Router) {

    console.log('RedactarMultaComponent constructor');
    this.crearFormulario();
  }



  /**
   * Creando un formulario que ingrese los valores de vehiculo y agente en el nuevo registro
   * importe tendra un valor de minima existencia pero el concepto deberá ser menor a 250 caracteres
   */
  crearFormulario() {
    console.trace('PaginaLoginComponent crearFormulario');
    this.formulario = this.formBuilder.group({
      importe: [
        '',
        [Validators.required]
      ],
      concepto: [
        '',
        [Validators.required, Validators.minLength(3), Validators.maxLength(250)] //limite 250 caracteres 
      ]
    });

  }// crearFormulario
  crearMulta() {
    console.trace('RedactarMultaComponent, this.crearMulta');

    //pasando valores del formulario a un nuevo objeto Multa

    let importe = this.formulario.controls.importe.value;
    let concepto = this.formulario.controls.concepto.value;
    console.debug('importe: %s concepto: %s', importe, concepto);

    // mappear de formulario a Multa
    let multa = new Multa(
      -1,
      this.formulario.value.importe,
      this.formulario.value.concepto,
      this.coche.id,
      this.agente.id


    );
    //llamar servicio TODO retornar Observable

    // Cuidado es una llamada Asincrona
    this.multaService.multar(multa).subscribe(
      data => {
        console.debug('Json Multa %o', data);
        this.crearFormulario();
        this.router.navigate(['/pagina-multas']);
      },
      error => {
        console.warn('error multa %o', error);
        this.agenteService.setLogged(false);
        this.alerta = new Alerta('Error al crear multa');
      }
    );


  }

  ngOnInit() {
    console.trace('RedactarMultaComponent ngOnInit');
    this.agenteService.getAgente();
    this.multaService.getCoche();
  }

}
