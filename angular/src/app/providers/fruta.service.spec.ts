import { TestBed } from '@angular/core/testing';

import { FrutaService } from './fruta.service';

describe('FrutaService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: FrutaService = TestBed.get(FrutaService);
    expect(service).toBeTruthy();
  });
});
