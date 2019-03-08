import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CardCasaComponent } from './card-casa.component';

describe('CardCasaComponent', () => {
  let component: CardCasaComponent;
  let fixture: ComponentFixture<CardCasaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CardCasaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CardCasaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
