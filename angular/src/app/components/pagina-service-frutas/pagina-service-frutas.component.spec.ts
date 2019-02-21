import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginaServiceFrutasComponent } from './pagina-service-frutas.component';

describe('PaginaServiceFrutasComponent', () => {
  let component: PaginaServiceFrutasComponent;
  let fixture: ComponentFixture<PaginaServiceFrutasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaginaServiceFrutasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaginaServiceFrutasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
