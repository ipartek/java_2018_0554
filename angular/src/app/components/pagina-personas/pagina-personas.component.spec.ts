import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginaPersonasComponent } from './pagina-personas.component';

describe('PaginaPersonasComponent', () => {
  let component: PaginaPersonasComponent;
  let fixture: ComponentFixture<PaginaPersonasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaginaPersonasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaginaPersonasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
