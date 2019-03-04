import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MandarMatriculaComponent } from './mandar-matricula.component';

describe('MandarMatriculaComponent', () => {
  let component: MandarMatriculaComponent;
  let fixture: ComponentFixture<MandarMatriculaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MandarMatriculaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MandarMatriculaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
