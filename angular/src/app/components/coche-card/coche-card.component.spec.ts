import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CocheCardComponent } from './coche-card.component';

describe('CocheCardComponent', () => {
  let component: CocheCardComponent;
  let fixture: ComponentFixture<CocheCardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CocheCardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CocheCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
