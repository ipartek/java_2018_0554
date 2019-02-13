import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginaDirectivaComponent } from './pagina-directiva.component';

describe('PaginaDirectivaComponent', () => {
  let component: PaginaDirectivaComponent;
  let fixture: ComponentFixture<PaginaDirectivaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaginaDirectivaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaginaDirectivaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
