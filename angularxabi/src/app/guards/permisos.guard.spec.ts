import { TestBed, async, inject } from '@angular/core/testing';

import { PermisosGuard } from './permisos.guard';

describe('PermisosGuard', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [PermisosGuard]
    });
  });

  it('should ...', inject([PermisosGuard], (guard: PermisosGuard) => {
    expect(guard).toBeTruthy();
  }));
});
