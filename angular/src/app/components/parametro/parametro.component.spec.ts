import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ParametroComponent } from './parametro.component';

describe('ParametroComponent', () => {
  let component: ParametroComponent;
  let fixture: ComponentFixture<ParametroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ParametroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ParametroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
