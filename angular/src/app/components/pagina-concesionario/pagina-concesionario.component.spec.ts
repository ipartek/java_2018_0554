import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PaginaConcesionarioComponent } from './pagina-concesionario.component';

describe('PaginaConcesionarioComponent', () => {
  let component: PaginaConcesionarioComponent;
  let fixture: ComponentFixture<PaginaConcesionarioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PaginaConcesionarioComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PaginaConcesionarioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
