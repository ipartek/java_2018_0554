import { Component, OnInit } from '@angular/core';
import { MultaService } from 'src/app/providers/multa.service';
import { Router } from '@angular/router';
import { Alert } from 'src/app/model/alert';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { AutorizacionService } from 'src/app/providers/autorizacion.service';
import { Coche } from 'src/app/model/coche';

@Component({
  selector: 'app-formulario-multar',
  templateUrl: './formulario-multar.component.html',
  styleUrls: ['./formulario-multar.component.scss']
})
export class FormularioMultarComponent implements OnInit {


 cocheMulta : Coche ;
  


  matricula: string; // ????

  
  formulario: FormGroup;  
  alert: Alert;

  
    constructor( public multaService:MultaService,
      private autorizacionService: AutorizacionService,
      private formBuilder: FormBuilder,
      private router: Router ) 
      {
        console.log('frutasComponent constructor');
        this.cocheMulta = null;
        console.trace('LoginComponent constructor');
        this.crearFormulario();
        this.alert = new Alert('');
    }
  
  
    ngOnInit() {
      console.log('TodosComponent ngOnInit');

      //this.matricula= '3548MKZ'; // TODO no hardcor

    }//ngOnInit
  

    crearFormulario(){
      console.trace('LoginComponent crearFormulario');
      this.formulario = this.formBuilder.group({
        importe: [
                  '',                                                                         
                  [Validators.required, Validators.minLength(3), Validators.maxLength(150)]   
                ],
        concepto : [
                '',
                [Validators.required, Validators.minLength(5), Validators.maxLength(200)]
        ]  
      });  
        
    }// crearFormulario


/*
    getCoche(matricula:string){
      console.log('TodosComponent getAllByUser');
      this.cocheMulta = null;
      this.multaService.getByMatricula(matricula).subscribe(resultado => {
          console.debug('Json Coche %o', resultado);
         // this.mapeo(resultado);
        // this.todos = resultado.filter( todo => !todo.completed );
           this.cocheMulta = resultado;
        },
        error=>{
          console.warn('peticion incorrecta %o', error);
        }
      );//subscribe   
    }

    delete(multas:Multa){
      console.log('frutas2Component delete %o', multas );
  
      this.multaService.delete(multas.id).subscribe(
        result=>{
          this.getAllByUser(this.id_agente);
        },
        error=>{
          alert('No de pudo elimiar fruta');
        }
      );
      }


    new(){
      console.log('FrutaComponent new ');
      let multas = new Multa(this.id,this.importe,this.concepto,this.fecha_alta,this.id_coche,this.id_agente);

      this.multaService.post(multas).subscribe(
        result=>{
          console.log('TodosComponent new %o', result);
          this.getAllByUser(this.id_agente);
        },
        error=>{
          alert('No se pudo Crear Nueva Tarea');
          console.error(error);
        }
      );
    }
  */
  }
  