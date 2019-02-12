import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { JuegoClickComponent } from './juego-click.component';

describe('JuegoClickComponent', () => {
  let component: JuegoClickComponent;
  let fixture: ComponentFixture<JuegoClickComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ JuegoClickComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(JuegoClickComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
