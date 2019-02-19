import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CocheComponent } from './coche.component';

describe('CocheComponent', () => {
  let component: CocheComponent;
  let fixture: ComponentFixture<CocheComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CocheComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CocheComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
