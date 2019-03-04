import { TestBed } from '@angular/core/testing';

import { AgenteServiceService } from './agente-service.service';

describe('AgenteServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AgenteServiceService = TestBed.get(AgenteServiceService);
    expect(service).toBeTruthy();
  });
});
