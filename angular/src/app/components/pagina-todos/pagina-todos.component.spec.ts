import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginaTodosComponent } from './pagina-todos.component';

describe('PaginaTodosComponent', () => {
  let component: PaginaTodosComponent;
  let fixture: ComponentFixture<PaginaTodosComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaginaTodosComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaginaTodosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
