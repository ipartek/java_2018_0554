import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginaMultasComponent } from './pagina-multas.component';

describe('PaginaMultasComponent', () => {
  let component: PaginaMultasComponent;
  let fixture: ComponentFixture<PaginaMultasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaginaMultasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaginaMultasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
