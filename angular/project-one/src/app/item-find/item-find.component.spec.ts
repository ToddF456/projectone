import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ItemFindComponent } from './item-find.component';

describe('ItemFindComponent', () => {
  let component: ItemFindComponent;
  let fixture: ComponentFixture<ItemFindComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ItemFindComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ItemFindComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
