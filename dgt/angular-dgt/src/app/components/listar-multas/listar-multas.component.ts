import { Component, OnInit } from '@angular/core';
import { AgenteServiceService } from 'src/app/providers/agente-service.service';
import { Multa } from 'src/app/model/multa';
import { LoginServiceService } from 'src/app/providers/login-service.service';
import { MultaServiceService } from 'src/app/providers/multa-service.service';

@Component({
  selector: 'app-listar-multas',
  templateUrl: './listar-multas.component.html',
  styleUrls: ['./listar-multas.component.scss']
})
export class ListarMultasComponent implements OnInit {

  multas: Multa[];

  constructor(private agenteS: AgenteServiceService, private loginService: LoginServiceService, private multaS: MultaServiceService) {
    console.trace('ListarMultasComponent constructor');
    this.multas = [];
  }

  ngOnInit() {
    console.trace('ListarMultasComponent ngOnInit');
    this.listarMultas();
  }

  listarMultas() {
    console.trace('ListarMultas')


    this.agenteS.listarMultasAg(this.loginService.getAgente().id).subscribe(
      json => {
        console.debug('Json Multa %o', json);

        this.multas = json.map(m => {
          return new Multa(m.id, m.coche.id, m.concepto, m.fechaAlta, m.fechaBaja, m.coche.matricula, m.coche.modelo, m.importe);
        })
      },
      error => {
        console.warn('error listarMultas %o', error);


      }
    );
  }

  anularMulta(id: number) {
    console.trace('ListarMultas');
    if (confirm("Estas seguro?")) {
      this.multaS.darBaja(id);
      window.location.reload();
    }
  }

  habilitarMulta(id: number) {
    console.trace('HabilitarMultas');
    if (confirm("Estas seguro?")) {
      this.multaS.darAlta(id);
      window.location.reload();
    }

  }

}
