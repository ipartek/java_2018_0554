import { TestBed, async, inject } from '@angular/core/testing';

import { GuardPermisosGuard } from './guard-permisos.guard';

describe('GuardPermisosGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [GuardPermisosGuard]
    });
  });

  it('should ...', inject([GuardPermisosGuard], (guard: GuardPermisosGuard) => {
    expect(guard).toBeTruthy();
  }));
});
