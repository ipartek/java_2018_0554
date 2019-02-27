import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormularioMultarComponent } from './formulario-multar.component';

describe('FormularioMultarComponent', () => {
  let component: FormularioMultarComponent;
  let fixture: ComponentFixture<FormularioMultarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormularioMultarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormularioMultarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
