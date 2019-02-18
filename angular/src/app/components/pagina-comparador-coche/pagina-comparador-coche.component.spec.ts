import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginaComparadorCocheComponent } from './pagina-comparador-coche.component';

describe('PaginaComparadorCocheComponent', () => {
  let component: PaginaComparadorCocheComponent;
  let fixture: ComponentFixture<PaginaComparadorCocheComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaginaComparadorCocheComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaginaComparadorCocheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
