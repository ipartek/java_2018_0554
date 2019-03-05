import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AnularMultaComponent } from './anular-multa.component';

describe('AnularMultaComponent', () => {
  let component: AnularMultaComponent;
  let fixture: ComponentFixture<AnularMultaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AnularMultaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AnularMultaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
