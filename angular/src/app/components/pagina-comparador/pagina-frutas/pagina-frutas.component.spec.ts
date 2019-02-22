import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginaFrutasComponent } from './pagina-frutas.component';

describe('PaginaFrutasComponent', () => {
  let component: PaginaFrutasComponent;
  let fixture: ComponentFixture<PaginaFrutasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaginaFrutasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaginaFrutasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
