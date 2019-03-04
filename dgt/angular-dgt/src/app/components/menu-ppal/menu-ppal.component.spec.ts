import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MenuPpalComponent } from './menu-ppal.component';

describe('MenuPpalComponent', () => {
  let component: MenuPpalComponent;
  let fixture: ComponentFixture<MenuPpalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MenuPpalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MenuPpalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
