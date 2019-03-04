import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MultaServiceService } from 'src/app/providers/multa-service.service';
import { Router } from '@angular/router';
import { DatosService } from 'src/app/providers/datos.service';
import { Coche } from 'src/app/model/coche';
import { Multa } from 'src/app/model/multa';

@Component({
  selector: 'app-crear-multa',
  templateUrl: './crear-multa.component.html',
  styleUrls: ['./crear-multa.component.scss']
})
export class CrearMultaComponent implements OnInit {

  formulario: FormGroup;
  public coche: Coche;
  constructor(private formBuilder: FormBuilder,
    private multaService: MultaServiceService,
    private datosService: DatosService,
    private router: Router) {

    console.trace('CrearMultaComponent constructor');
    this.coche = this.datosService.almacenamiento;
    this.crearFormulario();

    console.debug("Datos del coche buscado %0", this.coche);

  }

  ngOnInit() {
  }

  crearFormulario() {
    console.trace('CrearMultaComponent crearFormulario');

    this.formulario = this.formBuilder.group({
      matricula: [
        this.coche.matricula,
        [Validators.required, Validators.minLength(6), Validators.maxLength(8)]
      ],
      importe: [
        '',
        [Validators.required]
      ],

      concepto: [
        '',
        [Validators.required, Validators.minLength(1), Validators.maxLength(255)]
      ],
    });

  }

  insertar(){
    console.trace('click boton submit');
    let multa = new Multa(0, 0, this.formulario.controls.concepto.value,"", "", this.formulario.controls.matricula.value, "", this.formulario.controls.importe.value );
    this.multaService.insertarMulta(multa);
    this.router.navigate(['/menu-ppal']);
    alert('Multa insertada correctamente');
  }

}
