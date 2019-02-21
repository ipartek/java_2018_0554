import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginaServiceTodosComponent } from './pagina-service-todos.component';

describe('PaginaServiceTodosComponent', () => {
  let component: PaginaServiceTodosComponent;
  let fixture: ComponentFixture<PaginaServiceTodosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaginaServiceTodosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaginaServiceTodosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
