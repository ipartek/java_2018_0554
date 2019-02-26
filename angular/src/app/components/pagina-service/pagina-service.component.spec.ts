import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginaServiceComponent } from './pagina-service.component';

describe('PaginaServiceComponent', () => {
  let component: PaginaServiceComponent;
  let fixture: ComponentFixture<PaginaServiceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaginaServiceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaginaServiceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
