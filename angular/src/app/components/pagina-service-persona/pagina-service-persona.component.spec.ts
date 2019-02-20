import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginaServicePersonaComponent } from './pagina-service-persona.component';

describe('PaginaServicePersonaComponent', () => {
  let component: PaginaServicePersonaComponent;
  let fixture: ComponentFixture<PaginaServicePersonaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaginaServicePersonaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaginaServicePersonaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
