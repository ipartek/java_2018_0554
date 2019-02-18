import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginaComparadorComponent } from './pagina-comparador.component';

describe('PaginaComparadorComponent', () => {
  let component: PaginaComparadorComponent;
  let fixture: ComponentFixture<PaginaComparadorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaginaComparadorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaginaComparadorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
