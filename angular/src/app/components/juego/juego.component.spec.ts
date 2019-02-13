import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JuegoComponent } from './juego.component';

describe('JuegoComponent', () => {
  let component: JuegoComponent;
  let fixture: ComponentFixture<JuegoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JuegoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JuegoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
