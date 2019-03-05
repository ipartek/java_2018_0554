import { Component, OnInit } from '@angular/core';
import { Multa } from 'src/app/model/multa';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Coche } from 'src/app/model/coche';
import { Alerta } from 'src/app/model/alerta';
import { Router } from '@angular/router';
import { AgenteService } from 'src/app/providers/agente.service';
import { MultaService } from 'src/app/providers/multa.service';

@Component({
  selector: 'app-redactar-multa',
  templateUrl: './redactar-multa.component.html',
  styleUrls: ['./redactar-multa.component.scss']
})
export class RedactarMultaComponent implements OnInit {
    multaRegistrada: Multa;
    formulario: FormGroup;
    coche: Coche;
    alerta: Alerta;

  constructor(private router: Router, private multaService: MultaService, private agenteService: AgenteService, private formBuilder: FormBuilder) { 
    
    console.trace("constructor datos-multa");
    this.coche = this.multaService.getCocheGuardado();
    this.crearFormulario();}

  ngOnInit() {console.trace("ngOnInit datos-multa");
  console.debug("Coche obtenido: %o", this.coche);
  }
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
    let coche = this.multaService.getCocheGuardado();

    console.debug('agente: %o, coche: %o, importe: %s, concepto: %s', agente, coche, importe, concepto);

    this.multaService.multaPost(importe, concepto, agente, coche).subscribe(
      data => {
        console.debug('Json Multa %o', data);
        this.multaRegistrada = data;
        console.debug('Multa Registrada: %o', this.multaRegistrada);
        if(this.multaRegistrada.id != -1){
          this.router.navigate(["pagina-multas"]);
        }else{
          this.alerta = new Alerta(`No se ha podido crear la multa`);
        }
      },
      error => {
        if (error.status == 400) {
          this.alerta = new Alerta(` Error: ${error.status}, Verifica los datos.`,
            Alerta.TIPO_WARNING);
          console.error('Error encontrado: ' + error.status);
        } else if (error.status == 500){
          this.alerta = new Alerta(`Error: ${error.status}, Error del servidor. `);
          console.error(error.status);
        }else{
          this.alerta = new Alerta(`Error: ${error.status}, Error no esperado.`);
          console.error(error.status);
        }
      }
    )

  } 

}
