import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginaServicioFrutaComponent } from './pagina-servicio-fruta.component';

describe('PaginaServicioFrutaComponent', () => {
  let component: PaginaServicioFrutaComponent;
  let fixture: ComponentFixture<PaginaServicioFrutaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaginaServicioFrutaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaginaServicioFrutaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
