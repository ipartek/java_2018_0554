import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FrutaCardComponent } from './fruta-card.component';

describe('FrutaCardComponent', () => {
  let component: FrutaCardComponent;
  let fixture: ComponentFixture<FrutaCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FrutaCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FrutaCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
