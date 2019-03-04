import { TestBed, async, inject } from '@angular/core/testing';

import { LoginGuGuard } from './login-gu.guard';

describe('LoginGuGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LoginGuGuard]
    });
  });

  it('should ...', inject([LoginGuGuard], (guard: LoginGuGuard) => {
    expect(guard).toBeTruthy();
  }));
});
