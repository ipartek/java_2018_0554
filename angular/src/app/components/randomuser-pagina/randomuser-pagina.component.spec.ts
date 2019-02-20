import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RandomuserPaginaComponent } from './randomuser-pagina.component';

describe('RandomuserPaginaComponent', () => {
  let component: RandomuserPaginaComponent;
  let fixture: ComponentFixture<RandomuserPaginaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RandomuserPaginaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RandomuserPaginaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
