import { TestBed } from '@angular/core/testing';

import { PensionerServiceService } from './pensioner-service.service';

describe('PensionerServiceService', () => {
  let service: PensionerServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PensionerServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
