import { Component, OnInit } from '@angular/core';
import { Coche } from 'src/app/model/coche';
import { ActivatedRoute, Router } from '@angular/router';
import { MultaService } from 'src/app/providers/multa.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AgenteService } from 'src/app/providers/agente.service';
import { Multa } from 'src/app/model/multa';
import { Alerta } from 'src/app/model/alerta';

@Component({
  selector: 'app-datos-multa',
  templateUrl: './datos-multa.component.html',
  styleUrls: ['./datos-multa.component.scss']
})
export class DatosMultaComponent implements OnInit {

  coche: Coche;
  nuevaMulta: Multa;
  formulario: FormGroup;
  alerta: Alerta;

  constructor(
    private router: Router,
    private multaService: MultaService,
    private agenteService: AgenteService,
    private formBuilder: FormBuilder
  ) { 
    console.trace("constructor datos-multa");
    this.coche = this.multaService.getCocheSession();
    this.crearFormulario();
  }

  ngOnInit() {
    console.trace("ngOnInit datos-multa");
    console.debug("Coche obtenido: %o", this.coche);
   

  } //ngOnInit

  crearFormulario() {
    console.trace('MatriculaComponent crearFormulario');
    this.formulario = this.formBuilder.group({
      matricula: [
        this.coche.matricula        
      ],
      modelo: [
        this.coche.modelo
      ],
      importe: [
        undefined,
        [Validators.required, Validators.min(1)]
      ],
      concepto: [
        '',
        [Validators.required, Validators.minLength(10), Validators.maxLength(255)]
      ]
    });

  } // crearFormulario

  comprobar(){
    console.trace('click boton submit DatosMultaComponent');
    let importe = this.formulario.controls.importe.value;
    let concepto = this.formulario.controls.concepto.value;
    let agente = this.agenteService.getAgente();
    let coche = this.multaService.getCocheSession();

    console.debug('importe: %s, concepto: %s, agente: %o, coche: %o', importe, concepto, agente, coche);

    this.multaService.postMulta(importe, concepto, agente, coche).subscribe(
      data => {
        console.debug(data.JSON);
        this.nuevaMulta = data;
        console.debug('Nueva multa: %o', this.nuevaMulta);
        if(this.nuevaMulta.id != -1){
          this.router.navigate(["listado-multas"]);
        }else{
          this.alerta = new Alerta(`Ha ocurrido un error inesperado en la creación de la multa`);
        }
      },
      error => {
        if (error.status == 400) {
          this.alerta = new Alerta(`Los datos de la multa no son correctos. Código de error: ${error.status}`,
            Alerta.TIPO_WARNING);
          console.error('Error esperado: ' + error.status);
        } else if (error.status == 500){
          this.alerta = new Alerta(`Error inesperado en el servidor. Código de error: ${error.status}`);
          console.error(error.status);
        }else{
          this.alerta = new Alerta(`Error inesperado. Código de error: ${error.status}`);
          console.error(error.status);
        }
      }
    )

  } // comprobar


}
