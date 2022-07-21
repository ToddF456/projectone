import { TestBed } from '@angular/core/testing';

import { ItemApiService } from './item-api.service';

//Allows each component to have the item pi service active in them.
describe('ItemApiService', () => {
  let service: ItemApiService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ItemApiService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
