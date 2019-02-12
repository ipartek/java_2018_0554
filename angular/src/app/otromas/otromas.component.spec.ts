import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OtromasComponent } from './otromas.component';

describe('OtromasComponent', () => {
  let component: OtromasComponent;
  let fixture: ComponentFixture<OtromasComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OtromasComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OtromasComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
