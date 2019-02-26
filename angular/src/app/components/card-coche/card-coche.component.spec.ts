import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CardCocheComponent } from './card-coche.component';

describe('CardCocheComponent', () => {
  let component: CardCocheComponent;
  let fixture: ComponentFixture<CardCocheComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CardCocheComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CardCocheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
