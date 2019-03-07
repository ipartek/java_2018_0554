import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FrutaComponent } from './fruta.component';

describe('FrutaComponent', () => {
  let component: FrutaComponent;
  let fixture: ComponentFixture<FrutaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FrutaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FrutaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
