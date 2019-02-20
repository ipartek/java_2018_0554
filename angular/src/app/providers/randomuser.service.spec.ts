import { TestBed } from '@angular/core/testing';

import { RandomuserService } from './randomuser.service';

describe('RandomuserService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RandomuserService = TestBed.get(RandomuserService);
    expect(service).toBeTruthy();
  });
});
