import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { EstadisticasComponent } from './estadisticas.component';

describe('EstadisticasComponent', () => {
  let component: EstadisticasComponent;
  let fixture: ComponentFixture<EstadisticasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ EstadisticasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(EstadisticasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
