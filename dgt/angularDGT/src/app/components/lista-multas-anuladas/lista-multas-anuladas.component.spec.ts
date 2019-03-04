import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaMultasAnuladasComponent } from './lista-multas-anuladas.component';

describe('ListaMultasAnuladasComponent', () => {
  let component: ListaMultasAnuladasComponent;
  let fixture: ComponentFixture<ListaMultasAnuladasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ListaMultasAnuladasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ListaMultasAnuladasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
