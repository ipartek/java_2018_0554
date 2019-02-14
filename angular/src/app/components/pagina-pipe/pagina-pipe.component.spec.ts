import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginaPipeComponent } from './pagina-pipe.component';

describe('PaginaPipeComponent', () => {
  let component: PaginaPipeComponent;
  let fixture: ComponentFixture<PaginaPipeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaginaPipeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaginaPipeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
