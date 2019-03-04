import { Component, OnInit, Input } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { MultaServiceService } from 'src/app/providers/multa-service.service';
import { Router } from '@angular/router';
import { Coche } from 'src/app/model/coche';
import { Multa } from 'src/app/model/multa';
import { DatosService } from 'src/app/providers/datos.service';

@Component({
  selector: 'app-mandar-matricula',
  templateUrl: './mandar-matricula.component.html',
  styleUrls: ['./mandar-matricula.component.scss']
})
export class MandarMatriculaComponent implements OnInit {

  formulario: FormGroup;
  coche: Coche

  constructor(private formBuilder: FormBuilder,
    private multaService: MultaServiceService,
    private datosService: DatosService,
    private router: Router) {
    console.trace('MandarMatriculaComponent constructor');
    this.crearFormulario();
  }

  ngOnInit() {
  }

  crearFormulario(){
    console.trace('MandarMatriculaComponent crearFormulario');

    this.formulario = this.formBuilder.group({
      matricula: [
                '',                                                                         
                [Validators.required, Validators.minLength(6), Validators.maxLength(10)]   
              ]
    });  

  }

  mandarCoche(data:any){
    this.datosService.almacenamiento = data;
    if(data == null){
      alert("La matricula introducida no existe");
    }else{
      this.router.navigate(['/crearMulta'])
    }
  }

  comprobar(){
    console.trace('click boton submit');
    let matricula = this.formulario.controls.matricula.value;

    // llamar servicio Rest, realizar logica dentro de subscripcion
    // Cuidado es una llamada Asincrona
    this.multaService.busquedaMatricula(matricula).subscribe(
      data =>{
        console.debug('Json Agente %o', data);
        this.mandarCoche(data);
        /*
        this.coche = data.map(c => {
          new Coche(c.id, c.matricula, c.modelo, c.km);
        })
        */
      },
      error=>{
        console.warn('error login %o', error);
        
        
      }
    );
  }

}
