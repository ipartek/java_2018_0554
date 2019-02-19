import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginaArrayComponent } from './pagina-array.component';

describe('PaginaArrayComponent', () => {
  let component: PaginaArrayComponent;
  let fixture: ComponentFixture<PaginaArrayComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaginaArrayComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaginaArrayComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
