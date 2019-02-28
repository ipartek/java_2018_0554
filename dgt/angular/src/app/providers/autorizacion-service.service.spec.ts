import { TestBed } from '@angular/core/testing';

import { AutorizacionServiceService } from './autorizacion-service.service';

describe('AutorizacionServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AutorizacionServiceService = TestBed.get(AutorizacionServiceService);
    expect(service).toBeTruthy();
  });
});
