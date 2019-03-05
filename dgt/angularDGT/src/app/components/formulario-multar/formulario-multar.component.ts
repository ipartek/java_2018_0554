import { Component, OnInit } from '@angular/core';
import { MultaService } from 'src/app/providers/multa.service';
import { Router } from '@angular/router';
import { Alert } from 'src/app/model/alert';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AutorizacionService } from 'src/app/providers/autorizacion.service';
import { Multa } from 'src/app/model/multa';

@Component({
  selector: 'app-formulario-multar',
  templateUrl: './formulario-multar.component.html',
  styleUrls: ['./formulario-multar.component.scss']
})
export class FormularioMultarComponent implements OnInit {


  agente: any;
  vehiculo: any;
  formulario: FormGroup;  
  alert: Alert;

  
    constructor( public multaService:MultaService,
      private autorizacionService: AutorizacionService,
      private formBuilder: FormBuilder,
      private router: Router ) 
      {
        console.log('frutasComponent constructor');
        this.crearFormulario();
        this.alert = new Alert('');
    }
  
  
    ngOnInit() {
      console.log('TodosComponent ngOnInit');
      this.getAgenteInfo();
      this.getVehiculoInfo();
    }//ngOnInit
  
    getAgenteInfo() {
      this.agente = this.autorizacionService.getAgente();
  
    }
  
    getVehiculoInfo() {
      this.vehiculo = this.multaService.getVehiculo();
    }
  

    crearFormulario(){
      console.trace('LoginComponent crearFormulario');
      this.formulario = this.formBuilder.group({
        importe:  [
                  null,
                  [Validators.required, Validators.min(0.99), Validators.max(9999)]
        ],
        concepto :  [
                    '',
                    [Validators.required, Validators.minLength(5), Validators.maxLength(200)]
        ]  
      });  
        
    }// crearFormulario


  crear() {
      console.trace('click boton submit');
      let importe = this.formulario.controls.importe.value;
      let concepto = this.formulario.controls.concepto.value;
      console.debug('importe: %s concepto: %s', importe, concepto);

      // mappear de formulario a Multa
      let multa = new Multa(
        -1,
        this.formulario.value.importe,
        this.formulario.value.concepto,
        '', 
        this.agente.id,
        this.vehiculo.id     
      );


      this.multaService.multar(multa).subscribe(
        data => {
          console.debug('Json Multa %o', data);
          this.crearFormulario();
          this.router.navigate(['/listarMultas']);
          this.alert = new Alert('Multa creada con exito',"primary");

        },
        error => {
          console.warn('error multa %o', error);
          this.autorizacionService.setLogged(false);
          this.alert = new Alert('No se ha podido crear la multa');
        }
      );

}

  }
  