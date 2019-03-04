import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CrearMultaComponent } from './crear-multa.component';

describe('CrearMultaComponent', () => {
  let component: CrearMultaComponent;
  let fixture: ComponentFixture<CrearMultaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CrearMultaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CrearMultaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
