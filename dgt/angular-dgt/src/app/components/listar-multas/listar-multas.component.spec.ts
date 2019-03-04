import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarMultasComponent } from './listar-multas.component';

describe('ListarMultasComponent', () => {
  let component: ListarMultasComponent;
  let fixture: ComponentFixture<ListarMultasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListarMultasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarMultasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
