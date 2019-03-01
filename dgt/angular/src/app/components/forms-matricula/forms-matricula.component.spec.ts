import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FormsMatriculaComponent } from './forms-matricula.component';

describe('FormsMatriculaComponent', () => {
  let component: FormsMatriculaComponent;
  let fixture: ComponentFixture<FormsMatriculaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FormsMatriculaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FormsMatriculaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
