import { TestBed } from '@angular/core/testing';

import { MultaServiceService } from './multa-service.service';

describe('MultaServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: MultaServiceService = TestBed.get(MultaServiceService);
    expect(service).toBeTruthy();
  });
});
