import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TraductorComponent } from './traductor.component';

describe('TraductorComponent', () => {
  let component: TraductorComponent;
  let fixture: ComponentFixture<TraductorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TraductorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TraductorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
