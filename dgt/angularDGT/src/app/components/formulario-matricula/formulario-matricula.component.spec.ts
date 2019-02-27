import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioMatriculaComponent } from './formulario-matricula.component';

describe('FormularioMatriculaComponent', () => {
  let component: FormularioMatriculaComponent;
  let fixture: ComponentFixture<FormularioMatriculaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormularioMatriculaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormularioMatriculaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
